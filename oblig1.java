import java.util.Scanner;

public class oblig1 {

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        int input;
        int target;
        int value;
        

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
            System.out.println("11. G tidskompleksitet (Big O) for hver funksjon.");
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
                
                case 3:
                    linkedList.removeLast();
                    break;
                
                case 4:
                    System.out.println("Skriv node du ønsker slettet:");
                    value = scanner.nextInt();
                    linkedList.removeData(value);
                    break;
                
                case 5:
                    System.out.println("Skriv inn hvilken node du ønsker å sette verdi bak:");
                    target = scanner.nextInt();
                    System.out.println("Skriv inn verdi til ny node:");
                    value = scanner.nextInt();
                    linkedList.addAhead(target, value);
                    break;
                
                case 6:
                    System.out.println("Skrin inn node du ønsker å sette verdi forran");
                    target = scanner.nextInt();
                    System.out.println("Skriv inn verdi til ny node");
                    value = scanner.nextInt();
                    linkedList.addFirst(target, value);
                    break;

                case 7:
                    linkedList.listLength();
                    break;
                
                case 8:
                    System.out.println("Hvilken element ønsker du å finne antall forekomster: ");
                    target = scanner.nextInt();
                    System.out.println("\n" + "Antall forekomster av verdi " + target + " er " + linkedList.findInstances(target));
                    break;

                case 9:
                    System.out.println("Nodene printet ut er:\n");
                    linkedList.printList();
                    break;
                
                case 10:
                    System.out.println("Du sletter alle elementene i listen");
                    linkedList.removeAll();
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

    public void printNode(int value){
        System.out.println("╭-----------╮");
        System.out.println("|     "  + value + "     |");
        System.out.println("|-----------|");
        System.out.println("|   next    |");
        System.out.println("╰-----------╯");
        System.out.println("      V     ");

    }
    
    public void printList() {
        Node temp = head;

        if (temp == null) {
            System.out.println("Listen er tom.");
            return;
        }

        System.out.print("    HEAD\n");
        System.out.println("     V");
        while (temp != null) {  // iterer så lenge temp ikke er null
            
            printNode(temp.data);  // skriver ut data i noden
            temp = temp.next;  // går videre til neste node
        }
        System.out.println("     NULL");
        System.out.println("\n");  // avslutt med linjeskift etter at hele listen er skrevet ut
    }


    public void removeData(int value){
        if(head == null){
            System.out.println("Listen er tom."); // skjekker om listen er tom
            return; 
        }else if(head.data == value){
            head = head.next; // hvis hodet er ønsker verdi
        }

        Node temp = head;
        while(temp.next != null && temp.next.data != value){ //går gjennom listen til den finner ønsket node
            temp = temp.next;
        }
        if(temp.next != null){
            temp.next = temp.next.next; // når ønsket slettet node er funnet blir den koblet ut
        }
    }

    public void addAhead(int target, int value){
        if(head == null){
            System.out.println("Listen er tom."); // skjekker om listen er tom
            return;
        }else if(head.data == target){
            Node newNode = new Node(value); // lager ny node og setter dem
            head.next = newNode;
            return;
        }

        Node temp = head;
        while(temp.next != null && temp.next.data != target){
            temp = temp.next; // leter gjennom listen for å finne node
        }
        if(temp.next != null){
            Node newNode = new Node(value); // legger til 
            newNode.next = temp.next; // ny node peker på noden etter target
            temp.next = newNode; // nye node blir satt etter target
            return;
        }else{
            System.out.println("Verdien " + target + " finnes ikke i listen.");
        }
    }

    public void addFirst(int target, int value){
        Node temp = head;

        if(head == null){
            System.out.println("Listen er tom."); // ser om listen er tom
        }else if(head.data == target){
            
            Node newNode = new Node(value);
            newNode.next = head; // hvis target er head
            head = newNode;
            return;
        }
        while(temp.next != null && temp.next.data != target){
            temp = temp.next; // letter gjennom listen for å finne target
        }
        if(temp.next != null){
            Node newNode = new Node(value);
            newNode.next = temp.next; // når target er funnet setter vi nye node inn før target
            temp.next = newNode;
            return;
        }else{
            System.out.println("Noden " + target + " finnes ikke i listen."); // i tilfelle target ikke eksisterer
        }
    }

    public void listLength(){

        int counter = 0;

        if(head == null){
            System.out.println("Listen er tom."); // skjekker om listen er tom
            return;
        }

        Node temp = head;
        while(temp != null){
            temp = temp.next; // ittererer gjennom listen til den finner slutten
            counter++; // en teller som teller hvor mange elementer det er
        }

        System.out.println("\nListen er: " + counter + " element(er) lang.");
    }
    
    public int findInstances(int target){

        int counter = 0;

        Node temp = head;
        
        while(temp != null){
            if(temp.data == target){
                counter++;
                
            }
            temp = temp.next;
        }
        
        return counter;
    }

    public void removeAll(){
        int counter = 0;
        if(head == null){
            System.out.println("Listen er tom.");
        }
        while(head != null){
            head = head.next; // setter det slik at head bli neste element fram til head er lik null
            counter++; // har en counter som teller hvor mange elementer som ble slettet
        }
        System.out.println("Antall elementer slettet er: " + counter);
        
    }

}
