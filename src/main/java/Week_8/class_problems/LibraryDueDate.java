package Week_8.class_problems;

import java.time.LocalDate;
import java.util.Scanner;

class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    int getLoanDays() {
        return 0;
    }

    LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(getLoanDays());
    }
}

class Book extends LibraryItem {

    Book(String title) {
        super(title);
    }

    int getLoanDays() {
        return 14;
    }
}

class DVD extends LibraryItem {

    DVD(String title) {
        super(title);
    }

    int getLoanDays() {
        return 7;
    }
}

class Magazine extends LibraryItem {

    Magazine(String title) {
        super(title);
    }

    int getLoanDays() {
        return 3;
    }
}

public class LibraryDueDate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String[] parts = line.split(" ", 2);

            String type = parts[0];
            String title = parts[1].replace("\"", "");

            LibraryItem item;

            if (type.equals("BOOK")) {
                item = new Book(title);
            } else if (type.equals("DVD")) {
                item = new DVD(title);
            } else {
                item = new Magazine(title);
            }

            LocalDate dueDate = item.getDueDate(currentDate);

            System.out.println(title + ": " + dueDate);
        }

        sc.close();
    }
}