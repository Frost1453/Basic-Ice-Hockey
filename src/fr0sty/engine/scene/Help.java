package fr0sty.engine.scene;

import fr0sty.engine.Game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Help extends MouseAdapter {
	
    public void update() {

    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (Game.STATE == Scene.Help) {

            // ## Geri ##
            if (mouseOver(mx, my, 150, 580, 300, 80)) {
                Game.STATE = Scene.Menu;
            }
        }
    }

    public boolean mouseOver(int mx, int my, int x, int y, int w, int h){
        if (mx > x && mx < x + w) {
            if (my > y && my < y + h) {
                return true;
            } else return false;
        } else return false;
    }

    public void draw(Graphics g) {
        Font font = new Font("PixellettersFull",0,48);

        g.setColor(new Color(95, 205, 228));
        g.fillRect(0,0, Game.WIDTH,Game.HEIGHT);
        
        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString("YARDIM", 225, 300);

        g.setFont(Game.font2);
        g.drawString("Yon tuslari ile karakterini yonlendir topu kacirma!", 25, 350);

        g.setColor(new Color(223, 113, 38));
        g.fillRect(150, 580, 300, 80);

        g.setColor(Color.BLACK);
        g.setFont(font);       
        g.drawString("Geri", 265, 630);
    }
}
