package project.controller;
import java.io.*;

import org.apache.logging.log4j.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import project.controller.command.Command;
import project.controller.command.CommandType;

@WebServlet(name = "helloServlet", value = "/controller")
public class Controller extends HttpServlet {
    private String message;
    private static final Logger LOGGER = LogManager.getLogger(Controller.class);

    public void init() {
        LOGGER.debug("Servlet initialized successfully");
//        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.debug("GET request received");
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        LOGGER.debug("POST request received");
        processRequest(request, response);
    }

    public void destroy() {
        LOGGER.info("Servlet destroyed successfully");
    }

    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        String commandStr = request.getParameter("command");
        Command command = CommandType.findCommand(commandStr);
        String page = command.execute(request);
        request.getRequestDispatcher(page).forward(request, response);
    }
}