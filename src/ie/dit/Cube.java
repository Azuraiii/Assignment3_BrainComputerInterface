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
    float mellow_raw;

    float size = 75;

    float xAngle;
    float yAngle;
    float zAngle;
    float xSpeed,ySpeed,zSpeed;

    int colorNum =0;

    public Cube(PApplet papplet, float alpha_raw, float beta_raw, float delta_raw,float concentration_raw,float mellow_raw){
        this.papplet=papplet;
        this.alpha_raw = alpha_raw;
        this.beta_raw =  beta_raw;
        this.delta_raw = delta_raw;
        this.concentration_raw = concentration_raw;
        this.mellow_raw = mellow_raw;
    }

    public float getMax(float alpha_raw, float beta_raw, float delta_raw, float theta_raw, float gamma_raw, float eeg_raw, float concentration_raw, float mellow_raw) {

        //mapping the waves
        float alpha = papplet.map(alpha_raw,0,1,0,100);
        float beta = papplet.map(beta_raw,0,1,0,100);
        float delta = papplet.map(delta_raw,0,1,0,100);
        float theta = papplet.map(theta_raw,0,1,0,100);
        float gamma = papplet.map(gamma_raw,0,1,0,100);
        //mapping eeg
        float eeg = papplet.map(eeg_raw,500,1500,0,100);
        //mapping experimentals
        float concentration = papplet.map(concentration_raw,0,1,0,100);
        float mellow = papplet.map(mellow_raw,0,1,0,100);

        float[] array = new float[]{alpha,beta,gamma,delta,theta,gamma,eeg,concentration,mellow, };
        int max = 0;


        for(int i=0;i<array.length;i++){
            if(array[i] > max){
                max = (int) array[i];
                //System.out.println("delta " + delta_raw);
            }
        }

        if(max == alpha){
            //alpha
            return colorNum = 1;
        }

        if(max == beta){
            //beta
            return colorNum = 2;
        }
        if(max == delta){
            //delta
            return colorNum = 3;
        }
        if(max == theta){
            //theta
            return colorNum = 4;
        }
        if(max == gamma){
            //gamma
            return colorNum = 5;
        }
        if(max == eeg){
            //eeg
            return colorNum = 6;
        }
        if(max == concentration){
            //concentration
            return colorNum = 7;
        }
        if(max == mellow){
            //mellow
            return colorNum = 8;
        }

        System.out.println("colorNum: " + colorNum);
        System.out.println("mellow: " + mellow);
        System.out.println("max " + max);
        System.out.println("delta: " + delta);

        return max;
    }


    void drawCube(float concentration_raw,float mellow_raw){

        papplet.camera();
        papplet.lights();

        //System.out.println("colorNum: " + colorNum);

        float concentration = concentration_raw;
        float concentrationRGB = papplet.map(concentration, 0, 1, 0, 300);
        //System.out.println("concentrationRGB: "+concentrationRGB);

        float mellow= mellow_raw;
        float mellowRGB = papplet.map(mellow, 0, 1, 255, 0);
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
        papplet.fill(255,0,0,mellowRGB);
        papplet.pushMatrix();
        papplet.translate(300,300,100+concentrationRGB);
        papplet.rotateX(xAngle);
        papplet.rotateY(yAngle);
        papplet.rotateZ(zAngle);
        papplet.noStroke();

        papplet.box(size);
        papplet.popMatrix();

    }//end drawCube


}//end class
