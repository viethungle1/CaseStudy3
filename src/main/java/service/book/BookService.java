package service.book;
import config.ConnectionJDBC;
import model.Book;
import model.Category;
import service.category.CategoryService;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class BookService implements IBookService {
    private static final String INSERT_INTO_BOOK = "insert into book (name, author, price) value (?, ?, ?);";
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
                int price = rs.getInt("price");
                List<Category> category = categoryDAO.findAllByBookId(id);
                Book book = new Book(id, name, author, price, category);
                bookList.add(book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookList;
    }
    public List<Book> findByName(String nameSearch) {
        List<Book> bookList = new ArrayList<>();
        try {
            PreparedStatement statement = c.prepareStatement("select * from book where name like ?");
            statement.setString(1,nameSearch);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                int price = rs.getInt("price");
                List<Category> category = categoryDAO.findAllByBookId(id);
                Book book = new Book(id, name, author, price, category);
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
        statement1.setInt(1, id_book);
        statement1.executeUpdate();
    }

    @Override
    public Book selectBook(int id) throws SQLException {
        Book book = null;
        PreparedStatement statement = c.prepareStatement("select * from book where id=?;");
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            int book_id = rs.getInt("id");
            String book_name = rs.getString("name");
            String book_author = rs.getString("author");
            int book_price = rs.getInt("price");
            List<Category> categories = getCategoryList(id);
            book = new Book(book_id, book_name, book_author, book_price, categories);
        }
        return book;
    }
    public List<Category> getCategoryList(int id_book) throws SQLException {
        List<Category> b_categories = new ArrayList<>();
        PreparedStatement statement = c.prepareStatement("select * from book_category where id_book =?;");
        statement.setInt(1, id_book);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            int category_id = rs.getInt("id_category");
            PreparedStatement statement1 = c.prepareStatement("select * from category where id=?;");
            statement1.setInt(1, category_id);
            ResultSet rs2 = statement1.executeQuery();
            while (rs2.next()) {
                String c_name = rs2.getString("name");
                String c_description = rs2.getString("description");
                Category category = new Category(category_id, c_name, c_description);
                b_categories.add(category);
            }
        }
        return b_categories;
    }

    @Override
    public void save(Book book, int[] categories) {
        int id_book = 0;
        try{
            PreparedStatement statement = c.prepareStatement(INSERT_INTO_BOOK,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,book.getName());
            statement.setString(2,book.getAuthor());
            statement.setInt(3,book.getPrice());
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

    @Override
    public void edit(int id, Book book, int[] categories) throws SQLException {
        PreparedStatement statement = c.prepareStatement("delete from book_category where id_book=?;");
        statement.setInt(1,id);
        statement.executeUpdate();
        PreparedStatement statement1 = c.prepareStatement("update book set name=?, author=?, price=? where id=?;");
        statement1.setString(1, book.getName());
        statement1.setString(2, book.getAuthor());
        statement1.setInt(3,book.getPrice());
        statement1.setInt(4,id);
        statement1.executeUpdate();
        PreparedStatement statement2 = c.prepareStatement("insert into book_category (id_book,id_category) values (?,?);");
        for (int id_category : categories) {
            statement2.setInt(1,id);
            statement2.setInt(2,id_category);
            statement2.executeUpdate();
        }
    }
}

