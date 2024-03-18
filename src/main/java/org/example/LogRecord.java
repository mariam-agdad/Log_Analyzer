package com.example.dashboard1;

public class LogRecord {
    final String ipAddress;
    final String clientId;
    final String userId;
    final String creationTime;
    final String method;
    final String uri;



    final String protocol;
    final String statusCode;
    final double size;
    final UserAgent userAgent;


    public String getIpAddress() {
        return ipAddress;
    }

    public String getClientID() {
        return clientId;
    }

    public String getUserID() {
        return userId;
    }

    public String getRequestDate() {
        return creationTime;
    }

    public String getMethod() {
        return method;
    }
    public String getUri() {
        return uri;
    }
    public String getProtocol() {
        return protocol;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public double getSize() {
        return size;
    }

    public UserAgent getUserAgent() {
        return userAgent;
    }

    public LogRecord(String ipAddress, String clientId, String userId, String creationTime, String method, String uri,String protocol, String statusCode, double size,  UserAgent userAgent) {
        this.ipAddress = ipAddress;
        this.clientId = clientId;
        this.userId = userId;
        this.creationTime = creationTime;
        this.method = method;
        this.uri=uri;
        this.protocol = protocol;
        this.statusCode = statusCode;
        this.size = size;
        this.userAgent = userAgent;
    }
}
