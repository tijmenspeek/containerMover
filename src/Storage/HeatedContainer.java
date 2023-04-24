package Storage;

import java.util.Random;
/*
@Author Tijmen Speekenbrink (1029331)
 */

public class HeatedContainer implements Container {

    @Override
    public void attachContainer(String name) {
        try {
            String containerName = this.toString().replace("Storage.","");
            System.out.println(name + ": attaching : " + containerName);
            Random rand = new Random();
            int time = rand.nextInt(1000);
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void detatchContainer(String name) {
        try {
            String containerName = this.toString().replace("Storage.","");
            System.out.println(name + ": Detaching " + containerName);
            Random rand = new Random();
            int time = rand.nextInt(1000);
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
