package me.nettychannell.juicechat;

import lombok.Getter;
import me.nettychannell.juicechat.providers.ProvidersDataPlugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class JuiceChat extends JavaPlugin {

    @Getter
    private static JuiceChat instance;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        providers();
    }

    @Override
    public void onDisable() {

    }

    private void providers() {
        ProvidersDataPlugin providers = new ProvidersDataPlugin();
        providers.checkDependency();
        providers.loadCommands();
        providers.loadListeners();
        providers.loadPlaceholders();
    }
}