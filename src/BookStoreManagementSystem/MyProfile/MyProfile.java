package BookStoreManagementSystem.MyProfile;

import BookStoreManagementSystem.User.Employee;

public class MyProfile {
    /*Display the details of employee*/
    public static void profile(Employee emp){
        System.out.println("----------Profile----------");
        System.out.println("ID : "+emp.getEmID());
        System.out.println("Role : "+emp.getEmRole());
        System.out.println("Name : "+emp.getEmName());
        System.out.println("Address : "+emp.getEmAddress());
        System.out.println("Date of Birth : "+emp.getEmDOB());
        System.out.println("Contact Number : "+emp.getEmContactNum());
        System.out.println("Salary : "+emp.getEmSalary());
        System.out.println("Password : "+emp.getEmPSW());
        System.out.println();

    }
}
