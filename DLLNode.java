package com.tutorial.linkedlist;

public class DLLNode {

    // Struktur Double Linked List
    private Node head;
    private Node tail;
    private int size;
    public DLLNode() {
        this.size = 0;
    }

    // Method tambah data awal
    public void insertFirst(int val) {
        Node node = new Node(val);

        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
        size++;
    }

    // Method tambah data akhir
    public void insertLast(int val) {
        Node node = new Node(val);
        node.next = null;
        node.prev = tail;
        if (tail != null) {
            tail.next = node;
        }
        tail = node;
        if (head == null) {
            head = node;
        }
        size++;
    }

    // Method tambah data setelah data input
    public void insertAfterValue(int after, int val) {
        Node target = find(after);

        if (target == null) {
            System.out.println("Data input tidak ditemukan!");
            return;
        }

        Node node = new Node(val);

        node.next = target.next;
        target.next = node;
        node.prev = target;
        if (node.next != null) {
            node.next.prev = node;
        }
        size++;
    }

    // Method tambah data sebelum data input
    public void insertBeforeValue(int before, int val) {
        Node target = find(before);

        if (target == null) {
            System.out.println("Data input tidak ditemukan!");
            return;    
        }

        Node node = new Node(val);
        node.prev = target.prev;
        target.prev = node;
        node.next = target;

        if (node.prev != null) {
            node.prev.next = node;
        } else {
            head = node;
        }

    }

    // Method menghapus data awal
    public Node deleteFirst() {
        if (size == 0) {
            System.out.println("List masih kosong");
        }
        Node temp = head;
        head = head.next;
        head.prev = null;
        size--;
        return temp;
    }

    // Method menghapus data akhir
    public Node deleteLast() {
        if (size == 0) {
            throw new RuntimeException("List masih kosong");
        }
        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        return temp;
    }

    // Method menghapus node tertentu sesuai input
    public void deleteSelectionValue(int del_val) {
        Node target = find(del_val);

        if (target == null) {
            System.out.println("Data input tidak ditemukan");
        }

        if (target.next != null && target.prev != null) {
            target.prev.next = target.next;
            target.next.prev = target.prev;
        }

        if (target.next == null) {
            tail = target.prev;
            target.prev.next = null;
        } else if (target.prev == null) {
            head = target.next;
            target.next.prev = null;
        }

        size--;
    }

    // Method pencarian data node
    public Node find(int value) {
        Node node = head;
        while (node != null) {
            if (node.val == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    // Method mendapatkan data berdasarkan index
    public Node get(int index) {
        Node node = head;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    // Method display size
    public void displaySize() {
        System.out.println("Size : " + size);
    }

    // Method display hasil pencarian
    public int displayFind(int val) {
        Node node = find(val);
        System.out.println("Data : " + node.val + " ditemukan");

        return val;
    }

    // Print out tampilan maju
    public void displayForward() {
        Node node = head;
        
        if (node == null && size == 0) {
            System.out.println("Linked list masih kosong");
        }

        while(node != null) {
            System.out.print(node.val + " -- ");
            node = node.next;
        }
        System.out.println("AKHIR");
    }

    // Print out tampilan mundur
    public void displayBackward() {
        Node node = head;
        Node last = null;

        if (node == null && size == 0) {
            System.out.println("Linked list masih kosong");
        }

        while (node != null) {
            last = node;
            node = node.next;
        }

        while (last != null) {
            System.out.print(last.val + " -- ");
            last = last.prev;
        }
        System.out.println("AWAL");
    }

    // Struktur node
    private class Node {
        private int val;
        private Node prev;
        private Node next;

        // Constructor
        public Node(int val) {
            this.val = val;
        }
    }


}
