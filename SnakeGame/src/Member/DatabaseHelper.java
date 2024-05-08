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
            // JDBC 드라이버 클래스 로드
            Class.forName(DRIVER_CLASS);
            
            // 데이터베이스 연결
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            // SQL 쿼리 준비
            String sql = "SELECT username FROM member WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            // 쿼리 파라미터 설정
            statement.setString(1, userName);
            statement.setString(2, password);
            
            // 쿼리 실행 및 결과 처리
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                loggedInUserId = resultSet.getString("username"); // 사용자 이름 저장
            }
            
            // 자원 해제
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return loggedInUserId;
    }
   
}