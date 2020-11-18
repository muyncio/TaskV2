package pl.system.servlets;

import pl.system.table.Import;

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
            throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        String path = request.getParameter("path");
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>.xml file was import to database from  :  " + path + "</h1>");
            out.println("<h2><a href=\"./table.jsp\">GO TO TABLE -></a><h2>");
        }
        try {
            imp.importXmlFile(path);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
