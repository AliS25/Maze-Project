import javax.swing.*;
import java.awt.*;

public class MazePanels extends JPanel{
    private String onScreen;
          public MazePanels(String s) {
            // set size, otherwise Java will assume 0 x 0 and component may disappear
            setPreferredSize(new Dimension(300,300));
            onScreen=s;
        }

        public void paintComponent(Graphics g) {
            g.setColor(new Color(randomC(),randomC(),randomC()));
            g.draw3DRect(35,65,185,40,true);
            g.fill3DRect(35,65,185,40,false);
            g.setColor((new Color(randomC(),randomC(),randomC())));
            g.setFont(new Font("font", Font.PLAIN, 15));
            g.drawString(onScreen,35,85);


        }
        public int randomC(){
           return (int) (Math.random()*255);
        }

                }

