//  Name: Josue Gonzalez-Silva
//  Date: 7/29/24
//  Class CS 145
//  Assignment: Link List
//  Purpose: To test or demonstration class

public class TestClass {
    public static void main(String[] args) {
        PhonebookManager pbm = new PhonebookManager();

        // Adding entries
        pbm.addEntry("John Deer", "1228 Elm St", "Bellingham", "333-546-9870");
        pbm.addEntry("Boe Jim", "731 Oak St", "Seattle", "887-654-3210");
        pbm.addEntry("Alice Wonder", "159 Pine St", "Bellingham", "446-789-0123");

        // Print initial list
        System.out.println("Initial Phone Book:");
        pbm.printList();

        // Sort by name
        pbm.sortByName();
        System.out.println("Sorted Phone Book:");
        pbm.printList();

        // Modify an entry
        pbm.modifyEntry("John Deer", "Johnathan Deer", "453 Elm St", "Bellingham", "101-212-3593");
        System.out.println("Phone Book After Modification:");
        pbm.printList();

        // Delete an entry
        pbm.deleteEntry("Boe Jim");
        System.out.println("Phone Book After Deletion:");
        pbm.printList();
    }


    
}
