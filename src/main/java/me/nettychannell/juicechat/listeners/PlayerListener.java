package me.nettychannell.juicechat.listeners;

import me.nettychannell.juicechat.JuiceChat;
import me.nettychannell.juicechat.utils.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if(JuiceChat.getInstance().getConfig().getBoolean("join-msg-enabled")) {
            if(!e.getPlayer().hasPlayedBefore()) {
                e.setJoinMessage(Utils.getMessage("first-join-message").replace("%player%", e.getPlayer().getName()));
                return;
            }
            e.setJoinMessage(Utils.getMessage("join-message").replace("%player%", e.getPlayer().getName()));
            return;
        }
        e.setJoinMessage(null);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        if(JuiceChat.getInstance().getConfig().getBoolean("quit-msg-enabled")) {
            e.setQuitMessage(Utils.getMessage("quit-message").replace("%player%", e.getPlayer().getName()));
            return;
        }
        e.setQuitMessage(null);
    }
}