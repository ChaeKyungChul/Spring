package SnakeGame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SnakeGame extends JFrame {
    private String username; // ����� ���̵� ������ �ʵ�

    public SnakeGame(String username) {
        this.username = username; // ����� �̸� ����
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Board board = new Board(username); // ����� �̸��� �Ű������� �����Ͽ� Board ��ü ����
        add(board);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private int score = 0; // �������� ����

    public void increaseScore(int points) {
        score += points;

        // ���� ������Ʈ ����
    }

    public void gameOver() {
        // ���� ���� ����
        showScore(); // ���� ǥ�� �޼��� ȣ��
        // ������ ������ϰų� ���� �޴��� ���ư��� ������ ���⿡ �߰��� �� �ֽ��ϴ�.
        // ���⼭ this�� JFrame�� ����ŵ�ϴ�. ���� �ٸ� ���ؽ�Ʈ���� ȣ��ȴٸ� ������ �����ؾ� �մϴ�.
        // �߰���, ������ ������ϰų� ���� �޴��� ���ư��� ������ ���⿡ �߰��� �� �ֽ��ϴ�.
    }

    private void showScore() {
        // ���� ���� �޽����� ����� ���̵� ���Խ�Ŵ
        JOptionPane.showMessageDialog(this, "���� ����! " + username + "���� ������: " + score, "���� ����", JOptionPane.INFORMATION_MESSAGE);
    }
}
