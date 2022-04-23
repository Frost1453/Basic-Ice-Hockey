package fr0sty.engine.scene;

import fr0sty.engine.Game;
import fr0sty.engine.objects.Player;
import fr0sty.engine.sprite.SpriteSheet;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Settings extends MouseAdapter {

    BufferedImage[] heads = new BufferedImage[30];

    SpriteSheet ss;

    int _x = 120, _y = 100;



    public Settings(SpriteSheet spriteSheet) {
        this.ss = spriteSheet;
        init();
    }

    public void init() {

        heads[0] = ss.pickImage(1,2,32,32);
        heads[1] = ss.pickImage(1,3,32,32);
        heads[2] = ss.pickImage(1,4,32,32);
        heads[3] = ss.pickImage(1,5,32,32);
        heads[4] = ss.pickImage(1,6,32,32);
        heads[5] = ss.pickImage(1,7,32,32);
        heads[6] = ss.pickImage(1,8,32,32);
        heads[7] = ss.pickImage(1,9,32,32);
        heads[8] = ss.pickImage(1,10,32,32);
        heads[9] = ss.pickImage(1,11,32,32);
        heads[10] = ss.pickImage(1,12,32,32);
        heads[11] = ss.pickImage(1,13,32,32);
        heads[12] = ss.pickImage(1,14,32,32);
        heads[13] = ss.pickImage(1,15,32,32);
        heads[14] = ss.pickImage(2,1,32,32);
        heads[15] = ss.pickImage(2,2,32,32);
        heads[16] = ss.pickImage(2,3,32,32);
        heads[17] = ss.pickImage(2,4,32,32);
        //heads[18] = ss.pickImage(2,5,32,32);
        //heads[19] = ss.pickImage(2,6,32,32);
        //heads[20] = ss.pickImage(2,7,32,32);

    }

    public void update() {

    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if (Game.STATE == Scene.Settings) {
/*
            if (mouseOver(mx,my,_x,_y,60,60)){
                Player.playerImg = heads[0];
            } else if (mouseOver(mx,my,_x+80,_y,60,60)){

            }
*/

            // FIRST HEAD
            if (mouseOver(mx,my,_x,_y,64,64)) {
                Player.playerImg = heads[0];
                return;
            }
            // SECOND HEAD
            if (mouseOver(mx,my,_x+80,_y,64,64)) {
                Player.playerImg = heads[1];
                return;
            }
            // THIRD HEAD
            if (mouseOver(mx,my,_x+160,_y,64,64)) {
                Player.playerImg = heads[2];
                return;
            }
            // FOURTH HEAD
            if (mouseOver(mx,my,_x+240,_y,64,64)) {
                Player.playerImg = heads[3];
                return;
            }
            // FIFTH HEAD
            if (mouseOver(mx,my,_x,_y+60,64,64)) {
                Player.playerImg = heads[4];
                return;
            }
            // SIXTH HEAD
            if (mouseOver(mx,my,_x+80,_y+60,64,64)) {
                Player.playerImg = heads[5];
                return;
            }
            // SEVENTH HEAD
            if (mouseOver(mx,my,_x+160,_y+60,64,64)) {
                Player.playerImg = heads[6];
                return;
            }
            // EIGHTH HEAD
            if (mouseOver(mx,my,_x+240,_y+60,64,64)) {
                Player.playerImg = heads[7];
                return;
            }
            // NINTH HEAD
            if (mouseOver(mx,my,_x,_y+120,64,64)) {
                Player.playerImg = heads[8];
                return;
            }
            // TENTH HEAD
            if (mouseOver(mx,my,_x+80,_y+120,64,64)) {
                Player.playerImg = heads[9];
                return;
            }
            // ELEVENTH HEAD
            if (mouseOver(mx,my,_x+160,_y+120,64,64)) {
                Player.playerImg = heads[10];
                return;
            }
            // TWELFTH HEAD
            if (mouseOver(mx,my,_x+240,_y+120,64,64)) {
                Player.playerImg = heads[11];
                return;
            }
            // THIRTEENTH HEAD
            if (mouseOver(mx,my,_x,_y+180,64,64)) {
                Player.playerImg = heads[12];
                return;
            }
            // FOURTEENTH HEAD
            if (mouseOver(mx,my,_x+80,_y+180,64,64)) {
                Player.playerImg = heads[13];
                return;
            }
            // FIFTEENTH HEAD
            if (mouseOver(mx,my,_x+160,_y+180,64,64)) {
                Player.playerImg = heads[14];
                return;
            }
            
            // ## Back ##
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
        Font font = null;
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("PixellettersFull.ttf");
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(48f);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.setColor(new Color(95, 205, 228));
        g.fillRect(0,0, Game.WIDTH,Game.HEIGHT);

        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString("Karakterini Sec",150,80);

        int xx = 120, yy = 100;

        for (int i = 0; i < 15;i++) {
            g.drawImage(heads[i],xx,yy,64,64,null );
            xx+=80;
            if(xx > 400){
                yy+=60;
                xx-=320;
            }
        }

        g.setColor(new Color(223, 113, 38));
        g.fillRect(150, 580, 300, 80);

        g.setColor(Color.BLACK);
        g.setFont(font);
        g.drawString("Geri", 265, 630);
    }
}
