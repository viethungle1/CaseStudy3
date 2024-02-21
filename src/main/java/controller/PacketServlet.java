package controller;

import model.Packet;
import service.packet.PacketService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/packet")
public class PacketServlet extends HttpServlet {
    PacketService packetService = new PacketService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action="";
        }
        try {
            switch (action) {
//                case "create":
//                    showFormCreate(req, resp);
//                    break;
//                case "edit":
//                    showEditForm(req,resp);
//                    break;
//                case "delete":
//                    deleteBook(req, resp);
//                    break;
                default:
                    showData(req, resp);
            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void showData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Packet> packetList = packetService.findAll();
        req.setAttribute("packetList",packetList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("packet/list.jsp");
        dispatcher.forward(req,resp);
    }
}
