package pl.system.servlets;

import pl.system.Entity.Users;
import pl.system.daoImpl.UsersDaoImpl;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/table")
public class ServletTable extends HttpServlet {
    @Resource(name="jdbc:mysql://localhost:3306/users")
    private DataSource dataSource;
    private UsersDaoImpl usersDao;

    @Override
    public void init() {
        usersDao = new UsersDaoImpl(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Users> users = usersDao.list();
            request.setAttribute("users", users);
            request.getRequestDispatcher("/WEB-INF/products.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Cannot obtain products from DB", e);
        }
    }
}
