package utils;

import java.util.ArrayList;
import java.util.List;


public class Helpers {

    public void sleep (int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<String> orders (){
        List<String> typeOrder = new ArrayList<>();
        typeOrder.add("Pedidos");
        typeOrder.add("McDelivery");

        return typeOrder;
    }

}
