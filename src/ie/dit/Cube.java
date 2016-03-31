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

    float size = 75;

    float xAngle;
    float yAngle;
    float zAngle;
    float xSpeed,ySpeed,zSpeed;





    public Cube(PApplet papplet, float alpha_raw, float beta_raw, float delta_raw,float concentration_raw){
        this.papplet=papplet;
        this.alpha_raw = alpha_raw;
        this.beta_raw =  beta_raw;
        this.delta_raw = delta_raw;
        this.concentration_raw = concentration_raw;
    }


    void drawCube(float alpha_raw,float beta_raw,float delta_raw, float concentration_raw){

        papplet.camera();
        papplet.lights();



        //mapping out raw waves
        float alpha = alpha_raw;
        float alphaRGB = papplet.map(alpha, 0, 1, 0, 255);
        //System.out.println("alphaRGB: "+alphaRGB);

        float beta = beta_raw;
        float betaRGB = papplet.map(beta,0,1, 0, 255);
        //System.out.println("betaRGB: "+betaRGB);

        float delta = delta_raw;
        float deltaRGB = papplet.map(delta, 0, 1, 0, 255);
        //System.out.println("deltaRGB: "+deltaRGB);

        float concentration = concentration_raw;
       // float concentrationRGB = papplet.map(concentration, 0, 1, 100, 255);
        //System.out.println("concentrationRGB: "+concentrationRGB);

        if(concentration > 0){
            xSpeed = (float) 0.02;
            ySpeed = (float) 0.02;
            zSpeed = (float) 0.02;
        }
        else{
            xSpeed = (float) 0.001;
            ySpeed = (float) 0.001;
            zSpeed = (float) 0.001;
        }

        xAngle += xSpeed;
        yAngle += ySpeed;
        zAngle += zSpeed;

        papplet.background(0);


        papplet.pushMatrix();
        papplet.translate(300,300,300);
        papplet.rotateX(xAngle);
        papplet.rotateY(yAngle);
        papplet.rotateZ(zAngle);
        papplet.noStroke();
        papplet.box(size);
        papplet.popMatrix();

    }//end drawCube
}//end class
