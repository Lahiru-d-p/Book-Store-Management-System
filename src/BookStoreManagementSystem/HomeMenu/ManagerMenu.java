package BookStoreManagementSystem.HomeMenu;

import BookStoreManagementSystem.MainClass;
import BookStoreManagementSystem.MyProfile.MyProfile;
import BookStoreManagementSystem.User.Employee;

public class ManagerMenu extends HomeMenu{
    Employee employee;
    public ManagerMenu(String emID){
        employee = new Employee(emID);
        employee.viewEmployee();
    }

    @Override
    public void menu() {
        System.out.println("------------------------------------");
        System.out.println("------------MANAGER AREA------------");
        System.out.println("------------------------------------");

        System.out.println("1.Inventory Details");
        System.out.println("2.Employee Handling");
        System.out.println("3.Book Handling");
        System.out.println("4.My Profile");
        System.out.println("5.Back");
        System.out.println("6.Exit");

        choice = Integer.parseInt(input.nextLine());
        switch (choice){
            case 1:
                super.menu();
                menu();
                break;
            case 2:
                employeeHandling();
                menu();
                break;
            case 3:
                bookHandling();
                menu();
                break;
            case 4:
                MyProfile.profile(employee);
                menu();
                break;
            case 5:
                MainClass.welcomeToBookStoreManagementSystem();
                break;
            case 6:
                MainClass.Exit();
            default:
                System.out.println("****INCORRECT INPUT****");
                menu();
        }
    }

    private void employeeHandling(){
        Employee emp =new Employee();
        System.out.println("----------Employee Handling----------");
        System.out.println("1.Add Employee");
        System.out.println("2.Update Employee");
        System.out.println("3.Search Employee");
        System.out.println("4.Remove Employee");
        System.out.println("5.Back");
        System.out.println("6.Exit");

        choice = Integer.parseInt(input.nextLine());
        switch (choice){
            case 1:
                emp.addEmployee("Employee");
                employeeHandling();
                break;
            case 2:
                emp.updateEmployee();
                employeeHandling();
                break;
            case 3:
                emp.searchEmployee();
                employeeHandling();
                break;
            case 4:
                emp.removeEmployee();
                employeeHandling();
                break;
            case 5:
                menu();
                break;
            case 6:
                MainClass.Exit();
                break;
            default:
                System.out.println("****INCORRECT INPUT****");
                employeeHandling();

        }
    }

}
