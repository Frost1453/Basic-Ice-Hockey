package fr0sty.engine.window;

import fr0sty.engine.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Window extends JFrame {
    public Window(int w, int h,String title , Game game, BufferedImage icon) {
        this.setTitle(title);
        this.setIconImage(icon);
        this.setPreferredSize(new Dimension(w, h));
        this.setMinimumSize(new Dimension(w, h));
        this.setMaximumSize(new Dimension(w, h));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.add(game);
        this.setVisible(true);
        game.start();
    }
}


