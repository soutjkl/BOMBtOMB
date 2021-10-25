package model;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {

    public static Clip clip;

    public Sound(){

    }

    public void loadSound(String name){
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(name).getAbsoluteFile()) ;
             clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        clip.stop();
    }

    public void start(){
        clip.start();
    }

}
