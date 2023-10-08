package me.nettychannell.juicechat.utils;

import lombok.experimental.UtilityClass;
import me.clip.placeholderapi.PlaceholderAPI;
import me.nettychannell.juicechat.JuiceChat;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

@UtilityClass
public class Utils {
    public String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
    public String format(String text, Player player) {
        text = PlaceholderAPI.setPlaceholders(player, text);
        return color(text);
    }
    public String getMessage(String path) {
        return color(JuiceChat.getInstance().getConfig().getString(path));
    }
}
