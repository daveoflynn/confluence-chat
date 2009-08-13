package com.atlassian.fedex.chat.jabber;

import com.atlassian.fedex.chat.Chat;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Presence;

import java.net.URL;
import java.net.MalformedURLException;

public class JabberChat implements Chat
{
//    XMPPConnection


    public JabberChat()
    {

    }

    public boolean isOnline(String username)
    {
System.out.println("fetching connection");
        XMPPConnection conn = getConnection();
System.out.println("got connection");
        if (conn != null)
        {
System.out.println("fetching presence");
            Presence presence = conn.getRoster().getPresence(username + "@" + getServer());
System.out.println("got presence: " + presence.isAvailable());
            return presence.isAvailable();
        }
        return false;
    }

    public String getUrl(String username)
    {
        return new String("jabber://" + username + "@" + getServer());
    }

    protected String getLogonUsername()
    {
        return "coop coop coop";
    }

    protected String getLogonPassword()
    {
        return "beep-beep-beep";
    }

    protected String getServer()
    {
        return "chat.atlassian.com";
    }


    /**
     * Creates a server connection, if needed, and returns it logged in.
     */
    protected XMPPConnection getConnection()
    {
        try
        {
System.out.println("creating object");

            XMPPConnection conn = new XMPPConnection(getServer());
System.out.println("connecting");
            conn.connect();
System.out.println("logging in");
            conn.login(getLogonUsername(), getLogonPassword());
System.out.println("logged in");            

            return conn;
        }
        catch (XMPPException e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
