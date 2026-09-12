package Week_6.class_problems;


class LibraryCard {

    String studentName;
    String cardId;

    LibraryCard(String studentName, String cardId) {
        this.studentName = studentName;
        this.cardId = cardId;
    }

    void displayCard() {
        System.out.println("Name: " + studentName);
        System.out.println("Card ID: " + cardId);
    }
}

public class LibraryIDCardManagement {

    public static void main(String[] args) {

        LibraryCard card1 =
                new LibraryCard("Pavithra", "LIB101");

        LibraryCard card2 = card1;

        LibraryCard card3 =
                new LibraryCard("Pavithra", "LIB101");

        card1.displayCard();

        System.out.println("card1 == card2: " +
                (card1 == card2));

        System.out.println("card1 == card3: " +
                (card1 == card3));
    }
}