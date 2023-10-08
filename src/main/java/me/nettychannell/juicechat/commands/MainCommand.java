package me.nettychannell.juicechat.commands;

import lombok.Getter;
import me.nettychannell.juicechat.JuiceChat;
import me.nettychannell.juicechat.api.CommandManager;

import me.nettychannell.juicechat.api.SubCommand;
import me.nettychannell.juicechat.commands.subcommands.ReloadSubCommand;
import me.nettychannell.juicechat.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class MainCommand extends CommandManager implements TabCompleter {
    @Getter
    private List<SubCommand> subCommands = new ArrayList<>();

    public MainCommand() {
        super("juicechat", null, false);
        subCommands.add(new ReloadSubCommand());
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player player = (Player) sender;
        if (player.isOp() || player.hasPermission("juicechat.admin")) {
            if (args.length == 0) {
                if (args[0].equalsIgnoreCase("reload")) {
                    player.sendMessage(Utils.getMessage("messages.help-title"));
                    player.sendMessage("");
                    for (SubCommand sub : subCommands) {
                        player.sendMessage(Utils.getMessage("messages.help-format").replace("%command%", sub.name).replace("%syntax%", sub.syntax).replace("%description%", sub.description));
                    }
                }
                player.sendMessage(Utils.color("&1• &fRunning &9Juice&1Chat &fcreated by &9CodeDevv_ &f& &9SmoDev_&f."));
                player.sendMessage(Utils.color("&1• &fUse: /juicechat help &8| &7List of all commands."));
            }
            player.sendMessage(Utils.color("&1• &fRunning &9Juice&1Chat &fcreated by &9CodeDevv_ &f& &9SmoDev_&f."));
            if (args.length == 0) {
            } else {
                int sub = 0;
                for (int i = 0; i < getSubCommands().size(); i++) {
                    if (args[0].equalsIgnoreCase(getSubCommands().get(i).name)) {
                        sub++;
                        getSubCommands().get(i).execute((Player) sender, args);
                        break;
                    }
                }
                if (sub == 0) {
                    sender.sendMessage(Utils.getMessage("invalid-usage.juicechat-command"));
                }
            }
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] args) {
        List<String> complete = new ArrayList<>();
        if(args.length == 1){
            for(SubCommand sub : subCommands){
                complete.add(sub.name);
                }
            return complete;
        }
        return null;
    }
}