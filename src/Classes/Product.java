package Classes;

import java.util.Objects;
import java.util.Scanner;

public class Product extends Categories{
    public int productNumber;
    private String productName;
    private int productQuantity;
    private Suppliers supplier;



    public Product(String categoryName, String productName, int productQuantity, String supplier, String phone) {
        super(categoryName);
        this.productName=productName;
        this.productQuantity=productQuantity;
        this.supplier= new Suppliers(supplier,phone,categoryName);
        productNumber++;
    }
    public String getProductName() {
        return productName;
    }
    public void ChangeStock(int newStock){
        this.productQuantity=newStock;
    }
    public int getProductQuantity() {
        return productQuantity;
    }

    public Suppliers getSupplier() {
        return supplier;
    }
    @Override
    public void deleteMe(){
        this.productQuantity=0;
        this.supplier=null;
        this.productName=null;
        this.categoryName=null;
    }

    public void setSupplier(String name,String phone) {
        this.supplier.setSupplierName(name);
        this.supplier.setPhone(phone);
    }
    public void showMe(){
        System.out.println("Product: " + productName + " Quantity: " + productQuantity + " Supplier: " + supplier.getSupplierName());
    }
    //    Scanner input=new Scanner(System.in);
//    private int productNumber;
//    private String productName;
//    private int productQuantity;
//    private String supplierName;
//    private String [] products=new String[100];
//    public Product() {
//        super();
//        System.out.println("Welcome sir, please choose what you want:");
//        System.out.println("[1] For the list of categories and products and their suppliers.");
//        System.out.println("[2] For the list of products.");
//        System.out.println("[3] For the list of categories.");
//        System.out.println("[4] For the list of suppliers.");
//        System.out.println("[5] to add a new product.");
//        System.out.println("[6] to modify the product quantity");
//        System.out.println("[7] to modify the product supplier");
//        int in=input.nextInt();
//        switch (in){
//            case 1:
//               for(int i=0;i<categoryList.length;i++){
//                   if (categoryList[i]!=null){
//                       System.out.println(categoryList[i]);
//                       for (int k=0;k<products.length;k++)
//                       {
//                           if (products[k]!=null){
//                               System.out.println("product: "+products[k]);
//                           }
//                           else
//                               break;
//                       }
//                   }
//
//
//               }
//                break;
//            case 5:
//                System.out.println("Enter the product name:");
//                String pro= input.next();
//                System.out.println("Enter the product quantity:");
//                int quantity=input.nextInt();
//                System.out.println("Enter the product category:");
//                String catName=input.next();
//                System.out.println("Enter the supplier name category:");
//                String supName=input.next();
//                System.out.println("Enter the supplier phone:");
//                String phone=input.next();
//                new Suppliers(supName,phone);
//                newProduct(pro,quantity,catName,supName);
//                System.out.println("to close press 0/to continue press one");
//                int k=input.nextInt();
//                if (k==0){
//                    break;
//                }
//                else {
//                    new Product();
//                }
//        }
//    }
//    public Product(String categoryName,Suppliers supplier) {
//        super(categoryName,supplier);
//        System.out.println("Welcome sir, please choose what you want:");
//        System.out.println("[1] For the list of categories and products and their suppliers.");
//        System.out.println("[2] For the list of products.");
//        System.out.println("[3] For the list of categories.");
//        System.out.println("[4] For the list of suppliers.");
//        System.out.println("[5] to add a new product.");
//        System.out.println("[6] to modify the product quantity");
//        System.out.println("[7] to modify the product supplier");
//    }
//    private boolean isCategoryExist(String categoryName){
//        for(int i=0;i<categoryList.length;i++){
//            if(categoryList[i].equals(categoryName)){
//                return true;
//            }
//        }
//        return false;
//    }
//    public void newProduct(String productName,int productQuantity,String categoryName,String supName){
//        this.categoryName=categoryName;
//        this.productQuantity=productQuantity;
//        this.productName=productName;
//        if(!isCategoryExist(categoryName)){
//            this.categoryList[this.numberOfCategories]=categoryName;
//        }
//        this.products[productNumber]=productName;
//        this.supplierName=supName;
//        new Suppliers(supName,"01204270119");
//        System.out.println("Product created!");
//    }
}
