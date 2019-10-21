package telephoneStation.exceptions;

public final class DaoSaveException extends Throwable {
    @Override
    public String getMessage() {
        return "Error saving object";
    }
}
