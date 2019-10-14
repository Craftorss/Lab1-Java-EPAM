package telephoneStation.exceptions;

public class SaveFailedException extends Throwable {
    @Override
    public String getMessage() {
        return "Failed saving data";
    }
}
