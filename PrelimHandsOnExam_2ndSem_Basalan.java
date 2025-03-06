import java.util.Scanner;
import java.util.HashMap;

public class PrelimHandsOnExam_2ndSem_Basalan {
    static HashMap<String,HashMap<Double,Integer>> inventory = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    static void addItem(){
        System.out.println("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.println("Enter item price: ");
        double itemPrice = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter item quantity: ");
        int itemQuantity = Integer.parseInt(scanner.nextLine());
        HashMap<Double,Integer> hashHolder = new HashMap<>();
        hashHolder.put(itemPrice,itemQuantity);
        inventory.put(itemName,hashHolder);
        System.out.println();
    }
    static void setQuantity(){
        double priceHolder = 0;
        int quantityHolder = 0;
        System.out.println("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.println("Enter new quantity: ");
        int setQuantity = Integer.parseInt(scanner.nextLine());
        if(inventory.containsKey(itemName)){
            HashMap<Double,Integer> hashHolder = inventory.get(itemName);
            for(Double j: hashHolder.keySet()){
                priceHolder = j;
                quantityHolder = setQuantity;
                hashHolder.put(priceHolder,quantityHolder);
                inventory.put(itemName,hashHolder);
            }
        }
        System.out.println("Quantity of '" + itemName +"' set to " + setQuantity + "." );
    }
    static void displayInventory(){
        System.out.println("Inventory: ");
        //Format edit
        System.out.printf("%-10s %10s %10s","Item","Price","Quantity");
        System.out.println();
        System.out.println("--------------------------------------");
        for(String i: inventory.keySet()){
            //inventory.get = {key=value}, but the only needed element is the value which is the quantity
            //new hashmap is needed for name partition for easy retrieval
            HashMap<Double,Integer> hashHolder = inventory.get(i);
            for(Double j: hashHolder.keySet()){
                //To get the value out of the key-value pair, you need to use the .get(key) method
                int quantityHolder = hashHolder.get(j);
                //Format edit
                System.out.printf("%-10s %10.2f %10d",i,j,quantityHolder);
                System.out.println();
            }
        }
        System.out.println();
    }
    public static void main(String[] args){
        //Preload Items
        String item1 = "Laptop";
        String item2 = "Mouse";
        String item3 = "Keyboard";
        inventory.put(item1, new HashMap<Double,Integer>(){{put(1200.00,10);}});
        inventory.put(item2, new HashMap<Double,Integer>(){{put(25.50,50);}});
        inventory.put(item3, new HashMap<Double,Integer>(){{put(50.75,30);}});
        boolean inventorySystem = true;

        while(inventorySystem){
            System.out.println("Inventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. Set Quantity");
            System.out.println("3. Display Inventory");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch(choice){
                case 1: {
                    addItem();
                    break;
                }
                case 2: {
                    setQuantity();
                    break;
                }
                case 3: {
                    displayInventory();
                    break;
                }
                case 4: {
                    //Format edit
                    System.out.println("Exiting...");
                    inventorySystem = false;
                    break;
                }
            }
        }
    }
}
