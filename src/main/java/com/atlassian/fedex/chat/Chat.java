package com.atlassian.fedex.chat;

import java.util.Iterator;
import java.util.List;
import java.net.URL;

/**
 * Allows you to check IM status.
 */
public interface Chat
{
    boolean isOnline(String username);

    /**
     * eg "jabber://test-user@chat.atlassian.com"
     * @param username
     * @return
     */
    String getUrl(String username);
}
