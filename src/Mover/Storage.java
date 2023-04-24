package Mover;

import Storage.Container;
/*
@Author Tijmen Speekenbrink (1029331)
 */

 public class Storage {
    public Container[] containerArray;
    public int containerCounter;

    public Storage(int containerCounter) {
        containerArray = new Container[containerCounter];
        this.containerCounter = 0;
    }


   synchronized public boolean add(Container container){

        if (containerArray[containerCounter] == null){
            containerArray[containerCounter] = container;
            containerCounter++;
            notifyAll(); // notifies all thread when container is added
            return true;

        }
        return false;
    }

   synchronized public Container remove(){
        if (containerCounter == 0){
            return null;
        }
        Container returnContainer = containerArray[containerCounter - 1];
        containerArray[containerCounter - 1] = null;
        containerCounter--;
        notifyAll(); // notifies all thread when container is removed
        return returnContainer;

    }
}
