package unillanos.foodtainer.constants;

public class PathConstants {

    private PathConstants() {
        throw new IllegalStateException("Constants class.");
    }

    public static final String SAVE = "/save";

    public static final String FIND_ALL = "/findAll";

    public static final String FIND = "/find";

    public static final String PAGE_NUMBER = "/find/pageNumber";

    public static final String DELETE = "/delete/{id}";

    public static final String FIND_BY_ID = "/{id}";

    public static final String UPDATE = "/update";

    public static final String PATH_CITY = "city";

    public static final String PATH_RESTAURANT = "restaurant";

    public static final String PATH_USER = "user";

    public static final String PATH_HEADQUARTER = "headquarter";

    public static final String SIGN_UP = "signup";

    public static final String PATH_LOGIN = "login";


}
