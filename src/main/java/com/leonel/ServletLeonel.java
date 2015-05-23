package com.leonel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by leonel on 09/05/2015.
 */
@WebServlet(urlPatterns = {"/home", "*.do"}, initParams = {@WebInitParam(name = "ProductName",
value =  "Welcome Application")})
public class ServletLeonel extends HttpServlet{

    String appName = "Leonel's Application";
    String appNameContext = "Leonel's Application";

    @Override
    public void init() throws ServletException {
        //init param
        appName=getInitParameter("ProductName");
        //servlet context param
        appNameContext = getServletContext().getInitParameter("ProductName");
        System.out.println(appNameContext);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String cType = req.getParameter("contentType");
        if (name == "" || name == null)
        {
            /*resp.sendRedirect("index.jsp");*/
            throw new ServletException("A name should be entered");
        }
        else {


            if (cType != null && cType != "")
            {
                //resp.getWriter().write("XML XML XML \n");

                resp.setContentType("text/xml");
                resp.getWriter().printf("<application><name>Hello, %s</name><product>%s</product><productServletCont>%s</productServletCont></application>", name, appName, appNameContext);
                System.out.println("<application><name>Hello, %s</name><product>%s</product><productServletCont>%s</productServletCont></application>");
            }
            else {
                resp.getWriter().write("Hello, " + name + " " + cType);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String cType = req.getParameter("contentType");
        if (name == "" || name == null)
        {
            resp.sendRedirect("index.jsp");
        }
        else {


            if (cType != null && cType != "")
            {
                //resp.getWriter().write("XML XML XML \n");

                resp.setContentType("text/xml");
                resp.getWriter().printf("<application><name>Hello, %s</name><product>%s</product><productServletCont>%s</productServletCont></application>", name, appName, appNameContext);
                System.out.println("<application><name>Hello, %s</name><product>%s</product><productServletCont>%s</productServletCont></application>");
            }
            else {
                resp.getWriter().write("Hello, " + name + " " + cType);
            }
        }
    }
}
