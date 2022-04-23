import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


class SwitchListener extends NewLook implements ActionListener {
	private int mazeNum;

	public SwitchListener(JFrame an, int m) {
		super(an);
		mazeNum = m;
	}

	// Changes the Frame by adding one button
	public void actionPerformed(ActionEvent arg0) {
		if (mazeNum == 3) {
			JButton one = new JButton("MAZE 1");
			an.getContentPane().add(one);
			one.addActionListener(new NewLook(an));
			an.validate();
			an.repaint();

			JButton two = new JButton("MAZE 2");
			an.getContentPane().add(two);
			two.addActionListener(new NewLook(an));
			an.validate();
			an.repaint();
		}
		else if (mazeNum == 2) {
			JButton one = new JButton("MAZE 1");
			an.getContentPane().add(one);
			one.addActionListener(new NewLook(an));
			an.validate();
			an.repaint();

			JButton two = new JButton("MAZE 3");
			an.getContentPane().add(two);
			two.addActionListener(new NewLook(an));
			an.validate();
			an.repaint();
		}
		else if (mazeNum == 1) {
			JButton one = new JButton("MAZE 2");
			an.getContentPane().add(one);
			one.addActionListener(new NewLook(an));
			an.validate();
			an.repaint();

			JButton two = new JButton("MAZE 3");
			an.getContentPane().add(two);
			two.addActionListener(new NewLook(an));
			an.validate();
			an.repaint();
		}
	}
}
