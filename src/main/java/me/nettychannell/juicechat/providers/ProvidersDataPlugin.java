package me.nettychannell.juicechat.providers;

import me.nettychannell.juicechat.JuiceChat;
import me.nettychannell.juicechat.commands.MainCommand;
import me.nettychannell.juicechat.listeners.ChatListeners;
import me.nettychannell.juicechat.listeners.PlayerListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class ProvidersDataPlugin {
    public void loadCommands() {
        new MainCommand();
    }
    public void loadListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new ChatListeners(), JuiceChat.getInstance());
        pm.registerEvents(new PlayerListener(), JuiceChat.getInstance());
    }
    public void loadPlaceholders() {

    }
    public void checkDependency() {
        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") == null ||
                !Bukkit.getPluginManager().getPlugin("PlaceholderAPI").isEnabled()) {
            Bukkit.getPluginManager().disablePlugin(JuiceChat.getInstance());
        }
    }
}
