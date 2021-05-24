
/**
 * Write a description of class MP_PointArray here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MP_PointArray
{
    public static List<String> pos = new ArrayList<>();

    /**
     * Constructor for objects of class MP_PointArray
     */
    public MP_PointArray(int pos_x, int pos_y, int len, int size_x, int size_y) {
        if (!pos.isEmpty()) {
            return;
        }
        pos.add(0, pos_x+","+pos_y);
        for (int i = 1; i < len; i++) {
            int lastYPos = Integer.parseInt( pos.get(i-1).split(",")[1]);
            pos.add(i, pos_x+","+ (lastYPos+size_y));
        }        
    }

    public List<String> getPos() {
        return pos;
    }
}
