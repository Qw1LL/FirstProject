package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game extends GameBoard {
    private static final char X = 'X';
    private static final char O = 'O';
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private int i = 2;
    private boolean stop = false;
    private boolean criticalStop = false;
    private Player player = new Player();

    public static char getX() {
        return X;
    }

    public static char getO() {
        return O;
    }

    public boolean isStop() {
        return stop;
    }

    public boolean isCriticalStop() {
        return criticalStop;
    }


    public void startGame() throws IOException {
        showArray(arr);

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
                        forCase(0, 0);
                        break;
                    case 2:
                        forCase(0, 1);
                        break;
                    case 3:
                        forCase(0, 2);
                        break;
                    case 4:
                        forCase(1, 0);
                        break;
                    case 5:
                        forCase(1, 1);
                        break;
                    case 6:
                        forCase(1, 2);
                        break;
                    case 7:
                        forCase(2, 0);
                        break;
                    case 8:
                        forCase(2, 1);
                        break;
                    case 9:
                        forCase(2, 2);
                        break;
                    case 0:
                        criticalStop = true;
                        stop = true;
                        reader.close();
                        break;
                }

                directCheck();
                diagonalCheck();

                // Реализация ничьих
                if (!arr[0][0].equals("[ ]") && !arr[0][1].equals("[ ]") && !arr[0][2].equals("[ ]")
                        && !arr[1][0].equals("[ ]") && !arr[1][1].equals("[ ]") && !arr[1][2].equals("[ ]")
                        && !arr[2][0].equals("[ ]") && !arr[2][1].equals("[ ]") && !arr[2][2].equals("[ ]")) {
                    System.out.println("Ничья");
                    stop = true;
                    endGame(); // окончание, либо начало новой игры
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
            endGame();// окончание, либо начало новой игры
        }
    }

    public void diagonalCheck() {
        if (arr[0][0].equals("[" + getX() + "]") && arr[1][1].equals("[" + getX() + "]") && arr[2][2].equals("[" + getX() + "]") ||
                arr[0][2].equals("[" + getX() + "]") && arr[1][1].equals("[" + getX() + "]") && arr[2][0].equals("[" + getX() + "]")) {
            stop = true;

        } else if ((arr[0][0].equals("[" + getO() + "]") && arr[1][1].equals("[" + getO() + "]") && arr[2][2].equals("[" + getO() + "]") ||
                arr[0][2].equals("[" + getO() + "]") && arr[1][1].equals("[" + getO() + "]") && arr[2][0].equals("[" + getO() + "]"))) {
            stop = true;
        }
    }

    public void directCheck() {
        for (int t = 0; t < 3; t++) {
            if ((arr[t][0].equals("[" + getO() + "]") & arr[t][1].equals("[" + getO() + "]") & arr[t][2].equals("[" + getO() + "]") ||
                    (arr[0][t].equals("[" + getO() + "]") & arr[1][t].equals("[" + getO() + "]") & arr[2][t].equals("[" + getO() + "]")))) {
                stop = true;

            } else if ((arr[t][0].equals("[" + getX() + "]") & arr[t][1].equals("[" + getX() + "]") & arr[t][2].equals("[" + getX() + "]")) ||
                    (arr[0][t].equals("[" + getX() + "]") & arr[1][t].equals("[" + getX() + "]") & arr[2][t].equals("[" + getX() + "]"))) {
                stop = true;
            }
        }
    }

    public void forCase(int q, int y) {
        if (arr[q][y].equals("[ ]")) {
            if (this.i % 2 == 0) {
                arr[q][y] = ("[" + getX() + "]");
            } else {
                arr[q][y] = ("[" + getO() + "]");
            }
            showArray(arr);
            i++;
        } else {
            System.out.println("Эта клетка занята, введите другую.");
        }
    }

    public void endGame() throws IOException {
        System.out.println("Хотите сыграть еще раз? \n y - да; n - нет");
        String isExit = reader.readLine();
        if (isExit.equals("y") || isExit.equals("н")) {
            stop = false;
            resetOrNewArray(); // Обновил игровое поле
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