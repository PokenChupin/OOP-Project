/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreaker;
import java.awt.Rectangle;

import java.awt.Color;

/**
 *
 * @author JR
 */
public class Brick extends Rectangle {

    private int total;
    private Color color;
    
    public Brick(Color color){
        super(0,0,0,0);
        this.color = color;
        this.total = 21;
    }
    
    public Brick(int x, int y, int width, int height){
        super(x,y,width,height);
        this.color = Color.GREEN;
        this.total = 21;
    }
    
    public Brick( int x, int y,int width, int height,int total, Color color) {
        super(x, y,width,height);
        this.color = color;
        this.total = total;
    }
    
    public Color getColor(){
        return this.color;
    }
    
    public void setColor(Color color){
        this.color = color;
    }
   
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
   
    public void minusTotal(){
        --(this.total);
    }
}
