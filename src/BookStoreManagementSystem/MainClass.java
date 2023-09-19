package BookStoreManagementSystem;

import BookStoreManagementSystem.DBConnector.DBClass;
import BookStoreManagementSystem.Login.*;
import java.util.Scanner;
import static java.lang.System.exit;

public class MainClass{

    public static void main(String[] args) {
        //Start the application inside main
        welcomeToBookStoreManagementSystem();
    }

    public static void welcomeToBookStoreManagementSystem(){
        Scanner input = new Scanner(System.in);
        int choice;
        DBClass.connection();
        System.out.println("------------------------------------");
        System.out.println("-------------WELCOME TO-------------");
        System.out.println("\tBOOK STORE MANAGEMENT SYSTEM");
        System.out.println("------------------------------------");

        do{
            System.out.println("1.Admin Login");
            System.out.println("2.User Login");
            System.out.println("3.Exit");
            /*get the user choice*/
            choice = Integer.parseInt(input.nextLine());
            switch (choice){
                case(1):
                    AdminLogin adminLogin = new AdminLogin();
                    adminLogin.start();
                    break;
                case(2):
                    UserLogin userLogin = new UserLogin();
                    userLogin.start();
                    break;
                case(3):
                    Exit();
                default:
                    System.out.println("****INCORRECT INPUT****");
            }
        }while(!(choice==1 || choice==2 ));
    }

    public static void Exit(){
        System.out.println("**********HAVE A NICE DAY**********");
        exit(0);
    }
}
