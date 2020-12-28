/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2103brickbreaker;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
/**
 *
 * @author USER
 */
public class Main extends JPanel implements ActionListener, KeyListener, Runnable{

    /**
     * @param args the command line arguments
     */
    
    boolean right = false;
    boolean left = false;
    int count = 0;
    
    int ballx = 160;
    int bally = 218;
    
    int racketx = 160;
    int rackety = 240;
    
    int boxx = 70;
    int boxy = 50;
    
    int boxwidth = 30;
    int boxheight = 20;
    
    Rectangle ball = new Rectangle(ballx, bally, 5, 5);
    Rectangle racket = new Rectangle(racketx, rackety, 40, 5);
    
    Rectangle[] box = new Rectangle[12];
    
    int movex = -1;
    int movey = -1;
    
    public static void main(String[] args) {
        // TODO code application logic here
        

        JFrame frame = new JFrame();
        Main game = new Main();
        JButton button = new JButton();
        
        frame.setSize(350,450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        game.addKeyListener(game);
        game.setFocusable(true);
        Thread thread = new Thread(game);
        thread.start();
        
    }
    
    public void paint(Graphics g){
        //background
        
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, 350, 450);
        
        //ball
        
        g.setColor(Color.white);
        g.fillOval(ball.x, ball.y, ball.width, ball.height);
        
        
        //racket
        g.setColor(Color.white);
        g.fillRect(racket.x, racket.y, racket.width, racket.height);
        
        //frame-edgey-area
        g.setColor(Color.white);
        g.drawRect(0, 0, 343, 250);
        
        //the void char HWHAHAHAHAH
        g.setColor(Color.black);
        g.fillRect(0, 251, 400, 200);
        
        for(int i = 0; i < box.length; i++){
            if(box[i] != null){
                g.setColor(Color.white);
                g.fill3DRect(box[i].x, box[i].y, box[i].width, box[i].height, true);
            }
        }
    }
    
    @Override
    public void run(){
        // TODO code application logic here
        createBox();
        while(true){
            
            for(int i = 0; i < box.length; i++){
                if(box[i] != null){
                    if(box[i].intersects(ball)){
                        
                        box[i] = null;
                        movey = -movey;
                        count++;
                    }
                }
            }
            repaint();
            ball.x += movex;
            ball.y += movey;
            
            if(right == true){
                racket.x += 3;
                left = false;
            }
            
            if(left == true){
                racket.x -= 3;
                right = false;
            }
            
            if(ball.x <= 0 || ball.x + ball.height >= 343){
                movex = -movex;
            }
            
            if(ball.y <= 0){
                movey = -movey;
            }
            
            if(racket.intersects(ball)){
                movey = -movey;
            }
            
            try{
                Thread.sleep(10);
            }catch(Exception x){
                
            }
               
        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
       //To change body of generated methods, choose Tools | Templates.
        
        int key = ke.getKeyCode();
        if(key == KeyEvent.VK_RIGHT){
            right = true;
        }
        if(key == KeyEvent.VK_LEFT){
            left = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //To change body of generated methods, choose Tools | Templates.
        
        int key = ke.getKeyCode();
        if(key == KeyEvent.VK_RIGHT){
            right = false;
        }
        if(key == KeyEvent.VK_LEFT){
            left = false;
        }
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void actionPerformed(ActionEvent ke) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void createBox(){
        //DLI MU PRINT SOMETIMES -- CHOOSY :<<
        for(int i = 0 ; i < box.length; i++){
            box[i] = new Rectangle(boxx, boxy, boxwidth, boxheight);
            
            if(i == 5){
                boxx = 70;
                boxy = (boxy + boxheight + 2);
            }
            
            if(i == 9){
                boxx = 100;
                boxy = (boxy + boxheight + 2);
            }
            boxx += (boxwidth + 1);
        }
    }
    
}
