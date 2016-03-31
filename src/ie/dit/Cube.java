package ie.dit;

import processing.core.PApplet;

/**
 * Created by azkei on 23/03/2016.
 */
public class Cube {
    //this variable is the constant of 2 PI.
    private static final float TWO_PI = (float) 6.28318530718;
    PApplet papplet;
    //raw waves from headset
    float alpha_raw;
    float beta_raw;
    float delta_raw;
    float concentration_raw;

    float xmag,ymag = 0;
    float newXmag,newYmag = 0;

    public Cube(PApplet papplet, float alpha_raw, float beta_raw, float delta_raw,float concentration_raw){
        this.papplet=papplet;
        this.alpha_raw = alpha_raw;
        this.beta_raw =  beta_raw;
        this.delta_raw = delta_raw;
        this.concentration_raw = concentration_raw;
    }

    void drawCube(float alpha_raw,float beta_raw,float delta_raw, float concentration_raw){

        //mapping out raw waves
        float alpha = alpha_raw;
        float alphaRGB = papplet.map(alpha, 500, 1200, 50, 255);
        //System.out.println("alphaRGB: "+alphaRGB);

        float beta = beta_raw;
        float betaRGB = papplet.map(beta,0,0, 0, 255);
        //System.out.println("betaRGB: "+betaRGB);

        float delta = delta_raw;
        float deltaRGB = papplet.map(delta, -1000, 1000, 0, 255);
        //System.out.println("deltaRGB: "+deltaRGB);

        float concentration = concentration_raw*1000;
        float concentrationRGB = papplet.map(concentration, 0, 1000, 100, 255);
        //System.out.println("concentrationRGB: "+concentrationRGB);

       // papplet.colorMode(papplet.RGB,1);
        papplet.background(alphaRGB);

        papplet.fill(alphaRGB,0,0);
        papplet.pushMatrix();
        papplet.translate(papplet.width/2, papplet.height/2, -30);
        newXmag = papplet.mouseX/(float)(papplet.width) * TWO_PI;
        newYmag = papplet.mouseY/(float)(papplet.height) * TWO_PI;

        float diff = xmag-newXmag;
        if (papplet.abs(diff) >  0.01) {
            xmag -= diff/4.0;
        }
        diff = ymag-newYmag;
        if (papplet.abs(diff) >  0.01) {
            ymag -= diff/4.0;
        }

        float x = (float) .1;

        //rotations
//        if (concentrationRGB >= 1){
//            x += papplet.random((float) 0.1);
//            papplet.rotateX(x);
//        }

        papplet.rotateX(-ymag);
        papplet.rotateY(-xmag);
        papplet.box(betaRGB,deltaRGB,betaRGB);

        papplet.popMatrix();


//
//        mellow=mellow_raw*1000;
//        mellowRGB=papplet.map(mellow,0,1000,0,255);
//        //System.out.println("mellowRGB: "+mellowRGB);
//
//        alpha = alpha_raw*1000;
//        //System.out.println("alpha: "+alpha);
//        alphaRGB = papplet.map(alpha,0,1000,0,255);
//        //System.out.println("alphaRGB: "+alphaRGB);

    }//end drawCube
}//end class
