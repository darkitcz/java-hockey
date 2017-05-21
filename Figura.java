public class Figura {

    private float x,y;
    private float vx=0;
    private float vy=0;



    public Figura (float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    public float getX () {
        return x;
    }

    public void setX (float val) {
        this.x = val;
    }

    public float getY () {
        return y;
    }

    public void setY (float val) {
        this.y = val;
    }

    public float getVx () {
        return this.vx;
    }

    public void setVx (float val) {
        this.vx = val;
    }

    public float getVy () {
        return this.vy;
    }

    public void setVy (float val) {
        this.vy = val;
    }

}

