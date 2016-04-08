package ie.dit;

import processing.core.PApplet;

/**
 * Created by azkei on 22/03/2016.
 */
public class arduinoRobot{
    //to do:
    //flow data here
    //send to arduino
    //accelerometer to turn left/right
    //focus/concentration to move forward.

    PApplet papplet;
    public float concentration_raw;
    public float acc_raw;

    arduinoRobot(PApplet p){
        this.papplet = p;
    }

    void updateRobot(float concentration_raw,float acc_raw){
        //-500 left accel
        //500 right accel

        float concentration = concentration_raw;
        float accel = acc_raw;
    }

    void renderScreen(float concentration_raw, float acc_raw){
        papplet.background(0);
        papplet.text("Left",500,papplet.height/2);

        papplet.text("Right",30,papplet.height/2);

        papplet.text("Move Forward",papplet.width/4,papplet.height/6);

        papplet.text("Move Backward",papplet.width/4,550);
    }



}
