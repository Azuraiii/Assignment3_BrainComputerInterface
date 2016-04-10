package ie.dit;

import processing.core.PApplet;

/**
 * Created by azkei on 22/03/2016.
 */
public class Menu{

    PApplet papplet;
    public int menu;

    Menu(PApplet p) {
        this.papplet = p;
    }

    //passing processing applet so we can use proccesing methods
    public void render(Menu intf) {

        papplet.background(0);
        papplet.stroke(255,0,0);
        papplet.textSize(50);
        papplet.text("Mind Control Program",papplet.width/7, 70);
            //gray rectangle
            papplet.fill(255,0,0);
            papplet.rectMode(papplet.CENTER);
            papplet.rect(280,180,350,90);
            papplet.rect(280,280,350,90);
            papplet.rect(280,380,350,90);
            papplet.rect(280,480,350,90);

            papplet.ellipse(105+350,420,5,5);

            papplet.textSize(45);
            papplet.fill(255);
            papplet.text("Test Headset",130,200);
            papplet.text("Mind Cube", 130, 300);
            papplet.text("Arduino Robot", 130, 400);
            papplet.text("Exit",130, 500);

            if(papplet.mousePressed){
                if(papplet.mouseX >105 && papplet.mouseX <455 && papplet.mouseY >140 && papplet.mouseY <225) {
                    intf.menu = 1;
                }
                if(papplet.mouseX >105 && papplet.mouseX <455 && papplet.mouseY >235 && papplet.mouseY <325) {
                    intf.menu = 2;
                }
                if(papplet.mouseX >105 && papplet.mouseX <455 && papplet.mouseY >335 && papplet.mouseY <425) {
                    intf.menu = 3;
                }
                if(papplet.mouseX >105 && papplet.mouseX <455 && papplet.mouseY >435 && papplet.mouseY <525) {
                    intf.menu = 4;
                }
            }//end if
    }//end render
}//end class
