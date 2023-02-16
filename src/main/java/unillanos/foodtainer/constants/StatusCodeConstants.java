package unillanos.foodtainer.constants;

public class StatusCodeConstants {

    private StatusCodeConstants() { throw new IllegalStateException("Constants class."); }

    public static final int STATUS_OK = 200;

    public static final int CREATED = 201;

    public static final int BAD_REQUEST = 400;

    public static final int UNAUTHORIZED = 401;

    public static final int FORBIDDEN = 403;

    public static final int NOT_FOUND = 404;

    public static final int SERVER_ERROR = 502;

}
