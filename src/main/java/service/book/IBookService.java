package service.book;
import model.Book;
import java.sql.SQLException;
import java.util.List;

public interface IBookService {
    List<Book> findAll();
    public List<Book> showList();
    public Book selectBook(int id) throws SQLException;
    public void save(Book book, int[] categories);
    public void edit(int id,Book book, int[] categories) throws SQLException;
    public void deleteBook(int id_book) throws SQLException;
}
