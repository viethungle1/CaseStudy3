package service.bill;
import config.ConnectionJDBC;
import model.Bill;
import model.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BillService implements IBillService {
    Connection c = ConnectionJDBC.getConnection();
    @Override
    public List<Bill> findAll() throws SQLException {
        List<Bill> bills = new ArrayList<>();
        PreparedStatement statement = c.prepareStatement("select * from bill;");
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String phone = rs.getString("phone");
            String address = rs.getString("address");
            int quantity = rs.getInt("quantity");
            List<Book> books = findAllByBillId(id);
            int total = getTotal(id);
            Bill bill = new Bill(id,name,phone,address,quantity,books, total);
            bills.add(bill);
        }
        return bills;
    }

    @Override
    public List<Book> findAllByBillId(int id_bill) throws SQLException {
        List<Book> bookList = new ArrayList<>();
        PreparedStatement statement = c.prepareStatement("select b.name,b.price from book b join bill_book bb on b.id=bb.id_book and bb.id_bill = ?;");
        statement.setInt(1,id_bill);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            String name = rs.getString("name");
            int price = rs.getInt("price");
            Book book = new Book(name,price);
            bookList.add(book);
        }
        return bookList;
    }
    public int getTotal(int id_bill){
        try {
            int total = 0;
            List<Book> bookList = findAllByBillId(id_bill);
            for(Book b: bookList){
                total += b.getPrice();
            }
            return total;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void save(Bill bill, int[] books) throws SQLException {
        int id_bill = 0;
        PreparedStatement statement = c.prepareStatement("insert into bill (name,phone,address,quantity) values (?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,bill.getName());
        statement.setString(2,bill.getPhone());
        statement.setString(3, bill.getAddress());
        statement.setInt(4,bill.getQuantity());
        statement.executeUpdate();
        ResultSet rs = statement.getGeneratedKeys();
        while (rs.next()) {
            id_bill = rs.getInt(1);
        }
        PreparedStatement statement1 = c.prepareStatement("insert into bill_book(id_bill,id_book) values (?,?)");
        for (int id_book : books) {
            statement1.setInt(1,id_bill);
            statement1.setInt(2,id_book);
            statement1.executeUpdate();
        }
    }
}
