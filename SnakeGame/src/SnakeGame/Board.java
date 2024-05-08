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

    private JButton restartButton; //재시작
    private String username; // 사용자 이름변수추가
     

    private Timer timer;
    private boolean inGame = true;
    private boolean paused = false;
    private Snake snake;
    private Apple apple;
    private int score = 0;
    
    public Board(String username) {
        this.username = username; // 사용자 이름 초기화
        initBoard();
        initRestartButton();
    }
    
    
   // public Board(String username) {
     	
    			
    //}

    private void initRestartButton() {
        restartButton = new JButton("재시작");
        restartButton.setBounds(B_WIDTH / 2 - 50, B_HEIGHT / 2 + 50, 100, 40); // 버튼 위치 및 크기 설정
        restartButton.addActionListener(e -> startGame()); // 버튼 클릭 시 게임 재시작
        this.setLayout(null); // 컴포넌트의 위치를 수동으로 조정하기 위해 레이아웃 매니저를 null로 설정
        this.add(restartButton);
        restartButton.setVisible(false); // 처음에는 버튼이 보이지 않게 설정
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

	    // 기존 타이머가 있을 경우 정지시키고 제거
	    if (timer != null) {
	        timer.stop();
	        timer = null;
	    }

	    // 새 타이머 생성 및 시작
	    timer = new Timer(DELAY, this);
	    timer.start(); // 타이머 시작

	    // 게임 상태 초기화
	    score = 0; // 점수 초기화
	    snake = new Snake(DOT_SIZE, B_WIDTH, B_HEIGHT); // 뱀 초기화
	    apple = new Apple(DOT_SIZE, RAND_POS, B_WIDTH, B_HEIGHT); // 사과 초기화

	    // 재시작 버튼이 이미 생성되어 있다면 숨깁니다.
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
        System.out.println("점수가 " + points + "점 증가하여 현재 점수는 " + score + "점입니다."); 
        
        // 점수 업데이트 로직
    }
    private void gameOver(Graphics g) {
        String msg = "♥ " + username + " 게임 오버 ♥";
        String scoreMsg = "점수: " + score;

        Font big = new Font("Helvetica", Font.BOLD, 25);
        FontMetrics metr = getFontMetrics(big);

        g.setColor(Color.white);
        g.setFont(big);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
        g.drawString(scoreMsg, (B_WIDTH - metr.stringWidth(scoreMsg)) / 2, B_HEIGHT / 2 + 30);

        restartButton.setVisible(true);
    }
    
}