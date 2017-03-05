package com.javarush.task.task23.task2312;

/**
 * Created by sharka on 05.03.2017.
 */
public class Room {
    private int width, height;
    private Snake snake;
    private Mouse mouse;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public int getWidth() {

        return width;
    }

    public int getHeight() {
        return height;
    }

    public Snake getSnake() {
        return snake;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void createMouse() {
        mouse = new Mouse((int) (Math.random()*width),(int) (Math.random()*height));
    }

    public void eatMouse() {
        createMouse();
    }

    public Room(int width, int height, Snake snake) {

        this.width = width;
        this.height = height;
        this.snake = snake;
    }

    public static Room game;

    public void run() {

    }

    public void print() {

    }

    public static void main(String[] args) {
        Snake snake = new Snake(0,0);
        game = new Room(400,400,snake);
        snake.setDirection(SnakeDirection.DOWN);

    }
}
