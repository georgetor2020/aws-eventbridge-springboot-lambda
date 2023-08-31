package com.brianeno.aws.data;

/**
 * @author brianeno
 */
public class InboundCase {

    private String id;
    private String caseName;
    private String status;

    public InboundCase(String id, String caseName, String status) {
        this.id = id;
        this.caseName = caseName;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
