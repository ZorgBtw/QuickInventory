package fr.zorg.quickinventory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class QuickInventoryManager implements Listener {

    private static Map<Inventory, QuickInventory> inventoryList;

    public static void register(JavaPlugin javaPlugin) {
        javaPlugin.getServer().getPluginManager().registerEvents(new QuickInventoryManager(), javaPlugin);
        inventoryList = new HashMap<>();
    }

    public static void register(Class<JavaPlugin> javaPluginClazz) {
        QuickInventoryManager.register(JavaPlugin.getPlugin(javaPluginClazz));
    }

    protected static void addListener(Inventory inventory, QuickInventory quickInventory) {
        inventoryList.put(inventory, quickInventory);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory() == null
                || !(e.getClickedInventory().getHolder() instanceof QuickInventory)
                || !inventoryList.containsKey(e.getClickedInventory()))
            return;

        e.setCancelled(true);

        if (inventoryList.containsKey(e.getClickedInventory()) && inventoryList.get(e.getClickedInventory()).getActions().get(e.getSlot()) != null)
            inventoryList.get(e.getClickedInventory()).getActions().get(e.getSlot()).accept(e);
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e) {
        if (!(e.getInventory().getHolder() instanceof QuickInventory))
            return;
        if (inventoryList.containsKey(e.getInventory()))
            inventoryList.remove(e.getInventory());
    }

}