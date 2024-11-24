package OOPs_assignment;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Scanner;

class Customer{
    private String name;
    private String password;
    private ArrayList <Product> cart = new ArrayList<>();
    private float wallet;
    private float discountOffered;
    private String status;
    private ArrayList<Integer> coupons = new ArrayList<>();
    public void setCoupons(int number){
        coupons.add(number);
    }
    public ArrayList<Integer> getCoupons(){
        return this.coupons;
    }
    public Customer(String name , String pas){
        this.name = name;
        this.password =  pas;
        this.wallet = 1000;
        this.status = "Normal";
    }
    public void emptyCart(){
        cart.clear();
    }
    public void updateWallet(float amount){
        this.wallet+=amount;
    }
    public float getBalance(){
        return this.wallet;
    }
    public float cartPrice(){
        float cartt= 0;
        for (int i=0;i<cart.size();i++){
            cartt+=cart.get(i).getPrice();
        }
        return cartt;
    }
    public String getStatus(){
        return this.status;
    }

    public ArrayList<Product> getCart() {
        return this.cart;
    }
    public void setStatus(String status,float price){
        this.status=status;
        if(status.equals("Elite")){
            discountOffered = 10;
        }else{
            discountOffered =5;
        }
        this.wallet -= price;
    }
    public String getName(){
        return this.name;
    }
    public String getPassword(){
        return this.password;
    }

    public void addItemtoCart(Product pro,int quan) {
        for(int i = 0;i<quan;i++){
            cart.add(pro);
        }
    }
}
/*class Normal extends Customer{
    float price;
    public Normal(String name ,String pass){
        super(name,pass);
        this.status= "Normal";
    }
}

class Elite extends Customer{
    public Elite(String name ,String pass){

        super(name,pass);
        this.status="Elite";
    }
    float price;
    public String getStatus(){
        return this.status;
    }
}

class Prime extends Customer{
    float price;
    public Prime(String name ,String pass)
    {
        super(name,pass);
        this.status =  "Prime";
    }
    public String getStatus(){
        return this.status;
    }
}*/

class Category{
    private int id;
    private String name;
    private int num;
    private ArrayList<Product> products=  new ArrayList<>();
    public Category(int id,String name){
        this.id = id;
        this.name = name;
    }
    public void setProductList(Product prod){
        products.add(prod);
    }
    public int getId(){
        return this.id;
    }
    public String getCatName(){
        return this.name;
    }

}
class Admin{
    private String name;
    private String password;
    public String getName(){
        return this.name;
    }
    public String getPassword(){
        return this.password;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPassword(String name){
        this.password=name;
    }

}
class Product extends Category{
    public float getDiscountE(){
        return this.DiscE;
    }
    public float getDiscountP(){
        return this.DiscP;
    }
    public float getDiscount(){
        return this.Disc;
    }
    private String productName;
    private int cId;
    private String cName;
    private float price;
    private float pId;
    private Product discountPartner = null;
    private String proDetails;
    private float giveawayPrice;
    private float giveawayPriceP;
    private float giveawayPriceE;
    private float Disc;
    private float DiscP;
    private float DiscE;
    public Product(int id, String name,float pId,String productName,float price,String det){
        super(id, name);
        this.cName =name;
        this.cId = id;
        this.productName = productName;
        this.price = price;
        this.pId = pId;
        this.proDetails = det;
    }
    public float getpId(){
        return this.pId;
    }
    @Override
    public int getId(){
        return this.cId;
    }
    @Override
    public String getCatName(){
        return this.cName;
    }
    public Product getDiscoutPrtner(){
        return this.discountPartner;
    }
    public void setgiveawayPrice(float combined,float combinerP, float combinedE){
        this.giveawayPrice= combined;
        this.giveawayPriceP= combinerP;
        this.giveawayPriceE= combinedE;
    }
    public void setDiscount(float combined,float combinerP, float combinedE){
        this.Disc= combined;
        this.DiscP= combinerP;
        this.DiscE= combinedE;
    }
    public void setGiveawayPrice(float price){
        this.giveawayPrice= price;
    }
    public void setDiscountPartner(Product discountPartner) {
        this.discountPartner = discountPartner;
    }
    public float getPrice(){
        return this.price;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getDetails() {
        return this.proDetails;
    }

    public float getDiscount(Customer cust) {
        if(cust.getStatus().equals("Elite"))
            return this.DiscE;
        else if(cust.getStatus().equals("Prime")) return this.DiscP;
        else return this.Disc;
    }

    public float getGiveaway() {
        return this.giveawayPrice;
    }
    public float getGiveawayE() {
        return this.giveawayPriceE;
    }
    public float getGiveawayP() {
        return this.giveawayPriceP;
    }
}

interface lists{
    static ArrayList<Customer> customerList = new ArrayList<>();
    static HashMap<Integer,Integer> ht = new HashMap<>();
    static ArrayList<Admin> adminList = new ArrayList<>();
    static ArrayList<Category> categoryList = new ArrayList<>();
    static ArrayList<Product> productList = new ArrayList<>();
    static ArrayList<ArrayList<Product>> dealsList = new ArrayList<>();

}

public class main implements lists{
    public static void firstMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1) Enter as Admin\n" +
                "2) Explore the Product Catalog\n" +
                "3) Show Available Deals\n" +
                "4) Enter as Customer\n" +
                "5) Exit the Application");
        int op = sc.nextInt();
        if (op == 1) {
            System.out.println("Please Enter your username and password");
            sc.nextLine();
            String username = sc.nextLine();
            System.out.println("Enter pass");
            int coni =0;
            String pass = sc.next();
            for (int i = 0; i < adminList.size(); i++) {
                if (adminList.get(i).getName().equals(username) && pass.equals(adminList.get(i).getPassword())) {
                    coni=1;
                    adminFirast(adminList.get(i));
                }
            }
            if(coni ==0){
                System.out.println("Wrong password/username");
            }

        }
        if (op == 2) {
            productCatalogue();

        }
        if (op == 3) {
            showAvailableDeals();
        }
        if (op == 4) {
            customerMenu();
        }
        if (op == 5) return;
        firstMenu();

    }

    private static void customerMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1) Sign up \n" +
                "2) Log in\n" +
                "3) Back");
        int choice = sc.nextInt();
        if (choice == 1) {
            try {
                System.out.println("Enter Name");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.println("Enter Password");

                String pass = sc.next();
                Customer cust = new Customer(name, pass);
                customerList.add(cust);
                System.out.println("Registered Successfully");
            }
            catch (Exception e){
                System.out.println("Wrong input");
            }
        }
        if (choice == 2) {
            try {
                System.out.println("Enter Name");
                sc.nextLine();
                String name = sc.nextLine();
                System.out.println("Enter Password");
                String pass = sc.next();
                int condi=0;
                // check if username and password matches with the one in class;
                for (Customer customer : customerList) {
                    if (customer.getName().equals(name)) {
                        if (customer.getPassword().equals(pass)) {
                            condi=1;
                            customerPage(customer);
                        }
                    }
                }
                if(condi==0){
                    System.out.println("Wrong username/password");
                }

            }catch (Exception e){
                System.out.println("Wrong input");
            }
        }
        if (choice == 3) {
            return;
        }
        customerMenu();
    }

        private static void customerPage (Customer cust){
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome " + cust.getName());
            System.out.println("1) browse products\n" +
                    "2) browse deals\n" +
                    "3) add a product to cart\n" +
                    "4) add products in deal to cart\n" +
                    "5) view coupons\n" +
                    "6) check account balance\n" +
                    "7) view cart\n" +
                    "8) empty cart\n" +
                    "9) checkout cart\n" +
                    "10) upgrade customer status\n" +
                    "11) Add amount to wallet\n" +
                    "12) back");
            int choice = sc.nextInt();
            if(choice ==4){
                System.out.println("Giveaway deals:");
                for (int i = 0; i <dealsList.size() ; i++) {
                    System.out.println(i+1);
                    System.out.println(dealsList.get(i).get(0).getpId());
                    System.out.println(dealsList.get(i).get(1).getpId());
                }
                if(dealsList.size()==0){
                    System.out.println("No available deals");
                }
                else{
                    int choice2 = sc.nextInt();
                    if(choice2<dealsList.size()) {
                        cust.addItemtoCart(dealsList.get(choice2 - 1).get(0), 1);
                        cust.addItemtoCart(dealsList.get(choice2 - 1).get(1), 1);
                    }else{
                        System.out.println("Wrong choice ");
                    }
                }


            }
            if(choice == 5){
                ArrayList<Integer> a =cust.getCoupons();
                System.out.println("Available discount % are:-");
                for (Integer product : a) {
                    System.out.println(Integer.toString(product) + "%");
                }
                if(a.size()==0){
                    System.out.println("No available Coupons");
                }

            }
            if(choice ==7){
                ArrayList<Product> a =cust.getCart();
                for (Product product : a) {
                    System.out.println(product.getProductName());
                }
                if(a.size()==0){
                    System.out.println("Cart is currently empty");
                }
            }
            if(choice ==2){
                showAvailableDeals();
            }
            if (choice == 8) {
                //empty cart tems here
                cust.emptyCart();
                System.out.println("Cart successfully emptied");
                
            }
            if (choice == 11) {
                try {
                    System.out.println("Enter amount to add");
                    float amount = sc.nextFloat();
                    cust.updateWallet(amount);
                    System.out.println("Amount successfully added");
                    
                }catch (Exception e){
                    System.out.println("wrong input");
                }

            }
            if (choice == 12) {
                System.out.println("Bye " + cust.getName());
                return;
            }
            if (choice == 9) {
                try {
                    if (cust.getBalance() > cust.cartPrice()) {
                        // search for product here
                        ArrayList<Product> cart = cust.getCart();
                        float totPrice = 0;
                        System.out.println("Your order is placed successfully. Details:");
                        for (Product product : cart) {
                            System.out.println(product.getProductName());
                            System.out.println(product.getpId());
                            System.out.println(product.getDetails());
                            System.out.println("Discounts:-");
                            if(cart.contains(product.getDiscoutPrtner())){
                                System.out.println("Total effective discount");
                                if(cust.getStatus().equals("Elite")){
                                    totPrice+= product.getGiveawayE();
                                    System.out.println(product.getGiveawayE());
                                }
                                if(cust.getStatus().equals("Prime")){
                                    totPrice+= product.getGiveawayP();
                                    System.out.println(product.getGiveawayP());
                                }else{
                                    totPrice+= product.getGiveaway();
                                    System.out.println(product.getGiveaway());
                                }
                            }else {
                                float disc1 = 0;
                                float disc2 = 0;
                                float disc3 = 0;
                                if (cust.getStatus().equals("Elite")) {
                                    disc1 = 10;
                                    //disc3 = (int) (Math.random() * (15 - 5 + 1) + 5);
                                    if(!cust.getCoupons().isEmpty()){
                                        int max=0;
                                        for (int i = 0; i <cust.getCoupons().size() ; i++) {
                                            max =Math.max(cust.getCoupons().get(i),max);
                                        }
                                        disc3 =max;
                                    }
                                    else{
                                        disc3 = 0;
                                    }
                                } else if (cust.getStatus().equals("Prime")) {
                                    disc1 = 5;
                                    //disc3 = (int) (Math.random() * (15 - 5 + 1) + 5);
                                    if(!cust.getCoupons().isEmpty()){
                                        int max=0;
                                        for (int i = 0; i <cust.getCoupons().size() ; i++) {
                                            max =Math.max(cust.getCoupons().get(i),max);
                                        }
                                        disc3 =max;
                                    }
                                    else{
                                        disc3 = 0;
                                    }
                                } else {
                                    disc1 = 0;
                                    disc3 = 0;
                                }

                                if (product.getDiscount(cust) != 0) {
                                    System.out.println("product discount " + product.getDiscount(cust));
                                    disc2 = product.getDiscount(cust);
                                /*float price = product.getPrice();
                                price = price - price * (product.getDiscount(cust) / 100);
                                System.out.println(price);
                                totPrice += price;*/
                                } else {
                                    disc2 = 0;

                                }
                                System.out.println("Total effective discount " + Math.max(disc1, Math.max(disc2, disc3)) + "% of " + product.getPrice() + " = " + Float.toString(((Math.max(disc1, Math.max(disc2, disc3)) /100)*product.getPrice())));
                                System.out.println("Total cost");
                                float new_cost = product.getPrice() - (((Math.max(disc1, Math.max(disc2, disc3)) /100)* product.getPrice()));
                                System.out.println(new_cost);
                                totPrice += new_cost;
                            }
                            //System.out.println(cart.get(i).getDetails());
                        }
                        System.out.println("Delivery charges");
                        System.out.print(100 + " ");
                        float newPrice=0;
                        if(cust.getStatus().equals("Elite")){
                            newPrice=100;
                            System.out.println();
                        }
                        else if(cust.getStatus().equals("Prime")){
                            newPrice = (float) (100 + (0.2 * totPrice));
                            System.out.print("+ 2% of " + Float.toString(totPrice) +" = Rs" + Float.toString(newPrice));
                            System.out.println();
                        }
                        if(cust.getStatus().equals("Normal")){
                            newPrice = (float) (100 + 0.5*totPrice);
                            System.out.print("+ 5% of " + Float.toString(totPrice)+" = Rs" + Float.toString(newPrice));
                            System.out.println();
                        }
                        System.out.println("Total Price ");
                        System.out.println(totPrice+newPrice);
                        /*System.out.println("Discount:");
                        float newew = (float)0.1*totPrice;
                        System.out.println("10% of " +Float.toString(totPrice) +" = Rs " +Float.toString(newew));
                        System.out.println("Total cost");
                        System.out.println(totPrice - newew);*/
                        String date;
                        if(cust.getStatus().equals("Elite")){
                            date ="2";
                        }else if(cust.getStatus().equals("Prime")){
                            date= "3-6";
                        }else{
                            date= "8-10";
                        }
                        System.out.println("Your order will be delivered within "+ date +" days");
                        if(cust.getStatus().equals("Elite")){
                            System.out.println("You get 4 discount coupons");
                            for(int i =0;i<4;i++){
                                cust.setCoupons((int) (Math.random() * (15 - 5 + 1) + 5));
                                System.out.println(cust.getCoupons().get(i));
                            }


                        }else if(cust.getStatus().equals("Prime")){
                            System.out.println("You get 2 discount coupons");
                            for(int i =0;i<2;i++){
                                cust.setCoupons((int) (Math.random() * (15 - 5 + 1) + 5));
                                System.out.println(cust.getCoupons().get(i));
                            }
                        }

                        //System.out.println("Your order will be delivered within " + cust.days);

                    } else {
                        System.out.println("Insufficient balance!! Please try again");
                    }
                    
                }catch (Exception e){
                    System.out.println("Wrong input");
                }
            }
            if (choice == 6) {
                System.out.println("Current account balance is:-");
                System.out.println(cust.getBalance());
                
            }
            if (choice == 3) {
                try {
                    System.out.println("Enter product ID and quantity");
                    float id = sc.nextFloat();
                    int condi=0;
                    System.out.println("Enter quantity");
                    int quan = sc.nextInt();
                    // implement adding to cart
                    for (Product product : productList) {
                        if (product.getpId() == id) {
                            condi=1;
                            cust.addItemtoCart(product, quan);
                            System.out.println("Item successfully added to cart");
                        }
                    }
                    if(condi==0){
                        System.out.println("No such product id exists ");
                    }

                    
                }catch (Exception e){
                    System.out.println("Wrong input");
                }
            }
            if(choice ==1){
                productCatalogue();
            }
            if (choice == 10) {
                try {
                    System.out.println("Current status");
                    System.out.println(cust.getStatus());
                    System.out.println("Choose your new status");
                    String stat = sc.next();
                    // implement status change here
                    if (stat.equals("Elite") && cust.getBalance() > 300) {
                        cust.setStatus(stat, 300);
                    } else if (stat.equals("Prime") && cust.getBalance() > 200) {
                        cust.setStatus(stat, 200);
                    } else {
                        System.out.println("Not enough money");
                    }
                }catch (Exception e){
                    System.out.println("Wrong input");
                }
            }
            customerPage(cust);
        }



        private static void productCatalogue () {
        Scanner sc = new Scanner(System.in);
            for (Product product : productList) {

                System.out.println(product.getCatName());
            }
            System.out.println("Choose your category sir");
            int choice = sc.nextInt();
            System.out.println("Your products are");
            for (Product product : productList)
                if (product.getId() == choice)
                    System.out.println(product.getProductName());
        }

        private static void showAvailableDeals () {
            try{
                System.out.println("Giveaway deals:");
                for (Product product : productList) {
                    if (product.getDiscoutPrtner() != null) {

                        System.out.println("Buy " + product.getDiscoutPrtner().getProductName() +" " + product.getProductName() +" for Normal" +product.getGiveaway() +"\n" +"for Elite" + product.getGiveawayE() +"\n" + "For Prime "+ product.getGiveawayP() );
                    }
                }
                System.out.println("Discount offers");
                for (Product product : productList) {
                    System.out.println("For Elite");
                    if (product.getDiscountE() != 0) {
                        System.out.println(product.getProductName());
                        System.out.println(product.getDiscountE());
                    }
                    System.out.println("for Prime");
                    if (product.getDiscountP() != 0) {
                        System.out.println(product.getProductName());
                        System.out.println(product.getDiscountE());
                    }
                    System.out.println("For Normal");
                    if (product.getDiscount() != 0) {
                        System.out.println(product.getProductName());
                        System.out.println(product.getDiscountE());
                    }

                }


            }catch (Exception e){
                System.out.println("Wrong input");
            }
        }

        private static void adminFirast (Admin adm) {
            Scanner sc = new Scanner(System.in);
                    System.out.println("Welcome " + adm.getName());
                    System.out.println("Please choose any one of the following actions: \n " +
                            "1) Add category\n" +
                            "2) Delete category\n" +
                            "3) Add Product\n" +
                            "4) Delete Product\n" +
                            "5) Set Discount on Product\n" +
                            "6) Add giveaway deal\n" +
                            "7) Back");
                    int actions = sc.nextInt();
                    if(actions ==7){
                        return;
                    }
                    if (actions == 2) {
                        try {
                            System.out.println("Enter Category id");
                            int idd = sc.nextInt();
                            for (int j = 0; j < productList.size(); j++) {
                                if (productList.get(j).getId() == idd) {
                                    System.out.println("deleted category " + productList.get(j).getCatName());
                                    productList.remove(j);
                                    break;
                                }
                            }

                        }catch (Exception e){
                            System.out.println("Wrong Input");
                        }
                    }
                    if (actions == 4) {
                        try {
                            System.out.println("Enter Product id");
                            float idd = sc.nextFloat();
                            for (int j = 0; j < productList.size(); j++) {
                                if (productList.get(j).getpId() == idd) {
                                    System.out.println("deleted category " + productList.get(j).getProductName());
                                    productList.remove(j);
                                    break;
                                }
                            }
                            for (Product product : productList) {
                                System.out.println(product.getProductName());

                            }
                        }catch (Exception e){
                            System.out.println("Wrong Input");
                        }
                    }
                    if (actions == 5) {
                        try {
                            System.out.println("Dear Admin give the Product ID you want to add discount for");
                            System.out.println("Enter the Product ID");
                            float pId = sc.nextFloat();
                            int condi=0;
                            for (Product product : productList) {
                                if (pId == product.getpId()) {
                                    condi=1;
                                    System.out.println("Enter discount for Normal");
                                    float discN = sc.nextFloat();
                                    System.out.println("Enter discount for Prime");
                                    float discP = sc.nextFloat();
                                    System.out.println("Enter discount for Elite");
                                    float discE = sc.nextFloat();
                                    product.setDiscount(discN,discP,discE);
                                    break;
                                    // enter discount acc to customer programme
                                }

                            }
                            if(condi==0){
                                System.out.println("Wrong product ID");
                            }
                        }catch (Exception e){
                            System.out.println("Wrong input");
                        }
                    }
                    if (actions == 6) {
                        if(productList.isEmpty()){
                            System.out.println("No products added yet");
                        }else {
                            try {
                                System.out.println("Dear Admin give the Product IDs you want to combine and giveaway a deal for");
                                System.out.println("Enter the first Product ID :");
                                int condi=0;
                                float pId = sc.nextFloat();
                                System.out.println("Enter the second Product ID:");
                                float pId2 = sc.nextFloat();
                                System.out.println("Enter the combined price(Should be less than their combined price):");
                                System.out.println("Enter for Normal");
                                float combined = sc.nextFloat();
                                System.out.println("Enter for Prime");
                                float combinedP = sc.nextFloat();
                                System.out.println("Enter for Elite");
                                float combinedE = sc.nextFloat();
                                for (int j = 0; j < productList.size(); j++) {
                                    if (productList.get(j).getpId() == pId) {
                                        condi=1;
                                        int condi2 = 0;
                                        Product p1 = productList.get(j);
                                        for (Product product : productList) {
                                            if (product.getpId() == pId2) {
                                                condi2=1;
                                                p1.setDiscountPartner(product);
                                                product.setDiscountPartner(p1);
                                                p1.setgiveawayPrice(combined,combinedP,combinedE);
                                                product.setgiveawayPrice(combined,combinedP,combinedE);
                                                ArrayList<Product> p= new ArrayList<>();
                                                p.add(product);
                                                p.add(p1);
                                                dealsList.add(p);
                                                break;
                                            }
                                        }
                                        if(condi2 == 0){
                                            System.out.println("Wrong ID2");
                                            break;
                                        }else{
                                            break;
                                        }
                                    }
                                }
                                if(condi==0){
                                    System.out.println("wrong product id1");
                                }
                            } catch (Exception e) {
                                System.out.println("Wrong input");
                            }
                        }

                    }
                    if (actions == 3) {
                        try {
                            System.out.println("Enter category ID ");
                            int id = sc.nextInt();
                            if(!ht.containsKey(id)){
                                System.out.println("No category exists with this ID");
                            }
                            else {
                                String cName = "";
                                for (Product product : productList) {
                                    if (product.getId() == id) {
                                        cName = product.getCatName();
                                        //System.out.println("yes");
                                        // complete Further
                                        break;
                                    }
                                }
                                System.out.println("enter product Name");
                                sc.nextLine();
                                String name = sc.nextLine();
                                System.out.println("Enter id");
                                float productId = sc.nextFloat();

                                System.out.println("Enter details");
                                sc.nextLine();
                                String det = sc.nextLine();
                                System.out.println("Enter price");
                                float price = sc.nextFloat();
                                Product prod = new Product(id, cName, productId, name, price, det);
                                productList.add(prod);
                            }
                        }
                        catch(Exception e){
                            System.out.println("Wrong Input");
                        }
                    }
                    if (actions == 1) {
                        try {
                            System.out.println("Add cataegory ID");
                            int id = sc.nextInt();
                            if(ht.containsKey(id)){
                                System.out.println("Already an existing category");
                            }
                            else {
                                ht.put(id, 0);
                                System.out.println("Add cataegory NAME");
                                sc.nextLine();
                                String name = sc.nextLine();
                                // finally add the product to as a objethere
                                System.out.println("Add a product:-");
                                System.out.println("Add product Name");
                                String pName = sc.next();
                                System.out.println("Add product id");
                                float pId = sc.nextFloat();
                                System.out.println("Add product functionalities");
                                // add funbctionalities string here
                                sc.nextLine();
                                String det = sc.nextLine();
                                System.out.println("Add peoduct price");
                                float priice = sc.nextFloat();
                                Product pro = new Product(id, name, pId, pName, priice, det);
                                productList.add(pro);
                                for (Product product : productList) {
                                    System.out.println(product.getId());
                                }
                                // debug
                                //System.out.println(pro.id);
                                //System.out.println(pro.name);
                                pro.setProductList(pro);
                                // fil;l in product name a, id and all
                            }
                        }
                        catch (Exception e){
                            System.out.println("Wrong input");
                        }


                }


            adminFirast(adm);
        }


        public static void main (String[]args){
            Admin adm = new Admin();
            adm.setName("Beff Jezos");
            adm.setPassword("1234");
            adminList.add(adm);
            firstMenu();
        }
}





