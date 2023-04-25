package org.library.com;
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Neighborhood Library! \nHere are our available books:");
        //show the user the books
        //Ask user to enter their preferred book's book ID
        //Read users selection
        Book[] bookInventory = BookInventory.bookInventory;
        for (Book i : bookInventory) {
            //
            if (i.isCheckedOut()) continue;
                System.out.println(i.getId() + " " + i.getIsbn() + " " + i.getTitle());
        }
        System.out.println("Here are the books that are currently checked out: ");
        System.out.println();
        for (Book i : bookInventory) {
            if (i.isCheckedOut()) System.out.println(i.getId() + " " + i.getIsbn() + " " + i.getTitle());
        }
        Scanner scanner = new Scanner(System.in);
        boolean checkedOut = false;
        do {
            System.out.printf("Which book would you like to check out? (Type in title or ISBN) \nOr you can exit typing EXIT. \n");

            // Read users response
            //See if book is available
            //If it is available, tell user it ready for check out
            //Request users name
            //Set the book to is checked out
            //checkedOutTo var
            String consoleInput = scanner.nextLine();

            String selectedTitle = consoleInput;
            String selectedIsbn = consoleInput;
            Book selectedBook = null;

            for (Book i : bookInventory) {
                if (selectedTitle.equals(i.getTitle())) {
                    selectedBook = i;
                    System.out.println("What is your name?");
                    String name = scanner.nextLine();
                    Book.setCheckedOut(Boolean.parseBoolean(name));
                    checkedOut = true;
                    Book.setCheckedOut(true);
                    System.out.println("Ok, " + name + ", " + selectedTitle + " is now checked out.");
                    break;
                } else if (selectedIsbn.equals(i.getIsbn())) {
                    selectedBook = i;
                    System.out.println("What is your name?");
                    String name = scanner.nextLine();
                    Book.setCheckedOut(Boolean.parseBoolean(name));
                    checkedOut = true;
                    Book.setCheckedOut(true);
                    System.out.println("Ok, " + name + ", " + selectedTitle + " is now checked out.");
                    break;
                } else if (selectedTitle.equals("EXIT")) {
                    return;
                }
            }
        }while (!checkedOut);





    }
}
