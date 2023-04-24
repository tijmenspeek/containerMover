package Mover;

import Storage.Container;
import Storage.NormalContainer;
import Storage.HeatedContainer;
import Storage.CooledContainer;
import java.util.Random;
/*
@Author Tijmen Speekenbrink (1029331)
 */

public class Ship extends Storage {
    public Ship(int containerCounter) {
        super(containerCounter);
        for(int i = 0; i < containerArray.length; i++){
            containerArray[i]= randomContainer(); // new Container;

            this.containerCounter++;

        }
    }
    public Container randomContainer(){
        Container[] OptionIndex = new Container[]{new HeatedContainer(),new CooledContainer(), new NormalContainer()};
        Random rand = new Random();
        int index = rand.nextInt(3);
        return OptionIndex[index];
    }

}
