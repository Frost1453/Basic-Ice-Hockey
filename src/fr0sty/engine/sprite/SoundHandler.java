package fr0sty.engine.sprite;

import javax.sound.sampled.*;
import java.io.File;

public class SoundHandler {

    Clip clip;
    AudioInputStream audioStream;

    public SoundHandler() {
        try {
            clip = AudioSystem.getClip();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public AudioInputStream pickSound(String path) {
        try {
            audioStream = AudioSystem.getAudioInputStream(new File(path));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return audioStream;
    }

    public void playSound(String name) throws Exception{
        clip.open(pickSound(name));
        clip.start();
    }

}
