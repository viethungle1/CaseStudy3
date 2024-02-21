package service.packet;

import config.ConnectionJDBC;
import model.Book;
import model.Category;
import model.Packet;
import service.book.BookService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacketService {
    BookService bookService = new BookService();
    Connection c = ConnectionJDBC.getConnection();
    public List<Packet> findAll() {
        List<Packet> packetList = new ArrayList<>();
        try {
            PreparedStatement statement = c.prepareStatement("select * from packet;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int id_kh = rs.getInt("id_kh");
                int id_book = rs.getInt("id_book");
                int quantity = rs.getInt("so_luong");
                List<Book> list = findAllByPacketId(id);
                Packet packet = new Packet(id,id_kh,id_book,quantity,list);
                packetList.add(packet);
            }
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }
        return packetList;
    }
    public List<Book> findAllByPacketId(int id_packet) {
        List<Book> books = new ArrayList<>();
        try {
            PreparedStatement statement = c.prepareStatement("select b.id,b.name,b.author,b.price from book b join book_packet bp on b.id = bp.id_book and bp.id_packet=?;");
            statement.setInt(1, id_packet);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                int price = rs.getInt("price");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }
}
