package BookStoreManagementSystem.HomeMenu;

import BookStoreManagementSystem.MainClass;
import BookStoreManagementSystem.MyProfile.MyProfile;
import BookStoreManagementSystem.User.Employee;

public class EmployeeMenu extends HomeMenu{
    Employee employee;
    public EmployeeMenu(String emID){
        employee= new Employee(emID);
        employee.viewEmployee();
    }
    @Override
    public void menu() {
        System.out.println("------------------------------------");
        System.out.println("-----------EMPLOYEE  AREA-----------");
        System.out.println("------------------------------------");

        System.out.println("1.Inventory Details");
        System.out.println("2.Book Handling");
        System.out.println("3.My Profile");
        System.out.println("4.Back");
        System.out.println("5.Exit");

        choice = Integer.parseInt(input.nextLine());
        switch (choice){
            case 1:
                super.menu();
                menu();
                break;
            case 2:
                bookHandling();
                menu();
                break;
            case 3:
                MyProfile.profile(employee);
                menu();
                break;
            case 4:
                MainClass.welcomeToBookStoreManagementSystem();
                break;
            case 5:
                MainClass.Exit();
                break;
            default:
                System.out.println("****INCORRECT INPUT****");
                menu();
        }
    }
}
