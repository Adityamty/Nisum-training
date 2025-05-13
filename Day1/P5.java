public class UserDetails {
    public String name;
    public String id;
    public String email;
    private String password;
    private String creditCard;
    private double creditCardBalance;

    public UserDetails(String name, String id, String email, String password, String creditCard, double creditCardBalance) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.password = password;
        this.creditCard = creditCard;
        this.creditCardBalance = creditCardBalance;
    }

    public String getMaskedCard() {
        return "**** **** **** " + creditCard.substring(creditCard.length() - 4);
    }

    public double getCreditCardBalance() {
        return creditCardBalance;
    }
}
