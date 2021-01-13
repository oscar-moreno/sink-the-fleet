package com.oscarmoreno.sinkthefleet;

import java.util.Random;
import java.util.Scanner;

public class Shoot {
    String coordinates;
    Random r = new Random();
    Scanner sc = new Scanner(System.in);
    String[] targetCoordinates = new String[2];
    String shootXCoordinates;
    String shootYCoordinates;

    public void requestShoot() throws InterruptedException {
        System.out.println("\nLoading ammo...");
        System.out.print("Insert coordinate to shoot in appropriate format (i.e. B-7 or F-2): ");
        coordinates = sc.nextLine();
        targetCoordinates = coordinates.split("-");
        shootXCoordinates = targetCoordinates[0];
        shootYCoordinates = targetCoordinates[1];
        System.out.println("\nAiming...\n");
        Thread.sleep(2000);
    }

    public String randomShoot() throws InterruptedException {
        char xCoordinate = (char)(r.nextInt(10) + 'A');
        int yCoordinate = r.nextInt(10);
        coordinates = xCoordinate + "-" + yCoordinate;

        System.out.println("\nWarning! the enemy will shoot");
        Thread.sleep(2000);
        System.out.println("\nAiming...\n");
        Thread.sleep(2000);
        System.out.println("The enemy have shoot to " + coordinates+ "\n");

        return coordinates;
    }

    public String getCoordinates() {
        return coordinates;
    }


}
