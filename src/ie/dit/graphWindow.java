package ie.dit;

import processing.core.PApplet;

/**
 * Created by azkei on 30/03/2016.
 */
public class graphWindow extends PApplet{

    //waves
    public float rawAlpha1;
    public float rawAlpha2;
    public float rawAlpha3;

    public float rawBeta1;
    public float rawBeta2;
    public float rawBeta3;

    public float rawDelta1;
    public float rawDelta2;
    public float rawDelta3;

    public float rawTheta1;
    public float rawTheta2;
    public float rawTheta3;

    public float rawGamma1;
    public float rawGamma2;
    public float rawGamma3;
    //eeg
    public float rawEeg;
    //experimentals
    public float rawConcentration;
    public float rawMellow;
    //waves
    float alpha1;
    float alpha2;
    float alpha3;

    float beta1;
    float beta2;
    float beta3;

    float delta1;
    float delta2;
    float delta3;

    float theta1;
    float theta2;
    float theta3;

    float gamma1;
    float gamma2;
    float gamma3;

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
        size(1000,500);
    }

    public void setup(){
        background(255);
    }

    public void loadData(graphWindow gw){
        //waves
        this.alpha1 = gw.rawAlpha1;
        this.alpha2 = gw.rawAlpha2;
        this.alpha3 = gw.rawAlpha3;

        this.beta1 = gw.rawBeta1;
        this.beta2 = gw.rawBeta2;
        this.beta3 = gw.rawBeta3;

        this.delta1 = gw.rawDelta1;
        this.delta2 = gw.rawDelta2;
        this.delta3 = gw.rawDelta3;

        this.theta1 = gw.rawTheta1;
        this.theta2 = gw.rawTheta2;
        this.theta3 = gw.rawTheta3;

        this.gamma1= gw.rawGamma1;
        this.gamma2= gw.rawGamma2;
        this.gamma3= gw.rawGamma3;

        //eeg
        this.eeg = gw.rawEeg;

        //experimentals
        this.concentration = gw.rawConcentration;
        this.mellow = gw.rawMellow;
    }

    public void draw(){
        background(0);

        float yBorder = (float) (width*0.05);
        //mapping the waves
        float alphaHeight1 = map(alpha1,0,1,0,height);
        float alphaHeight2 = map(alpha2,0,1,0,height);
        float alphaHeight3 = map(alpha3,0,1,0,height);

        float betaHeight1 = map(beta1,0,1,0,height);
        float betaHeight2 = map(beta2,0,1,0,height);
        float betaHeight3 = map(beta3,0,1,0,height);

        float deltaHeight1 = map(delta1,0,1,0,height);
        float deltaHeight2 = map(delta2,0,1,0,height);
        float deltaHeight3 = map(delta3,0,1,0,height);

        float thetaHeight1 = map(theta1,0,1,0,height);
        float thetaHeight2 = map(theta2,0,1,0,height);
        float thetaHeight3 = map(theta3,0,1,0,height);

        float gammaHeight1 = map(gamma1,0,1,0,height);
        float gammaHeight2 = map(gamma2,0,1,0,height);
        float gammaHeight3 = map(gamma3,0,1,0,height);

        //mapping eeg
        float eegHeight = map(eeg,500,1500,0,height);

        //mapping experimentals
        float concentrationHeight = map(concentration,0,1,0,height);
        float mellowHeight = map(mellow,0,1,0,height);

       // System.out.println(alphaHeight);
        float gap = (float)width/18;

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
        float x9 =8*gap;
        float x10 =9*gap;
        float x11 =10*gap;
        float x12 =11*gap;
        float x13 =12*gap;
        float x14 =13*gap;
        float x15 =14*gap;
        float x16 =15*gap;
        float x17 =16*gap;
        float x18 =17*gap;

        //red for alpha
        fill(55,0,0);
        rect(x1,height-yBorder,gap,-alphaHeight1);
        fill(155,0,0);
        rect(x2,height-yBorder,gap,-alphaHeight2);
        fill(255,0,0);
        rect(x3,height-yBorder,gap,-alphaHeight3);

        //blue for beta
        fill(0,0,55);
        rect(x4,height-yBorder,gap,-betaHeight1);
        fill(0,0,155);
        rect(x5,height-yBorder,gap,-betaHeight2);
        fill(0,0,255);
        rect(x6,height-yBorder,gap,-betaHeight3);

        //purple for delta
        fill(160,30,240);
        rect(x7,height-yBorder,gap,-deltaHeight1);
        fill(160,30,240);
        rect(x8,height-yBorder,gap,-deltaHeight2);
        fill(160,30,240);
        rect(x9,height-yBorder,gap,-deltaHeight3);

        //green for theta
        fill(0,55,0);
        rect(x10,height-yBorder,gap,-thetaHeight1);
        fill(0,155,0);
        rect(x11,height-yBorder,gap,-thetaHeight2);
        fill(0,255,0);
        rect(x12,height-yBorder,gap,-thetaHeight3);

        //yellow for gamma
        fill(55,55,0);
        rect(x13,height-yBorder,gap,-gammaHeight1);
        fill(155,155,0);
        rect(x14,height-yBorder,gap,-gammaHeight2);
        fill(255,255,0);
        rect(x15,height-yBorder,gap,-gammaHeight3);

        //random color for eeg
        fill(120,120,120);
        rect(x16,height-yBorder,gap,-eegHeight);

        //random color for concentration
        fill(50,50,200);
        rect(x17,height-yBorder,gap,-concentrationHeight);
        //random color for mellow
        fill(250,120,10);
        rect(x18,height-yBorder,gap,-mellowHeight);
    }
}
