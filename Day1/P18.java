class UserData {
    private static UserData instance;
    private String username;

    private UserData() {
        username = "user123";
    }

    public static UserData getInstance() {
        if (instance == null) {
            instance = new UserData();
        }
        return instance;
    }

    public void displayUserData() {
        System.out.println("Username: " + username);
    }
}

public class Main {
    public static void main(String[] args) {
        UserData user = UserData.getInstance();
        user.displayUserData();
    }
}
