package pl.system.servlets;

import pl.system.table.Import;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

    Import imp = new Import();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        String path = request.getParameter("path");
//        try (PrintWriter out = response.getWriter()) {
//            out.println("<h1>Days value :  " + path + "</h1>");
//        }
        try {
            imp.importXmlFile(request.getParameter("path"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
