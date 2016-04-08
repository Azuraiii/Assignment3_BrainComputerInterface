package ie.dit;

import oscP5.OscMessage;
import oscP5.OscP5;
import processing.core.PApplet;

//Connecting to muse headband
//go to cmd
//type: muse-io --device Muse --60hz --osc osc.udp://localhost:5000
//
/**
 * Created by azkei on 22/03/2016.
 */
public class Main extends PApplet {

    PApplet papplet;
    Menu intf;
    OscP5 oscP5;
    Cube cube;
    TestHeadset testHeadset;
    graphWindow gw;
    arduinoRobot ar;

    //public variables where data flows
    //brainwaves
    public float alpha_raw1;
    public float alpha_raw2;
    public float alpha_raw3;

    public float beta_raw1;
    public float beta_raw2;
    public float beta_raw3;

    public float delta_raw1;
    public float delta_raw2;
    public float delta_raw3;

    public float theta_raw1;
    public float theta_raw2;
    public float theta_raw3;

    public float gamma_raw1;
    public float gamma_raw2;
    public float gamma_raw3;
    //experimental
    public float concentration_raw;
    public float mellow_raw;
    //accelerometer
    public float acc_raw;
    //electroencephalogram(EEG)
    public float eeg_raw;
    //test headset var
    public float horse1;
    public float horse2;
    public float horse3;
    public float horse4;
    //forehead var
    public int forehead;
    //blink
    public int blink;
    //jaw clench
    public int jaw_clench;
    //Port for bluetooth
    static int recvPort = 5000;

    public void setup(){
        oscP5 = new OscP5(this, recvPort);
        testHeadset = new TestHeadset(this,horse1,horse2,horse3,horse4,blink,forehead,jaw_clench);
        cube = new Cube(this, alpha_raw1,beta_raw1,delta_raw1,concentration_raw,mellow_raw);
        papplet = new PApplet();
        gw = new graphWindow();


        ar = new arduinoRobot(this);

        //this code helps pass by reference menu var
        intf = new Menu(this);
        intf.menu = 0;
    }

    public void settings(){
        //P3D for working with 3d objects
        size(600,600,P3D);
    }

    public void draw(){

        //this is for the real time bar graph window
        //waves
        gw.rawAlpha1 = alpha_raw1;
        gw.rawAlpha2 = alpha_raw2;
        gw.rawAlpha3 = alpha_raw3;

        gw.rawBeta1 = beta_raw1;
        gw.rawBeta2 = beta_raw2;
        gw.rawBeta3 = beta_raw3;

        gw.rawDelta1 = delta_raw1;
        gw.rawDelta2 = delta_raw2;
        gw.rawDelta3 = delta_raw3;

        gw.rawTheta1 = theta_raw1;
        gw.rawTheta2 = theta_raw2;
        gw.rawTheta3 = theta_raw3;

        gw.rawGamma1 = gamma_raw1;
        gw.rawGamma2 = gamma_raw2;
        gw.rawGamma3 = gamma_raw3;
        //eeg
        gw.rawEeg = eeg_raw;
        //experimentals
        gw.rawConcentration = concentration_raw;
        gw.rawMellow = mellow_raw;
        //this function passes the waves into the new window in real time
        gw.loadData(gw);

            switch (intf.menu) {
                case 0:
                    //menu screen pass by reference

                    intf.render(intf);
                    break;
                case 1:
                    //testHeadset here.
                   testHeadset.render(horse1,horse2,horse3,horse4,forehead,blink,jaw_clench);

                    break;
                case 2:
                    //mind cube here
                    //cube.getMax(alpha_raw,beta_raw,delta_raw,theta_raw,gamma_raw,eeg_raw,concentration_raw,mellow_raw);
                    cube.drawCube(concentration_raw,mellow_raw);

                    break;
                case 3:
                    //arduino robot here
                    ar.updateRobot(concentration_raw,acc_raw);
                    ar.renderScreen(concentration_raw,acc_raw);
                    break;
                case 4:
                    //exit
                    exit();
                    break;
            }
    }

    public void keyPressed(){
        if( key == ' ')
        {
            intf.menu = 0;
        }
    }

    //this method brings in real time bluetooth data from the Muse headband.
    void oscEvent(OscMessage msg){
        //accelerometer
        if(msg.checkAddrPattern("/muse/acc")==true){
            acc_raw = msg.get(2).floatValue();
            //System.out.println("acc_raw: "+acc_raw);
        }
        //eeg
        if(msg.checkAddrPattern("/muse/eeg")==true){
            eeg_raw = msg.get(0).floatValue();
            //System.out.println("eeg_raw: "+eeg_raw);
        }
        //waves
        if(msg.checkAddrPattern("/muse/elements/alpha_relative")==true){
            alpha_raw1 = msg.get(0).floatValue();
            //default
            alpha_raw2 = msg.get(1).floatValue();
            alpha_raw3 = msg.get(2).floatValue();
             // System.out.println("alpha_Raw: "+alpha_raw);
        }
        if(msg.checkAddrPattern("/muse/elements/beta_relative")==true){
            beta_raw1 = msg.get(0).floatValue();
            //default
            beta_raw2 = msg.get(1).floatValue();
            beta_raw3 = msg.get(2).floatValue();
              //System.out.println("beta_Raw: "+beta_raw);
        }
        if(msg.checkAddrPattern("/muse/elements/gamma_relative")==true){
            gamma_raw1 = msg.get(0).floatValue();
            //default
            gamma_raw2 = msg.get(1).floatValue();
            gamma_raw3 = msg.get(3).floatValue();
           // System.out.println("gamma_Raw: "+gamma_raw);
        }
        if(msg.checkAddrPattern("/muse/elements/theta_relative")==true){
            theta_raw1 = msg.get(0).floatValue();
            //default
            theta_raw2 = msg.get(1).floatValue();
            theta_raw3 = msg.get(2).floatValue();
           // System.out.println("theta_Raw: "+theta_raw);
        }
        if(msg.checkAddrPattern("/muse/elements/delta_relative")==true){
            delta_raw1 = msg.get(0).floatValue();
            //default
            delta_raw2 = msg.get(1).floatValue();
            delta_raw3 = msg.get(2).floatValue();
            //System.out.println("delta_raw: "+delta_raw);
        }
        //experimentals
        if(msg.checkAddrPattern("/muse/elements/experimental/concentration")==true){
            concentration_raw = msg.get(0).floatValue();
             //System.out.println("concentration raw: "+concentration_raw);
        }
        if(msg.checkAddrPattern("/muse/elements/experimental/mellow")==true){
            mellow_raw = msg.get(0).floatValue();
           // System.out.println("mellow_raw:" +mellow_raw);
        }
        //horseshoe test
        if(msg.checkAddrPattern("/muse/elements/horseshoe")==true){
            horse1 = msg.get(0).floatValue();
            horse2 = msg.get(1).floatValue();
            horse3 = msg.get(2).floatValue();
            horse4 = msg.get(3).floatValue();
//            System.out.println("horse1: "+horse1);
//            System.out.println("horse2: "+horse2);
//            System.out.println("horse3: "+horse3);
//            System.out.println("horse4: "+horse4);
        }
        if(msg.checkAddrPattern("/muse/elements/touching_forehead")==true){
            forehead = msg.get(0).intValue();
            //System.out.println("forehead: "+forehead);
        }
        if(msg.checkAddrPattern("/muse/elements/blink")==true){
            blink = msg.get(0).intValue();
        }
        if(msg.checkAddrPattern("/muse/elements/jaw_clench")==true){
            jaw_clench = msg.get(0).intValue();
        }
    }

    public static void main(String[] args)
    {
        String[] a = {"MAIN"};
        PApplet.runSketch( a, new Main());
    }

}
