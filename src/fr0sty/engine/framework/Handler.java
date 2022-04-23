package fr0sty.engine.framework;

import java.awt.*;
import java.util.ArrayList;

public class Handler {

    public ArrayList<GameObject> obj = new ArrayList<>();

    public void update() {
        for (GameObject obj : obj) {
            obj.update();
        }
    }

    public void draw(Graphics g) {
        for (GameObject obj : obj) {
            obj.draw(g);
        }
    }

    public void addObject(GameObject obj) {
        this.obj.add(obj);
    }

    public GameObject addObjects(GameObject obj) {
        return obj;
    }

    public void removeObject(GameObject obj) {
        this.obj.remove(obj);
    }
    
    public void removeAll() {
    	obj.clear();
    }
}
