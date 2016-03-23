package ie.dit;

import processing.core.PApplet;

/**
 * Created by azkei on 22/03/2016.
 */
public class DataStream {
    PApplet papplet;
    float delta_raw;
    float delta;
    float deltaRGB;

    float theta_raw;
    float theta;
    float thetaRGB;

    float alpha_raw;
    float alpha;
    float alphaRGB;

    float beta_raw;
    float beta;
    float betaRGB;

    float gamma_raw;
    float gamma;
    float gammaRGB;

    float concentration_raw;
    float concentration;
    float concentrationRGB;

    float mellow_raw;
    float mellow;
    float mellowRGB;

    float acc_raw;
    float acc;
    float accRGB;

    DataStream(PApplet papplet){
        this.papplet = papplet;
    }

    void update(){

    }

    void render(){
        acc = acc_raw;
        accRGB = papplet.map(acc, -1000, 1000, 0, 255);
        System.out.println("acc: "+accRGB);

        concentration = concentration_raw*1000;
        concentrationRGB = papplet.map(concentration, 0, 1000, 100, 255);
        //System.out.println("concentrationRGB: "+concentrationRGB);

        delta = delta_raw*1000;
        deltaRGB = papplet.map(delta,0,1000,0,255);
        //System.out.println("deltaRGB: "+deltaRGB);

        mellow=mellow_raw*1000;
        mellowRGB=papplet.map(mellow,0,1000,0,255);
        //System.out.println("mellowRGB: "+mellowRGB);

        alpha = alpha_raw*1000;
        //System.out.println("alpha: "+alpha);
        alphaRGB = papplet.map(alpha,0,1000,0,255);
        //System.out.println("alphaRGB: "+alphaRGB);

        //works
        papplet.background(concentrationRGB,0,mellowRGB);
        papplet.noStroke();

        //works
        papplet.fill(accRGB+100,0,150,188);
        papplet.ellipse(papplet.width/2,papplet.height - acc+100,acc,acc);
    }


}
