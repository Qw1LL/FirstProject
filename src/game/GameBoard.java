package game;

public class GameBoard {

    String[][] arr;

    public GameBoard(){
        arr = new String[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = ("[ ]");
            }
        }
//        showArray(arr);

    }
    public void showArray(String[][] a) {
       for (int i = 0; i < a.length; i++){
           for (int j = 0; j < a[i].length; j++){
               System.out.print(a[i][j]);
           }
           System.out.println();
       }
    }
}

