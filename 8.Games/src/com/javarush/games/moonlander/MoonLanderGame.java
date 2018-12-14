package com.javarush.games.moonlander;

import com.javarush.engine.cell.*;

public class MoonLanderGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private Rocket rocket;
    private GameObject landscape;

    private void createGame() {
        createGameObjects();
        drawScene();
    }

    private void createGameObjects() {
        rocket = new Rocket(WIDTH/2,0);
        landscape = new GameObject(0,25,ShapeMatrix.LANDSCAPE);
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
