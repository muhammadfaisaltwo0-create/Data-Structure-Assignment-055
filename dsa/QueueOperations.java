import java.util.Scanner;
// Queue-based menu program simulating bank token numbers
public class QueueOperations {
    public static void main(String[] args) {
        final int MAX_SIZE = 10;   // fixed capacity
        int[] queue = new int[MAX_SIZE];
        int front = 0;
        int rear = -1;
        int count = 0;              // number of elements currently in queue
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println();
            System.out.println("----- QUEUE MENU -----");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Size");
            System.out.println("5. isEmpty");
            System.out.println("6. isFull");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                // 1. Enqueue - add a new token to the back of the queue
                case 1:
                    if (count >= MAX_SIZE) {
                        System.out.println("Overflow! Queue is full.");
                    } else {
                        System.out.print("Enter token number to enqueue: ");
                        int value = sc.nextInt();
                        rear = (rear + 1) % MAX_SIZE;   // wrap around if needed
                        queue[rear] = value;
                        count++;
                        System.out.println("Token " + value + " enqueued.");
                    }
                    break;
                // 2. Dequeue - remove and show the token at the front
                case 2:
                    if (count == 0) {
                        System.out.println("Underflow! Queue is empty.");
                    } else {
                        int removed = queue[front];
                        front = (front + 1) % MAX_SIZE; // wrap around if needed
                        count--;
                        System.out.println("Dequeued token: " + removed);
                    }
                    break;
                // 3. Display - show all tokens from front to rear
                case 3:
                    if (count == 0) {
                        System.out.println("Queue is empty.");
                    } else {
                        System.out.println("Queue elements (front to rear):");
                        for (int i = 0; i < count; i++) {
                            int idx = (front + i) % MAX_SIZE;
                            System.out.println("Position " + i + ": " + queue[idx]);
                        }
                    }
                    break;
                // 4. Size - number of tokens currently waiting
                case 4:
                    System.out.println("Current size: " + count + " (Capacity: " + MAX_SIZE + ")");
                    break;
                // 5. isEmpty - check if queue has no tokens
                case 5:
                    System.out.println(count == 0 ? "Queue is empty." : "Queue is not empty.");
                    break;
                // 6. isFull - check if queue has reached capacity
                case 6:
                    System.out.println(count == MAX_SIZE ? "Queue is full." : "Queue is not full.");
                    break;

                // 7. Exit - end the program
                case 7:
                    System.out.println("Exiting Queue program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 7);
    }
}
