import processing.core.PApplet;

/**
 * THE LORENZO ATRACTOR
 */
public class CanvasBoard extends PApplet {

    float xAxis = 0;
    float yAxis = 0;
    float zAxis = 0;


    public void setup() {
        size(800, 600);
    }

    public void draw(){

    }

    public static void main(String[] args){
        String[] processingArgs = {"CanvasBoard"};
        CanvasBoard mySketch = new CanvasBoard();
        PApplet.runSketch(processingArgs, mySketch);
    }
}
