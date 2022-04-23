import java.awt.*;

import javax.swing.*;

public class Menu extends JFrame {
	private JButton[] buttons = new JButton[12];

	public void setUpMenu() {

		Container contentPane = this.getContentPane();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane.setLayout(new GridLayout(4, 4));


		int[] nums = {1, 2, 3, 4, 5, 6};
		for (int i = 0; i < 4; i++) {


			int num = (int) (Math.random() * 6);
			buttons[i] = new JButton("" + nums[num]);
			buttons[i].setFont(new Font("font", Font.PLAIN, 60));
			if (num % 2 == 0) buttons[i].setBackground(Color.blue);
			else buttons[i].setBackground(Color.green);
			contentPane.add(buttons[i]);

		}
		for (int i = 4; i < 8; i++) {
			int num = (int) (Math.random() * 4);
			buttons[i] = new JButton();

			if (num == 0) {
				ImageIcon icon = new ImageIcon("cross.png");
				Image image = icon.getImage();
				Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				buttons[i].setIcon(icon);
				buttons[i].setBackground(Color.red);
			} else if (num == 1) {
				ImageIcon icon = new ImageIcon("star.png");
				Image image = icon.getImage();
				Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				buttons[i].setIcon(icon);
				buttons[i].setBackground(Color.blue);


			} else if (num == 2) {
				ImageIcon icon = new ImageIcon("diamond.png");
				Image image = icon.getImage();
				Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				buttons[i].setIcon(icon);
				buttons[i].setBackground(Color.yellow);

			} else if (num == 3) {
				ImageIcon icon = new ImageIcon("flower.png");
				Image image = icon.getImage();
				Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				buttons[i].setIcon(icon);
				buttons[i].setBackground(Color.green);

			}
			contentPane.add(buttons[i]);
		}
		for (int i = 8; i < 12; i++) {
			int num = (int) (Math.random() * 8);
			int num2= (int) (Math.random() * 2);
			buttons[i] = new JButton();

			if(num==1&num2==1) {
				ImageIcon icon = new ImageIcon("right.png");
				Image image = icon.getImage();
				Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				buttons[i].setIcon(icon);
			}
			else   if(num==2&num2==1) {
				ImageIcon icon = new ImageIcon("leftred.png");
				Image image = icon.getImage();
				Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				buttons[i].setIcon(icon);
			}
			else   if(num==3&num2==1) {
				ImageIcon icon = new ImageIcon("upred.png");
				Image image = icon.getImage();
				Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				buttons[i].setIcon(icon);
			}
			else   if(num==4&num2==1) {
				ImageIcon icon = new ImageIcon("downred.png");
				Image image = icon.getImage();
				Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				buttons[i].setIcon(icon);
			}
			else   if(num==5&num2==1) {
				ImageIcon icon = new ImageIcon("upright.png");
				Image image = icon.getImage();
				Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				buttons[i].setIcon(icon);
			}
			else   if(num==6&num2==1) {
				ImageIcon icon = new ImageIcon("upleftred.png");
				Image image = icon.getImage();
				Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				buttons[i].setIcon(icon);
			}
			else   if(num==7&num2==1) {
				ImageIcon icon = new ImageIcon("downrightred.png");
				Image image = icon.getImage();
				Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				buttons[i].setIcon(icon);
			}
			else   if(num==0&num2==1) {
				ImageIcon icon = new ImageIcon("downleftred.png");
				Image image = icon.getImage();
				Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				buttons[i].setIcon(icon);
			}   else   if(num==1&num2==0) {
				ImageIcon icon = new ImageIcon("rightblue.png");
				Image image = icon.getImage();
				Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				buttons[i].setIcon(icon);
			}
			else   if(num==2&num2==0) {
				ImageIcon icon = new ImageIcon("leftblue.png");
				Image image = icon.getImage();
				Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				buttons[i].setIcon(icon);
			}
			else   if(num==3&num2==0) {
				ImageIcon icon = new ImageIcon("upblue.png");
				Image image = icon.getImage();
				Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				buttons[i].setIcon(icon);
			}
			else   if(num==4&num2==0) {
				ImageIcon icon = new ImageIcon("downblue.png");
				Image image = icon.getImage();
				Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				buttons[i].setIcon(icon);
			}
			else   if(num==5&num2==0) {
				ImageIcon icon = new ImageIcon("uprightblue.png");
				Image image = icon.getImage();
				Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				buttons[i].setIcon(icon);
			}
			else   if(num==6&num2==0) {
				ImageIcon icon = new ImageIcon("upleftblue.png");
				Image image = icon.getImage();
				Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				buttons[i].setIcon(icon);
			}
			else   if(num==7&num2==0) {
				ImageIcon icon = new ImageIcon("downrightblue.png");
				Image image = icon.getImage();
				Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				buttons[i].setIcon(icon);
			}
			else   if(num==0&num2==0) {
				ImageIcon icon = new ImageIcon("downleftblue.png");
				Image image = icon.getImage();
				Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
				icon = new ImageIcon(newimg);
				buttons[i].setIcon(icon);
			}
			contentPane.add(buttons[i]);
		}


		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout());

		JButton changer = new JButton("GAME MENU");

		jp2.add(changer);


		contentPane.add(jp2);

		ButtonToMenuListener fl = new ButtonToMenuListener(changer);

		changer.addActionListener(fl);

	}

}







