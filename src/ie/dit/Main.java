package ie.dit;

import oscP5.OscMessage;
import oscP5.OscP5;
import processing.core.PApplet;

//Connecting to muse headband
//go to cmd
//type: muse-io --device Muse --60hz --osc osc.udp://localhost:5000

/**
 * Created by azkei on 22/03/2016.
 */
public class Main extends PApplet {

    Interface intf;
    OscP5 oscP5;
    DataStream dataStream;


    static int recvPort = 5000;


    public void setup(){
        oscP5 = new OscP5(this, recvPort);
        intf = new Interface(this);
        dataStream = new DataStream(this);

    }

    public void settings(){
        size(900,600);
    }

    public void draw(){
        dataStream.render();


    }
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
