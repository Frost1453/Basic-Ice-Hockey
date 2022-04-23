package fr0sty.engine.objects;

import fr0sty.engine.Game;
import fr0sty.engine.framework.GameObject;
import fr0sty.engine.framework.ID;
import fr0sty.engine.sprite.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends GameObject {

    public static BufferedImage playerImg;

    public static int colNum = 1, rowNum = 15;

    public Player(int _x, int _y, ID id, SpriteSheet spriteSheet) {
        super(_x, _y, id, spriteSheet);
        init();
    }

    @Override
    public void init() {
        //colNum = 1;
        //rowNum = 15;

        playerImg = spriteSheet.pickImage(colNum,rowNum,32,32);
    }

    @Override
    public void update() {
        x += velX;

        x = (int) Game.clamp(x, -3, Game.WIDTH - 109);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(playerImg,x,y,96,96,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x+3,y+28,90,1);
    }
}
