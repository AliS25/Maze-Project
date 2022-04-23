import java.awt.*;


public class MazeRun{

    public static void main(String[] args) {

        Menu menuFrame = new Menu();
        menuFrame.setUpMenu();

        menuFrame.pack();
        menuFrame.setVisible(true);

        menuFrame.setPreferredSize(new Dimension(500,500));
        menuFrame.repaint();

        // this method must finish and return before GUI
        // handling begins
    }

}
