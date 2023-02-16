package unillanos.foodtainer.constants;

public class UserConstants {

    private UserConstants() {
        throw new IllegalStateException("Constants class.");
    }

    public static final String EMAIL_IN_USE = "El email ingresado ya está registrado en FoodTainer.";

    public static final String NOT_VALID_EMAIL = "El email ingresado no tiene un formato válido.";

    public static final String ERROR_SAVING = "Ocurrió un error al momento de guardar el usuario";

    public static final String SUCCESSFULLY_SAVED = "El usuario ha sido registrado con éxito.";

    public static final String ERROR_LOGGING = "Ocurrió un error al momento de iniciar sesión.";


}
