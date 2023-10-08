package me.nettychannell.juicechat.api;

import org.bukkit.entity.Player;

public abstract class SubCommand {
    public String name, syntax, description;

    public SubCommand(String name, String syntax, String description){
        this.name = name;
        this.syntax = syntax;
        this.description = description;
    }

    public abstract void execute(Player player, String[] args);
}