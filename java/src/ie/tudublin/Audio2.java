package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Audio2 extends PApplet
{
    Minim m;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    FFT fft;

    public void settings()
    {
        size(1024, 1024);
    }

    public void setup()
    {
        m = new Minim(this);
        ai= m.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix;
        lerpedBuffer = new float[width];

        fft = new FFT(width, 44100);

    }

    float[] lerpedBuffer;
    public void draw()
    {
        background(0);
        colorMode(HSB);
        stroke(255);
        float half=height/2;
        for (int i = 0; i<ab.size(); i++)
        {
            stroke(map(i, 0, ab.size(), 0, 255), 255, 255);
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.05f);
            float f= abs(lerpedBuffer[i] *half * 2.0f);
            line(i, half + f, i , half - f);
        }

        fft.forward(ab);
        stroke(255);

        int highestIndex = 0;
        for (int i = 0; i < fft.specSize(); i++)
        {
            line(i * 2.0f, height, i*2.0f, height - fft.getBand(i) * 5.0f);

            if(fft.getBand(i) > fft.getBand(highestIndex))
            {
                highestIndex=i;
            }
        }

        float freq = fft.indexToFreq(highestIndex);
        fill(255);
        textSize(20);
        text("Freq: ", +freq, 100, 200);

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
