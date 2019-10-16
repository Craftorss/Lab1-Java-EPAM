package telephoneStation.exceptions;

public final class CantLoadException extends Throwable {
    @Override
    public String getMessage() {
        return "Cannot load object";
    }
}
