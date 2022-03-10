package circular;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Declare and initialize variables
        Catalogue catalogue = new Catalogue(10);
        boolean running = true;

        while (running) {
            System.out.println("----------MAIN MENU----------");
            System.out.print("""
                    1. Display catalogue
                    2. Display available items
                    3. Add item to catalogue
                    4. Mark item as rented
                    5. Mark item as returned
                    6. Create new catalogue
                    7. Quit application
                                        
                    ~\t""");

            // Get user input
            Scanner sc = new Scanner(System.in);
            int menuInput = sc.nextInt();
            sc.nextLine();

            // Choice-based Scripts
            switch (menuInput) {
                case 1 -> {
                    Item[] allItems = catalogue.getFullList();
                    boolean empty = true;
                    for (int i = 0; i < allItems.length; i++) {
                        if (allItems[i] != null) {
                            empty = false;
                            break;
                        }
                    }
                    if (!empty) {
                        for (int i = 0; i < allItems.length; i++) {
                            if (!(allItems[i] == null)) {
                                System.out.println(allItems[i]);
                            }
                        }
                    } else {
                        System.out.println("There are no items in catalogue");
                    }
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                }
                case 2 -> {
                    Item[] availableItems = catalogue.getAvailableItems();
                    boolean empty = availableItems.length == 0;

                    if (!empty) {
                        displayItemList(availableItems);
                    } else {
                        System.out.println("There are no available items");
                    }
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                }
                case 3 -> {
                    System.out.print("Type item category: ");
                    String itemCat = sc.nextLine();
                    System.out.print("Type item description: ");
                    String itemDesc = sc.nextLine();
                    Item itemTmp = new Item(itemCat, itemDesc);
                    catalogue.addItem(itemTmp);
                }
                case 4 -> {
                    System.out.println("----------ITEM LIST----------");
                    Item[] allItems = catalogue.getFullList();
                    displayItemList(allItems);
                    System.out.print("Choose which machine to mark as rented: ");
                    int rented = sc.nextInt();
                    sc.nextLine();
                    catalogue.borrowItem(catalogue.getFullList()[rented - 1]);
                    System.out.println(catalogue.getFullList()[rented - 1].getDescription() + " was marked as unavailable");
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                }
                case 5 -> {
                    System.out.println("----------ITEM LIST----------");
                    Item[] allItems = catalogue.getFullList();
                    displayItemList(allItems);
                    System.out.print("Choose which item to mark as returned: ");
                    int returned = sc.nextInt();
                    sc.nextLine();
                    catalogue.returnItem(catalogue.getFullList()[returned - 1]);
                    System.out.println(catalogue.getFullList()[returned - 1].getDescription() + " was marked as available");
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                }
                case 6 -> {
                    System.out.print("Input catalogue size: ");
                    int catSize = sc.nextInt();
                    catalogue = new Catalogue(catSize);
                }
                case 7 -> running = false;
            }
        }

        // Closing message
        System.out.println("Closing application...");
    }

    private static void displayItemList(Item[] itemList) {

        for (int i = 0; i < itemList.length; i++) {
            if(!(itemList[i] == null)) {
                System.out.print(i + 1 + ". ");
                System.out.println(itemList[i]);
            }
        }
    }
}