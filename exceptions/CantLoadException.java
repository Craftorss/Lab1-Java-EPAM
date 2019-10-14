package telephoneStation.exceptions;

public class CantLoadException extends Throwable {
    @Override
    public String getMessage() {
        return "Cannot load object";
    }
}
