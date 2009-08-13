package com.atlassian.fedex.chat;

import com.atlassian.confluence.plugin.descriptor.web.conditions.BaseConfluenceCondition;
import com.atlassian.confluence.plugin.descriptor.web.WebInterfaceContext;
import com.atlassian.user.User;

import java.util.Map;

public class UserHasChatName extends BaseConfluenceCondition
{
    protected boolean shouldDisplay(WebInterfaceContext webInterfaceContext)
    {
        User user = webInterfaceContext.getTargetUser();
System.out.println("shouldDisplay was called for " + user.getName());
 //TODO: determine if the user has a jabber id       
        return true;
    }
}
