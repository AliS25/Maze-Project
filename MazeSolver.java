import java.util.ArrayList;

public class MazeSolver {
    ArrayList<Integer> row = new ArrayList<Integer>();
    ArrayList<Integer> column = new ArrayList<Integer>();
    ArrayList<Integer> checkedRow=new ArrayList<Integer>();
    ArrayList<Integer> checkedColumn= new ArrayList<Integer>();
    ArrayList<Integer> rowPath= new ArrayList<Integer>();
    ArrayList<Integer> columnPath= new ArrayList<Integer>();



    private ArrayList<Integer> FinalRow= new ArrayList<Integer>();
    private ArrayList<Integer> FinalColumn= new ArrayList<Integer>();


    public boolean alreadyStored(int r, int c){
        for(int i=0; i<checkedRow.size();i++){
            if(checkedRow.get(i)==r&checkedColumn.get(i)==c)
                return true;
        }
        return false;
    }

    public ArrayList<Integer> getFinalRow() {
        return FinalRow;
    }

    public ArrayList<Integer> getFinalColumn() {
        return FinalColumn;
    }

    public void solve(LocationInteface maze) {
        maze.solveClicked();



        row.add(maze.getCurrentRow());
        column.add(maze.getCurrentColumn());

        checkedRow.add(maze.getCurrentRow());
        checkedColumn.add(maze.getCurrentColumn());



        int goalCount=0;


        while(!(maze.isGoal(maze.getCurrentRow(),maze.getCurrentColumn()))){
            int hasTransitions=0;

            maze.applicableTransitions(maze.getCurrentRow(), maze.getCurrentColumn());

            int size=maze.getRows().size();

            for(int i=row.size()-1; i<size;i++) {
                if (!alreadyStored(maze.getRows().get(i), maze.getColumns().get(i))) {

                    row.add(maze.getRows().get(i));
                    column.add(maze.getColumns().get(i));
                    checkedRow.add(maze.getRows().get(i));
                    checkedColumn.add(maze.getColumns().get(i));
                    hasTransitions++;

                }
            }

            if (hasTransitions!=0) {
                rowPath.add(maze.getCurrentRow());
                columnPath.add(maze.getCurrentColumn());
            }
            row.remove(0);
            column.remove(0);
            maze.setCurrentRow(row.get(0));
            maze.setCurrentColumn(column.get(0));


            goalCount++;



        }






        FinalRow.add(maze.getCurrentRow());
        FinalColumn.add(maze.getCurrentColumn());

                while(!(maze.isStart(maze.getCurrentRow(),maze.getCurrentColumn()))) {

                    for (int i = rowPath.size() - 1; i >= 0; i--) {
                        int beforeSize = maze.getRows().size();


                        maze.applicableTransitions(rowPath.get(i), columnPath.get(i));
                        int afterSize = maze.getRows().size();

                        int sizeFinalRow = FinalRow.size() - 1;
                        int sizeFinalColumn = FinalColumn.size() - 1;
                        for (int j = beforeSize; j < afterSize; j++) {
                            if (maze.getRows().get(j) == FinalRow.get(sizeFinalRow) & maze.getColumns().get(j) == FinalColumn.get(sizeFinalColumn)) {

                            //    System.out.println("row "+rowPath.get(i)+" column "+columnPath.get(i));

                                maze.setCurrentRow(rowPath.get(i));
                                maze.setCurrentColumn(columnPath.get(i));

                                FinalRow.add(maze.getCurrentRow());
                                FinalColumn.add(maze.getCurrentColumn());
                            }

                        }

                    }
                }



    }
}
