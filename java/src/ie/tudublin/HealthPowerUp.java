package ie.tudublin;

import processing.core.PApplet;

public class HealthPowerUp extends GameObject implements PowerUp{
    float w;
    public HealthPowerUp(float x, float y, float rot, int c, PApplet p) {
        super(x, y, rot, c, p);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void update(){
        forward.x = p.sin(rot);
        forward.y = p.cos(rot);
    }

    @Override
    public void render() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'render'");
    }
}
