package com.atlassian.fedex.ui;

import com.atlassian.sal.api.pluginsettings.PluginSettingsFactory;

public class SettingsPersister
{
    private final PluginSettingsFactory pluginSettingsFactory;

    public SettingsPersister(PluginSettingsFactory pluginSettingsFactory)
    {
        this.pluginSettingsFactory = pluginSettingsFactory;
    }

    public void set(String name, String value)
    {
        pluginSettingsFactory.createGlobalSettings().put(name, value);
    }

    public String get(String name)
    {
        return (String) pluginSettingsFactory.createGlobalSettings().get(name);
    }
}
