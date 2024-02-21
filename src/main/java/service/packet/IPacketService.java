package service.packet;

import model.Book;

import java.sql.SQLException;
import java.util.List;

public interface IPacketService {
    List<Book> findAll();
    public Book selectBook(int id) throws SQLException;
    public void save(Book book, int[] categories);
    public void edit(int id,Book book, int[] categories) throws SQLException;
    public void deleteBook(int id_book) throws SQLException;
}
