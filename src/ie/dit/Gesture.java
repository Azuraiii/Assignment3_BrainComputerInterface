package ie.dit;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * Created by azkei on 23/03/2016.
 */
public class Gesture {
    //to do:
    //connect into menu buttons correctly
    //load images data here
    //pass the accelerometer data from headset
    //for loop to display it

    //advanced:
    //blinking
    //jaw clench

    PApplet papplet;
    String images;
    PImage[] view = new PImage[9];

    Gesture(PApplet p)
    {
        this.papplet = p;

        for(int j = 1; j<view.length;j++){
            view[j] = papplet.loadImage("/"+j+".png");
            view[j].resize(papplet.width,papplet.height);
        }
    }

    //360 degree view face
    void drawFace(float acc_raw){
        papplet.background(view[5]);
    }


}
