package dersoz.coderetreat.istanbul.gol.domain.exception;

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
