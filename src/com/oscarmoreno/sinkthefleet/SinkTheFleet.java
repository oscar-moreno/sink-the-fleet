package com.oscarmoreno.sinkthefleet;

public class SinkTheFleet {
    public static void main(String[] args) throws InterruptedException {
        Board userBoard = new Board();
        Board computerBoard = new Board();
        Shoot userShoot = new Shoot();
        Shoot computerShoot = new Shoot();
        boolean gameFinished = false;

        userBoard.initializeBoard();
        computerBoard.initializeBoard();

        while (!gameFinished) {
            System.out.println("\n** Your board **\n");
            userBoard.drawBoard();
            System.out.println("** Enemy Board **\n");
            computerBoard.drawUnknownBoard();
            System.out.println("\nSCORE:");
            System.out.println("Your score: " + userBoard.getScoreBoard());
            System.out.println("The computer score: " + computerBoard.getScoreBoard());

            userShoot.requestShoot();
            computerBoard.checkShoot(userShoot.getCoordinates());
            Thread.sleep(2000);
            userBoard.checkShoot(computerShoot.randomShoot());

            System.out.println("\nPreparing next round...");
            Thread.sleep(5000);

            if (computerBoard.getScoreBoard()==0) {
                gameFinished = true;
                System.out.println("Congratulations!! You defeat the enemy! :)");
            } else if (userBoard.getScoreBoard()==0) {
                gameFinished = true;
                System.out.println("Sorry, the enemy defeat you :(");
                System.out.println("Good luck next time!");
            }
        }
    }
}
