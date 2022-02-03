package me.reparar.APIs;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class ItensAPI {

    public static ItemStack ItensMaterial(List<String> lore, Material material, int amount, int data, String name) {
        ItemStack Item = new ItemStack(material, amount, (short)data);
        ItemMeta meta = Item.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(lore);

        Item.setItemMeta(meta);

        return Item;
    }

    public static ItemStack Itens(List<String> lore, Material material, int amount, String name) {
        ItemStack Item = new ItemStack(material, amount);
        ItemMeta meta = Item.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(lore);

        Item.setItemMeta(meta);

        return Item;
    }

    public static ItemStack ItensID(List<String> lore, int id, String name) {
        ItemStack Item = new ItemStack(id);
        ItemMeta meta = Item.getItemMeta();

        meta.setDisplayName(name);
        meta.setLore(lore);

        Item.setItemMeta(meta);

        return Item;
    }

}