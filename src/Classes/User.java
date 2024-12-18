package Classes;

import java.util.ArrayList;
import java.util.Scanner;
public  class User {
    private static final String password = "use";

    protected ArrayList<Product> prod=new ArrayList<>();

    public ArrayList<Product> getProd() {
        return prod;
    }

    public void setProd(ArrayList<Product> prod) {
        this.prod = prod;
    }
    public String getpass(){return password;}
    public  void addpro(String categoryName, String ProductName, int quantity, String supplierName, String phone){
//       for(int i=0;i<50;i++)
//       {
//           if(products[i]==null)
//           {
//               products[i]=new Product(categoryName,ProductName,quantity,supplierName,phone,excisted);
//               break;
//           }
//       }
        prod.add(new Product(categoryName,ProductName,quantity,supplierName,phone));
    }
    public  boolean isProductPrinted(Product product,int index){
        for (int i=index-1;i>=0;i--){
            if (product.getCategoryName().matches(prod.get(i).getCategoryName())){
                return true;
            }
        }
        return false;
    }
    public  boolean isSupplierPrinted(Product product,int index){
        for (int i=index-1;i>=0;i--){
            if (product.getSupplier().getSupplierName().matches(prod.get(i).getSupplier().getSupplierName())){
                return true;
            }
        }
        return false;
    }
    public  void goBack()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("to continue press 1/to close press any other key");
        String M=input.next();
        if (M.matches("1")){
            MainMenu();
        }
    }
    public  boolean excistedCategory(String cat){
        for(int i=0;i<prod.size();i++){
            if(prod.get(i).getCategoryName().matches(cat)){
                return true;
            }
        }
        return false;
    }
    public  void list() {
        if(prod.size()==0){
            System.out.println("There is nothing in the list yet!");
        }
        for (int H = 0; H < prod.size(); H++) {
            if (H!=0){
                if(!isProductPrinted(prod.get(H),H))
                {
                    System.out.println(prod.get(H).getCategoryName());
                    for (int i = 0; i < prod.size(); i++) {
                        if ( prod.get(i).getCategoryName().matches(prod.get(H).getCategoryName())) {
                            prod.get(i).showMe();
                        }
                    }
                }
            }
            else if (H==0) {
                System.out.println(prod.get(H).getCategoryName());
                for (int i = 0; i < prod.size(); i++) {
                    if ( prod.get(i).getCategoryName().matches(prod.get(H).getCategoryName())) {
                        prod.get(i).showMe();
                    }
                }
            }
//            }else if (products[H]==null&&H==0) {
//                System.out.println("there is nothing in the list");
//            }
        }
    }
    public  boolean checkInt(String quantity){
        for(int i=0;i<quantity.length();i++)
        {
            if(quantity.charAt(i)!='0'&&quantity.charAt(i)!='1'&&quantity.charAt(i)!='2'&&quantity.charAt(i)!='3'&&quantity.charAt(i)!='4'&&quantity.charAt(i)!='5'&&quantity.charAt(i)!='6'&&quantity.charAt(i)!='7'&&quantity.charAt(i)!='8'&&quantity.charAt(i)!='9'){
                return false;
            }
        }
        return true;
    }
    public  void  MainMenu(){
        Scanner input= new Scanner(System.in);
        System.out.println("Welcome, Choose what you want to do from this list: ");
        System.out.println("[1] For the list of categories and products and their suppliers.");
        System.out.println("[2] To add a new product.");
        System.out.println("[3] For the list of products.");
        System.out.println("[4] To show a category.");
        System.out.println("[5] For the list of suppliers.");
        System.out.println("[6] To log out.");
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
                break;
                default:
                System.out.println("please enter a number from the list: ");
                goBack();
        }

    }
}
