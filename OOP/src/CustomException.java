public class CustomException extends Exception {
    public CustomException(){
        super("Error: An error occurred");
    }

    public CustomException(String message){
        super(message);
    }

    public CustomException(String message, Throwable cause){
        super(message, cause);
    }

    public CustomException(Throwable cause){
        super(cause);
    }

    public static class AddressException extends RuntimeException {

        public AddressException(){
            super("Error: Address has not been updated");
        }

        public AddressException(String message){
            super(message);
        }

        public AddressException(String message, Throwable cause){
            super(message, cause);
        }

        public AddressException(Throwable cause){
            super(cause);
        }
    }

    public static class InvalidGenderException extends RuntimeException {

        public InvalidGenderException(){
            super("Error: Invalid gender. Excepted genders are male, female and other");
        }

        public InvalidGenderException(String message){
            super(message);
        }

        public InvalidGenderException(String message, Throwable cause){
            super(message, cause);
        }

        public InvalidGenderException(Throwable cause){
            super(cause);
        }
    }

    public static class InvalidBloodException extends RuntimeException {

        public InvalidBloodException(){
            super("Error: Invalid blood type");
        }

        public InvalidBloodException(String message){
            super(message);
        }

        public InvalidBloodException(String message, Throwable cause){
            super(message, cause);
        }

        public InvalidBloodException(Throwable cause){
            super(cause);
        }
    }
}
