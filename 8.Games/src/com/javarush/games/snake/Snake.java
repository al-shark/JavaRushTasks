package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<GameObject> snakeParts = new ArrayList();
    private static final String HEAD_SIGN = "\uD83D\uDC7E";
    private static final String BODY_SIGN = "\u26AB";
    public boolean isAlive = true;
    private Direction direction = Direction.LEFT;

    public Snake(int x, int y) {
        snakeParts.add(new GameObject(x,y));
        snakeParts.add(new GameObject(x+1,y));
        snakeParts.add(new GameObject(x+2,y));
    }

    public void draw(Game gm) {
        Color snakeColor = isAlive ? Color.BLACK : Color.RED;
        for (int i = 0; i < snakeParts.size(); i++) {
            if (i==0) gm.setCellValueEx(snakeParts.get(i).x,snakeParts.get(i).y,Color.NONE,HEAD_SIGN,snakeColor,75);
            else gm.setCellValueEx(snakeParts.get(i).x,snakeParts.get(i).y,Color.NONE,BODY_SIGN,snakeColor,75);
        }
    }

    public void setDirection(Direction direction) {
        switch (this.direction) {
            case UP:
                if (!(snakeParts.get(0).y == snakeParts.get(1).y)) this.direction = direction;
                break;
            case DOWN:
                if (!(snakeParts.get(0).y == snakeParts.get(1).y)) this.direction = direction;
                break;
            case LEFT:
                if (!(snakeParts.get(0).x == snakeParts.get(1).x)) this.direction = direction;
                break;
            case RIGHT:
                if (!(snakeParts.get(0).x == snakeParts.get(1).x)) this.direction = direction;
        }
    }

    public void move(Apple apple) {
        GameObject snakeHead = createNewHead();
        if ((snakeHead.x<0) || (snakeHead.y<0) || (snakeHead.x>14) || (snakeHead.y>14) || checkCollision(snakeHead)) {
            isAlive = false;
        }
        else {
            snakeParts.add(0,snakeHead);
            if ((apple.x == snakeHead.x) && (apple.y == snakeHead.y)) apple.isAlive = false;
            else removeTail();
        }
    }

    public GameObject createNewHead() {
        switch (direction) {
            case UP:
                return new GameObject(snakeParts.get(0).x,snakeParts.get(0).y-1);
            case DOWN:
                return new GameObject(snakeParts.get(0).x,snakeParts.get(0).y+1);
            case LEFT:
                return new GameObject(snakeParts.get(0).x-1,snakeParts.get(0).y);
            case RIGHT:
                return new GameObject(snakeParts.get(0).x+1,snakeParts.get(0).y);
        }

        return new GameObject(snakeParts.get(0).x,snakeParts.get(0).y);
    }

    public void removeTail() {
        snakeParts.remove(snakeParts.size()-1);
    }

    public boolean checkCollision(GameObject gm) {
        for (GameObject x : snakeParts) {
            if ((gm.x == x.x) && (gm.y == x.y)) return true;
        }
        return  false;
    }

    public int getLength() {
        return snakeParts.size();
    }
}
