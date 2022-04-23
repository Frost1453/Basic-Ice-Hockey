package fr0sty.engine.framework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import fr0sty.engine.Game;
import fr0sty.engine.scene.Scene;

public class KeyInput extends KeyAdapter {

    Handler handler;
    Game game;

    private boolean[] keys = {false, false};

    public KeyInput(Handler handler, Game game) {
        this.handler = handler;
        this.game = game;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        int size = handler.obj.size();
        for (int i = 0; i < size; i++){
            GameObject obj = handler.obj.get(i);

            if(obj.getID() == ID.Player){
                if (key == KeyEvent.VK_LEFT) {
                    keys[0] = true;
                    obj.setVelX(-4);
                }
                if (key == KeyEvent.VK_RIGHT) {
                    keys[1] = true;
                    obj.setVelX(4);
                }
                if (key == KeyEvent.VK_ESCAPE) {
					System.exit(1);
				}
            }
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        int size = handler.obj.size();
        for (int i = 0; i < size; i++){
            GameObject obj = handler.obj.get(i);

            if(obj.getID() == ID.Player){
                if (key == KeyEvent.VK_LEFT) {
                    keys[0] = false;
                }
                if (key == KeyEvent.VK_RIGHT) {
                    keys[1] = false;
                }
                if (!keys[0] && !keys[1]){
                    obj.setVelX(0);
                }
            }
        }
    }
}
