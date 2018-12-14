package com.javarush.games.moonlander;

import com.javarush.engine.cell.*;

public class MoonLanderGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private Rocket rocket;
    private GameObject landscape;
    private GameObject platform;
    private boolean isUpPressed;
    private boolean isLeftPressed;
    private boolean isRightPressed;
    private boolean isGameStopped;

    private void check() {
        if (rocket.isStopped()) {
            if (rocket.isCollision(platform)) win();
            if (rocket.isCollision(landscape)) gameOver();
        }
        else if (rocket.isCollision(landscape)) gameOver();
    }

    private void win() {
        rocket.land();
        isGameStopped = true;
        showMessageDialog(Color.NONE,"Win",Color.GREEN,75);
        stopTurnTimer();
    }

    private void gameOver() {
        rocket.crash();
        isGameStopped = true;
        showMessageDialog(Color.NONE,"Loose",Color.RED,75);
        stopTurnTimer();
    }

    @Override
    public void onKeyPress(Key key) {
        switch (key) {
            case UP:
                isUpPressed = true;
                break;
            case LEFT:
                isLeftPressed = true;
                isRightPressed = false;
                break;
            case RIGHT:
                isRightPressed = true;
                isLeftPressed = false;
                break;
            case SPACE:
                if (isGameStopped) createGame();
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        switch (key) {
            case UP:
                isUpPressed = false;
                break;
            case LEFT:
                isLeftPressed = false;
                break;
            case RIGHT:
                isRightPressed = false;
        }
    }

    private void createGame() {
        isLeftPressed = false;
        isRightPressed = false;
        isUpPressed = false;
        isGameStopped = false;
        createGameObjects();
        drawScene();
        setTurnTimer(50);
    }

    private void createGameObjects() {
        rocket = new Rocket(WIDTH/2,0);
        landscape = new GameObject(0,25,ShapeMatrix.LANDSCAPE);
        platform = new GameObject(23, HEIGHT - 1, ShapeMatrix.PLATFORM);
    }

    @Override
    public void onTurn(int step) {
        rocket.move(isUpPressed,isLeftPressed,isRightPressed);
        check();
        drawScene();
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if (!((x<0) || (x>WIDTH-1) || (y<0) || (y>HEIGHT-1))) super.setCellColor(x, y, color);
    }

    private void drawScene() {
        for (int i = 0; i < WIDTH ; i++) {
            for (int j = 0; j < HEIGHT ; j++) {
                setCellColor(i,j,Color.BLACK);
            }
        }
        rocket.draw(this);
        landscape.draw(this);
    }

    @Override
    public void initialize() {
        setScreenSize(WIDTH,HEIGHT);
        showGrid(false);
        createGame();
    }
}
