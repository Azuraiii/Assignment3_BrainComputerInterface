package ie.dit;

import processing.core.PApplet;

/**
 * Created by azkei on 30/03/2016.
 */
public class graphWindow extends PApplet{

    public float rawAlpha;
    public float rawBeta;
    public float rawDelta;
    public float rawTheta;
    public float rawGamma;

    float alpha;
    float beta;
    float delta;
    float theta;
    float gamma;

    graphWindow(graphWindow gw){
        super();
        PApplet.runSketch(new String[]{
                this.getClass().getSimpleName()
        },this);
        this.alpha =1000; //gw.rawAlpha;
        this.beta =1000; //gw.rawBeta;
        this.delta =1000; //gw.rawDelta;
        this.theta =1000; //gw.rawTheta;
        this.gamma=1000; //gw.rawGamma;

    }

    public void settings(){
        size(700,400);
    }

    public void setup(){
        background(255);
    }

    public void draw(){
        //mapping the waves
        float alphaHeight = map(alpha,500,1200,0,height);
        float betaHeight = map(beta,500,1200,0,height);
        float deltaHeight = map(delta,500,1200,0,height);
        float thetaHeight = map(theta,500,1200,0,height);
        float gammaHeight = map(gamma,500,1200,0,height);

        System.out.println(alphaHeight);
        float gap = (float)width/5;

        float x1 = 0*gap;
        float x2 = 1*gap;
        float x3 = 2*gap;
        float x4 = 3*gap;
        float x5 = 4*gap;

        //red for alpha
        fill(255,0,0);
        rect(x1,height,gap,-alphaHeight);
        //blue for beta
        fill(0,0,255);
        rect(x2,height,gap,-betaHeight);
        //purple for delta
        fill(160,30,240);
        rect(x3,height,gap,-deltaHeight);
        //green for theta
        fill(0,255,0);
        rect(x4,height,gap,-thetaHeight);
        //yellow for gamma
        fill(255,255,0);
        rect(x5,height,gap,-gammaHeight);

    }


}
