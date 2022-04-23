import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SolverListener implements ActionListener {
    private ArrayList<Integer> rowOrder=new ArrayList<Integer>();
    private ArrayList<Integer> columnOrder=new ArrayList<Integer>();


    LocationInteface maze;
    public SolverListener(LocationInteface m){
        maze=m;
    }
    public void actionPerformed(ActionEvent e){

        MazeSolver solver=new MazeSolver();
        solver.solve(maze);

        maze.solveClicked();


        rowOrder=solver.getFinalRow();
        columnOrder=solver.getFinalColumn();
        for(int i=rowOrder.size()-1;i>=0;i--){
            maze.applySolution(rowOrder.get(i),columnOrder.get(i));

        }
        maze.startOver();


    }
}
