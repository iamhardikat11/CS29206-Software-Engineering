import java.util.*;
import java.lang.*;
import java.io.*;

class Date {

    int day;
    int month;
    int year;

    public Date() {
        this.day = 0;
        this.month = 0;
        this.year = 0;
    }
}

class Entity extends Date {
    int id;
    String name;
    Date day;

    public Entity() {
        this.id = 0;
        this.name = "";
        this.day = new Date();
    }

}

class Manufacturer extends Entity {
    java.util.ArrayList<String> products;
    Entity op;

    public Manufacturer() {
        this.op = new Entity();
        this.products = new ArrayList<>();

    }

    public void add_Products(String name) {
        products.add(name);
    }
}

class Customer extends Entity {
    int zipCode;
    ArrayList<Info> v;
    Entity op;

    public Customer() {
        this.op = new Entity();
        this.zipCode = 0;
        this.v = new ArrayList<>();
    }

}

class Product extends Entity {
    Entity op;
    Manufacturer mn;

    public Product() {
        this.op = new Entity();
        this.mn = new Manufacturer();
    }

}

class Warehouse extends Entity {
    int zipCode;
    Entity op;
    HashMap<String, Integer> inventory;

    public Warehouse() {
        this.op = new Entity();
        this.zipCode = 0;
        this.inventory = new HashMap<>();
    }

    void update(String ob, int copy) {
        this.inventory.put(ob, inventory.get(ob) + copy);
    }

    boolean check_Order(Customer cu)
    {
        if(this.zipCode!=cu.zipCode)
            return false;
        for(int i=0;i<cu.v.size();i++)
        {
            if(this.inventory.containsKey(cu.v.get(i).name))
            {
                 if(this.inventory.get(cu.v.get(i).name)<cu.v.get(i).count)
                     return false;
            }
            else
            {
                return false;
            }
        }
        return true;
    }
}

class Agent extends Entity {
    int zipCode;
    int number_Of_Products;
    Entity op;

    Agent() {
        this.op = new Entity();
        this.zipCode = 0;
        this.number_Of_Products = 0;
    }

}

class Print extends Entity {

    void Print_Options() {
        System.out.println("Please Enter a Number According to the Given Guidelines");
        System.out.println("1. Create / Delete / Print Entities of Each Type");
        System.out.println("2. Add a Product to the Manufacturer");
        System.out.println("3. Add a Certain Number of Copies of a Product to a Shop.");
        System.out.println("4. Add an order of a product from a customer.");
        System.out.println("5. Process an Order. Please Note the order will only be Processed in a case where he product is available at a shop in the customer's zipcode.");
        System.out.println("6. Wish to see all your ordered objects in Cart!! Click here!!");
        System.out.println("7. Display the Inventory of a Shop(The Text-based Interface will display both the Products with their Live Count)");
        System.out.println("8. Products made by a Manufacturer");
        System.out.println("9. To Exit from the System OR Enter 1-8 to continue shopping/working.");
    }

    void Print_Manufacturer(Manufacturer mn) {
        System.out.println("Name: " + mn.name + " \tId: " + mn.id + " \t Date: " + mn.day.day + "/" + mn.day.month + "/" + mn.day.year);
        int j = 1;
        for (String i : mn.products) {
            System.out.println(j + "\t\t\t\t" + i);
            j++;
        }
    }

    void Print_Customer(Customer cu) {
        System.out.println("Name of Customer: " + cu.name + " \tId: " + cu.id + " \t Date: " + cu.day.day + "/" + cu.day.month + "/" + cu.day.year);
        System.out.println("ID:\t\t\t\tName:\t\t\t\tCount:\t\t\t\t");
        for (int i = 0; i < cu.v.size(); i++) {
            System.out.println(i + "\t\t\t\t   "+cu.v.get(i).name+"\t\t\t\t   "+cu.v.get(i).count);
        }
    }

    void Print_Warehouse(Warehouse wr) {
        System.out.println("Name of Warehouse: " + wr.name + " \tId: " + wr.id + " \t Date of Establishment: " + wr.day.day + "/" + wr.day.month + "/" + wr.day.year);
        System.out.println("ID:\t\t\t\tName:\t\t\t\tCount:\t\t\t\t");
        int cnt = 1;
        for (Map.Entry<String, Integer> set : wr.inventory.entrySet()) {
            System.out.println(cnt+"\t\t\t\t"+set.getKey()+"\t\t\t\t"+set.getValue());
        }
    }
}

class Info {
    String name;
    int count;

    Info() {
        this.name = "";
        this.count = 0;
    }
}

class Input{
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public String Input_String() throws IOException {
        return in.readLine();
    }

    public void take_Input(Entity op) throws IOException {
        System.out.println("Please Enter Name:");
        op.name = in.readLine();
        System.out.println("Please Enter ID:");
        op.id = Integer.parseInt(in.readLine());
        System.out.println("Please Enter Date in DD/MM/YYYY Format:");
        String a = in.readLine();
        op.day.day = Integer.parseInt(a.substring(0,2));
        op.day.month = Integer.parseInt(a.substring(3,5));
        op.day.year = Integer.parseInt(a.substring(6));
    }

//    public void take_Input_Mn(Manufacturer mn) throws IOException{
//        System.out.println("Enter the Number of Products being Manufactured");
//        int n = Integer.parseInt(in.readLine());
//        while(n-->0)
//        {
//            String a = in.readLine();
//            mn.products.add(a);
//        }
//    }
//
//    public void take_Input_Cu(Customer cu) throws IOException{
//        System.out.println("Please Enter the Number of Products and Name For The Customer on Separate Line");
//        System.out.println("Please Enter the Number of Products to Be Entered");
//        int n = Integer.parseInt(in.readLine());
//        System.out.println("Please Enter the Name of the Product and then their Count:");
//        while(n-->0)
//        {
//            String name = in.readLine();
//            int count = Integer.parseInt(in.readLine());
//            Info e = new Info();
//            e.name = name;
//            e.count = count;
//            cu.v.add(e);
//        }
//    }
//
//    public void take_Input_Pr(Product pr) throws IOException{
//        System.out.println("Please Enter the Name of the Manufacturer");
//        System.out.print("Name:");
//        pr.mn.name = in.readLine();
//    }
//
//    public void take_Input_Wr(Warehouse wr) throws IOException{
//        System.out.println("Please Enter the PinCode");
//        wr.zipCode = Integer.parseInt(in.readLine());
//
//    }
//
//    public void take_Input_ag(Agent ag) throws IOException{
//
//    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        Manufacturer mn = new Manufacturer();
        Customer cu = new Customer();
        Product pr = new Product();
        Warehouse wr = new Warehouse();
        Agent ag = new Agent();

        System.out.println("**************** ________________ WELCOME TO THE ONLINE MEDICINE STORE SYSTEM ________________ ****************");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Print p = new Print();
        Input iq = new Input();
        p.Print_Options();
        int ch = Integer.parseInt(iq.Input_String());
        ArrayList<String> active_Entities = new ArrayList<>();
        while (ch != 9) {
            switch (ch) {
                case 1 -> {
                    System.out.println("Please Enter :-");
                    System.out.println("CHOICE '1': CREATE NEW ENTITY");
                    System.out.println("CHOICE '2': DELETE AN ENTITY");
                    System.out.println("CHOICE '3': PRINT ALL ENTITIES");
                    int r = Integer.parseInt(iq.Input_String());
                    switch (r) {
                        case 1 -> {
                            System.out.println("Enter the Entity to be created");
                            String en = iq.Input_String();
                            switch (en) {
                                case "Manufacturer" -> {
                                    active_Entities.add("Manufacturer");
                                    iq.take_Input(mn.op);
                                }
                                case "Customer" -> {
                                    active_Entities.add("Customer");
                                    iq.take_Input(cu.op);
                                }
                                case "Product" -> {
                                    active_Entities.add("Product");
                                    iq.take_Input(pr.op);
                                }
                                case "Warehouse" -> {
                                    active_Entities.add("Warehouse");
                                    iq.take_Input(wr.op);
                                }
                                case "Agent" -> {
                                    active_Entities.add("Agent");
                                    iq.take_Input(ag.op);
                                }
                            }
                        }
                        case 2 -> {
                            System.out.println("Enter the entity to be Deleted");
                            String ob = in.readLine();
                            active_Entities.remove(ob);
                        }
                        case 3 -> {
                            System.out.println("The Entities that are Currently CREATED and are ACTIVE:");
                            for (String i : active_Entities)
                                System.out.println(i);
                        }
                    }
                }

                case 2 -> {
                    System.out.println("Welcome Distributor !! Please Enter the Name of the Product that must be added to the manufacturer");
                    System.out.println("Adding a Product to the Manufacturer..............");
                    String name = in.readLine();
                    mn.add_Products(name);

                }

                case 3 -> {
                    System.out.println("Mention the Number of Copies to be added to the shop..............Also mention the Object to be updated:");
                    int copy = Integer.parseInt(in.readLine());
                    String ob = in.readLine();
                    wr.update(ob, copy);
                }

                case 4 -> {
                    System.out.println("Dear User!! Please Enter the Order of the Product from the Customer:-.......................");
                    Info ob = new Info();
                    System.out.println("Please Enter the Product:");
                    ob.name = in.readLine();
                    System.out.println("Please Enter the Count of the Product:");
                    ob.count = Integer.parseInt(in.readLine());
                    cu.v.add(ob);
                }

                case 5 -> {
                    if(wr.check_Order(cu))
                    {
                        System.out.println("The Order can be Processed......... ");
                        System.out.println("The Details of the Delivery Agent that will deliver your Product are");

                    }
                    else
                    {
                        System.out.println("Sorry User!! The Requested Items are Out of Stock");
                    }
                }

                case 6 -> {
                    System.out.println("****** LIST OF ALL YOUR PURCHASES ******");
                    p.Print_Customer(cu);

                }

                case 7 -> {
                    System.out.println("***** WELCOME TO THE INVENTORY OF THE SHOP ******");
                    p.Print_Warehouse(wr);

                }

                case 8 -> {
                    System.out.println("****** LIST OF ALL PRODUCTS MANUFACTURED BY THE MANUFACTURER ******");
                    p.Print_Manufacturer(mn);
                }
            }
            p.Print_Options();
            ch = Integer.parseInt(in.readLine());
        }
        System.out.println("Loved to Serve You !! Hoping to meet you soon.");
        System.out.println("******************    END   ******************");
    }
}
