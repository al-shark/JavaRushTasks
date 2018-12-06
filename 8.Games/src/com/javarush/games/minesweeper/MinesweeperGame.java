package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;
import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE=9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField = 0;
    private static final String MINE="\uD83D\uDCA3";
    private static final String FLAG="\uD83D\uDEA9";
    private int countFlags = 0;
    private boolean isGameStopped;
    private int countClosedTiles = SIDE*SIDE;
    private int score;

    @Override
    public void initialize() {
        super.initialize();
        setScreenSize(SIDE,SIDE);
        createGame();
    }

    private void createGame() {
        boolean isMined = false;
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (getRandomNumber(10) == 5) {isMined = true; countMinesOnField++;}
                else isMined = false;
                gameField[j][i] = new GameObject(i,j,isMined);
                setCellColor(i,j,Color.ORANGE);
                setCellValue(i,j,"");
            }
        }
        countFlags = countMinesOnField;
        countMineNeighbors();
    }

    private  void restart() {
        isGameStopped = false;
        countMinesOnField = 0;
        score = 0;
        countClosedTiles=SIDE*SIDE;
        setScore(score);
        createGame();
        countFlags = countMinesOnField;
    }

    private List<GameObject> getNeighbors(GameObject go) {
        List<GameObject> tempList = new ArrayList<>();
        for (int i = go.x-1; i < go.x+2; i++) {
            for (int j = go.y-1; j < go.y+2; j++) {
                if ((i==go.x) && (j == go.y)) continue;
                if ((i<0) || (j<0)) continue;
                if ((i>SIDE-1) || (j>SIDE-1)) continue;
                tempList.add(gameField[j][i]);
            }
        }
        return tempList;
    }

    private void countMineNeighbors() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE; j++) {
                if (!gameField[j][i].isMine) {
                    List<GameObject> neighbors = getNeighbors(gameField[j][i]);
                    for (GameObject neighbor: neighbors) {
                        if (neighbor.isMine) gameField[j][i].countMineNeighbors++;
                    }
                }
            }
        }
    }

    private void openTile(int x, int y) {
        if (!isGameStopped && !gameField[y][x].isFlag) {
        if (!gameField[y][x].isOpen) {
            gameField[y][x].isOpen = true;
            setCellColor(x,y,Color.GREEN);
            countClosedTiles--;
            if (gameField[y][x].isMine) {
                setCellValueEx(x,y,Color.RED,MINE);
                gameOver();
            }
            else {
                if (gameField[y][x].countMineNeighbors>0) setCellNumber(x,y,gameField[y][x].countMineNeighbors);
                else {
                    setCellValue(x,y,"");
                    for (GameObject neighbor: getNeighbors(gameField[y][x])) {
                        openTile(neighbor.x,neighbor.y);
                    }
                }
                score+=5;
                setScore(score);
                if (countMinesOnField == countClosedTiles) win();
            }
        }
        }
    }

    private void markTile(int x, int y) {
        if (!isGameStopped) {
        if (!gameField[y][x].isOpen) {
            if (!(!gameField[y][x].isFlag && countFlags==0)) {
                if (gameField[y][x].isFlag) {
                    gameField[y][x].isFlag = false;
                    countFlags++;
                    setCellColor(x,y,Color.ORANGE);
                    setCellValue(x,y,"");
                }
                else {
                gameField[y][x].isFlag = true;
                countFlags--;
                setCellValue(x,y,FLAG);
                setCellColor(x,y,Color.YELLOW);
                }
            }
        }
        }
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.BLACK,"You win!",Color.GREEN,12);
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.BLACK,"Game Over!",Color.RED,12);
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        super.onMouseRightClick(x, y);
        markTile(x,y);
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        super.onMouseLeftClick(x, y);
        if (isGameStopped) restart();
        else openTile(x,y);
    }
}
