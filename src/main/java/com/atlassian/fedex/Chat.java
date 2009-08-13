package com.atlassian.fedex;

/**
 * Created by IntelliJ IDEA.
 * User: doflynn
 * Date: Aug 13, 2009
 * Time: 4:51:10 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Chat
{ 
    boolean sendMessage(String user, String messageText);
}
