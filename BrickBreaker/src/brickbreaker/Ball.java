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
public class Ball extends Component{
    private int Xdir;
    private int Ydir;
    
    public Ball(int x, int y) {
        super(x, y,Color.GREEN);
        this.Xdir = 0;
        this.Ydir = 0;
    }
    
    public Ball(int x, int y, Color color) {
        super(x, y, color);
        this.Xdir = 0;
        this.Ydir = 0;
    }
    
    public Ball(int x, int y,int Xdir, int Ydir) {
        super(x, y);
        this.Xdir = Xdir;
        this.Ydir = Ydir;
    }

    public Ball(int x, int y,int Xdir, int Ydir, Color color) {
        super(x, y, color);
        this.Xdir = Xdir;
        this.Ydir = Ydir;
    }

    public int getXdir() {
        return Xdir;
    }

    public void setXdir(int Xdir) {
        this.Xdir = Xdir;
    }

    public int getYdir() {
        return Ydir;
    }

    public void setYdir(int Ydir) {
        this.Ydir = Ydir;
    }
    
    public void changeXdir(int dir){
        
    }
}
