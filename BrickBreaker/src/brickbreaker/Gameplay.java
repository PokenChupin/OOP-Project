/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreaker;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements KeyListener, ActionListener {


    private boolean play = false;
    private int score = 0;
    private int points = 5;
    private Timer Timer;
    private int delay = 6;
    private int playerX = 310;
    private Ball ball = new Ball(350,525,-1,-2,Color.GREEN);
    private int state=0;
    
    private Color color = Color.red;
    private int level = 1;
    private int row=3,col=7;
    private MapGenerator map;

    public Gameplay() {
        map = new MapGenerator(3, 7,color);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        Timer = new Timer(delay, this);
        Timer.start();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(1, 1, 692, 592);

        map.draw((Graphics2D) g);

        g.setColor(Color.yellow);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);
        
        g.setColor(Color.white);
        g.setFont(new Font("Tahoma", Font.BOLD, 22));
        g.drawString("Level " + level, 15, 30);
        
        g.setColor(Color.white);
        g.setFont(new Font("Tahoma", Font.BOLD, 22));
        g.drawString("Score: " + score, 540, 30);

        g.setColor(Color.yellow);
        g.fillRect(playerX, 550, 100, 8);

        g.setColor(Color.GREEN);
        g.fillOval(ball.x, ball.y, 20, 20);

        if (ball.y > 570) {
            play = false;
            ball.setXdir(0);
            ball.setYdir(0);
            map.brick.setColor(color);
            this.level = 1;
            
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("    Game Over Score: " + score, 175, 300);

            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("   Press Enter to Restart", 190, 340);
            state=1;
        }
        
        if(!play && state==0){
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Use Left and Right Arrow Keys", 125, 300);
            g.drawString(" to Move Paddle", 215, 340);
            g.drawString("   Press SPACE to Start", 155, 380);
        }
        
        if(map.brick.getTotal() == 0){
            ++(this.level);
            this.points = this.points * this.level;
            col += 2;
            row++;
            if(this.delay>0){
              this.delay-=2;
            }
            int wew = this.level%8;
            switch (wew) {
                case 0:
                    color = Color.RED;
                    break;
                case 1:
                    color= Color.GREEN;
                    break;
                case 2:
                    color = Color.BLUE;
                    break;
                case 3:
                    color = Color.YELLOW;
                    break;
                case 4:
                    color = Color.CYAN;
                    break;
                case 5:
                    color = Color.MAGENTA;
                    break;
                case 6:
                    color = Color.WHITE;
                    break;
                case 7:
                    color = Color.ORANGE;
                    break;
                default:
                    break;
            }
            map = new MapGenerator(row, col,color);
            map.brick.setTotal(row*col);
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Timer.start();

        if (play) {
            if (new Rectangle(ball.x, ball.y, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
                ball.setYdir( - ball.getYdir());
            }

            A:
            for (int i = 0; i < map.map.length; i++) {
                for (int j = 0; j < map.map[0].length; j++) {
                    if (map.map[i][j] > 0) {

                        Brick brick = new Brick((int)map.brick.getWidth()*j+80,i*(int)map.brick.getHeight()+50,(int)map.brick.getWidth(),(int)map.brick.getHeight(),21,Color.RED);

                        Rectangle ballrect = new Rectangle(ball.x, ball.y, 20, 20);

                        if (ballrect.intersects(brick)) {
                            map.setBricksValue(0, i, j);
                            map.brick.minusTotal();
                            score += points;
                            if (ball.x + 19 <= brick.x || ball.x + 1 >= brick.x + (int)map.brick.getWidth()) {
                                ball.setXdir(- ball.getXdir());
                            } else {
                                ball.setYdir(- ball.getYdir());
                            }
                            break A;
                        }
                    }


                }
            }
            ball.x += ball.getXdir();
            ball.y += ball.getYdir();
            if (ball.x < 0) {
                ball.setXdir(- ball.getXdir());
            }
            if (ball.y < 0) {
                ball.setYdir(- ball.getYdir());
            }
            if (ball.x > 670) {
                ball.setXdir(- ball.getXdir());
            }
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

     }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (playerX >= 600) {
                playerX = 600;
            } else {
                playerX += 20;
                if(!play){
                    ball.x += 20;
                }
            }
        }else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (playerX <= 10) {
                playerX = 10;
            } else {
                playerX -= 20;
                if(!play){
                    ball.x -= 20;
                }
            }
            
            
        }
        
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            play = true;
        }

        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (!play) {
                ball.x = 350;
                ball.y = 525;
                ball.setXdir(-1);
                ball.setYdir(-2);
                score = 0;
                level = 1;
                points = 5;
                playerX = 310;
                color = Color.red;
                row = 3;
                col = 7;
                map.brick.setTotal(21);
                map = new MapGenerator(row, col,color);
                repaint();
            }
        }
    }
}
