package me.reparar;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;
import java.util.stream.Collectors;

public class ConfigManager {

    public String Prefix;

    public String msgNullItem;
    public String msgItemMax;
    public String noMoney;

    public String msgItemRepair;
    public String msgNoItemRepair;

    public double cust;

    public String nameMenu;

    public String confirmName;
    public int confirmSlot;
    public String confirmMaterial;
    public List<String> confirmLore;

    public String infoName;
    public int infoSlot;
    public String infoMaterial;
    public List<String> infoLore;

    public String cancelName;
    public int cancelSlot;
    public String cancelMaterial;
    public List<String> cancelLore;

    public void loadConfig() {

        FileConfiguration config = BoxReparar.Instance.getConfig();

        Prefix = config.getString("Prefixo").replace("&", "§");

        msgNullItem = config.getString("SemItemNaMao").replace("&", "§");
        msgItemMax = config.getString("DurabilidadeMaxima").replace("&", "§");
        noMoney = config.getString("SemDinheiro").replace("&", "§");

        msgItemRepair = config.getString("ItemReparado").replace("&", "§");
        msgNoItemRepair = config.getString("ReparacaoCancelada").replace("&", "§");

        cust = config.getDouble("Custo");

        nameMenu = config.getString("Menu.Nome").replace("&", "§");

        confirmName = config.getString("Menu.Itens.Confirmar.Nome").replace("&", "§");
        confirmSlot = config.getInt("Menu.Itens.Confirmar.Slot");
        confirmMaterial = config.getString("Menu.Itens.Confirmar.Material");
        confirmLore = config.getStringList("Menu.Itens.Confirmar.Lore");
        confirmLore = confirmLore.stream().map(l -> l.replace("&", "§")).collect(Collectors.toList());

        infoName = config.getString("Menu.Itens.Informacoes.Nome").replace("&", "§");
        infoSlot = config.getInt("Menu.Itens.Informacoes.Slot");
        infoMaterial = config.getString("Menu.Itens.Informacoes.Material");
        infoLore = config.getStringList("Menu.Itens.Informacoes.Lore");
        infoLore = infoLore.stream().map(l -> l.replace("&", "§")).collect(Collectors.toList());

        cancelName = config.getString("Menu.Itens.Cancelar.Nome").replace("&", "§");
        cancelMaterial = config.getString("Menu.Itens.Cancelar.Material");
        cancelSlot = config.getInt("Menu.Itens.Cancelar.Slot");
        cancelLore = config.getStringList("Menu.Itens.Cancelar.Lore");
        cancelLore = cancelLore.stream().map(l -> l.replace("&", "§")).collect(Collectors.toList());

    }
}