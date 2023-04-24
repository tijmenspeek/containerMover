import Mover.Crane;
import Mover.Ship;
import Mover.Truck;
import Storage.Dock;
/*
@Author Tijmen Speekenbrink (1029331)
 */

public class Main{
    public static void main(String[] Args){
        Ship ship = new Ship(20);
        Dock dock = new Dock(5);

        Crane crane1 = new Crane(1, ship, dock);
        Crane crane2 = new Crane(1, ship, dock);
        Truck truck1 = new Truck(1, ship, dock);
        Truck truck2 = new Truck(1, ship, dock);
        Truck truck3 = new Truck(1, ship, dock);
        crane1.setName("Crane 1");
        crane2.setName("Crane 2");

        truck1.setName("Truck 1");
        truck2.setName("Truck 2");
        truck3.setName("Truck 3");


        crane1.start();
        crane2.start();
        truck1.start();
        truck2.start();
        truck3.start();

    }
}
