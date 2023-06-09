package GanzZahlArithmetik;

import java.io.*;

public class GanzZahl00LinkLis {

    private Node head;
    private Node tail;
    private boolean positive;

    public GanzZahl00LinkLis() {
        positive = true;
    }

    private class Node {
        byte element;
        Node next;
        Node prev;

        public Node(byte element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public boolean isEmpty() { return head == null; }

    public boolean isPositive() { return positive; }

    public void setPositive(boolean sgn) { positive = sgn; }

    public void addFirst(byte element) {
        Node tmp;

        //TODO:Füge neue Ziffer am Anfang der Zahl hinzu.
        tmp = new Node(element, head, null);
        if (head != null) {
            head.prev = tmp;
        }
        head = tmp;
        if(tail == null) {
            tail = tmp;
        }

        System.out.println("hinzufügen: "+element);
    }

    public void addLast(byte element) {
        Node tmp;

        //TODO:Füge neue Ziffer am Ende der Zahl hinzu.
        tmp = new Node(element, null, tail);
        if (tail != null) {
            tail.next = tmp;
        }
        tail = tmp;
        if(head == null) {
            head = tmp;
        }

        System.out.println("hinzufügen: "+element);
    }

    public void iterateForward(){
        System.out.println("Durchlauf vorwärts..");
        Node tmp;

        //TODO:Gebe alle Ziffern von vorne nach hinten aus.
        tmp = head;
        while (tmp != null) {
            System.out.println(tmp.element);
            tmp = tmp.next;
        }

    }

    public void iterateBackward(){
        System.out.println("Durchlauf rückwärts..");
        Node tmp;

        //TODO:Gebe alle Ziffern von hinten nach vorne aus.
        tmp = tail;
        while (tmp != null) {
            System.out.println(tmp.element);
            tmp = tmp.prev;
        }

    }

    public byte removeFirst() {
        Node tmp;
        // ??? --> tmp=new Node((byte)127,null,null);

        //TODO:Lösche erste Ziffer.
        if (head == null) {
            System.err.println("Leer");
            System.exit(-1);
        }
        tmp = head;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        if (tmp == tail) {
            tail = null;
        }


        System.out.println("gelöscht: "+tmp.element);
        return tmp.element;
    }

    public byte removeLast() {
        Node tmp;
        // ??? --> tmp=new Node((byte)127,null,null);

        //TODO:Lösche erste Ziffer.
        if (tail == null) {
            System.err.println("Leer");
            System.exit(-1);
        }
        tmp = tail;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        }

        if (tmp == head) {
            head = null;
        }

        System.out.println("gelöscht: "+tmp.element);
        return tmp.element;
    }

    public static void main(String a[]) throws IOException{

        GanzZahl00LinkLis dll = new GanzZahl00LinkLis();
        System.out.println("ist leer: "+dll.isEmpty());
        dll.addFirst((byte)10);
        dll.addFirst((byte)34);
        dll.addLast((byte)56);
        dll.addLast((byte)36);
        dll.iterateForward();
        dll.removeFirst();
        dll.removeLast();
        dll.iterateBackward();
        System.out.println("ist leer: "+dll.isEmpty());

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        byte digit =0;
        String input="";
        System.out.println("Zahl eingeben:\n");
        input = br.readLine();
        System.out.println("Eingabe war: " + input);
        GanzZahl00LinkLis extern = new GanzZahl00LinkLis();
        if (input.charAt(0) == '-'){ extern.setPositive(false); }
        for (int i = 1; i < input.length(); i++){
            char c = input.charAt(i);
            digit = (byte)Character.getNumericValue(c);
            extern.addLast(digit);
            System.out.println(digit);
        }
        System.out.println("Ist Eingabe positiv: " + extern.isPositive());
        extern.iterateForward();

    }
}
