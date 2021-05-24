/**
 * Class MP_Prey represents any prey object.
 *
 * @author 
 * @version
 */
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class MP_Prey represents any prey object.
 *
 * @author 
 * @version 
 */
public class MP_Prey extends MP_Element{
    
    public static int positin_x;
    public static int positin_y;
    public static boolean one=false;
    /**
     * Constructor for objects of class MP_Prey
     */
    public MP_Prey(Graphics g)
    {
        if (!one) {
        setPositionRandomly(300, 300, 0, 0);
        one=true;
        }
        this.g = g;
        image = "prey.jpg";
        ImageIcon icon = new ImageIcon("resources/"+image);
        Image image = icon.getImage();
        g.drawImage(image, positin_x, positin_x,size_x,size_y, this);
    }  
    
    private void setPositionRandomly(int maximumX,int maximumY,int minimumX,int minimumY){
        positin_x = ThreadLocalRandom.current().nextInt(minimumX, maximumX + 1);
        positin_y = ThreadLocalRandom.current().nextInt(minimumY, maximumY + 1);
    }
  
    public void destroy(){}
}
