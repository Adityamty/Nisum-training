import java.util.*;

public class SimpleStackWithArrayDeque {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("""
                1. Push
                2. Pop
                3. Peek
                4. Display
                0. Exit
                Enter choice: """);
            String choice = sc.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.print("Enter number to push: ");
                    stack.push(Integer.parseInt(sc.nextLine()));
                    System.out.println("Pushed.\n");
                }
                case "2" -> {
                    if (stack.isEmpty()) System.out.println("Stack is empty.\n");
                    else System.out.println("Popped: " + stack.pop() + "\n");
                }
                case "3" -> {
                    if (stack.isEmpty()) System.out.println("Stack is empty.\n");
                    else System.out.println("Top element: " + stack.peek() + "\n");
                }
                case "4" -> {
                    if (stack.isEmpty()) System.out.println("Stack is empty.\n");
                    else System.out.println("Stack contents: " + stack + "\n");
                }
                case "0" -> {
                    System.out.println("Exiting.");
                    return;
                }
                default -> System.out.println("Invalid choice.\n");
            }
        }
    }
}
