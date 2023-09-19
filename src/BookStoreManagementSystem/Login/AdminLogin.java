package BookStoreManagementSystem.Login;

import BookStoreManagementSystem.HomeMenu.AdminMenu;
import BookStoreManagementSystem.MainClass;

import java.util.Scanner;

public class AdminLogin extends Login{
    int i = 0;
    final int AdminPSW = 1234;
    public void  start(){
        login();
    }

    /*Admin login*/
    void login(){
        /*Get admin password from user*/
        Scanner input = new Scanner(System.in);
        System.out.print("Enter admin Password: ");
        int getAdminPSW = Integer.parseInt(input.nextLine());

        /*Check whether password is correct or not*/
        if (getAdminPSW == AdminPSW){
            AdminMenu adminMenu = new AdminMenu();
            adminMenu.menu();
        }
        else {
            i++;
            System.out.println("*** INCORRECT ADMIN PASSWORD ***\n");
            if(i<3) {
                System.out.println("********** TRY AGAIN ************\n");
                login();
            }
            else
                MainClass.welcomeToBookStoreManagementSystem();
        }
    }
}
