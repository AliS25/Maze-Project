import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;


public class ButtonToMenuListener implements ActionListener {

	private JButton myButton;
	JPopupMenu  menu;

	public ButtonToMenuListener(JButton clicker) {
		myButton = clicker;

		// create a popup menu
		menu = new JPopupMenu("Menu");
		MazeChoiceListener mcl = new MazeChoiceListener();
		
        // create a menu item
		JMenuItem firstMaze = new JMenuItem("PLAY MAZE 1");
        // add the menu item to the menu
		menu.add(firstMaze);
        // add a listener to the menu item
		firstMaze.addActionListener(mcl);
		
		 // create a menu item
		JMenuItem secondMaze = new JMenuItem("PLAY MAZE 2");
        // add the menu item to the menu
		menu.add(secondMaze);
        // add a listener to the menu item
		secondMaze.addActionListener(mcl);

		JMenuItem thirdMaze = new JMenuItem("PLAY MAZE 3");
		menu.add(thirdMaze);
		thirdMaze.addActionListener(mcl);


        menu.add(new JMenuItem("PLAY LATER"));
	}

	public void actionPerformed(ActionEvent e) {
		
		menu.show(myButton,myButton.getWidth()/2,myButton.getHeight()/2);
	}


}
