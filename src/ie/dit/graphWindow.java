package ie.dit;

import processing.core.PApplet;

/**
 * Created by azkei on 30/03/2016.
 */
public class graphWindow extends PApplet{

    graphWindow(){
        super();
        PApplet.runSketch(new String[]{
                this.getClass().getSimpleName()
        },this);
    }

    public void settings(){
        size(500,500);
    }

    public void setup(){
        background(0);
    }
}
