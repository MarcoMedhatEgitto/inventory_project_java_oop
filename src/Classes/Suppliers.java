package Classes;
import java.util.*;
public class Suppliers {
    private String supplierName;
    private String phone;
    private String categoryName;
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Suppliers(String supplierName, String phone, String categoryName) {
        this.supplierName = supplierName;
        this.phone=phone;
        this.categoryName=categoryName;
    }
}
