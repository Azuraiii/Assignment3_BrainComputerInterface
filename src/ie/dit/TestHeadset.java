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

    int forehead;
    float jaw_clench;

    TestHeadset(PApplet p, float horse1, float horse2,float horse3,float horse4, float blink, int forehead,float jaw_clench)
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

    void render(float horse1,float horse2,float horse3,float horse4, int forehead,float blink ,float jaw_clench){
        papplet.background(255);

        if(jaw_clench > 1 || jaw_clench == 1) {
            papplet.pushMatrix();
            papplet.beginShape(papplet.POLYGON);
            papplet.fill(0);
            papplet.stroke(255);
            papplet.strokeWeight(3);
            int[] xpts = {150, 200, 300, 400, 450, 350, 300, 250, 150};
            int[] ypts = {350, 450, 500, 450, 350, 420, 430, 420, 350};

            for (int i = 0; i < 8; i++) {
                papplet.vertex(xpts[i], ypts[i]);
            }
            papplet.endShape();
            papplet.popMatrix();
        }

        //Headband
        papplet.fill(120,120,120);
        papplet.rect(300,100,350,40);

        //blink
        if(blink == 1) {
            papplet.ellipse(200, 240, 100, 50);
            papplet.ellipse(400, 240, 100, 50);
        }

        //horse1
        if(horse1 ==1) {
            papplet.fill(255, 0, 0);
            papplet.rect(150, 100, 50, 40);
        }
        //horse2
        if(horse2 ==1) {
            papplet.fill(0, 255, 0);
            papplet.rect(225, 100, 100, 40);
        }
        //forehead
        if(forehead ==1) {
            papplet.fill(0);
            papplet.rect(300, 100, 50, 40);
        }
        //horse3
        if(horse3 ==1) {
            papplet.fill(50, 90, 255);
            papplet.rect(375, 100, 100, 40);
        }
        //horse4
        if(horse4 ==1) {
            papplet.fill(0, 255, 255);
            papplet.rect(450, 100, 50, 40);
        }

    }



}
