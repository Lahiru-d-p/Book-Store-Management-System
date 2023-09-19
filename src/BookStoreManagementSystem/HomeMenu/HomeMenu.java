package BookStoreManagementSystem.HomeMenu;

import BookStoreManagementSystem.Book.Book;
import BookStoreManagementSystem.Inventory.Inventory;
import BookStoreManagementSystem.MainClass;
import java.util.Scanner;

public class HomeMenu {
    Scanner input = new Scanner(System.in);
    int choice;

    public void menu() {
        Inventory inventory = new Inventory();
        inventory.getTotalItemCount();
        inventory.getCategoryItemCount();
        inventory.getStockStatus();
    }



    void bookHandling(){
        Book book= new Book();
        System.out.println("----------Book Handling----------");
        System.out.println("1.Add Book");
        System.out.println("2.Search Book");
        System.out.println("3.Update Book");
        System.out.println("4.Remove Book");
        System.out.println("5.Back");
        System.out.println("6.Exit");

        choice = Integer.parseInt(input.nextLine());
        switch (choice){
            case 1:
                book.addBook();
                bookHandling();
                break;
            case 2:
                book.searchBook();
                bookHandling();
                break;
            case 3:
                book.updateBook();
                bookHandling();
                break;
            case 4:
                book.removeBook();
                bookHandling();
                break;
            case 5:
                menu();
                break;
            case 6:
                MainClass.Exit();
            default:
                System.out.println("****INCORRECT INPUT****");
                bookHandling();
        }
    }


}
