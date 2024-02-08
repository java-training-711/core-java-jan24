package org.example3;

import org.example3.models.Appliance;
import org.example3.models.Monitor;
import org.example3.models.WashingMachine;

public class InheritanceExample {
    public static void main(String[] args) {
        // a parent reference variable is holding child object reference
        Appliance washingMachine1 = new WashingMachine("SEMI_AUTO", "NO", 345.56f);
        Appliance washingMachine2 = new WashingMachine("AUTO", "YES", 545.67f);
        Appliance monitor1 = new Monitor(345.32f, 24, "ISP");
        Appliance monitor2 = new Monitor(545.43f, 32, "LED");

        System.out.println(washingMachine1);
        System.out.println(washingMachine2);
        System.out.println(monitor1);
        System.out.println(monitor2);

        System.out.println(monitor1.getPrice());

        System.out.println(washingMachine1.getPrice());
        System.out.println(washingMachine2.getPrice());

    }
}
