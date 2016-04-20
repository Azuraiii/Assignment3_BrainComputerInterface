package ie.dit;

import processing.core.PApplet;
import processing.serial.Serial;

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
    }//end constructor

    void updateRobot(float concentration_raw,float aVar,float mellow_raw)
    {
        float mellow = mellow_raw;
        float concentration = concentration_raw;
        float accel = aVar;

        papplet.background(0);
        papplet.fill(255);
        System.out.println(accel);
        //right
        if(accel > 500) {
            papplet.text("Right", 475, papplet.height / 2);
        }

        //left
        if(accel < - 400) {
            papplet.text("Left", 30, papplet.height / 2);
        }

        //forward
        if (concentration > 0.3 /*&& concentration > */) {
            papplet.text("Move Forward", papplet.width / 4, papplet.height / 6);
        }

        //going backwards
//        if(mellow >0.3 && mellow > concentration) {
//            papplet.text("Move Backward", papplet.width / 4, 550);
//        }
    }//end updateRobot

    public void pass(Serial myPort, String var) {
        myPort.write(var);
    }



}//end class

