package servlets;

import entities.User;
import model.Model;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user1 = (User) getServletContext().getAttribute("NewUser");
        Model model = Model.getInstance();
        User user = model.get(user1);
        List<String> mr = user.getMyResults();
        List<String> mv = user.getMyValues();
        req.setAttribute("userValues", mv);
        req.setAttribute("userResults", mr);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/game.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("n1") != null) {
            short bool = 0, cow = 0;
            String inp = req.getParameter("n1") + req.getParameter("n2") + req.getParameter("n3") + req.getParameter("n4");
            User user = (User) getServletContext().getAttribute("NewUser");
            Model model = Model.getInstance();
            User truser = model.get(user);
            if (!truser.isWin()) {
                String val = truser.getMagicValue();
                truser.addValue(inp);
                int ind = -1, ind1 = -1;
                boolean rule = true;
                for (int i = 0; i < 4; i++) {
                    if (inp.charAt(i) == val.charAt(i))
                        bool++;
                    ind = val.indexOf(String.valueOf(inp.charAt(i)));
                    ind1 = val.lastIndexOf(String.valueOf(inp.charAt(i)));
                    if ((ind1 != ind) || inp.lastIndexOf(String.valueOf(inp.charAt(i))) > i) {
                        rule = false;
                        break;
                    } else if (ind != -1)
                        cow++;
                }
                if (rule && bool == 4) {
                    truser.addResult(bool + "Б" + cow + "К" + " Победа! Число попыток: " + truser.getCount() + ". В среднем: " + model.getAvg(truser.getCount()));
                    truser.setWin();
                } else if (rule)
                    truser.addResult(bool + "Б" + cow + "К");
                else
                    truser.addResult(" Ошибка: числа не должны повторяться!");
                getServletContext().setAttribute("NewUser", truser);
            }
        }
        doGet(req, resp);
    }
}
