package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

import processing.data.*;

public class StarMap extends PApplet {
    public void settings(){
        size(800, 800);
    }

    public void setup(){
        colorMode(HSB);
        background(0);
        textAlign(CENTER);
    }

    float border=50f;
    float displace;

    public void draw(){

        displace=(width-2*border)/10f;
        stroke(125, 255, 255);
        for (int i=0; i<11; i++){
            
            line(border + i*displace, border, border + i*displace, height-border);
            line(border, border + i*displace, width-border, border + i*displace);

            strokeWeight(1);
            text(str(i-5), border +i*displace, border/2);
            text(str(i-5), border/2, border +i*displace);
        }
    }
    void loadStars()
 	{
 		Table table = loadTable("HabHYG15ly.csv", "header");
 		for(TableRow r:table.rows())
 		{
 			Star s = new Star(r);
 			stars.add(s);
 		}
 	}
}