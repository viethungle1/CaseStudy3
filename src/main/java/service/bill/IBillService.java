package service.bill;

import model.Bill;
import model.Book;
import model.Category;

import java.sql.SQLException;
import java.util.List;

public interface IBillService {
    List<Bill> findAll() throws SQLException;
    public List<Book> findAllByBillId(int id_bill) throws SQLException;
    public void save(Bill bill, int[]books) throws SQLException;
}
