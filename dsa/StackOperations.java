import java.util.Scanner;
// Stack-based menu program simulating a pile of plates 
public class StackOperations {
    public static void main(String[] args) {
        final int MAX_SIZE = 10;   // fixed capacity
        int[] stack = new int[MAX_SIZE];
        int top = -1;              // -1 means empty
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println();
            System.out.println("----- STACK MENU -----");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Size");
            System.out.println("5. isEmpty");
            System.out.println("6. isFull");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                // 1. Push - add a new plate on top
                case 1:
                    if (top >= MAX_SIZE - 1) {
                        System.out.println("Overflow! Stack is full.");
                    } else {
                        System.out.print("Enter value to push: ");
                        int value = sc.nextInt();
                        top++;
                        stack[top] = value;
                        System.out.println("Value " + value + " pushed onto stack.");
                    }
                    break;
                // 2. Pop - remove and show the top plate
                case 2:
                    if (top == -1) {
                        System.out.println("Underflow! Stack is empty.");
                    } else {
                        int removed = stack[top];
                        top--;
                        System.out.println("Popped value: " + removed);
                    }
                    break;
                // 3. Display - show all plates
                case 3:
                    if (top == -1) {
                        System.out.println("Stack is empty.");
                    } else {
                        System.out.println("Stack elements (top to bottom):");
                        for (int i = top; i >= 0; i--) {
                            System.out.println("Index " + i + ": " + stack[i]);
                        }
                    }
                    break;
                // 4. Size - number of plates currently stacked
                case 4:
              System.out.println("Current size: " + (top + 1) + " (Capacity: " + MAX_SIZE + ")");
                    break;
                // 5. isEmpty - check if stack has no plates
                case 5:
                    System.out.println(top == -1 ? "Stack is empty." : "Stack is not empty.");
                    break;
                // 6. isFull - check if stack has reached capacity
                case 6:
                    System.out.println(top == MAX_SIZE - 1 ? "Stack is full." : "Stack is not full.");
                    break;
                // 7. Exit - end the program
                case 7:
                    System.out.println("Exiting Stack program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);
    }
}