package fr0sty.engine.scene;

import fr0sty.engine.Game;

import java.awt.*;
import java.awt.event.MouseAdapter;

public class GameOverScene extends MouseAdapter {

    private static boolean playerWon;
    private static boolean aiWon;

    public GameOverScene() {
        playerWon = false;
        aiWon = false;
    }

    public void update() {

    }

    public void draw(Graphics g) {
    	/*
    	InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("PixellettersFull.ttf");
    	Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, stream).deriveFont(64f);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
    	
		/*
		InputStream stream2 = ClassLoader.getSystemClassLoader().getResourceAsStream("PixellettersFull.ttf");
    	Font font2 = null;
		try {
			font2 = Font.createFont(Font.TRUETYPE_FONT, stream2).deriveFont(32f);
		} catch (Exception e) {
			e.printStackTrace();
		}
*/
        g.clearRect(0, 0, Game.WIDTH, Game.HEIGHT);

        g.setColor(new Color(95, 205, 228));
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

        if (aiWon) {
            //System.out.println("YOU LOST");
            g.setColor(Color.BLACK);
            g.setFont(Game.font);
            g.drawString("Kaybettin!", 180, 300);
            
            g.setFont(Game.font2);
            g.drawString("Tekrar oynamak icin [SPACE] tusuna bas", 80, 400);
            g.drawString("Cikmak icin [ESC] tusuna bas", 150, 450);
        } else if (playerWon) {
            g.setColor(Color.RED);
            g.setFont(Game.font);
            g.drawString("Kazandin!", 200, 300);
            
            g.setColor(Color.BLACK);
            g.setFont(Game.font2);
            g.drawString("Tekrar oynamak icin [SPACE] tusuna bas", 80, 400);
            g.drawString("Cikmak icin [ESC] tusuna bas", 150, 450);
        }
        System.gc();
    }

    public static boolean isPlayerWon() {
        return playerWon;
    }

    public static void setPlayerWon(boolean playerWon) {
        GameOverScene.playerWon = playerWon;
    }

    public static boolean isAiWon() {
        return aiWon;
    }

    public static void setAiWon(boolean aiWon) {
        GameOverScene.aiWon = aiWon;
    }
}
