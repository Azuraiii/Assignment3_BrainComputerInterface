package ie.dit;

import controlP5.ControlP5;
import oscP5.OscMessage;
import oscP5.OscP5;
import processing.core.PApplet;
//Connecting to muse headband
//go to cmd
//type: muse-io --device Muse --60hz --osc osc.udp://localhost:5000

//to do here:
//pass headset data into the classes
//create the menu here
//
/**
 * Created by azkei on 22/03/2016.
 */
public class Main extends PApplet {

    Interface intf;
    OscP5 oscP5;
    DataStream dataStream;
    ControlP5 cp5;
    //Ball ball;

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

    int menu = 0;

    static int recvPort = 5000;


    public void setup(){
        oscP5 = new OscP5(this, recvPort);
        intf = new Interface(this);
        //dataStream = new DataStream(this);
        //ball = new Ball();

    }

    public void settings(){
        size(600,600);
    }

    public void draw(){
        switch(menu){
            case 0:
                intf.menu();
                break;

        }


    }

    //this method brings in real time data from the Muse headband.
    void oscEvent(OscMessage msg){
        if(msg.checkAddrPattern("/muse/acc")==true) {
            acc_raw = msg.get(0).floatValue();
            System.out.println("acc_raw: "+acc_raw);

        }
        if(msg.checkAddrPattern("/muse/elements/experimental/concentration")==true) {
            concentration_raw = msg.get(0).floatValue();
        }
        if(msg.checkAddrPattern("/muse/elements/alpha_relative")==true) {
            alpha_raw = msg.get(0).floatValue();

        }
//        if(msg.checkAddrPattern("/muse/elements/beta_relative")==true) {
//            beta_raw = msg.get(0).floatValue();
//            beta = beta_raw*1000;
//            betaRGB = map(beta,0,1000,0,255);
//        }
//        if(msg.checkAddrPattern("/muse/elements/theta_relative")==true) {
//            theta_raw = msg.get(0).floatValue();
//            theta = theta_raw*1000;
//            thetaRGB = map(theta,0,1000,0,255);
//        }
        if(msg.checkAddrPattern("/muse/elements/delta_relative")==true) {
            delta_raw = msg.get(0).floatValue();
        }

        if(msg.checkAddrPattern("muse/elements/experimental/mellow")==true){
            mellow_raw = msg.get(0).floatValue();
        }
    }


    public static void main(String[] args)
    {
        String[] a = {"MAIN"};
        PApplet.runSketch( a, new Main());
    }

}
