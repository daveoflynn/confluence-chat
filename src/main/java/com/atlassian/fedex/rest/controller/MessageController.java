package com.atlassian.fedex.rest.controller;

import com.atlassian.fedex.rest.model.Presence;
import com.atlassian.fedex.chat.Chat;

import java.net.URL;

public class MessageController
{
    Chat chat;


    public Presence isOnline(String username)
    {
        return new Presence(chat.isOnline(username));
    }

    public String getChatUrl(String username)
    {
        return chat.getUrl(username);
    }

    public void setChat(Chat chat)
    {
        this.chat = chat;
    }
}
