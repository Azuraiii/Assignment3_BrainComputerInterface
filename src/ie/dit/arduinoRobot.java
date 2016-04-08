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
    }//end constructor

    void updateRobot(float concentration_raw,float acc_raw){
        //-500 left accel
        //500 right accel


        float concentration = concentration_raw;
        float accel = acc_raw;
    }//end updateRobot

    void arrowRight(float concentration_raw, float acc_raw){

        papplet.background(0);
        papplet.fill(255,0,0);
        papplet.line(papplet.width/2,0,papplet.width/2,papplet.height);
        papplet.line(0,papplet.width/2,papplet.width,papplet.height/2);
        papplet.fill(255);
        papplet.text("Left",525,papplet.height/2);
        papplet.text("Right",30,papplet.height/2);
        papplet.text("Move Forward",papplet.width/4,papplet.height/6);
        papplet.text("Move Backward",papplet.width/4,550);


        papplet.beginShape(papplet.POLYGON);
        papplet.translate(375,papplet.height/3+35);
        papplet.stroke(255);
        papplet.strokeWeight(3);
        int[] xpts1 = {0,60,60,100,60,60,0,0};
        int[] ypts1 = {30,30,0,50,100,70,70,30};
        for (int i = 0; i < 8; i++) {
            papplet.vertex(xpts1[i], ypts1[i]);
        }
        papplet.endShape();
    }//end arrowRight

    void arrowLeft(){
        papplet.beginShape(papplet.POLYGON);
        papplet.translate(-125,papplet.height/4-50);
        papplet.rotate(papplet.PI);
        papplet.stroke(190);
        papplet.strokeWeight(3);
        int[] xpts2 = {0,60,60,100,60,60,0,0};
        int[] ypts2 = {30,30,0,50,100,70,70,30};
        for (int i = 0; i < 8; i++) {
            papplet.vertex(xpts2[i], ypts2[i]);
        }
        papplet.endShape();
    }//end arrowLeft

    void arrowTop(){

        papplet.beginShape(papplet.POLYGON);
        papplet.translate(0,papplet.height/4);
        papplet.rotate(papplet.PI/2);
        papplet.stroke(190);
        papplet.strokeWeight(3);
        int[] xpts3 = {0,60,60,100,60,60,0,0};
        int[] ypts3 = {30,30,0,50,100,70,70,30};
        for (int i = 0; i < 8; i++) {
            papplet.vertex(xpts3[i], ypts3[i]);
        }
        papplet.endShape();
    }//end arrowTop

    void arrowBot()
    {
        papplet.beginShape(papplet.POLYGON);
        papplet.translate(-200,papplet.height/4-50);
        papplet.rotate(papplet.PI);
        papplet.stroke(190);
        papplet.strokeWeight(3);
        int[] xpts4 = {0,60,60,100,60,60,0,0};
        int[] ypts4 = {30,30,0,50,100,70,70,30};
        for (int i = 0; i < 8; i++) {
            papplet.vertex(xpts4[i], ypts4[i]);
        }
        papplet.endShape();

    }//end arrowBot

}//end class
