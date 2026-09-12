package week6;

import java.util.Scanner;

public class LibraryIDCardManagement {

    static class IdCard {

        String name;
        int booksIssued;

        IdCard(String name, int booksIssued) {
            this.name = name;
            this.booksIssued = booksIssued;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter books issued: ");
        int booksIssued = sc.nextInt();

        IdCard ravi = new IdCard(name, booksIssued);

        IdCard duplicate = ravi;

        duplicate.booksIssued = 3;

        IdCard separate = new IdCard(name, 3);

        System.out.println(ravi.name
                + "'s booksIssued (via first variable): "
                + ravi.booksIssued);

        System.out.println("duplicate == ravi: "
                + (duplicate == ravi));

        System.out.println("separate == ravi: "
                + (separate == ravi));
    }
}