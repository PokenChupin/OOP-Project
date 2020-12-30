/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreaker;

import java.awt.Color;

/**
 *
 * @author JR
 */
public class Component {
    
    public int x;
    public int y;
    public Color color;
    

    public Component(Color color){
        this.color = color;
        this.x = 0;
        this.y = 0;
    }
    
    public Component(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = Color.red;
    }

    public Component(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public void updateX(int x){
        this.x += x;
    }
    
    public void updateY(int y){
        this.y += y;
    }
}
