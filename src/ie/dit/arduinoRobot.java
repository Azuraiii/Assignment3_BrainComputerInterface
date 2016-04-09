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
    boolean var = false;

    arduinoRobot(PApplet p){
        this.papplet = p;
    }//end constructor

    void updateRobot(float concentration_raw,float acc_raw,float mellow_raw)
    {
        float mellow = mellow_raw;
        float concentration = concentration_raw;
        float accel = acc_raw;

        papplet.background(0);
        papplet.fill(255);
        if(accel > 500) {
            papplet.text("Right", 475, papplet.height / 2);
        }

        if(accel < - 400) {
            papplet.text("Left", 30, papplet.height / 2);
        }

        if (concentration > 0.3 && concentration > mellow) {
            papplet.text("Move Forward", papplet.width / 4, papplet.height / 6);
        }

        if(mellow >0.3 && mellow > concentration) {
            papplet.text("Move Backward", papplet.width / 4, 550);
        }
        //-500 left accel
        //500 right accel
//
    }//end updateRobot

}//end class
