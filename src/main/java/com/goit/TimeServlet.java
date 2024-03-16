package com.goit;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


@WebServlet(value = "/time")
public class TimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String timezone = req.getParameter("timezone");
        if (timezone == null || timezone.isEmpty()) {
            timezone = "UTC+0";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(timezone));
        String time = simpleDateFormat.format(new Date());
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        printWriter.print("<html><body>");
        printWriter.print("<h1>Current time is:</h1>");
        printWriter.print
                ("<h2 align=\"center\">" + time + " " + timezone + "</h2>");
        printWriter.print("</body></html>");
        printWriter.close();
    }
}
