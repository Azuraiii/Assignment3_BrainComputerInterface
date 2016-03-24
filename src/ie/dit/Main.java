package ie.dit;

import oscP5.OscMessage;
import oscP5.OscP5;
import processing.core.PApplet;

import java.util.ArrayList;
//Connecting to muse headband
//go to cmd
//type: muse-io --device Muse --60hz --osc osc.udp://localhost:5000

//to do here:
//pass headset data into the classes
//create the menu here

/**
 * Created by azkei on 22/03/2016.
 */
public class Main extends PApplet {

    PApplet papplet;
//    Menu intf;
     OscP5 oscP5;
//    DataStream dataStream;
//    ControlP5 cp5;
    Cube cube;

    public float delta_raw;
    float delta;
    float deltaRGB;

    public float theta_raw;
    float theta;
    float thetaRGB;

    public float alpha_raw;
    float alpha;
    float alphaRGB;

    public float beta_raw;
    float beta;
    float betaRGB;

    public float gamma_raw;
    float gamma;
    float gammaRGB;

    public float concentration_raw;
    float concentration;
    float concentrationRGB;

    public float mellow_raw;
    float mellow;
    float mellowRGB;

    public float acc_raw;
    float acc;
    float accRGB;


    public int menu = 0;

    static int recvPort = 5000;

    ArrayList<Cube>cubeObject = new ArrayList<Cube>();

    public void setup(){
        oscP5 = new OscP5(this, recvPort);

        cube = new Cube(this, acc_raw);
        cubeObject.add(cube);

        papplet = new PApplet();
        //dataStream = new DataStream(this);
        //ball = new Ball();
    }

    public void settings(){
        size(600,600);
    }

    public void draw(){
        background(0);
       // System.out.println("acc: "+acc_raw);
        switch(menu){
            case 0:
                //intf.render();
                //
                cube.drawBall(acc_raw);

                break;
//            case 1:
//                //gesture here
//                break;
//            case 2:
//                //mind cube here
//                break;
//            case 3:
//                //arduino robot here
//                break;
//            case 4:
//                //close
//                break;
        }
    }
    //this method brings in real time data from the Muse headband.
    void oscEvent(OscMessage msg){

        if(msg.checkAddrPattern("/muse/acc")==true) {
            acc_raw = msg.get(0).floatValue();
            //System.out.println("acc_raw: "+acc_raw);
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
