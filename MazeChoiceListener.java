import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MazeChoiceListener implements ActionListener {

	//FunPanel[] an;



	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("PLAY MAZE 1")) {
			MazeFrame1 frame = new MazeFrame1();
			frame.setUpFrame();
			frame.pack();
			frame.setVisible(true);
			frame.setPreferredSize(new Dimension(500, 500));
			frame.repaint();
		} else if (action.equals("PLAY MAZE 2")) {
			MazeFrame2 frame = new MazeFrame2();
			frame.setUpFrame();
			frame.pack();
			frame.setVisible(true);
			frame.setPreferredSize(new Dimension(500, 500));
			frame.repaint();
		} else if (action.equals("PLAY MAZE 3")) {
			MazeFrame3 frame = new MazeFrame3();
			frame.setUpFrame();
			frame.pack();
			frame.setVisible(true);
			frame.setPreferredSize(new Dimension(500, 500));
			frame.repaint();
		}
	}


}
