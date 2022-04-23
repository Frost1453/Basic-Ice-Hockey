package fr0sty.engine.scene;

import fr0sty.engine.Game;
import fr0sty.engine.framework.AIController;
import fr0sty.engine.framework.GameObject;
import fr0sty.engine.framework.Handler;
import fr0sty.engine.framework.ID;
import fr0sty.engine.objects.AIPlayer;
import fr0sty.engine.objects.Ball;
import fr0sty.engine.objects.Player;
import fr0sty.engine.sprite.ImageLoader;
import fr0sty.engine.sprite.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameScene {

    Handler handler;
    Game game;

    GameObject player;
    GameObject aiPlayer;
    GameObject ball;

    private SpriteSheet ss;
    private BufferedImage spriteSheet;
    private ImageLoader loader;

    AIController aicontroller;
    GameOverScene gameOver;


    public GameScene(Handler handler, Game game) {
        this.handler = handler;
        this.game = game;

        init();
    }

    private void init() {
        loader = new ImageLoader();
        spriteSheet = loader.getImage("/hockey_sprite.png");
        ss = new SpriteSheet(spriteSheet);

        gameOver = new GameOverScene();

        player = handler.addObjects(new Player(250,650, ID.Player,ss));
        aiPlayer = handler.addObjects(new AIPlayer(250,20,ID.AIPlayer,ss,handler));
        ball = handler.addObjects(new Ball(Game.WIDTH/2,Game.HEIGHT/2,ID.Ball,ss, (Player) player, (AIPlayer) aiPlayer));

        aicontroller = new AIController(handler, (AIPlayer) aiPlayer, (Ball) ball);

        handler.addObject(player);
        handler.addObject(aiPlayer);
        handler.addObject(ball);

    }

    public void update() {
        aicontroller.update();
        handler.update();

        if (ball.getY() >= Game.HEIGHT){
            Game.STATE = Scene.GameOver;
            GameOverScene.setAiWon(true);
        } else if (ball.getY() <= 0) {
            Game.STATE = Scene.GameOver;
            GameOverScene.setPlayerWon(true);
        }
    }

    public void draw(Graphics g) {
        g.setColor(new Color(95, 205, 228));
        g.fillRect(0,0,Game.WIDTH,Game.HEIGHT);
        handler.draw(g);
    }
}
