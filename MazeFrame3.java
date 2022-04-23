import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MazeFrame3 extends JFrame implements MazeInterface{
        private Location[][] location = new Location[8][8];

 //   private JButton solve;

    //  private Location current=new Location(5,1);


        private JLabel message;

        public void setUpFrame() {
            // Exit when window is closed
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            Container ct = getContentPane();


            ct.setLayout(new GridLayout(9, 8));


            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    location[i][j] = new Location(i, j);
                    ct.add(location[i][j]);

                }
            }

            message = new JLabel("move to opposite color");
            ct.add(message);
            MazePanels lowerPanel = new MazePanels("ARROWS GAME");
            JButton changer = new JButton("SWITCH GAME");
            changer.addActionListener(new SwitchListener(this,3));
            lowerPanel.add(changer);
     //       lowerPanel.add(solve);
            ct.add(lowerPanel);

        }




        public void setDoneMessage(String message1) {
            message.setText(message1);
        }


        //--------------------------------------------------------------
        public class Location extends JButton implements ActionListener{
            private Information colorInfo= new Information(1);
            private Information directionInfo= new Information(1);

            private int row;
            private int column;

            private int currentRow=0;
            private int currentColumn=0;
            private ArrayList<Integer>rows=new ArrayList<Integer>();
            private ArrayList<Integer>columns=new ArrayList<Integer>();



            private ArrayList<Location> possibleTransitions = new ArrayList<Location>();
            private int[] rightArrow = {0,8,11,30,36,46,51,52,53,57};
            private int[] leftArrow = {14,17,22,23,33,47,49};
            private int[] upArrow = {16,58,61};
            private int[] downArrow = {2,4,6,7,9,13,28,34,35,40};
            private int[] upRightArrow = {20,32,37,45,48,56,59,60};
            private int[] upLeftArrow={29,31,38,39,44,54,62};
            private int[] downRightArrow={1,10,12,19,24,25,27,41,42,43,50};
            private int[] downLeftArrow = {3,5,15,18,21,26,55};
            private int[] redArrow = {0,1,4,5,6,7,9,11,15,16,19,20,23,24,25,27,28,30,33,34,39,40,42,43,44,45,47,48,51,52,55,57,59};
            private int[] blueArrow = {2,3,8,10,12,13,14,17,18,21,22,26,29,31,32,35,36,37,38,41,46,49,50,53,54,56,58,60,61,62};

//            public int getInfo() {
//                return colorInfo.getDirection();
//            }


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
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
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
                int shape = buttonShape((r ) *8+ (c));
                int color= buttonColor((r*8)+c);
                if(shape==1&color==1) {
                    setIcon("right.png");
                }
                else   if(shape==2&color==1) {
                   setIcon("leftred.png");
                }
                else   if(shape==3&color==1) {
                    setIcon("upred.png");
                }
                else   if(shape==4&color==1) {
                    setIcon("downred.png");
                }
                else   if(shape==5&color==1) {
                 setIcon("upright.png");
                }
                else   if(shape==6&color==1) {
                    setIcon("upleftred.png");
                }
                else   if(shape==7&color==1) {
                   setIcon("downrightred.png");
                }
                else   if(shape==8&color==1) {
                    setIcon("downleftred.png");
                }   else   if(shape==1&color==2) {
                    setIcon("rightblue.png");
                }
                else   if(shape==2&color==2) {
                  setIcon("leftblue.png");
                }
                else   if(shape==3&color==2) {
                    setIcon("upblue.png");
                }
                else   if(shape==4&color==2) {
                    setIcon("downblue.png");
                }
                else   if(shape==5&color==2) {
                   setIcon("uprightblue.png");
                }
                else   if(shape==6&color==2) {
                 setIcon("upleftblue.png");
                }
                else   if(shape==7&color==2) {
                  setIcon("downrightblue.png");
                }
                else   if(shape==8&color==2) {
                  setIcon("downleftblue.png");
                }
                else   if(shape==0&color==0) {
                    setIcon("target.png");
                }
                if (color==1)setBackground(Color.red);
                else if(color==2) setBackground(Color.blue);
                row = r;
                column = c;
                this.addActionListener(this);
                if (r == 0 & c == 0) {
                    this.setEnabled(true);
               //     solve=new JButton("SHOW MAZE SOLUTION");
                   // solve.addActionListener(new SolverListener(this));
                }
                else this.setEnabled(false);
            }
            public void setIcon(String s){
                ImageIcon icon = new ImageIcon(s);
                Image image = icon.getImage();
                Image newimg = image.getScaledInstance(160, 80, java.awt.Image.SCALE_SMOOTH);
                icon = new ImageIcon(newimg);
                setIcon(icon);
            }
            public int buttonShape(int c) {

                for (int a : rightArrow)
                    if (c == a) return 1;
                for (int a : leftArrow)
                    if (c == a) return 2;
                for (int a : upArrow)
                    if (c == a) return 3;
                for (int a : downArrow)
                    if (c == a) return 4;
                for (int a : upRightArrow)
                    if (c == a) return 5;
                for (int a : upLeftArrow)
                    if (c == a) return 6;
                for (int a : downRightArrow)
                    if (c == a) return 7;
                for (int a : downLeftArrow)
                    if (c == a) return 8;
                return 0;
            }
            public int buttonColor(int c){
                for (int a : redArrow)
                    if (c == a) return 1;
                for (int a : blueArrow)
                    if (c == a) return 2;
                return 0;
            }

            public boolean differentColor(Location l){
                return(this.buttonColor((this.row*8)+this.column)!=l.buttonColor((l.row*8)+l.column));
            }





            public void applicableTransitions(int row, int column) {
                if (colorInfo.getDirection() == 1) {
                    if (directionInfo.getDirection() == 1) {
                        for (int i = column + 1; i < 8; i++) {
                            if (location[row][i].differentColor(location[row][column])) {
                                possibleTransitions.add(location[row][i]);
                            }
                        }
                    }

                    if (directionInfo.getDirection() == 2) {
                        for (int i = 0; i < column; i++) {
                            if (location[row][i].differentColor(location[row][column])) {
                                possibleTransitions.add(location[row][i]);
                            }
                        }
                    }
                    if (directionInfo.getDirection() == 3) {
                        for (int i = 0; i < row; i++) {
                            if (location[i][column].differentColor(location[row][column])) {
                                possibleTransitions.add(location[i][column]);
                            }
                        }
                    }
                    if (directionInfo.getDirection() == 4) {
                        for (int i = row + 1; i < 8; i++) {
                            if (location[i][column].differentColor(location[row][column])) {
                                possibleTransitions.add(location[i][column]);
                            }
                        }
                    }
                    if (directionInfo.getDirection() == 5) {
                        for (int i = column + 1; i < 8; i++) {
                            if (row - i + column >= 0) {
                                if (location[row - i + column][i].differentColor(location[row][column])) {
                                    possibleTransitions.add(location[row - i + column][i]);
                                }
                            }
                        }
                    }
                    if (directionInfo.getDirection() == 6) {
                        for (int i = 0; i < row; i++) {
                            if (column - row + i >= 0) {
                                if (location[i][column - row + i].differentColor(location[row][column])) {
                                    possibleTransitions.add(location[i][column - row + i]);
                                }
                            }
                        }
                    }
                    if (directionInfo.getDirection() == 7) {
                        for (int i = row + 1; i < 8; i++) {
                            if (column - row + i < 8) {
                                if (location[i][column - row + i].differentColor(location[row][column])) {
                                    possibleTransitions.add(location[i][column - row + i]);
                                }
                            }
                        }
                    }

                    if (directionInfo.getDirection() == 8) {
                        for (int i = row + 1; i < 8; i++) {
                            if (column + row - i >= 0) {
                                if (location[i][column + row - i].differentColor(location[row][column])) {
                                    possibleTransitions.add(location[i][column + row - i]);
                                }
                            }
                        }

                    }

                } else if (colorInfo.getDirection() == 2) {
                    if (directionInfo.getDirection() == 1) {
                        for (int i = column + 1; i < 8; i++) {
                            if (location[row][i].differentColor(location[row][column])) {
                                possibleTransitions.add(location[row][i]);
                            }
                        }
                    }

                    if (directionInfo.getDirection() == 2) {
                        for (int i = 0; i < column; i++) {
                            if (location[row][i].differentColor(location[row][column])) {
                                possibleTransitions.add(location[row][i]);
                            }
                        }
                    }
                    if (directionInfo.getDirection() == 3) {
                        for (int i = 0; i < row; i++) {
                            if (location[i][column].differentColor(location[row][column])) {
                                possibleTransitions.add(location[i][column]);
                            }
                        }
                    }
                    if (directionInfo.getDirection() == 4) {
                        for (int i = row + 1; i < 8; i++) {
                            if (location[i][column].differentColor(location[row][column])) {
                                possibleTransitions.add(location[i][column]);
                            }
                        }
                    }
                    if (directionInfo.getDirection() == 5) {
                        for (int i = column + 1; i < 8; i++) {
                            if (row - i + column >= 0) {
                                if (location[row - i + column][i].differentColor(location[row][column])) {
                                    possibleTransitions.add(location[row - i + column][i]);
                                }
                            }
                        }
                    }
                    if (directionInfo.getDirection() == 6) {
                        for (int i = 0; i < row; i++) {
                            if (column - row + i >= 0) {
                                if (location[i][column - row + i].differentColor(location[row][column])) {
                                    possibleTransitions.add(location[i][column - row + i]);
                                }
                            }
                        }
                    }
                    if (directionInfo.getDirection() == 7) {
                        for (int i = row + 1; i < 8; i++) {
                            if (column - row + i < 8) {
                                if (location[i][column - row + i].differentColor(location[row][column])) {
                                    possibleTransitions.add(location[i][column - row + i]);
                                }
                            }
                        }
                    }

                    if (directionInfo.getDirection() == 8) {
                        for (int i = row + 1; i < 8; i++) {
                            if (column + row - i >= 0) {
                                if (location[i][column + row - i].differentColor(location[row][column])) {
                                    possibleTransitions.add(location[i][column + row - i]);
                                }
                            }
                        }

                    }
                }
            }

            public boolean isGoal(int r, int c){
                return(r==7&c==7);
            }
            public boolean isStart(int r, int c){
                return(r==0&c==0);
            }



            public void beenHere() {
                if (!isGoal(row,column)) {
                    if (colorInfo.getDirection() == 1) {
                        directionInfo.setDirection(buttonShape((this.row * 8) + this.column));
                        colorInfo.setDirection(2);
                    } else if (colorInfo.getDirection() == 2) {
                        directionInfo.setDirection(buttonShape((this.row * 8) + this.column));
                        colorInfo.setDirection(1);
                    }
                    this.applicableTransitions(this.row, this.column);


                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            location[i][j].setEnabled(false);
                        }
                    }
                    for (int i = 0; i < possibleTransitions.size(); i++) {
                        possibleTransitions.get(i).setEnabled(true);

                    }
                }
                else {
                    setDoneMessage("YOU WIN, TRY ANOTHER MAZE");
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
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


