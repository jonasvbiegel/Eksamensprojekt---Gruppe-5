package view;
import controller.SaleController;

import java.util.Scanner;

public class SaleUI {
    public SaleUI(){
        MainMenu();
    }

    Scanner sn;

    public void MainMenu(){
        boolean running = true;
        sn = new Scanner(System.in);
        System.out.println("Welcome to the Vestbjerg A/S Sales System");
        while(running){
            System.out.println("-----------------------------------------");
            System.out.println("1. Create Sale");
            System.out.println("2. Generate test data");
            System.out.println();
            System.out.println("3. Exit");

            switch(sn.nextInt()){
                case 1: System.out.println("1");
                break;
                case 2: System.out.println("2");
                break;
                case 3: running = false;
            }
        }
    }
}
