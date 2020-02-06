package com;

import com.model.Application;
import lombok.SneakyThrows;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(
        name = "MyServlet",
        urlPatterns = "/boo")
public class MyServlet extends HttpServlet {
    public static void main(String[] args) {
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Application application = new Application();
        application.setFullName(req.getParameter("name"));
        application.setEmail(req.getParameter("email"));
        application.setCourse(req.getParameter("course"));
        application.setIsOnline("on".equals(req.getParameter("online")));
        boolean result = Application.addApplicationToBD(application);
        System.out.println(result);
        req.setAttribute("result", result ? "Success" : "Fail");
        //req.setAttribute("application",application);
        String url = "/New.jsp";
        RequestDispatcher dispatcher1 = getServletContext().getRequestDispatcher(url);
        dispatcher1.forward(req,resp);
    }
}
