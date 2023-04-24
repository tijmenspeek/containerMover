package Mover;

import Storage.Container;
import Storage.Dock;
import java.util.Random;
/*
@Author Tijmen Speekenbrink (1029331)
 */

public class Truck extends ContainerMover{
    public Dock dock;
    public Ship ship;
    static public int removedContainers;
    public Truck(int containerCounter, Ship ship, Dock dock) {
        super(containerCounter);
        this.dock = dock;
        this.ship = ship;

    }

    @Override
    public void move() {
        try {
            Random rand = new Random();
            Thread.sleep(rand.nextInt(2000)+1000); // tussen 1 en 3 seconde
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void run(){
        while (ship.containerCounter > 0 || dock.containerCounter > 0){
            Container toMove = dock.remove(); //trying to get container from dock
            while (toMove == null){
                synchronized(dock) {
                    try {
                        System.out.println(currentThread().getName() + ": wants to get container");
                        dock.wait(); // truck needs to wait because there are no container to move at dock
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                toMove = dock.remove(); //trying again to get container from dock
            }
                System.out.println(currentThread().getName()+ ": got: "+ toMove.toString().replace("Storage.","") + " from the dock");
                toMove.attachContainer(currentThread().getName());
                move();
                System.out.println(this.getName() + ": is done moving  " + toMove.toString().replace("Storage.","") + " from dock to truck \n");
                removedContainers++;
                //System.out.println(removedContainers); //for debugging purposes
        }
    }

}
