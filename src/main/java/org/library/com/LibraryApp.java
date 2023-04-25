package org.library.com;

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        System.out.println("Welcome to the Neighborhood Library!\n Main Menu");
        System.out.println("1,Show available books");
        System.out.println("2, Show Checked out books");
        System.out.println("3, Exit");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        if (userInput.equals("1")) {
            showBook();

        } else if (userInput.equals("2")) {
            checkedOutBooks();
        }
    }

    public static void showBook() {
        System.out.println("Here are our available books:");

        //show the user the books
        //Ask user to enter their preferred book's book ID
        //Read users selection
        Book[] bookInventory = BookInventory.bookInventory;
        for (Book i : bookInventory) {
            //
            if (i.isCheckedOut()) continue;
            System.out.println(i.getId() + " " + i.getIsbn() + " " + i.getTitle());
        }

        Scanner scanner = new Scanner(System.in);
        boolean checkedOut = false;
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

        for (Book i : bookInventory) {
            if (selectedTitle.equals(i.getTitle())) {
                System.out.println("What is your name?");
                String name = scanner.nextLine();
                i.setCheckedOut(true);
                i.checkOut(name);
                System.out.println("Ok, " + name + ", " + selectedTitle + " is now checked out.");
                break;
            } else if (selectedIsbn.equals(i.getIsbn())) {
                System.out.println("What is your name?");
                String name = scanner.nextLine();
                i.setCheckedOut(true);
                i.checkOut(name);
                System.out.println("Ok, " + name + ", " + selectedTitle + " is now checked out.");
                break;
            } else if (selectedTitle.equals("EXIT")) {
                main(null);
            }
        }

        main(null);
    }

    public static void checkedOutBooks() {
        Book[] bookInventory = BookInventory.bookInventory;
        System.out.println("Here are the books that are currently checked out: ");
        System.out.println();
        for (Book i : bookInventory) {
            if (i.isCheckedOut()) {
                System.out.println(i.getId() + " " + i.getIsbn() + " " + i.getTitle());
            }
        }

    }
}
