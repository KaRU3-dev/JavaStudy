package com.github.karu3;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Calculator exe = new Calculator();
        int result = exe.add(1, 3);
        System.out.println(result);

        Square square = new Square();
        square.render();

        ThreadSpawnerOrganizer tso = new ThreadSpawnerOrganizer();
        tso.spawners.clear();
    }
}
