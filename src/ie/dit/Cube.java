package ie.dit;

import processing.core.PApplet;

/**
 * Created by azkei on 23/03/2016.
 */
public class Cube {
    private static final float TWO_PI = (float) 6.28318530718;
    PApplet papplet;
    float alpha_raw;
    float xMag,yMag = 0;
    float newXmag,newYmag = 0;



    public Cube(PApplet papplet, float alpha_raw){
        this.papplet=papplet;
        this.alpha_raw = alpha_raw;

        newXmag = papplet.mouseX/papplet.width * TWO_PI;
        newYmag = papplet.mouseY/papplet.height * TWO_PI;

        float diff = xMag-newXmag;
        if (papplet.abs(diff) >  0.01) {
            xMag -= diff/4.0;
        }

        diff = yMag-newYmag;
        if (papplet.abs(diff) >  0.01) {
            yMag -= diff/4.0;
        }
    }

    void drawCube(float alpha_raw){
        papplet.background(0);
        papplet.lights();


        papplet.pushMatrix();
        //put concentration here
        papplet.translate((papplet.width/2),(papplet.height/2)-100,-30);
        //put concentration here
        papplet.rotateX(-xMag);
        papplet.rotateY(-yMag);
        papplet.directionalLight(0,0,255,0,-1,0);
        papplet.box(200);
        papplet.popMatrix();
//        float alpha = alpha_raw;
//        float alphaRGB = papplet.map(alpha, -1000, 1000, 0, 255);
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
//        papplet.background(alphaRGB,0,alphaRGB);
//        papplet.noStroke();

        //works
//        papplet.fill(accRGB+100,0,150,188);
//        papplet.ellipse(papplet.width/2,papplet.height - acc+100,acc,acc);
    }//end drawCube
}
