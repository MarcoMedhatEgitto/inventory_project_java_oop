package Classes;

import java.util.Scanner;

public class Admin extends User{
    private static final String password = "password";
    public static String getPassword() {
        return password;
    }
    public  int productIndex(String product){
        for (int i=0;i<prod.size();i++){
            if(prod.get(i).getProductName().matches(product)){
                return i;
            }
        }
        return -1;
    }
    public  boolean excistedCategory(String cat){
        for(int i=0;i<prod.size();i++){
            if(prod.get(i).getCategoryName().matches(cat)){
                return true;
            }
        }
        return false;
    }
    public  boolean excistedProduct(String cat){
        for(int i=0;i<prod.size();i++){
            if(prod.get(i).getProductName().matches(cat)){
                return true;
            }
        }
        return false;
    }
    @Override
    public  void MainMenu(){
        Scanner input= new Scanner(System.in);
        System.out.println("Welcome, Choose what you want to do from this list: ");
        System.out.println("[1] For the list of categories and products and their suppliers.");
        System.out.println("[2] To add a new product.");
        System.out.println("[3] For the list of products.");
        System.out.println("[4] To show a category.");
        System.out.println("[5] For the list of suppliers.");
        System.out.println("[6] To modify the product quantity");
        System.out.println("[7] To modify the product supplier");
        System.out.println("[8] To delete product or category");
        System.out.println("[9] To log out.");
        String in=input.next();
        switch (in){
            case "1":
                list();
                goBack();
                break;
            case "2":

                System.out.println("Enter the product name:");
                String pro= input.next().toLowerCase();
                System.out.println("Enter the product quantity:");
                String quantity=input.next();
                while(!checkInt(quantity)){
                    System.out.println("Please enter number: ");
                    quantity=input.next();
                }
                int quantityInt=Integer.parseInt(quantity);
                System.out.println("Enter the product category:");
                String catName=input.next().toLowerCase();
                System.out.println("Enter the supplier name:");
                String supName=input.next().toLowerCase();
                System.out.println("Enter the supplier phone:");
                String phone=input.next();
                // Product excisted=excistedSupplier(supName,phone);
                addpro(catName,pro,quantityInt,supName,phone);
                //boolean check=excistedCategory(catName);
                // System.out.println(check);
//               if(!excistedCategory(catName)){
//                   category[catnum]=catName;
//                   catnum++;
//               }
                // System.out.println(k);
                System.out.println("Product is created!");
                goBack();
                break;
            case "3":
                System.out.println("Product  "+"quantity  "+"category");
                for(int i=0;i<prod.size();i++){
                    System.out.println(prod.get(i).getProductName()+"  "+prod.get(i).getProductQuantity()+"  "+prod.get(i).getCategoryName());
                }
                goBack();
                break;
            case "4":
                System.out.println("Enter the category name: ");
                String categoryName=input.next().toLowerCase();
                if(!excistedCategory(categoryName))
                {
                    System.out.println("Category doesn't exist!");

                }
                else{
                    System.out.println(categoryName);
                    for(int i=0;i<prod.size();i++)
                    {
                        if(prod.get(i).getCategoryName().matches(categoryName)){
                            System.out.println((i+1)+")"+prod.get(i).getProductName()+"  quantity)"+prod.get(i).getProductQuantity());
                        }
                    }
                }
                goBack();
                break;
            case "5":
                System.out.println("  Supplier  "+"  phone  ");
                for(int k=0;k<prod.size();k++)
                {
//                    int l=0;
//                    for(int i=k+1;i<prod.size();i++){
//                            if(prod.get(k).getSupplier().getSupplierName().equals(prod.get(i).getSupplier().getSupplierName())&&prod.get(k).getSupplier().getPhone().equals(prod.get(i).getSupplier().getPhone())){
//                             l=1;
//                             break;
//                            }
//                    }
//                        if(l==0)
                    if(!isSupplierPrinted(prod.get(k),k))
                        System.out.println(prod.get(k).getSupplier().getSupplierName()+"  "+prod.get(k).getSupplier().getPhone());
                }

                goBack();
                break;
            case "6":
                System.out.println("Enter the name of the product: ");
                String product=input.next().toLowerCase();
                if(productIndex(product)==-1){
                    System.out.println("Sorry, can't find the product.");
                }
                else{
                    System.out.println("Enter the new stock quantity: ");
                    String stock=input.next();
                    while(!checkInt(stock)){
                        System.out.println("Enter a number: ");
                        stock= input.next();
                    }
                    int stockInt=Integer.parseInt(stock);
                    System.out.println("Stock quantity changed correctly!");
                    prod.get(productIndex(product)).ChangeStock(stockInt);
                }
                goBack();
                break;
            case "7":
                System.out.println("Enter the name of the product: ");
                product=input.next().toLowerCase();
                if(productIndex(product)==-1){
                    System.out.println("Sorry, can't find the product.");
                }
                else{
                    System.out.println("Enter the new supplier name: ");
                    String sup=input.next().toLowerCase();
                    System.out.println("Enter the new supplier phone number: ");
                    String supnum=input.next();
                    System.out.println("Supplier name & number changed correctly!");
                    prod.get(productIndex(product)).setSupplier(sup,supnum);
                    //suppliers[supIndex()]
                }
                goBack();
                break;
            case "8":
                System.out.println("category or product:");
                String which=input.next().toLowerCase();
                while(!which.matches("category")&&!which.matches("product")){
                    System.out.println("Enter category or product as they are written: ");
                    which=input.next().toLowerCase();
                }
                System.out.println("Enter the name of the "+which);
                String name=input.next().toLowerCase();
                if(!excistedCategory(name)&&!excistedProduct(name))
                {
                    System.out.println("Sorry it doesn't seem to be saved!");
                    goBack();
                }
                else{
                    if (which.matches("category")){
                        for(int i=0;i<prod.size();i++)
                        {
                            if(prod.get(i).getCategoryName().matches(name)){
                                prod.get(i).deleteMe();
                                prod.remove(i);
                            }
                        }

                    }
                    else{
                        for(int i=0;i<prod.size();i++)
                        {
                            if(prod.get(i).getProductName().matches(name)){
                                prod.get(i).deleteMe();
                                prod.remove(i);
                            }
                        }
                    }
                }
                goBack();
                break;
            case "9":
                break;
            default:
                System.out.println("please enter a number from the list: ");
                goBack();
        }
}
}

