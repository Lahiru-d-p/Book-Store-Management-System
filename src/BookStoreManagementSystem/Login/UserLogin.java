package BookStoreManagementSystem.Login;
import BookStoreManagementSystem.HomeMenu.EmployeeMenu;
import BookStoreManagementSystem.HomeMenu.ManagerMenu;
import BookStoreManagementSystem.MainClass;
import BookStoreManagementSystem.User.Employee;

import java.util.Objects;
import java.util.Scanner;

public class UserLogin extends Login{
    Scanner input = new Scanner(System.in);
    Employee user = new Employee();
    private int i=0;
    public void  start(){
        login();
    }

    void login(){
        System.out.print("Enter Employee ID : ");
        user.setEmID(input.nextLine());

        user.viewEmployee();
        System.out.print("Enter employee Password : ");
        String getEmpPSW = input.nextLine();

        if(Objects.equals(getEmpPSW, user.getEmPSW())){
            if(Objects.equals(user.getEmRole(),"Manager")){
                ManagerMenu managerMenu = new ManagerMenu(user.getEmID());
                managerMenu.menu();
            }
            else{
                EmployeeMenu employeeMenu = new EmployeeMenu(user.getEmID());
                employeeMenu.menu();
            }
        }
        else {
            i++;
            System.out.println("****INCORRECT USER ID OR PASSWORD****\n");
            if(i<3) {
                System.out.println("********** TRY AGAIN ************\n");
                login();
            }
            else
                MainClass.welcomeToBookStoreManagementSystem();
        }
    }
}
