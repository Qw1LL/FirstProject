package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game extends GameBoard {
    private static final char X = 'X';
    private static final char O = 'O';
    boolean stop = false;
    boolean criticalStop = false;
    Player player = new Player();


    public static char getX() {
        return X;
    }

    public static char getO() {
        return O;
    }

    public void startGame() throws IOException {
        showArray(arr);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = 2;


        while (!stop) {


            if (i % 2 == 0) {
                System.out.println("Введите номер ячейки, чтобы поставить крестик!");
            } else {
                System.out.println("Введите номер ячейки, чтобы поставить нолик!");
            }
            try {

                int num = Integer.parseInt(reader.readLine());

                switch (num) {
                    case 1:
                        if (arr[0][0].equals("[ ]")) {
                            if (i % 2 == 0) {
                                arr[0][0] = ("[" + getX() + "]");
                            } else {
                                arr[0][0] = ("[" + getO() + "]");
                            }
                            showArray(arr);
                            i++;
                        } else {
                            System.out.println("Эта клетка занята, введите другую.");
                        }
                        break;
                    case 2:
                        if (arr[0][1].equals("[ ]")) {
                            if (i % 2 == 0) {
                                arr[0][1] = ("[" + getX() + "]");
                            } else {
                                arr[0][1] = ("[" + getO() + "]");
                            }
                            showArray(arr);
                            i++;
                        } else {
                            System.out.println("Эта клетка занята, введите другую.");
                        }
                        break;
                    case 3:
                        if (arr[0][2].equals("[ ]")) {
                            if (i % 2 == 0) {
                                arr[0][2] = ("[" + getX() + "]");
                            } else {
                                arr[0][2] = ("[" + getO() + "]");
                            }
                            showArray(arr);
                            i++;
                        } else {
                            System.out.println("Эта клетка занята, введите другую.");
                        }
                        break;
                    case 4:
                        if (arr[1][0].equals("[ ]")) {
                            if (i % 2 == 0) {
                                arr[1][0] = ("[" + getX() + "]");
                            } else {
                                arr[1][0] = ("[" + getO() + "]");
                            }
                            showArray(arr);
                            i++;
                        } else {
                            System.out.println("Эта клетка занята, введите другую.");
                        }
                        break;
                    case 5:
                        if (arr[1][1].equals("[ ]")) {
                            if (i % 2 == 0) {
                                arr[1][1] = ("[" + getX() + "]");
                            } else {
                                arr[1][1] = ("[" + getO() + "]");
                            }
                            showArray(arr);
                            i++;
                        } else {
                            System.out.println("Эта клетка занята, введите другую.");
                        }
                        break;
                    case 6:
                        if (arr[1][2].equals("[ ]")) {
                            if (i % 2 == 0) {
                                arr[1][2] = ("[" + getX() + "]");
                            } else {
                                arr[1][2] = ("[" + getO() + "]");
                            }
                            showArray(arr);
                            i++;
                        } else {
                            System.out.println("Эта клетка занята, введите другую.");
                        }
                        break;
                    case 7:
                        if (arr[2][0].equals("[ ]")) {
                            if (i % 2 == 0) {
                                arr[2][0] = ("[" + getX() + "]");
                            } else {
                                arr[2][0] = ("[" + getO() + "]");
                            }
                            showArray(arr);
                            i++;
                        } else {
                            System.out.println("Эта клетка занята, введите другую.");
                        }
                        break;
                    case 8:
                        if (arr[2][1].equals("[ ]")) {
                            if (i % 2 == 0) {
                                arr[2][1] = ("[" + getX() + "]");
                            } else {
                                arr[2][1] = ("[" + getO() + "]");
                            }
                            showArray(arr);
                            i++;
                        } else {
                            System.out.println("Эта клетка занята, введите другую.");
                        }
                        break;
                    case 9:
                        if (arr[2][2].equals("[ ]")) {
                            if (i % 2 == 0) {
                                arr[2][2] = ("[" + getX() + "]");
                            } else {
                                arr[2][2] = ("[" + getO() + "]");
                            }
                            showArray(arr);
                            i++;
                        } else {
                            System.out.println("Эта клетка занята, введите другую.");
                        }
                        break;
                    case 0:
                        criticalStop = true;
                        stop = true;
                        reader.close();
                        break;
                }

                for (int t = 0; t < 3; t++) {
                    // Проверка прямых
                    if ((arr[t][0].equals("[" + getO() + "]") & arr[t][1].equals("[" + getO() + "]") & arr[t][2].equals("[" + getO() + "]") ||
                            (arr[0][t].equals("[" + getO() + "]") & arr[1][t].equals("[" + getO() + "]") & arr[2][t].equals("[" + getO() + "]")))) {
                        stop = true;

                    } else if ((arr[t][0].equals("[" + getX() + "]") & arr[t][1].equals("[" + getX() + "]") & arr[t][2].equals("[" + getX() + "]")) ||
                            (arr[0][t].equals("[" + getX() + "]") & arr[1][t].equals("[" + getX() + "]") & arr[2][t].equals("[" + getX() + "]"))) {

                        stop = true;
                        for (int z = 0; z < arr.length; z++) {
                            for (int j = 0; j < arr[z].length; j++) {
                                arr[z][j] = ("[ ]");
                            }
                        }
                    }
                }

                if (arr[0][0].equals("[" + getX() + "]") && arr[1][1].equals("[" + getX() + "]") && arr[2][2].equals("[" + getX() + "]") ||
                        arr[0][2].equals("[" + getX() + "]") && arr[1][1].equals("[" + getX() + "]") && arr[2][0].equals("[" + getX() + "]")) {
                    stop = true;

                } else if ((arr[0][0].equals("[" + getO() + "]") && arr[1][1].equals("[" + getO() + "]") && arr[2][2].equals("[" + getO() + "]") ||
                        arr[0][2].equals("[" + getO() + "]") && arr[1][1].equals("[" + getO() + "]") && arr[2][0].equals("[" + getO() + "]"))) {
                    stop = true;
                    for (int z = 0; z < arr.length; z++) {
                        for (int j = 0; j < arr[z].length; j++) {
                            arr[z][j] = ("[ ]");
                        }
                    }
                }
                // Реализация ничьих
                if (!arr[0][0].equals("[ ]") && !arr[0][1].equals("[ ]") && !arr[0][2].equals("[ ]")
                        && !arr[1][0].equals("[ ]") && !arr[1][1].equals("[ ]") && !arr[1][2].equals("[ ]")
                        && !arr[2][0].equals("[ ]") && !arr[2][1].equals("[ ]") && !arr[2][2].equals("[ ]")) {
                    System.out.println("Ничья");
                    stop = true;
                    for (int z = 0; z < arr.length; z++) {
                        for (int j = 0; j < arr[z].length; j++) {
                            arr[z][j] = ("[ ]");
                        }
                    }
                    System.out.println("Хотите сыграть еще раз? \n y - да; n - нет");
                    String isExit = reader.readLine();
                    if (isExit.equals("y") || isExit.equals("н")) {
                        stop = false;
                        startGame();
                    } else if (isExit.equals("n") || isExit.equals("т")) {
                        criticalStop = true;
                        reader.close();
                    } else System.out.println("чтобы выйти из игры нажмите 'n' ");

                }

            } catch (NumberFormatException e) {
                System.out.println("Введите именно число!");
            }
        }
        while (!criticalStop) {
            System.out.println("Введите Ваше имя ");
            player.setName(reader.readLine());
            System.out.println(player.getName() + " одержал победу");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Хотите сыграть еще раз? \n y - да; n - нет");
            String isExit = reader.readLine();
            if (isExit.equals("y") || isExit.equals("н")) {
                stop = false;
                startGame();
            } else if (isExit.equals("n") || isExit.equals("т")) {
                criticalStop = true;
                reader.close();
            } else {
                while (true) {
                    System.out.println("чтобы выйти из игры нажмите 'n' ");
                    String isExit1 = reader.readLine();
                    if ((isExit1.equals("n") || isExit1.equals("т"))) {
                        criticalStop = true;
                        break;
                    }

                }
            }

        }
    }
}