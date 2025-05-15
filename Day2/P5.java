import java.util.Stack;

class BrowserHistory {
    private Stack<String> history = new Stack<>();

    public void visitPage(String url) {
        history.push(url);
        System.out.println("Visited: " + url);
    }

    public void goBack() {
        if (!history.isEmpty()) {
            System.out.println("Going back to: " + history.pop());
        } else {
            System.out.println("No history available.");
        }
    }

    public void viewCurrentPage() {
        System.out.println(history.isEmpty() ? "No current page." : "Current page: " + history.peek());
    }

    public void viewHistory() {
        System.out.println("Full History:");
        history.forEach(System.out::println);
    }
}

public class BrowserHistoryDemo {
    public static void main(String[] args) {
        BrowserHistory browser = new BrowserHistory();
        browser.visitPage("https://example.com");
        browser.visitPage("https://github.com");
        browser.viewCurrentPage();
        browser.goBack();
        browser.viewCurrentPage();
        browser.viewHistory();
    }
}
