package fr0sty.engine.objects;

import fr0sty.engine.Game;
import fr0sty.engine.framework.GameObject;
import fr0sty.engine.framework.Handler;
import fr0sty.engine.framework.ID;
import fr0sty.engine.sprite.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class AIPlayer extends GameObject {

    Random r;
    int rowNum;
    int colNum;
    BufferedImage playerImg;

    Handler handler;

    public AIPlayer(int _x, int _y, ID id, SpriteSheet spriteSheet, Handler handler) {
        super(_x, _y, id, spriteSheet);
        this.handler = handler;
    }

    @Override
    public void init() {
        r = new Random();
        rowNum = r.nextInt((11-1)+1)+1;
        colNum = r.nextInt((5-4)+1)+4;


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
        return new Rectangle(x, y + 66, 90, 1);
    }
}
