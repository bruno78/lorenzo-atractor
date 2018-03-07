import processing.core.PApplet;


/**
 * PERLIN NOISE GRASSY GREEN LANDSCAPE FIELD
 */
public class CanvasBoard extends PApplet {

    // sets the number of columns of the 2D array of the terrain field
    int columns;
    // sets the number of rows of the 2D array of the terrain field
    int rows;
    // sets the size of the vectors (triangle lines)
    int scale = 20;
    // sets the width of the field
    int w = 1480;
    // sets the height of the field
    int h = 1250;

    // 2D array for the terrain
    float[][] terrain;

    // equivalent of constructor
    public void settings() {
        // size of canvas
        size(600, 600, P3D);
        columns = w / scale;
        rows = h/ scale;
        terrain = new float[columns][rows];
    }


    public void draw() {
        float yoffset = 0;
        // set the offset y axis
        yoffset = mouseY;
        for (int y = 0; y < rows; y++) {
            // set the offset x axis
            float xoffset = 0;
            for (int x = 0; x < columns; x++) {
                // feeding the 2d terrain field
                terrain[x][y] = map(noise(xoffset, yoffset), 0, 1, -100, 100);
                // spreading away in x axis
                xoffset += 0.2;
            }
            // spreading away in y axis
            // scrolls the landscape up and down
            yoffset += mouseY; // 0.2 smooth value
        }


        // sets the background color (light green)
        background(100, 100, 255);
        // sets the color of the field
        fill(100,255, 100);
        // sets the color of the lines
        stroke(20, 125, 20);

        // rotates putting the field on the bottom
        translate(width/2, height/2+50);
        // rotates the field (laying down revealing the sky)
        rotateX(PI/3);
        // sets the field in the middle of the canvas
        translate(-w/2, -h/2);

        // drawing the vectors
        for (int y = 0; y < rows-1; y++) {
            beginShape(TRIANGLE_STRIP);
            for (int x = 0; x < columns; x++) {
                vertex(x*scale, y*scale, terrain[x][y]);
                vertex(x*scale, (y+1)*scale, terrain[x][y+1]);

            }
            endShape();
        }
    }

    public static void main(String[] args){
        String[] processingArgs = {"CanvasBoard"};
        CanvasBoard mySketch = new CanvasBoard();
        PApplet.runSketch(processingArgs, mySketch);
    }
}
