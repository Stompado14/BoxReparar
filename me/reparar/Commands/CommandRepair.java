package me.reparar.Commands;

import me.reparar.BoxReparar;
import me.reparar.ConfigManager;
import me.reparar.Inventory.RepairInv;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandRepair implements CommandExecutor {

    ConfigManager Config = BoxReparar.Config;

    String prefix = Config.Prefix;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("§cO console não executa esse comando.");
            return true;
        }
        Player p = (Player)sender;

        if (!p.hasPermission("boxreparar.admin")) {
            p.sendMessage("§cVocê não possui permissão para esse comando.");
            return true;
        }

        if (args.length == 0) {

            ItemStack item = p.getItemInHand();

            if (item == null || item.getType() == Material.AIR) {
                p.sendMessage(Config.msgNullItem.replace("@prefixo", prefix));
                return true;

            }  else if (item.getDurability() == 0) {
                p.sendMessage(Config.msgItemMax.replace("@prefixo", prefix));
                return true;

            } else {
                new RepairInv().openInv(p);

            }
        }
        return false;
    }
}