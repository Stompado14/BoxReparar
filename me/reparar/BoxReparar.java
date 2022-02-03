package me.reparar;

import me.reparar.Commands.CommandRepair;
import me.reparar.Listeners.Events;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class BoxReparar extends JavaPlugin {

    public static BoxReparar Instance;
    public static ConfigManager Config;

    private static Economy economy = null;

    ConsoleCommandSender cs = Bukkit.getConsoleSender();
    PluginManager pm = getServer().getPluginManager();

    public void onEnable() {

        Instance = this;
        registerYaml();
        registerCommands();
        setupEconomy();
        hasVault();
        registerEvents();
        sendMessage();

    }

    private void registerCommands() {

        getCommand("reparar").setExecutor(new CommandRepair());

    }

    private void registerEvents() {

        pm.registerEvents(new Events(), this);

    }

    private void registerYaml() {

        Config = new ConfigManager();
        saveDefaultConfig();
        Config.loadConfig();

    }

    private void sendMessage() {

        cs.sendMessage("§e[BoxReparar] §fCriado por §b[Stompado]");
        cs.sendMessage("§e[BoxReparar] §aO plugin §eBoxReparar §afoi iniciado com sucesso.");

    }

    public boolean hasVault() {

        if (pm.getPlugin("Vault") == null) {
            cs.sendMessage("§e[BoxReparar] §cOuve um erro ao encontrar o plugin §eVault§c. Desabilitando plugin...");
            pm.disablePlugin(this);
            return false;
        }
        return true;

    }

    private boolean setupEconomy()
    {
        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            economy = economyProvider.getProvider();
        }

        return (economy != null);
    }

    public static Economy getEconomy() {
        return economy;
    }
}
