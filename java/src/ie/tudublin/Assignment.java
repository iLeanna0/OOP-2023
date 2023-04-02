package ie.tudublin;

import processing.core.PApplet;

public class Assignment extends PApplet {

    public void settings()
    {
        fullScreen(P3D,SPAN);
    }

    public void setup()
    {
        

    }

    float var;

    public void draw()
    {
        background(0);
        translate(width/2, height/2);
        rotate(var += 0.05f , 1.7f, 3.3f, 5f);
        box(300);

    }
    
}
