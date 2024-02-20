package controller;
import model.Book;
import service.book.BookService;
import service.category.CategoryService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/")
public class BookServlet extends HttpServlet {
    BookService bookService = new BookService();
    CategoryService categoryService = new CategoryService();
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
                case "delete":
                    deleteBook(req, resp);
                default:
                    showData(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void showData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> bookList = bookService.findAll();
        req.setAttribute("list",bookList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("book/list.jsp");
        dispatcher.forward(req,resp);
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("book/create.jsp");
        req.setAttribute("categories",categoryService.showList());
        dispatcher.forward(req,resp);
        
    }
    private void deleteBook(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        bookService.deleteBook(id);
        List<Book> bookList = bookService.findAll();
        req.setAttribute("list",bookList);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action) {
            case "create":
                createNewBook(req, resp);
                break;
        }
    }
    private void createNewBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String description = req.getParameter("description");
        String [] categoriesStr = req.getParameterValues("categories");
        int [] categories = new int[categoriesStr.length];
        for (int i = 0; i < categoriesStr.length; i++) {
            categories[i] = Integer.parseInt(categoriesStr[i]);
        }
        Book book = new Book(name,author,description);
        bookService.save(book,categories);
        RequestDispatcher dispatcher = req.getRequestDispatcher("book/create.jsp");
        dispatcher.forward(req,resp);
    }

}
