package com.atlassian.fedex.rest.controller;

import com.atlassian.fedex.rest.model.Presence;
import com.atlassian.fedex.rest.model.ChatUrl;
import com.atlassian.fedex.chat.Chat;

import java.net.URL;

public class MessageController
{
    Chat chat;


    public Presence isOnline(String username)
    {
        return new Presence(chat.isOnline(username));
    }

    public ChatUrl getChatUrl(String username)
    {
        return new ChatUrl(chat.getUrl(username));
    }

    public void setChat(Chat chat)
    {
        this.chat = chat;
    }
}
