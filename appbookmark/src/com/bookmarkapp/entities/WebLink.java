package com.bookmarkapp.entities;

import com.bookmarkapp.partner.Shareable;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by sadiq on 05/03/20.
 */
public class WebLink extends Bookmark implements Shareable {

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

    @Override
    public String getItemData() {
        StringBuilder builder = new StringBuilder();
        builder.append("<item>");
            builder.append("<type>WebLink</type>");
            builder.append("<title>").append(getTitle()).append("</title>");
            builder.append("<url>").append(url).append("</url>");
            builder.append("<host>").append(host).append("</host>");
        builder.append("</item>");

        return builder.toString();
    }
}

