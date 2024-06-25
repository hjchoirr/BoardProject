package org.choongang.global.exceptions;

public class AlertRedirectException extends AlertException{
    private String redirectUrl;
    private String target;

    public AlertRedirectException(String message, String url, int status, String target) {
        super(message, status);
        this.redirectUrl = url;
        this.target = target;
    }
    public AlertRedirectException(String message, String url, int status) {
        this(message, url,status,"self");
    }
    public String getRedirectUrl() {
        return redirectUrl;
    }
    public String getTarget() {
        return target;
    }
}
