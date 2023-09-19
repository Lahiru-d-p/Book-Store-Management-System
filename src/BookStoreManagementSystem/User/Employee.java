package BookStoreManagementSystem.User;

import BookStoreManagementSystem.DBConnector.DBClass;
import BookStoreManagementSystem.MyProfile.MyProfile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;


public class Employee {
    private String emID;
    private String emRole;
    private String emName;
    private String emAddress;
    private String emDOB;
    private String emContactNum;
    private String emSalary;
    private String emPSW;

    Scanner input = new Scanner(System.in);

    public Employee(){

    }

    public Employee(String ID){
        this.setEmID(ID);
    }

    public void setEmID(String emID) {
        this.emID = emID;
    }

    public void setEmRole(String emRole) {
        this.emRole = emRole;
    }

    public void setEmName(String emName) {
        this.emName = emName;
    }

    public void setEmAddress(String emAddress) {
        this.emAddress = emAddress;
    }

    public void setEmDOB(String emDOB) {
        this.emDOB = emDOB;
    }

    public void setEmContactNum(String emContactNum) {
        this.emContactNum = emContactNum;
    }

    public void setEmSalary(String emSalary) {
        this.emSalary = emSalary;
    }

    public void setEmPSW(String emPSW) {
        this.emPSW = emPSW;
    }

    public String getEmID() {
        return emID;
    }

    public String getEmRole() {
        return emRole;
    }

    public String getEmName() {
        return emName;
    }

    public String getEmAddress() {
        return emAddress;
    }

    public String getEmDOB() {
        return emDOB;
    }

    public String getEmContactNum() {
        return emContactNum;
    }

    public String getEmSalary() {
        return emSalary;
    }

    public String getEmPSW() {
        return emPSW;
    }

    public void addEmployee(String Role){
        System.out.print("Enter ID : ");
        this.setEmID(input.nextLine());
        /*check whether employee exists or not*/
        viewEmployee();
        if(this.getEmName()==null){
            /*get details from user*/
            getEmpDetails();
            this.setEmRole(Role);
            /*add details to database*/
            addItem();
            System.out.println("------"+ Role +" has bean added------\n");
        }
        else{
            System.out.println("****ALREADY EXISTS A "+ Role +" WITH THIS ID****\n");
        }
    }

    /*Add Employee details to database*/
    private void addItem(){
        try {
            Connection connection= DBClass.getConnection();
            PreparedStatement pt;
            String sql = "INSERT INTO EMPLOYEE VALUES(?,?,?,?,?,?,?,?)";
            assert connection != null;
            pt = connection.prepareStatement(sql);
            pt.setString(1,this.emID);
            pt.setString(2,this.emRole);
            pt.setString(3,this.emName);
            pt.setString(4,this.emAddress);
            pt.setString(5,this.emDOB);
            pt.setString(6,this.emContactNum);
            pt.setString(7,this.emSalary);
            pt.setString(8,this.emPSW);
            pt.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateEmployee(){
        System.out.print("Enter ID : ");
        this.setEmID(input.nextLine());
        /*check whether employee exists or not*/
        viewEmployee();
        if(this.getEmName()==null){
            System.out.println("****DOESN'T EXISTS A EMPLOYEE WITH THIS ID****\n");
        }
        else{
            /*get details from user*/
            System.out.print("Enter Roll(Manager or Employee) : ");
            this.setEmRole(input.nextLine());
            getEmpDetails();
            /*add details to database*/
            updateItem();
            System.out.println("------Employee has bean updated------\n");

        }
    }

    /*Update the details in database*/
    private void updateItem(){
        try {
            Connection connection= DBClass.getConnection();
            PreparedStatement pt;
            String sql = "UPDATE EMPLOYEE SET emRole=?,emName=?,emAddress=?,emDOB=?,emContactNum=?,emSalary=?,emPSW=? "
                    +"WHERE emID=?";
            assert connection != null;
            pt = connection.prepareStatement(sql);
            pt.setString(1,this.emRole);
            pt.setString(2,this.emName);
            pt.setString(3,this.emAddress);
            pt.setString(4,this.emDOB);
            pt.setString(5,this.emContactNum);
            pt.setString(6,this.emSalary);
            pt.setString(7,this.emPSW);
            pt.setString(8,this.emID);
            pt.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //This method will be take employee details from the user
    private void getEmpDetails(){
        System.out.print("Enter Name : ");
        this.setEmName(input.nextLine());
        System.out.print("Enter Address : ");
        this.setEmAddress(input.nextLine());
        System.out.print("Enter Date of Birth : ");
        this.setEmDOB(input.nextLine());
        System.out.print("Enter Contact Number : ");
        this.setEmContactNum(input.nextLine());
        System.out.print("Enter Salary : ");
        this.setEmSalary(input.nextLine());
        System.out.print("Enter Password : ");
        this.setEmPSW(input.nextLine());
    }

    public void searchEmployee(){
        System.out.print("Enter ID : ");
        this.setEmID(input.nextLine());

        viewEmployee();
        if (this.getEmName()==null){
            System.out.println("****DOESN'T EXISTS A EMPLOYEE WITH THIS ID****\n");
        }
        else
            MyProfile.profile(this);

    }

    /*Retrieve details of Employee from database*/
    public void viewEmployee(){
        try {
            Connection connection= DBClass.getConnection();
            PreparedStatement pt;
            String sql = "SELECT emRole,emName,emAddress,emDOB,emContactNum,emSalary,emPSW "
                    +"FROM EMPLOYEE WHERE emID=?";
            assert connection != null;
            pt = connection.prepareStatement(sql);
            pt.setString(1,this.emID);

            ResultSet rs = pt.executeQuery();
            if(rs.next()){
                this.emRole = rs.getString(1);
                this.emName = rs.getString(2);
                this.emAddress = rs.getString(3);
                this.emDOB = rs.getString(4);
                this.emContactNum = rs.getString(5);
                this.emSalary = rs.getString(6);
                this.emPSW = rs.getString(7);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*remove Employee from database*/
    public void removeEmployee(){
        System.out.print("Enter ID : ");
        this.setEmID(input.nextLine());
        try {
            Connection connection= DBClass.getConnection();
            PreparedStatement pt;
            String sql = "DELETE FROM EMPLOYEE WHERE emID=?";
            assert connection != null;
            pt = connection.prepareStatement(sql);
            pt.setString(1,this.emID);
            pt.executeUpdate();
            connection.close();
            System.out.println("-----Employee has bean Removed-----\n");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
