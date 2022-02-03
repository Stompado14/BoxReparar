package me.reparar.Listeners;

import me.reparar.BoxReparar;
import me.reparar.ConfigManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class Events implements Listener {

    ConfigManager Config = BoxReparar.Config;

    String prefix = Config.Prefix;

    @EventHandler
    void repairEvent(InventoryClickEvent e) {

        if (!e.getInventory().getName().equals(Config.nameMenu)) return;
        e.setCancelled(true);
        Player p = (Player) e.getWhoClicked();

        if (e.getSlot() == Config.confirmSlot) {

            if (!(BoxReparar.getEconomy().has(p, Config.cust))) {
                p.sendMessage(Config.noMoney.replace("@prefixo", prefix).replace("{custo}", "" + Config.cust));
                p.closeInventory();
                return;

            } else {

                BoxReparar.getEconomy().withdrawPlayer(p, Config.cust);

                p.getItemInHand().setDurability((short)0);
                p.closeInventory();

                p.sendMessage(Config.msgItemRepair.replace("@prefixo", prefix));

            }
        } else if (e.getSlot() == Config.cancelSlot) {

                p.closeInventory();
                p.sendMessage(Config.msgNoItemRepair.replace("@prefixo", prefix));

        }
    }
}