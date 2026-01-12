package de.zweifelnder.zweifelentitys;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class EntitySpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage("§cNur Spieler können diesen Command benutzen.");
            return true;
        }

        if (!player.hasPermission("zweifelentitys.use")) {
            player.sendMessage("§8[§2ZWEIFELENTITYS§8] §cDu hast keine Berechtigung dazu!");
            return true;
        }

        if (args.length < 1) {
            player.sendMessage("§8[§2ZWEIFELENTITYS§8] §cBenutze die Befehle bitte so: /entityspawn <entity> [name]");
            return true;
        }

        EntityType entityType;
        try {
            entityType = EntityType.valueOf(args[0].toUpperCase());
        } catch (IllegalArgumentException e) {
            player.sendMessage("§8[§2ZWEIFELENTITYS§8] §cUngültige Entity!");
            return true;
        }

        Location location = player.getLocation();
        Entity entity = player.getWorld().spawnEntity(location, entityType);

        if (args.length >= 2) {
            String name = String.join(" ", args).substring(args[0].length() + 1);
            entity.setCustomName(name);
            entity.setCustomNameVisible(true);
        }

        player.sendMessage("§8[§2ZWEIFELENTITYS§8] §aEntity §e" + entityType.name() + " §agespawnt!");
        return true;
    }
}
