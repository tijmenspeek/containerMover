package Mover;
/*
@Author Tijmen Speekenbrink (1029331)
 */

public abstract class ContainerMover extends Thread{
    Storage storage;


    public ContainerMover(int containerCounter) {
        storage = new Storage(containerCounter);


    }

    abstract public void move();
}
