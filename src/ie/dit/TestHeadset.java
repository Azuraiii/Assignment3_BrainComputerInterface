package ie.dit;

import processing.core.PApplet;

/**
 * Created by azkei on 23/03/2016.
 */
public class TestHeadset{

    //horseshoe
    //forehead
    //blink
    //jaw
    PApplet papplet;
    float horse1;
    float horse2;
    float horse3;
    float horse4;
    float blink;
    float forehead;
    float jaw_clench;

    TestHeadset(PApplet p, float horse1, float horse2,float horse3,float horse4, float blink, float forehead,float jaw_clench)
    {
        this.papplet = p;
        this.horse1 = horse1;
        this.horse2 = horse2;
        this.horse3 = horse3;
        this.horse4 = horse4;
        this.blink = blink;
        this.forehead = forehead;
        this.jaw_clench = jaw_clench;
    }

    void render(float horse1, float horse2,float horse3,float horse4, float blink, float forehead,float jaw_clench){
        papplet.background(120,120,120);

        //papplet.ellipse(200,200,200,200);
        papplet.pushMatrix();
        papplet.beginShape(papplet.POLYGON);
        papplet.fill(0);
        papplet.stroke(255);
        papplet.strokeWeight(3);
        int[]xpts ={150,200,300,400,450,350,300,250,150};
        int[]ypts ={350,450,500,450,350,420,430,420,350};

        for(int i = 0; i<8;i++){
            papplet.vertex(xpts[i],ypts[i]);
        }

//        papplet.vertex(150,350);
//        papplet.vertex(200,-450);
//        papplet.vertex(300,-500);
//        papplet.vertex(400,-450);
//        papplet.vertex(450,-350);
//        papplet.vertex(350,-420);
//        papplet.vertex(300,-430);
//        papplet.vertex(250,-420);
//        papplet.vertex(150,-350);
        papplet.endShape();
        papplet.popMatrix();



    }



}
