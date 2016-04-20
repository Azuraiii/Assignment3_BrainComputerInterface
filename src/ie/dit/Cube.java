package ie.dit;

import processing.core.PApplet;

/**
 * Created by azkei on 23/03/2016.
 */
public class Cube {
    PApplet papplet;
    //raw waves from headset
    float alpha_raw;
    float beta_raw;
    float delta_raw;
    float concentration_raw;
    float mellow_raw;

    //size of cube
    float size = 75;

    //needed to manipulate the cube
    float xAngle;
    float yAngle;
    float zAngle;
    float xSpeed, ySpeed, zSpeed;

    int colorNum = 0;

    public Cube(PApplet papplet, float alpha_raw, float beta_raw, float delta_raw, float concentration_raw, float mellow_raw) {
        this.papplet = papplet;
        this.alpha_raw = alpha_raw;
        this.beta_raw = beta_raw;
        this.delta_raw = delta_raw;
        this.concentration_raw = concentration_raw;
        this.mellow_raw = mellow_raw;
    }

//    public void getMax(float alpha_raw, float beta_raw, float delta_raw, float theta_raw, float gamma_raw) {
//
//        //mapping the waves
//        float alpha = papplet.map(alpha_raw, 0, 1, 0, 100);
//        float beta  = papplet.map(beta_raw, 0, 1, 0, 100);
//        float delta = papplet.map(delta_raw, 0, 1, 0, 100);
//        float theta = papplet.map(theta_raw, 0, 1, 0, 100);
//        float gamma = papplet.map(gamma_raw, 0, 1, 0, 100);
//
//        float[] array = new float[]{alpha, beta, gamma, delta, theta, gamma};
//        int max = 0;
//        int maxIndex = -1;
//
//        for (int i = 0; i < array.length; i++)
//        {
//            if (array[i] > max) {
//               // max = (int) array[i];
//                maxIndex = i;
//            }
//        }
//        //System.out.println("delta " + delta_raw);
//
//        if (maxIndex == 0) {
//            //alpha
//             colorNum = 1;
//        }
//        if (maxIndex == 1) {
//            //beta
//             colorNum = 2;
//        }
//        if (maxIndex == 2) {
//            //delta
//             colorNum = 3;
//        }
//        if (maxIndex == 3) {
//            //theta
//             colorNum = 4;
//        }
//        if (maxIndex == 4) {
//            //gamma
//             colorNum = 5;
//        }
//
//    }


    void drawCube(float concentration_raw, float mellow_raw) {

        papplet.camera();
        papplet.lights();



//        System.out.println("colorNum: " + colorNum);

        //mapping the concentration values
        float concentration = concentration_raw;
        float concentrationRGB = papplet.map(concentration, 0, 1, 0, 300);
        //System.out.println("concentrationRGB: "+concentrationRGB);

        //mapping the relaxation values
        float mellow = mellow_raw;
        float mellowRGB = papplet.map(mellow, 0, 1, 255, 0);

        //mapping the relaxation values
        float alpha = alpha_raw;
        float alphaRGB = papplet.map(alpha, 0, 1, 255, 0);

        //mapping the relaxation values
        float beta = beta_raw;
        float betaRGB = papplet.map(beta, 0, 1, 255, 0);

        //mapping the relaxation values
        float delta = delta_raw;
        float deltaRGB = papplet.map(delta, 0, 1, 255, 0);
        //System.out.println("concentrationRGB: "+concentrationRGB);

        //if user is concentrating, make cube speed faster
        if (concentration > 0) {
            xSpeed = (float) 0.02;
            ySpeed = (float) 0.02;
            zSpeed = (float) 0.02;
        } else {
            xSpeed = (float) 0.001;
            ySpeed = (float) 0.001;
            zSpeed = (float) 0.001;
        }



        //add rotation speed
        xAngle += xSpeed;
        yAngle += ySpeed;
        zAngle += zSpeed;

        papplet.background(0);

        //makes the cube fade out as the more you mellow out.
        //change the color of the cube
        papplet.fill(alphaRGB, betaRGB, deltaRGB, mellowRGB);

        papplet.pushMatrix();
        papplet.textSize(15);
        papplet.text("Concentrate to move the cube, Relax to make it disappear",papplet.width/5,100);

        //brings the cube closer as you concentrate
        papplet.translate(300, 300, 100 + concentrationRGB);
        papplet.rotateX(xAngle);
        papplet.rotateY(yAngle);
        papplet.rotateZ(zAngle);
        papplet.noStroke();
        papplet.box(size);
        papplet.popMatrix();

    }//end drawCube
}//end class
