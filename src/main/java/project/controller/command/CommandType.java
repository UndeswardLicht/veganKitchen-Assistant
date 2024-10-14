package project.controller.command;

public enum CommandType {
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    DEFAULT(new DefaultCommand());
    private Command command;

    CommandType(Command command){
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public static Command findCommand(String commandStr){
        //todo
        //to change a little to avoid possible exceptions
        return CommandType.valueOf(commandStr.toUpperCase()).getCommand();
    }
}
