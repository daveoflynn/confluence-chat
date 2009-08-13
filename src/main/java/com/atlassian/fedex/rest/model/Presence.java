package com.atlassian.fedex.rest.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Presence
{
    @XmlElement
    Boolean online;

    public Presence()
    {
        online = Boolean.FALSE;
    }

    public Presence(boolean online)
    {
        online = new Boolean(online);
    }
}
