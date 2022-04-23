import java.util.ArrayList;

public interface LocationInteface {
    void setRow(int x);
    int getRow();
    void setColumn(int x);
    int getColumn();
    void applicableTransitions(int x, int y);
    boolean isGoal(int x, int y);
    void beenHere();
    ArrayList<Integer>getRows();
    ArrayList<Integer>getColumns();
    int getCurrentRow();
    int getCurrentColumn();

    void setCurrentRow(int i);
    void setCurrentColumn(int i);
    void solveClicked();
    void applySolution(int x, int y);
    void startOver();

//
    boolean isStart(int x, int y);


    //void setInfo(int i);
    //void setRowC(int x);
    //void setColumnC(int x);
    //int getInfo();
    //void test(int x, int y);
}
