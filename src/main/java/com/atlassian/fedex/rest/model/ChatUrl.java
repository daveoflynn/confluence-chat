package com.atlassian.fedex.rest.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

@XmlRootElement
public class ChatUrl
{
    @XmlElement
    String url;

    public ChatUrl()
    {
        this.url = "";
    }

    public ChatUrl(String url)
    {
        this.url = url;
    }
}
