package unillanos.petcity.exceptions;

public class PetCityException extends Exception {

    public PetCityException(String message) {
        super(message);
    }

    public PetCityException(String message, Exception exception) {
        super(message, exception);
    }

}
