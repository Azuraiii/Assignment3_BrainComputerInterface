package ie.dit;

import processing.core.PApplet;

/**
 * Created by azkei on 23/03/2016.
 */
public class Cube {


    PApplet papplet;
    float alpha_raw;

    public Cube(PApplet papplet, float alpha_raw){
        this.papplet=papplet;
        this.alpha_raw = alpha_raw;
    }

    void drawBall(float alpha_raw){
        float alpha = alpha_raw;
        float alphaRGB = papplet.map(alpha, -1000, 1000, 0, 255);
       // System.out.println("acc: "+alpha_raw);

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
        papplet.background(alphaRGB,0,alphaRGB);
        papplet.noStroke();

        //works
//        papplet.fill(accRGB+100,0,150,188);
//        papplet.ellipse(papplet.width/2,papplet.height - acc+100,acc,acc);
    }
}
