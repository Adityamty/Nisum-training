sealed class PaymentException extends Exception
        permits InvalidPaymentMethodException, InvalidOfferAppliedException {
    public PaymentException(String message) {
        super(message);
    }
}
final class InvalidPaymentMethodException extends PaymentException {
    public InvalidPaymentMethodException(String message) {
        super(message);
    }
}
final class InvalidOfferAppliedException extends PaymentException {
    public InvalidOfferAppliedException(String message) {
        super(message);
    }
}
class PaymentService {

    public void paymentMethod(String paymentType, String offer) throws PaymentException {
        if (!paymentType.equalsIgnoreCase("CreditCard") && !paymentType.equalsIgnoreCase("UPI")) {
            throw new InvalidPaymentMethodException("Unsupported payment method: " + paymentType);
        }

        if (offer != null && !offer.equalsIgnoreCase("DISCOUNT10") && !offer.equalsIgnoreCase("NONE")) {
            throw new InvalidOfferAppliedException("Invalid offer applied: " + offer);
        }

        System.out.println("Payment processed successfully with " + paymentType +
                           (offer.equalsIgnoreCase("NONE") ? "" : " using offer " + offer));
    }
    public void processPaymentMethod(String paymentType, String offer) {
        try {
            paymentMethod(paymentType, offer);
        } catch (PaymentException e) {
            switch (e) {
                case InvalidPaymentMethodException ipme -> 
                    System.out.println("Error: " + ipme.getMessage());
                case InvalidOfferAppliedException ioae -> 
                    System.out.println("Error: " + ioae.getMessage());
                default -> 
                    System.out.println("Unknown payment error: " + e.getMessage());
            }
        }
    }
}
public class PaymentApp {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        service.processPaymentMethod("UPI", "DISCOUNT10");    
        service.processPaymentMethod("Cash", "NONE");          
        service.processPaymentMethod("CreditCard", "OFFER50"); 
    }
}
