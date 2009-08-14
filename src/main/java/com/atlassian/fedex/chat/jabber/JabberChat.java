package com.atlassian.fedex.chat.jabber;

import com.atlassian.fedex.chat.Chat;

import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.RosterEntry;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.packet.Presence;

import java.net.URL;
import java.net.MalformedURLException;

public class JabberChat implements Chat
{
    XMPPConnection conn;


    public JabberChat()
    {
System.out.println("creating new JabberChat!");        
        // instantiate connection, as presence info is asynchronous.
        getConnection();
    }

//    public void finalize()
//    {
//        if (conn != null)
//        {
//            conn.disconnect();
//        }
//    }

    public boolean isOnline(String username)
    {
System.out.println("fetching connection");
        XMPPConnection conn = getConnection();
System.out.println("got connection");
        if (conn != null)
        {
System.out.println("fetching presence");
            Presence presence = conn.getRoster().getPresence(username + "@" + getServer());
System.out.println("got presence: " + presence);

            boolean isAvailable = presence.isAvailable();
            return isAvailable;
        }
        return false;
    }

    public String getUrl(String username)
    {
        return new String("jabber://" + username + "@" + getServer());
    }

    protected String getLogonUsername()
    {
        return "xxx";
    }

    protected String getLogonPassword()
    {
        return "yyy";
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
        if (conn == null || !conn.isConnected())
        {
            try
            {
    System.out.println("creating object");
//                XMPPConnection.DEBUG_ENABLED = true;
                ConnectionConfiguration config = new ConnectionConfiguration(getServer());

                conn = new XMPPConnection(config);
    System.out.println("connecting");
                conn.connect();
    System.out.println("logging in");
                conn.login(getLogonUsername(), getLogonPassword());
    System.out.println("logged in");
    System.out.println(conn);


                return conn;
            }
            catch (XMPPException e)
            {
                e.printStackTrace();
                conn = null;
            }
        }
        return conn;
    }
}
