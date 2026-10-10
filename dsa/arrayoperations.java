import java.util.Scanner;

// Array-based menu program for managing book IDs on a library shelf
public class arrayoperations {
    static final int MAX_SIZE = 10;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] books = new int[MAX_SIZE];
        int size = 0;
        int choice;

        do {
            System.out.println("\n===== LIBRARY BOOK MANAGEMENT =====");
            System.out.println("1. Add value at end");
            System.out.println("2. Insert value at index");
            System.out.println("3. Fill the array");
            System.out.println("4. Delete last element");
            System.out.println("5. Delete by index");
            System.out.println("6. Display all elements");
            System.out.println("7. Search for a value");
            System.out.println("8. Get value at index");
            System.out.println("9. Update value");
            System.out.println("10. Show size");
            System.out.println("11. Exit");
            System.out.println("===================================");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                // 1. Add book ID to end
                case 1:
                    if (size == MAX_SIZE) {
                        System.out.println("Array is full.");
                    } else {
                        System.out.print("Enter book ID: ");
                        books[size] = input.nextInt();
                        size++;
                        System.out.println("Book ID added successfully.");
                    }
                    break;

                // 2. Insert book ID at index
                case 2:
                    if (size == MAX_SIZE) {
                        System.out.println("Array is full.");
                    } else {
                        System.out.print("Enter index (0 to " + size + "): ");
                        int index = input.nextInt();
                        if (index < 0 || index > size) {
                            System.out.println("Invalid index.");
                        } else {
                            System.out.print("Enter book ID: ");
                            int value = input.nextInt();
                            for (int i = size; i > index; i--) {
                                books[i] = books[i - 1];
                            }
                            books[index] = value;
                            size++;
                            System.out.println("Value inserted successfully.");
                        }
                    }
                    break;

                // 3. Fill the shelf with multiple book IDs
                case 3:
                    if (size == MAX_SIZE) {
                        System.out.println("Array is already full.");
                    } else {
                        char again;
                        do {
                            System.out.print("Enter book ID: ");
                            books[size] = input.nextInt();
                            size++;
                            if (size == MAX_SIZE) {
                                System.out.println("Array is now full.");
                                break;
                            }
                            System.out.print("Add another value? (y/n): ");
                            again = input.next().charAt(0);
                        } while (again == 'y' || again == 'Y');
                    }
                    break;

                // 4. Delete last book ID
                case 4:
                    if (size == 0) {
                        System.out.println("Array is empty.");
                    } else {
                        size--;
                        System.out.println("Last element deleted successfully.");
                    }
                    break;

                // 5. Delete book ID by index
                case 5:
                    if (size == 0) {
                        System.out.println("Array is empty.");
                    } else {
                        System.out.print("Enter index to delete: ");
                        int deleteIndex = input.nextInt();
                        if (deleteIndex < 0 || deleteIndex >= size) {
                            System.out.println("Invalid index.");
                        } else {
                            for (int i = deleteIndex; i < size - 1; i++) {
                                books[i] = books[i + 1];
                            }
                            size--;
                            System.out.println("Element deleted successfully.");
                        }
                    }
                    break;

                // 6. Display all book IDs
                case 6:
                    if (size == 0) {
                        System.out.println("Array is empty.");
                    } else {
                        System.out.print("Book IDs: ");
                        for (int i = 0; i < size; i++) {
                            System.out.print(books[i] + " ");
                        }
                        System.out.println();
                    }
                    break;

                // 7. Search for a book ID
                case 7:
                    System.out.print("Enter book ID to search: ");
                    int searchValue = input.nextInt();
                    boolean found = false;
                    for (int i = 0; i < size; i++) {
                        if (books[i] == searchValue) {
                            System.out.println("Book ID found at index " + i);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Book ID does not exist.");
                    }
                    break;

                // 8. Get book ID at index
                case 8:
                    System.out.print("Enter index: ");
                    int getIndex = input.nextInt();
                    if (getIndex < 0 || getIndex >= size) {
                        System.out.println("Invalid index.");
                    } else {
                        System.out.println("Value at index " + getIndex + " = " + books[getIndex]);
                    }
                    break;

                // 9. Replace/Update book ID at index
                case 9:
                    System.out.print("Enter index to update: ");
                    int updateIndex = input.nextInt();
                    if (updateIndex < 0 || updateIndex >= size) {
                        System.out.println("Invalid index.");
                    } else {
                        System.out.print("Enter new book ID: ");
                        books[updateIndex] = input.nextInt();
                        System.out.println("Value updated successfully.");
                    }
                    break;

                // 10. Show current size
                case 10:
                    System.out.println("Current size: " + size);
                    break;

                // 11. Exit program
                case 11:
                    System.out.println("Program exited successfully.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 11);

        input.close();
    }
}