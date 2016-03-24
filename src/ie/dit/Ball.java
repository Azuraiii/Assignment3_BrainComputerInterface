package ie.dit;

///**
// * Created by azkei on 23/03/2016.
// */
//public class Cube extends DataObject{
//    PApplet papplet;
//
//    public Ball(PApplet papplet){this.papplet=papplet;}
//
//
//
//    void drawBall(){
//        acc = acc_raw;
//        accRGB = papplet.map(acc, -1000, 1000, 0, 255);
//        System.out.println("acc: "+accRGB);
//
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
//
//        //works
//        papplet.background(concentrationRGB,0,mellowRGB);
//        papplet.noStroke();
//
//        //works
//        papplet.fill(accRGB+100,0,150,188);
//        papplet.ellipse(papplet.width/2,papplet.height - acc+100,acc,acc);
//    }
//}
