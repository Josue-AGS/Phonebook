//  Name: Josue Gonzalez-Silva
//  Date: 7/27/24
//  Class CS 145
//  Assignment: Linked List
//  Purpose: To act as a controller for a phonebook, allows user to perform operations on a list of contacts stored in a linked list format

public class PhonebookManager {
    private ListNode head;

    // Constructor
    public PhonebookManager() {
        this.head = null;
    }

    // Adds a new entry to the end of the list
    public void addEntry(String name, String address, String city, String phoneNumber) {
        ListNode newNode = new ListNode(name, address, city, phoneNumber);
        if (head == null) {
            head = newNode;
        }   else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Sorts the list alphabetically by last name
    public void sortByName() {
        head = mergeSort(head);
        if (head == null || head.next == null) return;

        boolean swapped;
        do {
            swapped = false;
            ListNode current = head;
            ListNode prev = null;

            while (current.next != null) {
                if (current.name.compareTo(current.next.name) > 0) {
                    // Swap the nodes
                    if (prev != null) {
                        prev.next = current.next;
                    } else {
                        head = current.next;
                    }
                    ListNode temp = current.next.next;
                    current.next.next = current;
                    current.next = temp;
                    swapped = true;
                }
                prev = current;
                current = current.next;
            }
        } while (swapped);
    }

    // Modifies an entry
    public void modifyEntry(String oldName, String newName, String newAddress, String newCity, String newPhoneNumber) {
        ListNode current = head;
        while (current != null) {
            if (current.name.equals(oldName)) {
                current.name = newName;
                current.address = newAddress;
                current.city = newCity;
                current.phoneNumber = newPhoneNumber;
                return;
            }
            current = current.next;
        }
        System.out.println("Entry with name " + oldName + " not found.");
    }

    // Deletes an entry
    public void deleteEntry(String name) {
        if (head == null) return;
    
        if (head.name.equals(name)) {
            head = head.next;
            System.out.println("Entry with name " + name + " deleted.");
            return;
        }
    
        ListNode current = head;
        while (current.next != null && !current.next.name.equals(name)) {
            current = current.next;
        }
    
        if (current.next != null) {
            current.next = current.next.next;
            System.out.println("Entry with name " + name + " deleted.");
        } else {
            System.out.println("Entry with name " + name + " not found.");
        }
    }

    // Prints the list
    public void printList() {
        ListNode current = head;
        while (current != null) {
            current.printNode();
            current = current.next;
        }
    }

    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMiddle(head);
        ListNode nextOfMiddle = middle.next;
        middle.next = null;
        
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(nextOfMiddle);
        
        return sortedMerge(left, right);
    }

    private ListNode getMiddle(ListNode head) {
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode sortedMerge(ListNode left, ListNode right) {
        if (left == null) return right;
        if (right == null) return left;

        if (left.name.compareTo(right.name) <= 0) {
            left.next = sortedMerge(left.next, right);
            left.next.next = null;
            return left;
        } else {
            right.next = sortedMerge(left, right.next);
            right.next.next = null;
            return right;
        }
    }

}
