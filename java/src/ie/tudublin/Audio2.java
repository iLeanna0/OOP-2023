package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio2 extends PApplet
{
    Minim m;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    public void settings()
    {
        size(1024, 1000);
    }

    public void setup()
    {
        m = new Minim(this);
        ai= m.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix;
        lerpedBuffer = new float[width];

    }

    float[] lerpedBuffer;
    public void draw()
    {
        background(0);
        colorMode(HSB);
        float half=height/2;
        for (int i = 0; i<ab.size(); i++)
        {
            stroke(map(i, 0, ab.size(), 0, 255), 255, 255);
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
            float f= abs(lerpedBuffer[i] *half * 2.0f);
            line(i, half + f, i, half - f);
        }
        //println(map(5, 0, 10, 1000, 2000));
        //println(map2(a:5, b:2, c:10, d:1000, e:2000));

    }  
    
    /*float map1(float a, float b, float c, float d, float e)
    {
        float f = (a - b) / (c -b ); new
        return d + f * (e - d);
    }
    
    float map2(float a, float b, float c, float d, float e)
    {
        float range1= c - b;
        float range2= e - d;
        float howFar= a - b;

        return d + (howFar / range1)* range2;
    }*/
}
