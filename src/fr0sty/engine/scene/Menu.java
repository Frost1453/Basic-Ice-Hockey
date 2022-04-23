package fr0sty.engine.scene;

import fr0sty.engine.Game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class Menu extends MouseAdapter {
	
	BufferedImage image;
	
    public Menu(BufferedImage image) {
    	this.image = image;
    }

    public void update() {

    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (Game.STATE == Scene.Menu) {

            // ## PLAY ##
            if (mouseOver(mx, my, 200, 250, 200, 80)) {
                Game.STATE = Scene.Game;
            }

            // ## SETTINGS ##
            if (mouseOver(mx, my, 150, 360, 300, 80)) {
                Game.STATE = Scene.Settings;
            }

            // ## HELP ##
            if (mouseOver(mx, my, 150, 470, 300, 80)) {
                Game.STATE = Scene.Help;
            }

            // ## QUIT ##
            if (mouseOver(mx, my, 150, 580, 300, 80)) {
                System.exit(0);
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
        //Font font = new Font("PixellettersFull",0,48);

        g.setColor(new Color(95, 205, 228));
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

        g.setColor(Color.BLACK);
        g.setFont(Game.font);
        g.drawString("Ana Menu", 190, 100);

        g.setColor(new Color(223, 113, 38));
        g.fillRect(150, 250, 300, 80);

        g.setColor(Color.BLACK);
        g.setFont(Game.font);
        g.drawString("Oyna", 250, 300);

        g.setColor(new Color(223, 113, 38));
        g.fillRect(150, 360, 300, 80);

        g.setColor(Color.BLACK);
        g.setFont(Game.font);
        g.drawString("Ayarlar", 230, 410);


        g.setColor(new Color(223, 113, 38));
        g.fillRect(150, 470, 300, 80);

        g.setColor(Color.BLACK);
        g.setFont(Game.font);
        g.drawString("Yardim", 235, 520);


        g.setColor(new Color(223, 113, 38));
        g.fillRect(150, 580, 300, 80);

        g.setColor(Color.BLACK);
        g.setFont(Game.font);
        g.drawString("Cikis", 255, 630);
        
        g.setFont(Game.font2);
        g.drawString("by fr0sty", 400, 740);
        g.drawImage(image, 500, 700, 64,64, null);
    }
}
