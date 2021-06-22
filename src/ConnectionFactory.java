
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lecox
 */
public class ConnectionFactory {

    Connection connection = null;
    private static final String URL = "jdbc:mysql://localhost/mecanica?useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "";

    /**
     *
     * @return
     */
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (connection == null) {
                connection = DriverManager.getConnection(URL, USER, PASS);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;

    }

    public void CloseConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            //n faz nada
        }

    }

}
