package id.zakariandys.restsample.api.response;

import java.io.Serializable;

public class HelloWorldResponse implements Serializable {

    private boolean success;

    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "HelloWorldResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                '}';
    }
}
