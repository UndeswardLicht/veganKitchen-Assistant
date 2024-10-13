package com.example.jakartaeedemounicourse;

import java.io.*;

import org.apache.logging.log4j.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/controller")
public class Controller extends HttpServlet {
    private String message;
    private static final Logger LOGGER = LogManager.getLogger(Controller.class);

    public void init() {
        LOGGER.debug("Servlet initialized successfully");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.debug("GET request received");
        String numString = request.getParameter("number");
        int number = Integer.parseInt(numString);
        number *= 2;
        request.setAttribute("first", number);
        request.getRequestDispatcher("/jsp/main.jsp").forward(request, response);
        response.setContentType("text/html");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.debug("POST request received");
    }

    public void destroy() {
        LOGGER.info("Servlet destroyed successfully");
    }
}