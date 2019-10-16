package telephoneStation.exceptions;

public final class SaveFailedException extends Throwable {
    @Override
    public String getMessage() {
        return "Failed saving data";
    }
}
