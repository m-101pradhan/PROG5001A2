import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MP_GameBoard extends JPanel implements ActionListener
{ 
    int xcells = 30;   
    int ycells = 30;
    int zcells = 10;
    MP_Snake snake;
    MP_Prey prey;
    private final int DELAY = 140;
    private Timer t;

    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
     
    public MP_GameBoard() {
        addKeyListener(new TAdapter());
        setPreferredSize(new Dimension(xcells * zcells, ycells * zcells));        
        setBackground(Color.black);
        setFocusable(true);
        t = new Timer(DELAY, this);
        t.start();
    }
    
    @Override
    public void paintComponent(Graphics g) {
     super.paintComponent(g);
     snake = new MP_Snake(g);
     prey = new MP_Prey(g);
    }
    
    private void moveSnake() {
        if (left)
            snake.move("left");
        if (right)
            snake.move("right");
        if (up)
            snake.move("up");
        if (down)
            snake.move("down");
    }
    public void actionPerformed(ActionEvent e) {
        moveSnake();
        repaint();
    }
    
    public void showWinner(){}
    public void showLoser(){}
    
    private class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!right)) {
                left = true;
                up = false;
                down = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!left)) {
                right = true;
                up = false;
                down = false;
            }

            if ((key == KeyEvent.VK_UP) && (!down)) {
                up = true;
                right = false;
                left = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!up)) {
                down = true;
                right = false;
                left = false;
            }
        }
    }
}
