package com.exmple.testing.model;

public class Settings {

    private String baseUrl;
    private String testEmail;
    private String testPassword;
    private String driverPath;
    private String driverPropertyName;

    public String getDriverPath() {
        return driverPath;
    }

    public void setDriverPath(String driverPath) {
        this.driverPath = driverPath;
    }

    public String getDriverPropertyName() {
        return driverPropertyName;
    }

    public void setDriverPropertyName(String driverPropertyName) {
        this.driverPropertyName = driverPropertyName;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getTestEmail() {
        return testEmail;
    }

    public void setTestEmail(String testEmail) {
        this.testEmail = testEmail;
    }

    public String getTestPassword() {
        return testPassword;
    }

    public void setTestPassword(String testPassword) {
        this.testPassword = testPassword;
    }
}
