# QuickInventory

## Description

➠  This API allows you to create some cool GUIs and cool items easily in Minecraft

➠  Register your plugin
```java
public class MainClass extends JavaPlugin {

    @Override
    public void onEnable() {
        QuickInventoryManager.register(this);
    }

}
```

➠  Create a simple Inventory
```java
public class ExampleInventory extends QuickInventory {

    public ExampleInventory(Player player) {
        super("§cHow cool is that !", 3);
        setBorders(QuickItem.of(Material.STAINED_GLASS_PANE).durability(14).glow().name("§f")); // Setting the borders
        s(14, QuickItem.of(Material.ANVIL).size(10).name("§710 anvils !").lore("Line 1", "§cLine 2, but colored !")); // Method s() is a shortcut for setSlot()
        open(player);
    }

}
```

➠  Run an action when an item is clicked
```java
setSlot(10, QuickItem.of(Material.APPLE).name("§cRandom apple"), inventoryClickEvent -> {
    // Your action here
});
```

## Integration

➠  To add this API to Gradle, juste add this in your `build.gradle`
```gradle
repositories {
  maven { url = 'https://repo.zorg-dev.fr/repository/releases/' } // QuickInventory
}

dependencies {
  implementation group: 'fr.zorg', name: 'quickinventory', version: '1.0.0' // QuickInventory
}
```