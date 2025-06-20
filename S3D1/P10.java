public class LayeredErrorHandlingApp {
    static class DataAccessException extends Exception {
        public DataAccessException(String message) {
            super(message);
        }
    }

    static class BusinessServiceException extends Exception {
        public BusinessServiceException(String message, Throwable cause) {
            super(message, cause);
        }
    }
    static class Repository {
        public String fetchDataById(int id) throws DataAccessException {
            if (id < 0) {
                throw new DataAccessException("Invalid ID: cannot fetch data for negative ID.");
            }
            return "Data for ID: " + id;
        }
    }
    static class Service {
        private final Repository repository = new Repository();

        public String processRequest(int id) throws BusinessServiceException {
            try {
                String data = repository.fetchDataById(id);
                return "Processed: " + data;
            } catch (DataAccessException e) {
                throw new BusinessServiceException("Failed to process request in Service layer.", e);
            }
        }
    }
    static class Controller {
        private final Service service = new Service();

        public void handleRequest(int id) {
            try {
                String response = service.processRequest(id);
                System.out.println("Response: " + response);
            } catch (BusinessServiceException e) {
                System.out.println("Exception caught in Controller:");
                System.out.println("Message: " + e.getMessage());
                System.out.println("Caused by: " + e.getCause().getMessage());
            }
        }
    }
    public static void main(String[] args) {
        Controller controller = new Controller();

        System.out.println("=== Valid Request ===");
        controller.handleRequest(5); 

        System.out.println("\n=== Invalid Request ===");
        controller.handleRequest(-10); 
    }
}
