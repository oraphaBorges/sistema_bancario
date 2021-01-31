package sistemaBancario.exceptions;

public class CustomExceptionHandlerResponse {
    private String field;
    private String message;

    public CustomExceptionHandlerResponse(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public String toString() {
        return "CustomExceptionHandlerResponse{" +
                "message='" + message + '\'' +
                ", field='" + field + '\'' +
                '}';
    }
}
