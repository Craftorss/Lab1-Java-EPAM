package telephoneStation.exceptions;

public final class WrongArgumentsException extends Throwable{
    @Override
    public String getMessage() {
        return "Wrong constructor arguments";
    }
}
