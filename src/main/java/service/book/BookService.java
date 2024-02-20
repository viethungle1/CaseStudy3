package service.book;

import config.ConnectionJDBC;
import model.Book;
import model.Category;
import service.category.CategoryService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookService implements IBookService {
    private static final String INSERT_INTO_BOOK = "insert into book (name, author, description) value (?, ?, ?);";
    private static final String SELECT_ALL_BOOK = "select * from book;";
    private static final String DELETE_FROM_BOOK = "delete from book where id=?;";
    public static final String DELETE_FROM_BOOK_CATEGORY = "delete from book_category where id_book = ?;";
    Connection c = ConnectionJDBC.getConnection();
    CategoryService categoryDAO = new CategoryService();

    @Override
    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();
        try {
            PreparedStatement statement = c.prepareStatement(SELECT_ALL_BOOK);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                String description = rs.getString("description");
                List<Category> category = categoryDAO.findAllByBookId(id);
                Book book = new Book(id,name,author,description,category);
                bookList.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }
    @Override
    public void deleteBook(int id_book) throws SQLException {
        PreparedStatement statement = c.prepareStatement(DELETE_FROM_BOOK_CATEGORY);
        statement.setInt(1, id_book);
        statement.executeUpdate();
        PreparedStatement statement1 = c.prepareStatement(DELETE_FROM_BOOK);
        statement1.setInt(1,id_book);
        statement1.executeUpdate();
    }

    @Override
    public void save(Book book, int[] categories) {
        int id_book = 0;
        try{
            PreparedStatement statement = c.prepareStatement(INSERT_INTO_BOOK,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,book.getName());
            statement.setString(2,book.getAuthor());
            statement.setString(3,book.getDescription());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                id_book = rs.getInt(1);
            }
            PreparedStatement statement1 = c.prepareStatement("insert into book_category (id_book,id_category) VALUE (?, ?);");
            for (int id_category: categories) {
                statement1.setInt(1,id_book);
                statement1.setInt(2,id_category);
                statement1.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

