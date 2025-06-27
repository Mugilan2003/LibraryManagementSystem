package rePractice;

import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);


        library.addBook("Java Basics", "James Gosling");
        library.addBook("OOP in Java", "Grady Booch");
        library.addUser(1, "Ram");
        library.addUser(2, "Aakash");
        library.addUser(2, "Swetha");

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. View All Books");
            System.out.println("2. View Issued Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Add Book");
            System.out.println("6. Add User");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    library.listAllBooks();
                    break;
                case 2:
                    library.listIssuedBooks();
                    break;
                case 3:
                    System.out.print("Enter User ID: ");
                    int issueUserId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String issueTitle = sc.nextLine();
                    library.issueBook(issueUserId, issueTitle);
                    break;
                case 4:
                    System.out.print("Enter User ID: ");
                    int returnUserId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String returnTitle = sc.nextLine();
                    library.returnBook(returnUserId, returnTitle);
                    break;
                case 5:
                    System.out.print("Enter Book Title: ");
                    String newTitle = sc.nextLine();
                    System.out.print("Enter Author Name: ");
                    String newAuthor = sc.nextLine();
                    library.addBook(newTitle, newAuthor);
                    break;
                case 6:
                    System.out.print("Enter User ID: ");
                    int newUserId = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter User Name: ");
                    String newUserName = sc.nextLine();
                    library.addUser(newUserId, newUserName);
                    break;
                case 7:
                    System.out.println("Exiting system....");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
