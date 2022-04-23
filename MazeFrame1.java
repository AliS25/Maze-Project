import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class MazeFrame1 extends JFrame implements MazeInterface{
    private Location[][] location = new Location[7][7];
    private JButton solve;


    private JLabel message;

    public void setUpFrame() {
        // Exit when window is closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container ct = getContentPane();

        // set the layout manager to a grid 0 rows by 3 columns
        // (0 means however many you need)
        ct.setLayout(new GridLayout(8, 7));


        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                // create a button  (DiamondButton is part of Lab 7)
                //
                location[i][j] = new Location(i, j);
                ct.add(location[i][j]);


                // Adding an action listener -
                // when the button is pushed, the actionPerformed method of the
                // Listener is called
                //
            }
        }

        message = new JLabel("numbers display skipped spots");
        ct.add(message);
        MazePanels lowerPanel = new MazePanels("NUMBERS GAME");

        JButton changer = new JButton("SWITCH GAME");
        changer.addActionListener(new SwitchListener(this, 1));





        lowerPanel.add(changer);
        lowerPanel.add(solve);
        ct.add(lowerPanel);

        for (int row = 0; row < 7; row++) {
            for (int column = 0; column < 7; column++) {
                location[row][column].applicableTransitions(row, column);
            }
        }
    }


        public void setDoneMessage(String message1) {
            message.setText(message1);
        }






    //--------------------------------------------------------------
    public class Location extends JButton implements ActionListener, LocationInteface{
        private int row;
        private int column;
private Color c;
        private int currentRow=0;
        private int currentColumn=0;
        private ArrayList<Integer>rows=new ArrayList<Integer>();
        private ArrayList<Integer>columns=new ArrayList<Integer>();

        private ArrayList<Location> possibleTransitions = new ArrayList<Location>();
        private int[] sixButtons = new int[2];
        private int[] fiveButtons = new int[6];
        private int[] fourButtons = new int[13];
        private int[] threeButtons = new int[11];
        private int[] twoButtons = new int[13];
        private int[] oneButtons = new int[3];
        private int[] goalButton = new int[1];







        public ArrayList<Integer> getRows() {
rows.clear();
            for(int i=0;i<possibleTransitions.size();i++){
                rows.add(possibleTransitions.get(i).getRow());
            }
            return rows;
        }
        public ArrayList<Integer> getColumns() {
            columns.clear();
            for(int i=0;i<possibleTransitions.size();i++){
                columns.add(possibleTransitions.get(i).getColumn());
            }
            return columns;
        }

        public void setCurrentRow(int currentRow) {
            this.currentRow = currentRow;
        }

        public void setCurrentColumn(int currentColumn) {
            this.currentColumn = currentColumn;
        }

        public int getCurrentRow() {
            return currentRow;
        }
        public int getCurrentColumn(){
            return currentColumn;
        }
        public void solveClicked(){
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    location[i][j].setEnabled(false);
                }
            }
        }
        public void applySolution(int r, int c){
            location[r][c].setEnabled(true);
            location[r][c].doClick(1500);
        }
        public void startOver(){
            getContentPane().removeAll();
            setUpFrame();
            validate();
            repaint();
        }

        public void useFile(String number, int[] numarray) {

            File data = new File("DisplayButtonsData");

            try {
                Scanner sc = new Scanner(data);
                if (number.equals("six")) {
                    while (sc.hasNext()) {
                        if (sc.next().equals("six")) {
                            for (int i = 0; i < numarray.length; i++) {
                                numarray[i] = sc.nextInt();
                            }
                        }
                    }
                } else if (number.equals("five")) {
                    while (sc.hasNext()) {
                        if (sc.next().equals("five")) {
                            for (int i = 0; i < numarray.length; i++) {
                                numarray[i] = sc.nextInt();
                            }
                        }
                    }
                } else if (number.equals("four")) {
                    while (sc.hasNext()) {
                        if (sc.next().equals("four")) {
                            for (int i = 0; i < numarray.length; i++) {
                                numarray[i] = sc.nextInt();
                            }
                        }
                    }
                } else if (number.equals("three")) {
                    while (sc.hasNext()) {
                        if (sc.next().equals("three")) {
                            for (int i = 0; i < numarray.length; i++) {
                                numarray[i] = sc.nextInt();
                            }
                        }
                    }
                } else if (number.equals("two")) {
                    while (sc.hasNext()) {
                        if (sc.next().equals("two")) {
                            for (int i = 0; i < numarray.length; i++) {
                                numarray[i] = sc.nextInt();
                            }
                        }
                    }
                } else if (number.equals("one")) {
                    while (sc.hasNext()) {
                        if (sc.next().equals("one")) {
                            for (int i = 0; i < numarray.length; i++) {
                                numarray[i] = sc.nextInt();
                            }
                        }
                    }
                } else if (number.equals("goal")) {
                    while (sc.hasNext()) {
                        if (sc.next().equals("goal")) {
                            for (int i = 0; i < numarray.length; i++) {
                                numarray[i] = sc.nextInt();
                            }
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }


        public void setRow(int row) {
            this.row = row;
        }

        public int getRow() {
            return row;
        }

        public void setColumn(int column) {
            this.column = column;
        }

        public int getColumn() {
            return column;
        }


        public Location(int r, int c) {

            useFile("six", sixButtons);
            useFile("five", fiveButtons);
            useFile("four", fourButtons);
            useFile("three", threeButtons);
            useFile("two", twoButtons);
            useFile("one", oneButtons);
            useFile("goal", goalButton);


            this.setFont(new Font("font", Font.PLAIN, 60));
            int stepNum = (r) * 7 + (c);
            if(stepNum%2==0)            setBackground(Color.blue);
            else if (stepNum!=0)setBackground(Color.green);
            String text;
            if (r == 6 & c == 6) text = "GOAL";
            else text = "" + buttonNum(stepNum);
            this.setText(text);
            row = r;
            column = c;
            this.addActionListener(this);
            if (r == 0 & c == 0) {
                setBorderPainted(true);
                this.setEnabled(true);
                setBackground(Color.red);
                solve=new JButton("SHOW MAZE SOLUTION");
                solve.addActionListener(new SolverListener(this));
            }

            else {
                this.setEnabled(false);
                setBorderPainted(false);
            }
        }

        public int buttonNum(int c) {
            for (int a : sixButtons) {
                if (c == a) return 6;
            }
            for (int a : fiveButtons)
                if (c == a) return 5;
            for (int a : fourButtons)
                if (c == a) return 4;
            for (int a : threeButtons)
                if (c == a) return 3;
            for (int a : twoButtons)
                if (c == a) return 2;
            for (int a : oneButtons)
                if (c == a) return 1;
            return 0;
        }

        public void applicableTransitions(int row, int column) {
            int stepNum = buttonNum((row) * 7 + (column));
            if (row + stepNum < 7) {
                possibleTransitions.add(location[row + stepNum][column]);
            }

            if (row - stepNum >= 0) {
                possibleTransitions.add(location[row - stepNum][column]);
            }

            if (column + stepNum < 7) {
                possibleTransitions.add(location[row][column + stepNum]);
            }

            if (column - stepNum >= 0) {
                possibleTransitions.add(location[row][column - stepNum]);
            }
        }

        public boolean isGoal(int r, int c){
            return(r==6&c==6);
        }
        public boolean isStart(int r, int c){
            return(r==0&c==0);
        }


        public void beenHere() {
            if (!isGoal(row,column)) {
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 7; j++) {
                        location[i][j].setEnabled(false);
                    }
                }
                for (int i = 0; i < possibleTransitions.size(); i++) {
                    possibleTransitions.get(i).setBorderPainted(true);
                    possibleTransitions.get(i).setEnabled(true);

                }
            }
            else {
                setDoneMessage("YOU WIN, TRY ANOTHER MAZE");
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 7; j++) {
                        location[i][j].setEnabled(false);
                    }
                }
            }
        }


        public void actionPerformed(ActionEvent e) {
            beenHere();
        }

    }
}

