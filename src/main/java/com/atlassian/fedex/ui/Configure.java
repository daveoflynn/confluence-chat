package com.atlassian.fedex.ui;

import com.atlassian.confluence.core.ConfluenceActionSupport;

public class Configure extends ConfluenceActionSupport
{
    private String username;
    private String password;
    private String server;

    private SettingsPersister settingsPersister;


    public String doDefault()
    {
        // fetch via SAL
        setUsername(settingsPersister.get("chat.username"));
        setPassword(settingsPersister.get("chat.password"));
        setServer(settingsPersister.get("chat.server"));

        log.info("Got Username: " + getUsername());
        log.info("Got Password: " + getUsername());
        log.info("Got Server: " + getUsername());

        return SUCCESS;
    }

    public String doUpdate()
    {
        log.info("Setting Username: " + getUsername());
        log.info("Setting Password: " + getUsername());
        log.info("Setting Server: " + getUsername());

        // store using SAL
        settingsPersister.set("chat.username", getUsername());
        settingsPersister.set("chat.password", getPassword());
        settingsPersister.set("chat.server", getServer());
        
        return doDefault();
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getServer()
    {
        return server;
    }

    public void setServer(String server)
    {
        this.server = server;
    }


    public void setSettingsPersister(SettingsPersister settingsPersister)
    {
        this.settingsPersister = settingsPersister;
    }
}
