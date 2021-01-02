/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package brickbreaker;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapGenerator
{
    public int map[][];
    public Brick brick;
    
    public MapGenerator(int row , int col, Color color){
        map = new int[row][col];
        for(int i = 0; i < map.length; i++){
            for(int j = 0;j < map[0].length; j++){
                map[i][j] = 1;
            }
        }
        
        brick = new Brick(color);
        brick.width = 540/col;
        brick.height = 150/row;
        brick.setColor(color);
    }
    
    public void draw(Graphics2D g) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] > 0) {
                    g.setColor(brick.getColor());

                    g.fillRect(j * (int)brick.getWidth() + 80, i * (int)brick.getHeight() + 50, (int)brick.getWidth(), (int)brick.getHeight());
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                  
                    g.drawRect(j * (int)brick.getWidth() + 80, i * (int)brick.getHeight() + 50, (int)brick.getWidth(), (int)brick.getHeight());

                }
            }

        }
    }
    
    public void setBricksValue(int value,int row,int col)
    {
        map[row][col] = value;
    }
}