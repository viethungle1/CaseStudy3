package service.book;
import model.Book;
import java.sql.SQLException;
import java.util.List;

public interface IBookService {
    List<Book> findAll();
    public void save(Book book, int[] categories);
    public void deleteBook(int id_book) throws SQLException;
}
