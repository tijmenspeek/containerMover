package Mover;

import Storage.Container;
import Storage.Dock;
import java.util.Random;
/*
@Author Tijmen Speekenbrink (1029331)
 */

public class Crane extends ContainerMover{
    public Ship ship;
    public Dock dock;


    public Crane(int containerCounter, Ship ship, Dock dock) {
        super(containerCounter);
        this.ship = ship;
        this.dock = dock;

    }

    @Override
    public void move() {
        try {
            Random rand = new Random();
            Thread.sleep(rand.nextInt(5000)+1000); // tussen 1 en 6 seconde
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void run(){
        System.out.println( "started");
        while (ship.containerCounter > 0){
            Container toMove = ship.remove();

            while (!(dock.containerCounter < 5)){
                synchronized (dock) {
                    try {
                        dock.wait(); //wait for notify if dock is full
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            String containerName = toMove.toString().replace("Storage.", "");

            System.out.println("ship gave: " + containerName + " to: "+ currentThread().getName());
            toMove.detatchContainer(currentThread().getName());
            move();
            System.out.println(this.getName() + ": is done moving: " +containerName + " from ship to dock \n");

            dock.add(toMove);
        }
        System.out.println(currentThread().getName()+ ": ship is empty");
    }
}
