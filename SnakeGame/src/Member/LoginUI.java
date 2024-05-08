package Member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import SnakeGame.SnakeGame;

public class LoginUI extends JFrame {
    private JPanel panel;
    private JLabel userLabel;
    private JTextField userText;
    private JLabel passwordLabel;
    private JPasswordField passwordText;

    public LoginUI() {
        this.setTitle("Login");
        this.setSize(350, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        this.add(panel);
        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(10, 80, 80, 25);
        panel.add(loginButton);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = userText.getText();
                char[] password = passwordText.getPassword();

                // 사용자 인증
                String loggedInUserId = DatabaseHelper.authenticateUser(userName, new String(password));

                if (loggedInUserId != null) {
                    JOptionPane.showMessageDialog(null, "로그인 성공!");
                    // 지렁이 게임 화면으로 전환                    
                    SnakeGame game = new SnakeGame(loggedInUserId); // SnakeGame 인스턴스 생성
                    game.setVisible(true); // 게임 화면을 보이게 설정
                    LoginUI.this.dispose(); // 로그인 창 닫기
                } else {
                    JOptionPane.showMessageDialog(null, "로그인 실패. 사용자 이름 또는 비밀번호가 잘못되었습니다.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginUI().setVisible(true);
            }
        });
    }
}