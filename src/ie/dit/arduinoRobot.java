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

    void update(float concentration_raw,float acc_raw){
        //-500 left accel
        //500 right accel

        float concentration = concentration_raw;
        float accel = acc_raw;


    }



}
