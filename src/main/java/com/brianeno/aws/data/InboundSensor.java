package com.brianeno.aws.data;

/**
 * @author brianeno
 */
public class InboundSensor {

    private String id;
    private String value;
    private String status;

    public InboundSensor(String id, String value, String status) {
        this.id = id;
        this.value = value;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
