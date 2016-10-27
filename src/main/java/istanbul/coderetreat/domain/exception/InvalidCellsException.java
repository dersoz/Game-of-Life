package istanbul.coderetreat.domain.exception;

/**
 * Created by dogan
 */
public class InvalidCellsException extends RuntimeException {
    public InvalidCellsException(String message) {
        super(message);
    }

    public InvalidCellsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidCellsException(Throwable cause) {
        super(cause);
    }
}
