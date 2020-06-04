package servlets;

import entities.User;
import model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class AddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("pass");
        User user = new User(name, password, getValue());
        Model model = Model.getInstance();
        model.add(user);
        getServletContext().setAttribute("userName", name);
        getServletContext().setAttribute("NewUser", user);
        ServletContext context = getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/Game");
        rd.forward(req, resp);
    }

    private String getValue() {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < arr.length; i++)
            arr[i] = i;
        Collections.shuffle(Arrays.asList(arr));
        String n_arr = (Arrays.toString(arr));
        String res = n_arr.substring(4, 5) + n_arr.substring(7, 8) + n_arr.substring(10, 11) + n_arr.substring(13, 14);
        return res;
    }
}