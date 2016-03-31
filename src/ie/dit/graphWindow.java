package ie.dit;

import processing.core.PApplet;

/**
 * Created by azkei on 30/03/2016.
 */
public class graphWindow extends PApplet{
    //waves
    public float rawAlpha;
    public float rawBeta;
    public float rawDelta;
    public float rawTheta;
    public float rawGamma;
    //eeg
    public float rawEeg;
    //experimentals
    public float rawConcentration;
    public float rawMellow;
    //waves
    float alpha;
    float beta;
    float delta;
    float theta;
    float gamma;
    //eeg
    float eeg;
    //experimentals
    float concentration;
    float mellow;

    public graphWindow() {
        super();
        PApplet.runSketch(new String[]{
                this.getClass().getSimpleName()
        },this);
    }

    public void settings(){
        size(700,400);
    }

    public void setup(){
        background(255);
    }

    public void loadData(graphWindow gw){
        //waves
        this.alpha = gw.rawAlpha;
        this.beta = gw.rawBeta;
        this.delta = gw.rawDelta;
        this.theta = gw.rawTheta;
        this.gamma= gw.rawGamma;

        //eeg
        this.eeg = gw.rawEeg;

        //experimentals
        this.concentration = gw.rawConcentration;
        this.mellow = gw.rawMellow;
    }

    public void draw(){
        background(0);


        //mapping the waves
        float alphaHeight = map(alpha,0,1,0,height);
        float betaHeight = map(beta,0,1,0,height);
        float deltaHeight = map(delta,0,1,0,height);
        float thetaHeight = map(theta,0,1,0,height);
        float gammaHeight = map(gamma,0,1,0,height);

        //mapping eeg
        float eegHeight = map(eeg,500,1500,0,height);

        //experimentals
        float concentrationHeight = map(concentration,0,1,0,height);
        float mellowHeight = map(mellow,0,1,0,height);

       // System.out.println(alphaHeight);
        float gap = (float)width/8;

        //waves
        float x1 = 0*gap;
        float x2 = 1*gap;
        float x3 = 2*gap;
        float x4 = 3*gap;
        float x5 = 4*gap;

        //eeg
        float x6 =5*gap;

        //experimentals
        float x7 =6*gap;
        float x8 =7*gap;

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

        //random color for eeg
        fill(120,120,0);
        rect(x6,height,gap,-eegHeight);

        //random color for concentration
        fill(50,50,200);
        rect(x7,height,gap,-concentrationHeight);
        //random color for mellow
        fill(250,120,10);
        rect(x8,height,gap,-mellowHeight);

    }


}
