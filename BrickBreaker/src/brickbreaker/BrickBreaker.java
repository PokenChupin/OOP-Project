/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreaker;

import javax.swing.*;


public class BrickBreaker {
    public static void main(String[] args)
    {
        JFrame obj = new JFrame();
        Gameplay game = new Gameplay();
        
        obj.setBounds(10,10,700,600);
        obj.setTitle("BrickBreaker");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        obj.add(game);
    }
}
