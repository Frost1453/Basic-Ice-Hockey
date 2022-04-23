package fr0sty.engine;

import fr0sty.engine.framework.Handler;
import fr0sty.engine.framework.KeyInput;
import fr0sty.engine.scene.*;
import fr0sty.engine.scene.Menu;
import fr0sty.engine.sprite.ImageLoader;
//import fr0sty.engine.sprite.SoundHandler;
import fr0sty.engine.sprite.SpriteSheet;
import fr0sty.engine.window.Window;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.InputStream;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 600, HEIGHT = 800;
    private boolean running = false;
    private Thread thread;

    public static boolean gameOvered = false;
    
    private SpriteSheet ss;
    private BufferedImage spriteSheet;
    private ImageLoader loader;
    private BufferedImage icon;
    private BufferedImage headImg;

    private Handler handler;

    private GameScene game;
    private Menu menu;
    private Help help;
    private Settings settings;
    private GameOverScene gameOver;
    
    public static Font font;
    public static Font font2;
    
    int frames = 0;

    //private SoundHandler soundHandler;

    //#########################################
    public static Scene STATE = Scene.Menu;
    //#########################################

    public Game() {
        init();
        start();
        
        
    }

    public void init() {
    	// INITIALIZING COMPONENTS        
    	handler = new Handler();
    	loader = new ImageLoader();
    	icon = loader.getImage("/icon.png");
    	headImg = loader.getImage("/headImg.png");
    	menu = new Menu(headImg);
    	spriteSheet = loader.getImage("/hockey_sprite.png");
    	ss = new SpriteSheet(spriteSheet);
    	
    	settings = new Settings(ss);
    	help = new Help();
    	gameOver = new GameOverScene();

    	// CREATING AND INITIALIZING WINDOW
        new Window(WIDTH,HEIGHT,"FIRST BASIC GAME",this,icon);

        // INITIALIZING FONTS
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("PixellettersFull.ttf");
    	font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(64f);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        InputStream stream2 = ClassLoader.getSystemClassLoader().getResourceAsStream("PixellettersFull.ttf");
    	font2 = null;
		try {
			font2 = Font.createFont(Font.TRUETYPE_FONT, stream2).deriveFont(32f);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
		// ADDING MOUSE INPUT TO SCENES
        this.addMouseListener(menu);
        this.addMouseListener(help);
        this.addMouseListener(settings);
        this.addMouseListener(help);
        this.addMouseListener(gameOver);

        // ADDING KEYBOARD INPUT TO CONTROL PLAYER
        this.addKeyListener(new KeyInput(handler, this));
        game = new GameScene(handler,this);
        //soundHandler = new SoundHandler();
    }

    // FUNCTIONS
    public synchronized void start() {
        if (!running){
            running = true;
            thread = new Thread(this);
            thread.start();
            System.out.println("GAME STARTED");
        }
    }

    public synchronized void stop() {
        if (running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.gc();
    }

    public void update() {
        if (STATE == Scene.Menu){
            menu.update();
        }
        if (STATE == Scene.Settings) {
            settings.update();
        }
        if (STATE == Scene.Help) {
            help.update();
        }
        if (STATE == Scene.Game){
            game.update();
            if(gameOvered) {
            	handler.removeAll();
            	gameOver.update();
            }
        }        
    }

    public void draw() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        if(STATE == Scene.Menu){
            menu.draw(g);
        }
        if (STATE == Scene.Settings) {
            settings.draw(g);
        }
        if (STATE == Scene.Help) {
            help.draw(g);
        }
        if(STATE == Scene.Game){
            game.draw(g);
        }
        if (STATE == Scene.GameOver){
            gameOver.draw(g);
        }

        g.dispose();
        bs.show();
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfUpdates = 60.0;
        double ns = 1000000000 / amountOfUpdates;
        double delta = 0;
        long timer = System.currentTimeMillis();
        frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                delta--;
            }
            draw();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;

            }
        }
        stop();
    }

    public static float clamp(float value, float min, float max) {
        if (value <= min){
            return min;
        } else if (value >= max) {
            return max;
        }else {
            return value;
        }
    }
    
    
    
    // MAIN FUNCTION
    public static void main(String[] args) {
        new Game();
    }
}