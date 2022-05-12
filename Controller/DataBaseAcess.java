package Controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseAcess {
  private Connection connection;
  private String url;
  private String password;
  private String user;
  private String dName;

  DataBaseAcess() {
    user = "root";
    password = "agena_DEBANE";
    dName = "Login_Form";
    url = "jdbc:mysql://localhost:3306/" + dName;

  }

  public Connection getconnection() {
    try {
      connection = DriverManager.getConnection(url, user, password);
    }

    catch (Exception e) {
      return null;
    }
    return connection;
  }

}
