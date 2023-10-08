package me.nettychannell.juicechat.listeners;

import me.clip.placeholderapi.PlaceholderAPI;
import me.nettychannell.juicechat.JuiceChat;
import me.nettychannell.juicechat.utils.Utils;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.PlayerInventory;

public class ChatListeners implements Listener {
    @EventHandler
    public void antiSwear(AsyncPlayerChatEvent e) {
        String message = e.getMessage();
        if(containsSwearWord(message)) {
            e.getPlayer().sendMessage(Utils.getMessage("anti-swear-message"));
            e.setCancelled(true);
            return;
        }

        String generalMessage = Utils.getMessage("chat.format");
        String personalMessage = Utils.getMessage("chat.personal-format");

        OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer("playerName");

        // Controlla se il giocatore è mai entrato nel server
        if (offlinePlayer.hasPlayedBefore()) {
            PlayerInventory inventory = offlinePlayer.getInventory();

            // Ritorna l'inventario del giocatore
            return inventory.getContents();
        }

    }

    private boolean containsSwearWord(String string) {
        return JuiceChat.getInstance().getConfig().getStringList("blacklist-words").stream().anyMatch(string::contains);
    }

}