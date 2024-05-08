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

                // ����� ����
                String loggedInUserId = DatabaseHelper.authenticateUser(userName, new String(password));

                if (loggedInUserId != null) {
                    JOptionPane.showMessageDialog(null, "�α��� ����!");
                    // ������ ���� ȭ������ ��ȯ                    
                    SnakeGame game = new SnakeGame(loggedInUserId); // SnakeGame �ν��Ͻ� ����
                    game.setVisible(true); // ���� ȭ���� ���̰� ����
                    LoginUI.this.dispose(); // �α��� â �ݱ�
                } else {
                    JOptionPane.showMessageDialog(null, "�α��� ����. ����� �̸� �Ǵ� ��й�ȣ�� �߸��Ǿ����ϴ�.");
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