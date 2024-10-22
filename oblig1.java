import java.util.Scanner;

public class oblig1 {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        int input;

        do {
            System.out.println("\nEnter ønsket funksjon:");
            System.out.println("\n1. Slette første element i listen.");
            System.out.println("2. Legge til et element i slutten av listen.");
            System.out.println("3. Slette et element fra slutten av listen.");
            System.out.println("4. Slette ønsket verdi fra listen.");
            System.out.println("5. Legge til et element etter et annet element med oppgitt verdi.");
            System.out.println("6. Legge til et element foran et element med oppgitt verdi.");
            System.out.println("7. Skrive ut lengden på listen.");
            System.out.println("8. Tell opp antall forekomster av ønsket verdi.");
            System.out.println("9. Skrive ut hele listen.");
            System.out.println("10. Slette hele listen.");
            System.out.println("11. G tidskomplesitet (Big O) for hver funksjon.");
            System.out.println("0. Avslutt.");
            System.out.println();

            input = scanner.nextInt();

            switch (input) {
                case 1:
                    linkedList.removeFirst();
                    break;

                case 2:
                    System.out.println("Skriv inn ønsket element: ");
                    int data = scanner.nextInt();
                    linkedList.addLast(data);
                    break;

                case 9:
                    System.out.println("Nodene printet ut er:");
                    linkedList.printList();
                    break;

                default:
                    break;
            }
        } while (input != 0);

        scanner.close();
    }
}

class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {

    private Node head = null;

    public void removeFirst() {
        if (head != null) {
            System.out.println("Du slettet node: " + head.data);
            head = head.next; // setter at neste node er head
        } else {
            System.out.println("Listen er tom");
        }
    }

    public void addLast(int data) {
        Node newNode = new Node(data); // oppretter ny node med gitt verdi data
        if (head == null) {
            head = newNode; // hvis listen er tom blir nye noden head
        } else {
            Node temp = head; // hvis listen  ikke er tom starter vi fra head
            while (temp.next != null) { // ittererer gjennom listen for å finne siste node
                temp = temp.next;
            }
            temp.next = newNode; //når siste node er funnet peker next på nye noden
        }
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("Listen er tom.");
        } else if (head.next == null) { // hvis det er bare en node blir den slettet
            head = null;
        } else {
            Node temp = head;
            while (temp.next != null) { // ittererer gjennom listen for å finne det siste elementet.
                temp = temp.next;
            }
            temp.next = null;
        }
    }

    public void printList() {
        Node temp = head;

        if (temp == null) {
            System.out.println("Listen er tom.");
            return;
        }

        while (temp != null) {  // Iterer så lenge temp ikke er null
            System.out.print(temp.data + " ");  // Skriver ut data i noden
            temp = temp.next;  // Går videre til neste node
        }
        System.out.println();  // Avslutt med linjeskift etter at hele listen er skrevet ut
    }
}
