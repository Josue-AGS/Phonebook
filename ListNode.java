//  Name: Josue Gonzalez-Silva
//  Date: 7/26/24
//  Class CS 145
//  Assignment: Linked List
//  Purpose: To store and manage information about a single entry

public class ListNode {
    String name;
    String address;
    String city;
    String phoneNumber;
    ListNode next;

    // Constructor
    public ListNode(String name, String address, String city, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.next = null;
    }

    // Displays node information
    public void printNode() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("City: " + city);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("-----------------------------");
    }
}
