package Member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DatabaseHelper {

    private static final String URL = "jdbc:mysql://localhost:3306/snakegame?useUnicode=true&characterEncoding=utf-8";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "dufrhdgkwk10@";
    private static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

    public static String authenticateUser(String userName, String password) {
        String loggedInUserId = null;
        
        try {
            // JDBC ����̹� Ŭ���� �ε�
            Class.forName(DRIVER_CLASS);
            
            // �����ͺ��̽� ����
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            // SQL ���� �غ�
            String sql = "SELECT username FROM member WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            // ���� �Ķ���� ����
            statement.setString(1, userName);
            statement.setString(2, password);
            
            // ���� ���� �� ��� ó��
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                loggedInUserId = resultSet.getString("username"); // ����� �̸� ����
            }
            
            // �ڿ� ����
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return loggedInUserId;
    }
   
}