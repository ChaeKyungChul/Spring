package SnakeGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import Member.DatabaseHelper;

public class Board extends JPanel implements ActionListener {
	

    private final int B_WIDTH = 700;
    private final int B_HEIGHT = 700;
    private final int DOT_SIZE = 10;
    private final int ALL_DOTS = 200;
    private final int RAND_POS = 29;
    private final int DELAY = 140;

    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];

    private JButton restartButton; //�����
    private String username; // ����� �̸������߰�
     

    private Timer timer;
    private boolean inGame = true;
    private boolean paused = false;
    private Snake snake;
    private Apple apple;
    private int score = 0;
    
    public Board(String username) {
        this.username = username; // ����� �̸� �ʱ�ȭ
        initBoard();
        initRestartButton();
    }
    
    
   // public Board(String username) {
     	
    			
    //}

    private void initRestartButton() {
        restartButton = new JButton("�����");
        restartButton.setBounds(B_WIDTH / 2 - 50, B_HEIGHT / 2 + 50, 100, 40); // ��ư ��ġ �� ũ�� ����
        restartButton.addActionListener(e -> startGame()); // ��ư Ŭ�� �� ���� �����
        this.setLayout(null); // ������Ʈ�� ��ġ�� �������� �����ϱ� ���� ���̾ƿ� �Ŵ����� null�� ����
        this.add(restartButton);
        restartButton.setVisible(false); // ó������ ��ư�� ������ �ʰ� ����
    }


	private void initBoard() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        setFocusable(true);

        snake = new Snake(DOT_SIZE, B_WIDTH, B_HEIGHT);
        apple = new Apple(DOT_SIZE, RAND_POS, B_WIDTH, B_HEIGHT);

        addKeyListener(new TAdapter());

        startGame();
    }
    

	private void startGame() {
	    inGame = true;
	    paused = false;

	    // ���� Ÿ�̸Ӱ� ���� ��� ������Ű�� ����
	    if (timer != null) {
	        timer.stop();
	        timer = null;
	    }

	    // �� Ÿ�̸� ���� �� ����
	    timer = new Timer(DELAY, this);
	    timer.start(); // Ÿ�̸� ����

	    // ���� ���� �ʱ�ȭ
	    score = 0; // ���� �ʱ�ȭ
	    snake = new Snake(DOT_SIZE, B_WIDTH, B_HEIGHT); // �� �ʱ�ȭ
	    apple = new Apple(DOT_SIZE, RAND_POS, B_WIDTH, B_HEIGHT); // ��� �ʱ�ȭ

	    // ����� ��ư�� �̹� �����Ǿ� �ִٸ� ����ϴ�.
	    if (restartButton != null) {
	        restartButton.setVisible(false);
	    }
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            if (!paused) {
                checkApple();
                checkCollision();
                snake.move();
            }
        }
        repaint();
    }

    private void checkApple() {
        if (snake.getX() == apple.getX() && snake.getY() == apple.getY()) {
            snake.grow();
            apple.locateApple();
            increaseScore(10);
        }
    }

    private void checkCollision() {
        int snakeX = snake.getX();
        int snakeY = snake.getY();

        if (snakeX >= B_WIDTH || snakeX < 0 || snakeY >= B_HEIGHT || snakeY < 0) {
            inGame = false;
        }

        if (!inGame) {
            timer.stop();
        }
    }

    private class TAdapter extends KeyAdapter {
    	@Override
    	public void keyPressed(KeyEvent e) {
    		snake.keyPressed(e);
    		
    		int key = e.getKeyCode();
    		
    		if(key == KeyEvent.VK_SPACE) {
    			if(inGame) {
    				paused = !paused;
    			}else {
    				startGame();
    			}
    		}
    	}
    
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }

    private void doDrawing(Graphics g) {
        if (inGame) {
            g.setColor(Color.RED);
            g.fillRect(apple.getX(), apple.getY(), DOT_SIZE, DOT_SIZE);

            snake.draw(g);
        } else {
            gameOver(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }
    
    public void increaseScore(int points) {
        score += points;
        System.out.println("������ " + points + "�� �����Ͽ� ���� ������ " + score + "���Դϴ�."); 
        
        // ���� ������Ʈ ����
    }
    private void gameOver(Graphics g) {
        String msg = "�� " + username + " ���� ���� ��";
        String scoreMsg = "����: " + score;

        Font big = new Font("Helvetica", Font.BOLD, 25);
        FontMetrics metr = getFontMetrics(big);

        g.setColor(Color.white);
        g.setFont(big);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
        g.drawString(scoreMsg, (B_WIDTH - metr.stringWidth(scoreMsg)) / 2, B_HEIGHT / 2 + 30);

        restartButton.setVisible(true);
    }
    
}