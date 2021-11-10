import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Gifted{ 

  private static final int WIDTH = 1000;
  private static final int HEIGHT = 600;

//////////////////////////////////////////////////////////MAIN//////////////////////////////////////////
  public static void main(String[] args) {

    JFrame frame = new GiftedlView();
    ImageIcon img = new ImageIcon("images/freindship.JPG");
    frame.setBackground(Color.CYAN);
    frame.setTitle("GIFTED");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(WIDTH, HEIGHT);
    frame.setVisible(true);
    frame.setResizable(false);
    
   }
}
