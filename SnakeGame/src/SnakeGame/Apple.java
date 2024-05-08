package SnakeGame;

import javax.swing.*;
import java.awt.*;

public class Apple {

    private int x;
    private int y;
    private Image image;
    private final int DOT_SIZE;
    private final int RAND_POS;
    private final int B_WIDTH;
    private final int B_HEIGHT;

    public Apple(int dotSize, int randPos, int b_WIDTH, int b_HEIGHT) {
        this.DOT_SIZE = dotSize;
        this.RAND_POS = randPos;
        this.B_WIDTH = b_WIDTH;
        this.B_HEIGHT = b_HEIGHT;
        ImageIcon iia = new ImageIcon("src/resources/apple.jpg");
        image = iia.getImage();
        locateApple();
    }

    public void locateApple() {
        int r = (int) (Math.random() * RAND_POS);
        x = r * DOT_SIZE;

        r = (int) (Math.random() * RAND_POS);
        y = r * DOT_SIZE;

        // x 좌표를 게임 화면의 너비 범위 내에서 설정
        x %= B_WIDTH;
        // y 좌표를 게임 화면의 높이 범위 내에서 설정
        y %= B_HEIGHT;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImage() {
        return image;
    }

    // 이동 메서드가 필요 없으므로 비워둡니다.
    public void move() {
        // 비워둡니다.
    }
}