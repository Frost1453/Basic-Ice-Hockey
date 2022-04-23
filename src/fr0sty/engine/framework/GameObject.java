package fr0sty.engine.framework;

import fr0sty.engine.sprite.SpriteSheet;

import java.awt.*;

public abstract class GameObject {

    protected int x;
    protected int y;
    protected int velX;
    protected int velY;
    protected ID id;
    protected SpriteSheet spriteSheet;

    protected GameObject(int _x, int _y, ID id, SpriteSheet spriteSheet) {
        x = _x;
        y = _y;
        this.id = id;
        this.spriteSheet = spriteSheet;

        init();
    }

    public abstract void init();
    public abstract void update();
    public abstract void draw(Graphics g);

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getVelX() {
        return velX;
    }
    public int getVelY() {
        return velY;
    }
    public ID getID() {
        return id;
    }

    public void setX(int _x) {
        x = _x;
    }
    public void setY(int _y) {
        y = _y;
    }
    public void setVelX(int velX) {
        this.velX = velX;
    }
    public void setVelY(int velY) {
        this.velY = velY;
    }
    public void setID(ID id) {
        this.id = id;
    }
    public abstract Rectangle getBounds();
}
