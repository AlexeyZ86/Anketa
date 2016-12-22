package ua.lesson.homework;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

@SuppressWarnings("serial")
public class AnketaServleta extends HttpServlet {
    static final String RESP = "<!DOCTYPE html>" +
            "<html>\n" +
            "  <head>\n" +
            "<meta content=\"text/html\"; charset=\"utf-8\">" +
            "    <title>Anketa</title>\n" +
            "  </head>\n" +
            "  <body>\n" +
            "  <div align=\"center\">\n" +
            "  <p><b>Всего опрошено людей: %d</b></p>\n" +
            "  <p><b>Мужчин: %d</b></p>\n" +
            "  <p><b>Женщин: %d</b></p>\n" +
            "  <br/>\n" +
            "  <p><b>Количество пьющих:%d</b></p>\n" +
            "  <p><b>Количество не пьющих:%d</b></p>\n" +
            "  <p><b>Количество курящих:%d</b></p>\n" +
            "  <p><b>Количество не курящих:%d</b></p>\n" +
            "  \n" +
            "\t<br/>\n" +
            "  <a href=\"../index.html\">Новый опрос!</a>\n" +
            "\n" +
            "\t  </div>\n" +
            "  </body>\n" +
            "</html>";

    private static int count;
    private static int man;
    private static int woman;
    private static int drink;
    private static int notdrink;
    private static int smoke;
    private static int notsmoke;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        final String q1 = req.getParameter("question1");
        final String q2 = req.getParameter("question2");
        final String q3 = req.getParameter("question3");

        if (q1.equals("man")) {
            man++;
        } else {
            woman++;
        }

        if (q2.equals("yes")) {
            drink++;
        } else {
            notdrink++;
        }
        if (q3.equals("yes")) {
                smoke++;
            } else  {
                notsmoke++;
        }
    count++;
    resp.getWriter().println(String.format(RESP, count, man, woman, drink, notdrink, smoke, notsmoke));
    }
}
