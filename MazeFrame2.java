import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MazeFrame2 extends JFrame implements MazeInterface {
    private Location[][] location = new Location[6][6];
    private Information info = new Information(1);
    private Location current = new Location(5, 1);

  //  private JButton solve;



    private JLabel message;

    public void setUpFrame() {
        // Exit when window is closed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container ct = getContentPane();

        // set the layout manager to a grid 0 rows by 3 columns
        // (0 means however many you need)
        ct.setLayout(new GridLayout(7, 6));


        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
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

        message = new JLabel("Keep pressing buttons");
        ct.add(message);
        MazePanels lowerPanel = new MazePanels("Shapes And Colors Game");
        JButton changer = new JButton("SWITCH GAME");
        changer.addActionListener(new SwitchListener(this, 2));
        lowerPanel.add(changer);
       // lowerPanel.add(solve);
        ct.add(lowerPanel);

    }


        public void setDoneMessage(String message1) {
            message.setText(message1);
}


        //--------------------------------------------------------------
        public class Location extends JButton implements ActionListener,LocationInteface {
            private int row;
            private int column;

            private int currentRow=5;
            private int currentColumn=1;
            private ArrayList<Integer>rows=new ArrayList<Integer>();
            private ArrayList<Integer>columns=new ArrayList<Integer>();


            private ArrayList<Location> possibleTransitions = new ArrayList<Location>();
            private int[] crossButtons = {2, 6, 15, 19, 23, 26};
            private int[] starButtons = {7,11,12,14,16,20,24};
            private int[] diamondButtons = {8,9,10,13,22,25,27};
            private int[] flowerButtons = {17,18,21,28,29,31};
            private int[] greenButtons = {2,15,16,17,20,24,28};
            private int[] redButtons={6,7,10,14,18,19,25};
            private int[] yellowButtons={8,11,12,13,22,23,26,27,31};
            private int[] blueButtons = {9,21,29};

public void setRowC(int r){
    current.row=r;
}
            public void setColumnC(int c){
                current.column=c;
            }


            public int getInfo() {
                return info.getDirection();
            }
            public void setInfo(int i){
                info.setDirection(i);
            }

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
                for (int i = 0; i < 6; i++) {
                    for (int j = 0; j < 6; j++) {
                        location[i][j].setEnabled(false);
                    }
                }
            }
            public void applySolution(int r, int c){
                location[r][c].setEnabled(true);
                location[r][c].doClick(1000);
            }
            public void startOver(){
                getContentPane().removeAll();
                setUpFrame();
                validate();
                repaint();
            }
            public void test(int r, int c){
                location[r][c].setEnabled(true);
                location[r][c].doClick(2000);
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
                this.setFont(new Font("font", Font.PLAIN, 15));
                int shape = buttonShape((r ) *6+ (c));
                int color= buttonColor((r*6)+c);
                if(shape==1) {
                    ImageIcon icon = new ImageIcon("cross.png");
                    Image image = icon.getImage();
                    Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
                    icon = new ImageIcon(newimg);
                    setIcon(icon);
                }
                else   if(shape==2) {
                    ImageIcon icon = new ImageIcon("star.png");
                    Image image = icon.getImage();
                    Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
                    icon = new ImageIcon(newimg);
                    setIcon(icon);
                }
                else   if(shape==3) {
                    ImageIcon icon = new ImageIcon("diamond.png");
                    Image image = icon.getImage();
                    Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
                    icon = new ImageIcon(newimg);
                    setIcon(icon);
                }
                else   if(shape==4) {
                    ImageIcon icon = new ImageIcon("flower.png");
                    Image image = icon.getImage();
                    Image newimg = image.getScaledInstance(120, 120, java.awt.Image.SCALE_SMOOTH);
                    icon = new ImageIcon(newimg);
                    setIcon(icon);
                }

                if(color==1){
                    this.setBackground(Color.green);
                }
                if(color==2){
                    this.setBackground(Color.red);
                }
                if(color==3){
                    this.setBackground(Color.yellow);
                }
                if(color==4){
                    this.setBackground(Color.blue);
                }


                if(r==0&c==2)
                this.setText("GOAL");
                row = r;
                column = c;
                this.addActionListener(this);
                if (r == 5 & c == 1) {
                    this.setEnabled(true);
                 //   solve=new JButton("SHOW MAZE SOLUTION");
                  //  solve.addActionListener(new SolverListener(this));
                }
                else this.setEnabled(false);

            }
            public int buttonShape(int c) {

                for (int a : crossButtons)
                    if (c == a) return 1;
                for (int a : starButtons)
                    if (c == a) return 2;
                for (int a : diamondButtons)
                    if (c == a) return 3;
                for (int a : flowerButtons)
                    if (c == a) return 4;
                return 0;
            }
            public int buttonColor(int c){
                for (int a : greenButtons)
                    if (c == a) return 1;
                for (int a : redButtons)
                    if (c == a) return 2;
                for (int a : yellowButtons)
                    if (c == a) return 3;
                for (int a : blueButtons)
                    if (c == a) return 4;
                     return 0;
            }

            public boolean sameColor(Location l){
                return(this.buttonColor((this.row*6)+this.column)==l.buttonColor((l.row*6)+l.column));
            }
            public boolean sameShape(Location l){
                return(this.buttonShape((this.row*6)+this.column)==l.buttonShape((l.row*6)+l.column));
            }




            public void applicableTransitions(int row, int column) {
                if (info.getDirection() == 1) {
                    this.possibleTransitions.clear();

                    for(int i=0; i<row;i++) {
                        if(location[i][column].sameColor(location[row][column])||location[i][column].sameShape(location[row][column])){
                            possibleTransitions.add(location[i][column]);
                           // System.out.println("called 1 1");
                        }
                    }
                    for(int i=column+1; i<6;i++) {
                        if(location[row][i].sameColor(location[row][column])||location[row][i].sameShape(location[row][column])){
                            possibleTransitions.add(location[row][i]);
                          //  System.out.println("called 1 2");

                        }
                    }
                    for(int i=0; i<column;i++) {
                        if(location[row][i].sameColor(location[row][column])||location[row][i].sameShape(location[row][column])){
                            possibleTransitions.add(location[row][i]);
                      //      System.out.println("called 1 3");

                        }
                    }
                                    }
                if (info.getDirection() == 2) {
                    this.possibleTransitions.clear();

                    for(int i=0; i<row;i++) {
                        if(location[i][column].sameColor(location[row][column])||location[i][column].sameShape(location[row][column])){
                            possibleTransitions.add(location[i][column]);
                         //   System.out.println("called 2 1");

                        }
                    }
                    for(int i=column+1; i<6;i++) {
                        if(location[row][i].sameColor(location[row][column])||location[row][i].sameShape(location[row][column])){
                            possibleTransitions.add(location[row][i]);
                        //    System.out.println("called 2 2");

                        }
                    }
                    for(int i=row+1; i<6;i++) {
                        if(location[i][column].sameColor(location[row][column])||location[i][column].sameShape(location[row][column])){
                            possibleTransitions.add(location[i][column]);
                  //          System.out.println("called 2 3");

                        }
                    }
                }
                if (info.getDirection() == 3) {
                    this.possibleTransitions.clear();

                    for(int i=0; i<column;i++) {
                        if (location[row][i].sameColor(location[row][column]) || location[row][i].sameShape(location[row][column])) {
                            possibleTransitions.add(location[row][i]);
//                            System.out.println("called 3 1");

                        }
                    }
                    for(int i=column+1; i<6;i++) {
                        if(location[row][i].sameColor(location[row][column])||location[row][i].sameShape(location[row][column])){
                            possibleTransitions.add(location[row][i]);
//                            System.out.println("called 3 2");


                        }
                    }
                    for(int i=row+1; i<6;i++) {
                        if(location[i][column].sameColor(location[row][column])||location[i][column].sameShape(location[row][column])){
                            possibleTransitions.add(location[i][column]);
//                            System.out.println("called 3 3");

                        }
                    }
                }
                if (info.getDirection() == 4) {
                    this.possibleTransitions.clear();
                    for(int i=0; i<row;i++) {
                        if(location[i][column].sameColor(location[row][column])||location[i][column].sameShape(location[row][column])){
                            possibleTransitions.add(location[i][column]);
//                            System.out.println("called 4 1");

                        }
                    }

                    for(int i=0; i<column;i++) {
                        if (location[row][i].sameColor(location[row][column]) || location[row][i].sameShape(location[row][column])) {
                            possibleTransitions.add(location[row][i]);
//                            System.out.println("called 4 2");

                        }
                    }

                    for(int i=row+1; i<6;i++) {
                        if(location[i][column].sameColor(location[row][column])||location[i][column].sameShape(location[row][column])){
                            possibleTransitions.add(location[i][column]);
//                            System.out.println("called 4 3");

                        }
                    }
                }

            }
            public boolean isGoal(int r, int c){
                return(r==0&c==2);
            }
            public boolean isStart(int r, int c){
                return(r==5&c==1);
            }

            public void beenHere() {
                if (!isGoal(row,column)) {
                    if (info.getDirection() == 1) {
//                        System.out.println("up");

                        if (this.column == current.column) info.setDirection(1);
                        else if (this.column > current.column) info.setDirection(2);
                        else if (this.column < current.column) info.setDirection(4);
                        current.setColumn(this.column);
                        current.setRow(this.row);
                    } else if (info.getDirection() == 2) {
//                        System.out.println(current.row);

                        if (this.row == current.row) info.setDirection(2);
                        else if (this.row > current.row) info.setDirection(3);
                        else if (this.row < current.row) info.setDirection(1);
                        current.setColumn(this.column);
                        current.setRow(this.row);
                    } else if (info.getDirection() == 3) {
                        //System.out.println("down");

                        if (this.column == current.column) info.setDirection(3);
                        else if (this.column > current.column) info.setDirection(2);
                        else if (this.column < current.column) info.setDirection(4);
                        current.setColumn(this.column);
                        current.setRow(this.row);
                    } else if (info.getDirection() == 4) {
                        //System.out.println("left");

                        if (this.row == current.row) info.setDirection(4);
                        else if (this.row > current.row) info.setDirection(3);
                        else if (this.row < current.row) info.setDirection(1);
                        current.setColumn(this.column);
                        current.setRow(this.row);
                    }


                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 6; j++) {
                            location[i][j].setEnabled(false);
                        }
                    }
                    this.applicableTransitions(this.row, this.column);

                    for (int i = 0; i < possibleTransitions.size(); i++) {
                        possibleTransitions.get(i).setEnabled(true);
                    }
                }
                else {
                    setDoneMessage("YOU WIN, TRY ANOTHER MAZE");
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < 6; j++) {
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


