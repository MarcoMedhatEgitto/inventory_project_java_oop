package Classes;

import java.util.Scanner;

abstract public class Categories {
    protected String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public Categories() {
        categoryName=null;
    }
    public Categories( String categoryName) {
        this.categoryName = categoryName;

    }
    abstract public void deleteMe();

}
//    Scanner input=new Scanner(System.in);
//    private int numberOfCategories;
//    protected String [] categoryList=new String[100];
//    protected String categoryName;
//    private Suppliers supplier;
//    public Categories(){
//        this.numberOfCategories=1;
//        this.categoryList[0]="clothes";
//        this.categoryName="trousers";
//        System.out.println("Data base is initialized!. Welcome to our inventory application, Please enter your privilage: ");
//
//    }
//
//    public Categories(int numberOfCategories, String categoryName) {
//        this.numberOfCategories = numberOfCategories;
//        categoryName = categoryName;
//        System.out.println("Data base is initialized!. Welcome to our inventory application, please choose what you want to do: ");
//    }
//
//    public int getNumberOfCategories() {
//        return numberOfCategories;
//    }
//
//    public void setNumberOfCategories(int numberOfCategories) {
//        this.numberOfCategories = numberOfCategories;
//    }
//
//    public void getCategoryList() {
//        for(int i=0;i<categoryList.length;i++){
//            if(categoryList[i]!=null)
//            System.out.println("Category number "+ (i+1)+" is "+categoryList[i]);
//            else
//                break;
//        }
//    }
//    public Suppliers getSupplier() {
//        return supplier;
//    }
//
//    public void setSupplier(Suppliers supplier) {
//        this.supplier = supplier;
//    }
//
//    public void addToCategoryList(String category) {
//        this.categoryList[numberOfCategories-1] = category;
//
//    }
//
//    public String getCategoryName() {
//        return categoryName;
//    }
//
//    public void setCategoryName(String categoryName) {
//        categoryName = categoryName;
//    }
