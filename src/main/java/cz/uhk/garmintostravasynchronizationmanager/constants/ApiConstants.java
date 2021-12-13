package cz.uhk.garmintostravasynchronizationmanager.constants;

public class ApiConstants {

    public static final String SIGN_UP_URL = "/users/auth";
    public static final String WEBHOOK_URL = "/webhook";
    public static final String API_DOC_URL = "/swagger-ui/**";
    public static final String HEADER_NAME = "Authorization";
    public static final String PREFIX = "Bearer";
    public static final Long EXPIRATION_TIME = 19_800_000L; // 5,5 hours

    public static final String JWT_TOKEN = "jwt_key";

}
