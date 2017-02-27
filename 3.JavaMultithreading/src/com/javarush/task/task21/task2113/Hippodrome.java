package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharka on 27.02.2017.
 */
public class Hippodrome {
    private List<Horse> horses;
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void move() {
        for (Horse x : horses) {
            x.move();
        }
    }

    public void print() {
        for (Horse x : horses) {
            x.print();
        }
        for (int i=0; i<10; i++) System.out.println();
    }

    public void run() throws InterruptedException {
        for (int i=1; i<101; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public static void main(String[] args) {
        List<Horse> h = new ArrayList<>();
        h.add(new Horse("Horse1",3,0));
        h.add(new Horse("Horse2",3,0));
        h.add(new Horse("Horse3",3,0));
        game = new Hippodrome(h);

    }
}
