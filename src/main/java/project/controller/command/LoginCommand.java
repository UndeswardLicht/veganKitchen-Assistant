package project.controller.command;

import jakarta.servlet.http.HttpServletRequest;
import project.service.UserService;
import project.service.impl.UserServiceImpl;

public class LoginCommand implements Command{

    @Override
    public String execute(HttpServletRequest request) {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        UserService userService = new UserServiceImpl(); //todo
        String page;
        if (userService.authenticate(login,password)){
            request.setAttribute("user", login);
            page = "jsp/main.jsp";
        } else {
            request.setAttribute("errorLoginMessage", "Incorrect login or password");
            page = "jsp/login.jsp";
        }
        return page;
    }
}
