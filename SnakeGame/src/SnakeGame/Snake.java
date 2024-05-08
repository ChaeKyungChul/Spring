package SnakeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Snake {
    public static final int ALL_DOTS = 200;
    private final int[] x = new int[ALL_DOTS];
    private final int[] y = new int[ALL_DOTS];
    private final int DOT_SIZE;
    private final int B_WIDTH;
    private final int B_HEIGHT;
    private int dots = 3;
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean inGame = true; // ���� ���¸� ǥ���ϴ� ���� �߰�

    public Snake(int dotSize, int boardWidth, int boardHeight) {
        this.DOT_SIZE = dotSize;
        this.B_WIDTH = boardWidth;
        this.B_HEIGHT = boardHeight;

        for (int i = 0; i < dots; i++) {
            x[i] = 50 - i * DOT_SIZE;
            y[i] = 50;
        }
    }

    public void move() {
        for (int i = dots; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        if (leftDirection) {
            x[0] -= DOT_SIZE;
        }

        if (rightDirection) {
            x[0] += DOT_SIZE;
        }

        if (upDirection) {
            y[0] -= DOT_SIZE;
        }

        if (downDirection) {
            y[0] += DOT_SIZE;
        }

        checkCollision();
    }

    private void checkCollision() {
        for (int z = dots; z > 0; z--) {
            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }
        }

        if (y[0] >= B_HEIGHT) {
            inGame = false;
        }

        if (y[0] < 0) {
            inGame = false;
        }

        if (x[0] >= B_WIDTH) {
            inGame = false;
        }

        if (x[0] < 0) {
            inGame = false;
        }
    }

    public void grow() {
        dots++;
    }

    public void draw(Graphics g) {
        if (inGame) {
            for (int i = 0; i < dots; i++) {
                if (i == 0) {
                    g.setColor(Color.RED); // �Ӹ��� ������
                    g.fillRect(x[i], y[i], DOT_SIZE, DOT_SIZE);
                } else {
                    g.setColor(Color.white); // ������ ������
                    g.fillRect(x[i], y[i], DOT_SIZE, DOT_SIZE);
                }
            }
        } else {
            // ���� ���� ������ ���� ó���� ���⿡ �߰��� �� �ֽ��ϴ�.
        }
    }
    

    public int getX() {
        return x[0];
    }

    public int getY() {
        return y[0];
    }

    public int getDots() {
        return dots;
    }

    public void keyPressed(KeyEvent e) {
    	int key = e.getKeyCode();
    	
    	if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
    		leftDirection = true;
    		upDirection = false;
    		downDirection = false;
    		
    	}
    	if ((key == KeyEvent.VK_RIGHT)&& (!leftDirection)) {
    		rightDirection = true;
    		upDirection = false;
    		downDirection = false;
    	}
    	if ((key == KeyEvent.VK_UP)&& (!downDirection))  {
    		upDirection = true;
    		rightDirection = false;
    		leftDirection = false;				
    	}
    	 if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
    	        downDirection = true;
    	        rightDirection = false;
    	        leftDirection = false;
     }
    }		
}


		
	
