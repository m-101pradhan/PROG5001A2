import java.awt.Graphics;
import javax.swing.JFrame;
/**
 * Write a description of class MP_Element here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class MP_Element extends JFrame
{
    protected int pos_x, pos_y;
    protected int size_x=25, size_y=25;
    
    protected String image;
    protected Graphics g;

    /**
     * Constructor for objects of class MP_Element
     */
    public MP_Element(){}

    public int getXPosition() {
        return this.pos_x;
    }
    
    public void setXPosition(int pos_x) {
        this.pos_x = pos_x;
    }
    
    public int getYPosition() {
        return pos_y;
    }
    
    public void setYPosition(int pos_y) {
        this.pos_y = pos_y;
    }
    
    public void setInitialPosition(int x, int y) {
    }

    public void draw() {}
    
    public void setImage(String image) {
        this.image = image;
    }
  
    public String getImage() {
        return this.image;

    }
}
