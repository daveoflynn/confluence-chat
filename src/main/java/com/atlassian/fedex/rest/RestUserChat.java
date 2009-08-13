package com.atlassian.fedex.rest;

import com.atlassian.fedex.rest.controller.MessageController;

import javax.ws.rs.*;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.MediaType.APPLICATION_XML;

import javax.ws.rs.core.Response;


@Path("/{userName}")
@Consumes({APPLICATION_JSON, APPLICATION_XML})
@Produces({APPLICATION_JSON, APPLICATION_XML})
public class RestUserChat
{
    MessageController messageController;


    @GET
    public Response isOnline(@PathParam("userName") String username)
    {
        return Response.ok(messageController.isOnline(username)).build();
    }

    @Path("chat")
    @GET
    public Response getChatUrl(@PathParam("userName") String username)
    {
        return Response.ok(messageController.getChatUrl(username)).build();
    }

    public void setMessageController(MessageController messageController)
    {
        this.messageController = messageController;
    }
}
