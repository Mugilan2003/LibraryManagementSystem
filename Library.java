package rePractice;

import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Book> books = new ArrayList<>();
    private List<User> users = new ArrayList<>();

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
    }

    public void addUser(int id, String name) {
        users.add(new User(id, name));
    }

    public void listAllBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void listIssuedBooks() {
        for (Book book : books) {
            if (book.isIssued()) {
                System.out.println(book);
            }
        }
    }

    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
				return user;
			}
        }
        return null;
    }

    public void issueBook(int userId, String title) {
        User user = getUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isIssued()) {
                book.issue();
                user.borrowBook(book);
                System.out.println("Book issued to " + user.getName());
                return;
            }
        }
        System.out.println("Book not available.");
    }

    public void returnBook(int userId, String title) {
        User user = getUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        for (Book book : user.getBorrowedBooks()) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.returnBook();
                user.returnBook(book);
                System.out.println("Book returned by " + user.getName());
                return;
            }
        }
        System.out.println("This user hasn't borrowed that book.");
    }
}
