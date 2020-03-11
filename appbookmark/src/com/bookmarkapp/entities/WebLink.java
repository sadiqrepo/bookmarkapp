package com.bookmarkapp.entities;

/**
 * Created by sadiq on 05/03/20.
 */
public class WebLink extends Bookmark {

    private String url;
    private String host;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public boolean isKidFriendlyEligible() {
        if(url.contains("porn")|| getTitle().contains("porn") || host.contains("adult")){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "WebLink{" +
                "url='" + url + '\'' +
                ", host='" + host + '\'' +
                '}';
    }
}

