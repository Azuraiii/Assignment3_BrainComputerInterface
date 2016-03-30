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


    }



}
