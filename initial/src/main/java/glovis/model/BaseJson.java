package glovis.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class BaseJson implements Serializable {
    private static final long serialVersionUID = -3282914508008080205L;
    private Boolean result;
    private String errorMessage;
    private Object payload;
    private String timestamp;

    public BaseJson() {
        Timestamp timesp = new Timestamp(System.currentTimeMillis());

        timestamp = String.valueOf(timesp.getTime());
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Object getPayload() {
        return payload;
    }
    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
