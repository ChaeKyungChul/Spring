package SnakeGame;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SnakeGame extends JFrame {
    private String username; // 사용자 아이디를 저장할 필드

    public SnakeGame(String username) {
        this.username = username; // 사용자 이름 설정
        setTitle("Snake Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Board board = new Board(username); // 사용자 이름을 매개변수로 전달하여 Board 객체 생성
        add(board);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private int score = 0; // 점수저장 변수

    public void increaseScore(int points) {
        score += points;

        // 점수 업데이트 로직
    }

    public void gameOver() {
        // 게임 오버 로직
        showScore(); // 점수 표시 메서드 호출
        // 게임을 재시작하거나 메인 메뉴로 돌아가는 로직도 여기에 추가할 수 있습니다.
        // 여기서 this는 JFrame을 가리킵니다. 만약 다른 컨텍스트에서 호출된다면 적절히 수정해야 합니다.
        // 추가로, 게임을 재시작하거나 메인 메뉴로 돌아가는 로직을 여기에 추가할 수 있습니다.
    }

    private void showScore() {
        // 게임 오버 메시지에 사용자 아이디를 포함시킴
        JOptionPane.showMessageDialog(this, "게임 오버! " + username + "님의 점수는: " + score, "게임 오버", JOptionPane.INFORMATION_MESSAGE);
    }
}
