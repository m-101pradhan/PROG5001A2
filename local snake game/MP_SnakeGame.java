import java.awt.EventQueue;
import java.awt.FlowLayout;
import javax.swing.*;

public class MP_SnakeGame extends JFrame {

    public MP_SnakeGame(String gameTille) { 
        getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        add(new MP_GameBoard());
        add(new MP_Menu()); 
        setTitle(gameTille);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();        
    }
    
    public static void main(String[] args) {        
        EventQueue.invokeLater(() -> {
            //create the game with a game title as follow: The Snake Game (C) Your_Name
            JFrame sgame = new JFrame();
            sgame.setVisible(true);
        });
    }
}
