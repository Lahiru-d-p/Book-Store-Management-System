package BookStoreManagementSystem.HomeMenu;

import BookStoreManagementSystem.MainClass;
import BookStoreManagementSystem.User.Employee;

public class AdminMenu extends HomeMenu {

    @Override
    public void menu() {
        System.out.println("------------------------------------");
        System.out.println("-------------ADMIN AREA-------------");
        System.out.println("------------------------------------");
        System.out.println("1.Add Manager");
        System.out.println("2.Back");
        System.out.println("3.Exit");
        choice = Integer.parseInt(input.nextLine());

        if (choice == 1) {
            //add manager
            Employee employee = new Employee();
            employee.addEmployee("Manager");
            //After add manager back to admin area
            menu();
        }
        else if (choice==2) {
            //back to log in area
            MainClass.welcomeToBookStoreManagementSystem();
        }
        else if (choice == 3) {
            //exit from the system
            MainClass.Exit();
        }
        else {
            //where input is incorrect back to admin area
            System.out.println("****INCORRECT INPUT****");
            this.menu();
        }
    }
}
