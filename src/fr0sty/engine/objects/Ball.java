package fr0sty.engine.objects;

import fr0sty.engine.Game;
import fr0sty.engine.framework.GameObject;
import fr0sty.engine.framework.ID;
import fr0sty.engine.sprite.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Ball extends GameObject {

    BufferedImage ballImg;
    Player player;
    AIPlayer aiPlayer;

    public Ball(int _x, int _y, ID id, SpriteSheet spriteSheet, Player player, AIPlayer aiPlayer) {
        super(_x, _y, id, spriteSheet);
        this.player = player;
        this.aiPlayer = aiPlayer;
    }

    @Override
    public void init() {
        ballImg = spriteSheet.pickImage(7,15,32,32);
        velX = 2;
        velY = 5;
    }

    @Override
    public void update() {
        y -= velY;
        x -= velX;

        //if (y <= 0 || y >= Game.HEIGHT - 64) velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 48) velX *= -1;

        collision();
    }

    public void collision(){
        if (getBounds().intersects(player.getBounds()) || getBounds().intersects(aiPlayer.getBounds())){
            velY *= -1;
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(ballImg,x,y,32,32,null);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x+4,y+4,24,24);
    }
}
