package controller;

import model.Bill;
import service.bill.BillService;
import service.book.BookService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet(urlPatterns = "/bill")
public class BillServlet extends HttpServlet {
    BillService billService = new BillService();
    BookService bookService = new BookService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action="";
        }
        try {
            switch (action) {
                case "create":
                    showFormCreate(req, resp);
                    break;
                default:
                    showData(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void showData(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("bill/list.jsp");
        List<Bill> billList = billService.findAll();
        req.setAttribute("list",billList);
        dispatcher.forward(req,resp);
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("bill/create.jsp");
        req.setAttribute("books",bookService.showList());
        dispatcher.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action="";
        }
        try {
            switch (action) {
                case "create":
                    createNewBill(req, resp);
                    break;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void createNewBill(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String [] bookSTR = req.getParameterValues("books");
        int [] books = new int[bookSTR.length];
        for (int i = 0; i < books.length; i++) {
            books[i] = Integer.parseInt(bookSTR[i]);
        }
        Bill bill = new Bill(name,phone,address,quantity);
        billService.save(bill,books);
        RequestDispatcher dispatcher = req.getRequestDispatcher("bill/list.jsp");
        dispatcher.forward(req,resp);
    }
}
