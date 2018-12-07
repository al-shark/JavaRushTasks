package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;
    private int score;

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.NONE,"You win!",Color.GREEN,75);
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.NONE,"You loose!",Color.RED,75);
    }

    @Override
    public void initialize() {
        setScreenSize(SIDE,SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        for (int i = 0; i < SIDE; i++)
            for (int j = 0; j < SIDE; j++)
                gameField[i][j]=0;
        createNewNumber();
        createNewNumber();
        score = 0;
        setScore(score);
    }

    private void drawScene() {
        for (int i = 0; i < SIDE; i++)
            for (int j = 0; j < SIDE; j++)
                setCellColoredNumber(i,j,gameField[j][i]);
    }

    private void createNewNumber() {
        int x;
        int y;

        if (getMaxTileValue() == 2048) {
            win();
            return;
        }
        do {
            x = getRandomNumber(SIDE);
            y = getRandomNumber(SIDE);
        } while (!(gameField[y][x] == 0));

        if (getRandomNumber(10) == 9) gameField[y][x] = 4;
        else gameField[y][x] = 2;
    }

    private Color getColorByValue(int value) {
        switch (value) {
            case 2048:
                return Color.GREEN;
            case 1024:
                return Color.CORAL;
            case 512:
                return Color.RED;
            case 256:
                return Color.CORNFLOWERBLUE;
            case 128:
                return Color.ORANGE;
            case 64:
                return Color.OLDLACE;
            case 32:
                return Color.DARKSEAGREEN;
            case 16:
                return Color.YELLOW;
            case 8:
                return Color.ALICEBLUE;
            case 4:
                return Color.AQUAMARINE;
            case 2:
                return Color.BEIGE;
        }
        return Color.GRAY;
    }

    private void setCellColoredNumber(int x, int y, int col) {
        setCellValueEx(x,y,getColorByValue(col),col ==0?"": Integer.toString(col));
    }

    private boolean compressRow(int[] row) {
        int tempI;
        boolean isMoved = false;

        for (int i = 0; i<row.length; i++)
            for (int j = i+1; j<row.length; j++) {
                if ((row[i]==0) && !(row[j]==0)) {
                  tempI = row[i];
                  row[i]=row[j];
                  row[j]=tempI;
                  isMoved = true;
                }
            }
         return isMoved;
    }

    private boolean mergeRow(int[] row) {
        boolean isMerged = false;

        for (int i = 0; i<row.length; i++)
            for (int j = i+1; j<row.length; j++) {
                if ((row[i]==row[j]) && !(row[i]==0)) {
                    row[i]=row[i]+row[i];
                    score+=row[i];
                    setScore(score);
                    row[j]=0;
                    i++;
                    isMerged = true;
                } else break;
            }
        return isMerged;
    }

    private void moveLeft() {
        boolean isShifted = false;
        boolean isChanged = false;
        boolean isGlobalChange = false;

        for (int i=0; i<SIDE; i++) {
            isShifted=compressRow(gameField[i]);
            isChanged=mergeRow(gameField[i]);
            if (isChanged) compressRow(gameField[i]);
            if (isChanged || isShifted) isGlobalChange = true;
        }

        if (isGlobalChange) createNewNumber();
    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }
    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }
    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    @Override
    public void onKeyPress(Key key) {
        if ((key==Key.SPACE) && isGameStopped) {
            isGameStopped = false;
            createGame();
            drawScene();
        }
        if (!isGameStopped) {
        if (canUserMove()) {
        switch (key) {
            case LEFT:
                moveLeft();
                drawScene();
                break;
            case RIGHT:
                moveRight();
                drawScene();
                break;
            case UP:
                moveUp();
                drawScene();
                break;
            case DOWN:
                moveDown();
                drawScene();
        }
        }
        else gameOver();}
    }
    
    private void rotateClockwise() {
        int tmp;
        for(int i=0;i<SIDE/2;i++) {
            for(int j=i;j<SIDE-1-i;j++) {
                tmp = gameField[i][j];
                gameField[i][j] = gameField[SIDE-j-1][i];
                gameField[SIDE-j-1][i] = gameField[SIDE-i-1][SIDE-j-1];
                gameField[SIDE-i-1][SIDE-j-1] = gameField[j][SIDE-i-1];
                gameField[j][SIDE-i-1] = tmp;
            }
        }
    }

    private int getMaxTileValue() {
        int max = 0;

        for (int i = 0; i<SIDE; i++)
            for (int j = 0; j<SIDE; j++)
                if (gameField[i][j]>max) max = gameField[i][j];
        return max;
    }

    private int getEmptyTilesCount() {
        int count = 0;

        for (int i = 0; i<SIDE; i++)
            for (int j = 0; j<SIDE; j++)
                if (gameField[i][j] == 0) count++;
        return count;
    }

    private boolean canMerge() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE ; j++) {
                if (!(i-1<0) && (gameField[i][j] == gameField[i-1][j])) return true;
                if (!(i+1>=SIDE) && (gameField[i][j] == gameField[i+1][j])) return true;
                if (!(j-1<0) && (gameField[i][j] == gameField[i][j-1])) return true;
                if (!(j+1>=SIDE) && (gameField[i][j] == gameField[i][j+1])) return true;
            }
        }
        return false;
    }

    private boolean canUserMove() {
        if ((getEmptyTilesCount() == 0) && !canMerge()) return false;
        return true;
    }
}
