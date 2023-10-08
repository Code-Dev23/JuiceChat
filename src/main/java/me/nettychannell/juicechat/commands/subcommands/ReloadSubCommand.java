package me.nettychannell.juicechat.commands.subcommands;

import me.nettychannell.juicechat.JuiceChat;
import me.nettychannell.juicechat.api.SubCommand;
import me.nettychannell.juicechat.utils.Utils;
import org.bukkit.entity.Player;

public class ReloadSubCommand extends SubCommand {
    public ReloadSubCommand() {
        super("reload", "/juicechat reload", "Reload the config file.");
    }

    @Override
    public void execute(Player player, String[] args) {
        JuiceChat.getInstance().reloadConfig();
        player.sendMessage(Utils.color("&aConfig reloaded with success!"));
    }
}
