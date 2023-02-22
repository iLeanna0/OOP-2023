package ie.tudublin;

import java.util.HashSet;
import java.util.Set;

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
        
        loadStars();
        displace=(width-2*border)/10f;
    }

    float border=50f;
    float displace;
    Set<Star> stars = new HashSet<Star>();
    Star star1, star2;

    public void draw(){
        textAlign(CENTER);
        
        stroke(125, 255, 255);
        for (int i=0; i<11; i++){
            
            line(border + i*displace, border, border + i*displace, height-border);
            line(border, border + i*displace, width-border, border + i*displace);

            strokeWeight(1);
            text(str(i-5), border +i*displace, border/2);
            text(str(i-5), border/2, border +i*displace);
        }

        translate(width/2, height/2);
        for(Star star:stars){
            circle(star.xG*displace, star.yG*displace, star.absMag);
            textAlign(LEFT);
            text(star.displayName, star.absMag + star.xG*displace, star.yG*displace);
        }

        line(star1.xG, star1.yG, star2.xG, star2.yG);
    }
    void loadStars()
 	{
 		Table table = loadTable("HabHYG15ly.csv", "header");
 		for(TableRow r:table.rows())
 		{
 			Star s = new Star(r);
 			stars.add(s);

        }
        
        for(Star star:stars){
            star1 = star;
            star2 = star;
            break;
               
        }
        

 	}

    public void mousePressed(){
        for(Star star:stars){
            if(mouseX>star.xG*displace+ border - star.absMag && mouseX<star.xG*displace+border + star.absMag &&
                mouseY>star.yG*displace+ border - star.absMag && mouseY<star.yG*displace+border + star.absMag){
            star1=star;
            print("HI\n");
            }

        }
    }
    public void mouseReleased(){
        for(Star star:stars){
            if(mouseX>star.xG*displace+ border - star.absMag && mouseX<star.xG*displace+border + star.absMag &&
                mouseY>star.yG*displace+ border - star.absMag && mouseY<star.yG*displace+border + star.absMag){

            star2=star;
            print("Bye\n");

            }
            
        }
    }
}