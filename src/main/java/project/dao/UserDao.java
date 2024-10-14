package project.dao;

public interface UserDao {
String authenticate(String login, String passEncrypted);
}
