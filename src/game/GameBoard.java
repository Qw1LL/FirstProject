package game;

public class GameBoard {
    int[][] arr;

    public GameBoard(){
        arr = new int[3][3];
        showArray(arr);

    }
    public void showArray(int[][] a) {
       for (int i = 0; i < a.length; i++){
           for (int j = 0; j < a[i].length; j++){
               System.out.print("[ ]");
           }
           System.out.println();
       }
    }
}

