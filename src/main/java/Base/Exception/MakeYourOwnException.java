package Base.Exception;

public class MakeYourOwnException  extends RuntimeException{

    public MakeYourOwnException(String message, Throwable cause) { super(message, cause); }

    public MakeYourOwnException(String message) { super(message); }

    @Override
    public String toString() {
        return String.format("%s%s", getMessage(), getCause() == null ? "" : "caused by " + getCause().getMessage() );
    }

}
