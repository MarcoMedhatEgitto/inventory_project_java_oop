import Classes.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        User user=new User();
        Admin admin=new Admin();
        int x=0;
        while(x==0)
        {
            System.out.println("Enter your privilage user/admin, for exit press 0: ");
            String privilage=input.next().toLowerCase();
            while(!privilage.matches("user")&&!privilage.matches("admin")&&!privilage.matches("0")){
                System.out.println("Please enter the word user or the word admin: ");
                privilage=input.next();
            }
            if(privilage.matches("0")){
                x=1;
            }
            else if(privilage.matches("admin")){
                System.out.println("Enter the password: ");
                String pass=input.next();
                if (pass.matches(Admin.getPassword())){
                    System.out.println("Welcome admin!");
                    admin.setProd(user.getProd());
                    admin.MainMenu();
                }
                else {
                    System.out.println("Sorry the user password is not valid!");
                }
            }
            else {
                System.out.println("Enter the password: ");
                String pass=input.next();
                if(pass.matches(user.getpass()))
                {
                    user.setProd(admin.getProd());
                    System.out.println("Welcome user!");
                    user.MainMenu();
                }
            }
        }

    }
}