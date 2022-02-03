package me.reparar.Inventory;

import me.reparar.APIs.ItensAPI;
import me.reparar.BoxReparar;
import me.reparar.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.stream.Collectors;

public class RepairInv {

    ConfigManager Config = BoxReparar.Config;

    public void openInv(Player p) {

        Inventory inv = Bukkit.createInventory(null, 9*3, Config.nameMenu);

        inv.setItem(Config.confirmSlot, ItensAPI.ItensMaterial(Config.confirmLore.stream().map(l -> l.replace("{custo}", "" + Config.cust)).collect(Collectors.toList()), Material.valueOf(Config.cancelMaterial.split(":")[0]), 1, Integer.parseInt(Config.confirmMaterial.split(":")[1]), Config.confirmName));

        inv.setItem(Config.infoSlot, ItensAPI.ItensMaterial(Config.infoLore, Material.valueOf(Config.infoMaterial.split(":")[0]), 1, Integer.parseInt(Config.infoMaterial.split(":")[1]), Config.infoName));

        inv.setItem(Config.cancelSlot, ItensAPI.ItensMaterial(Config.cancelLore, Material.valueOf(Config.cancelMaterial.split(":")[0]), 1, Integer.parseInt(Config.cancelMaterial.split(":")[1]), Config.cancelName));

        p.openInventory(inv);

    }
}