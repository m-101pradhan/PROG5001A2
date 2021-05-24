import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.util.Iterator;
/**
 * Write a description of class MP_Snake here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MP_Snake extends MP_Element
{
    private int len;
    private float speed;
    MP_PointArray snakeArray;
    Image head;
    Image tail;
    /**
     * Constructor for objects of class MP_Snake
     */
    public MP_Snake(Graphics g)
    {
        if (snakeArray==null) 
        {
            len = 4;
            pos_x = 150;
            pos_y = 150;
            snakeArray = new MP_PointArray(pos_x,pos_y,len,size_x,size_y);
        }
        this.g = g;
        image = "head1.png";
        ImageIcon icon = new ImageIcon("resources/"+image);
        head= icon.getImage();
        ImageIcon tailicon = new ImageIcon("resources/tail.png");
        tail = tailicon.getImage();
        for (int i = 0; i < len; i++) {
            String bone= snakeArray.getPos().get(i);
            int x = Integer.parseInt(bone.split(",")[0]);
            int y = Integer.parseInt(bone.split(",")[1]);
            if (i==0) {
                g.drawImage(head, x, y,size_x,size_y, this);
            }else {
                 g.drawImage(tail, x, y,size_x,size_y, this);
            }
            
        }
    }
    
    public int getLen() {
        return this.len; 
    }
    
    public void setLen(int len) {
        this.len=len;
    }

    public void increaseLength(int amount) {}
    
    public float getSpeed() 
    {
        return speed;
    }

    public void setSpeed(float speed) 
    {
        this.speed = speed;
    }
    
    public void move(String direction) {
        pos_x=Integer.parseInt(snakeArray.getPos().get(0).split(",")[0]);
        pos_y=Integer.parseInt(snakeArray.getPos().get(0).split(",")[1]);
        switch (direction) {
        case "up": 
            pos_y-=size_y;
            break;
        case "down":
            pos_y+=size_y;
            break;
        case "left":
            pos_x-=size_x;
            break;
        case "right":
            pos_x+=size_x;
            break;
        default:
            throw new IllegalArgumentException("Unexpected value: " + direction);
        }
        
        
        for (int i = len-1; i > 0; i--) {
            snakeArray.getPos().set(i, snakeArray.getPos().get(i-1));
        }
        snakeArray.getPos().set(0, pos_x+","+pos_y);
    }
    
    public boolean checkCollision() {
        return false;
    }
}
