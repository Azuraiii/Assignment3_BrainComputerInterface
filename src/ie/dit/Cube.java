package ie.dit;

import processing.core.PApplet;

/**
 * Created by azkei on 23/03/2016.
 */
public class Cube {

    PApplet papplet;
    float acc_raw;

    public Cube(PApplet papplet, float acc_raw){
        this.papplet=papplet;
        this.acc_raw = acc_raw;


    }


    void drawBall(){
        float acc = acc_raw;
        float accRGB = papplet.map(acc, -1000, 1000, 0, 255);
        //System.out.println("acc: "+acc_raw);

//        concentration = concentration_raw*1000;
//        concentrationRGB = papplet.map(concentration, 0, 1000, 100, 255);
//        //System.out.println("concentrationRGB: "+concentrationRGB);
//
//        delta = delta_raw*1000;
//        deltaRGB = papplet.map(delta,0,1000,0,255);
//        //System.out.println("deltaRGB: "+deltaRGB);
//
//        mellow=mellow_raw*1000;
//        mellowRGB=papplet.map(mellow,0,1000,0,255);
//        //System.out.println("mellowRGB: "+mellowRGB);
//
//        alpha = alpha_raw*1000;
//        //System.out.println("alpha: "+alpha);
//        alphaRGB = papplet.map(alpha,0,1000,0,255);
//        //System.out.println("alphaRGB: "+alphaRGB);

        //works
        papplet.background(accRGB,0,accRGB);
        papplet.noStroke();

        //works
        papplet.fill(accRGB+100,0,150,188);
        papplet.ellipse(papplet.width/2,papplet.height - acc+100,acc,acc);
    }
}
