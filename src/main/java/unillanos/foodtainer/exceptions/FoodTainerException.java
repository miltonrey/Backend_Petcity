package unillanos.foodtainer.exceptions;

public class FoodTainerException extends Exception {

    public FoodTainerException(String message) {
        super(message);
    }

    public FoodTainerException(String message, Exception exception) {
        super(message, exception);
    }

}
