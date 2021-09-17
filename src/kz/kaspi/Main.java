package kz.kaspi;

import kz.kaspi.controller.Controller;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Controller controller = new Controller();
        controller.run();
    }
}
