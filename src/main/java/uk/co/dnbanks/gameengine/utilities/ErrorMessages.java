package uk.co.dnbanks.gameengine.utilities;

/**
 * Class with all the Error Messages.
 * @author Daniel Banks
 */
public class ErrorMessages {
    public static final String LESS_THAN_ZERO = "%s must be greater than 0";

    public static final String NULL_POINTER = "%s %S does not exist";

    public static final String NO_SCENE_ERROR = "Scene";

    /**
     * Creates a custom error message.
     * @param error The error message
     * @param variable The variable that caused the issue
     * @return Error Message
     */
    public static String createErrorMsg(String error, String... variable) {
        return String.format(error, variable[0]);
    }
}
