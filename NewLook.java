import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class NewLook implements ActionListener {

	JFrame an;

	public NewLook(JFrame an) {
		this.an = an;
	}

	public void specialDo(String a) {
		if (a.equals("MAZE 1")) {
			MazeFrame1 now = new MazeFrame1();
			now.setUpFrame();
			now.pack();
			now.setVisible(true);
			now.setPreferredSize(new Dimension(500, 500));
			now.repaint();
		}
		if (a.equals("MAZE 2")) {
			MazeFrame2 now = new MazeFrame2();
			now.setUpFrame();
			now.pack();
			now.setVisible(true);
			now.setPreferredSize(new Dimension(500, 500));
			now.repaint();
		}
		if (a.equals("MAZE 3")) {
			MazeFrame3 now = new MazeFrame3();
			now.setUpFrame();
			now.pack();
			now.setVisible(true);
			now.setPreferredSize(new Dimension(500, 500));
			now.repaint();
		}
	}

	// removes all the components are reinitializes the Frame
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		an.getContentPane().removeAll();
		specialDo(action);
		an.validate();
		an.repaint();
	}
}