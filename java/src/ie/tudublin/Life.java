package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet
{
	boolean space = true;


	LifeBoard board;
	public void settings()
	{
		size(200,200);
	}

	public void setup() {
		colorMode(RGB);
		background(0);
		board = new LifeBoard(50,this);
		board.randomise();
		frameRate(10);
	}

	public void draw()
	{	
		background(0);
		noStroke();
		board.render();
		board.applyRules();
		
	}
	public void keyPressed()
	{
		if(keyPressed)
		{
			if(key == ' ')
			{
				space = !space;

				if(space)
				{
					loop();
				}
				else{
					noLoop();
				}
			}
			if(key =='1')
			{
				board.randomise();
			}
			if(key =='2')
			{
				board.clear();
			}
			if(key =='3')
			{
				board.clear();
				board.jesus();
			}
		}
	}
}
