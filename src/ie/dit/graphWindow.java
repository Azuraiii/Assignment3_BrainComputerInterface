package ie.dit;

import processing.core.PApplet;

/**
 * Created by azkei on 30/03/2016.
 */
public class graphWindow extends PApplet{

    public float rawAlpha;
    public float rawBeta;
    public float rawDelta;

    float alpha;
    float beta;
    float delta;

    graphWindow(graphWindow gw){
        super();
        PApplet.runSketch(new String[]{
                this.getClass().getSimpleName()
        },this);
        this.alpha =1000; //gw.rawAlpha;
        this.beta =1000; //gw.rawBeta;
        this.delta =1000; //gw.rawDelta;
    }

    public void settings(){
        size(500,500);
    }

    public void setup(){
        background(255);
    }

    public void draw(){
        //mapping the wavesa

        float alphaHeight = map(alpha,500,1200,0,500);
        float betaHeight = map(beta,500,1200,0,500);
        float deltaHeight = map(delta,500,1200,0,500);

        System.out.println(alphaHeight);
        float gap = (float)width/3;

        float x1 = 0*gap;
        float x2 = 1*gap;
        float x3 = 2*gap;
        fill(0);
        rect(x1,height,gap,-alphaHeight);
        fill(255,0,0);
        rect(x2,height,gap,-betaHeight);
        fill(0,255,0);
        rect(x3,height,gap,-deltaHeight);
    }


}
