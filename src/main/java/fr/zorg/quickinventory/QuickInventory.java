package fr.zorg.quickinventory;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class QuickInventory implements InventoryHolder {

    private Inventory inventory;

    private Map<Integer, Consumer<InventoryClickEvent>> actions;

    public QuickInventory(InventoryType inventoryType, String title, int size) {
        this.actions = new HashMap<>();
        if (inventoryType == InventoryType.CHEST)
            this.inventory = Bukkit.createInventory(this, size < 9 ? size * 9 : size, title);
        else
            this.inventory = Bukkit.createInventory(this, inventoryType, title);
    }

    public QuickInventory(InventoryType inventoryType) {
        this(inventoryType, inventoryType.getDefaultTitle(), inventoryType.getDefaultSize());
    }

    public QuickInventory(InventoryType inventoryType, String title) {
        this(inventoryType, title, inventoryType.getDefaultSize());
    }

    public QuickInventory(InventoryType inventoryType, int size) {
        this(inventoryType, inventoryType.getDefaultTitle(), size);
    }

    /**
     * Set a specific slot of the {@link QuickInventory} to a {@link ItemStack,
     * with an action to perform when this item is clicked
     *
     * @param slot      The slot to set
     * @param quickItem The {@link ItemStack} to set, don't need to build it directly
     * @param action    The action to perform when the item is clicked in the inventory
     * @return The {@link QuickInventory}
     */
    public QuickInventory setSlot(int slot, ItemStack item, Consumer<InventoryClickEvent> action) {
        this.inventory.setItem(slot, item);

        if (this.actions.containsKey(slot))
            this.actions.remove(slot);

        if (action != null)
            this.actions.put(slot, action);
        return this;
    }

    /**
     * Set a specific slot of the {@link QuickInventory} to a {@link ItemStack}
     *
     * @param slot The slot to set
     * @param item The {@link ItemStack} to set
     * @return The {@link QuickInventory}
     */
    public QuickInventory setSlot(int slot, ItemStack item) {
        return this.setSlot(slot, item, null);
    }

    /**
     * Set a specific slot of the {@link QuickInventory} to a {@link QuickItem}
     *
     * @param slot      The slot to set
     * @param quickItem The {@link QuickItem} to set, don't need to build it directly
     * @return The {@link QuickInventory}
     */
    public QuickInventory setSlot(int slot, QuickItem quickItem) {
        return this.setSlot(slot, quickItem.build(), null);
    }

    /**
     * Set a specific slot of the {@link QuickInventory} to a {@link QuickItem}
     *
     * @param slot      The slot to set
     * @param quickItem The {@link QuickItem} to set, don't need to build it directly
     * @param action    The action to perform when the item is clicked in the inventory
     * @return The {@link QuickInventory}
     */
    public QuickInventory setSlot(int slot, QuickItem quickItem, Consumer<InventoryClickEvent> action) {
        return this.setSlot(slot, quickItem.build(), action);
    }

    /**
     * Set multiple slots to an {@link ItemStack}, with an action to perform
     *
     * @param slots  The slots to set
     * @param item   The item to set
     * @param action The action to perform when an item is clicked
     * @return The {@link QuickInventory}
     */
    public QuickInventory setSlots(int[] slots, ItemStack item, Consumer<InventoryClickEvent> action) {
        for (int slot : slots) {
            this.setSlot(slot, item, action);
        }
        return this;
    }

    /**
     * Set multiple slots to an {@link ItemStack}
     *
     * @param slots The slots to set
     * @param item  The item to set
     * @return The {@link QuickInventory}
     */
    public QuickInventory setSlots(int[] slots, ItemStack item) {
        return this.setSlots(slots, item, null);
    }

    /**
     * Set corners of the {@link QuickInventory} to an {@link ItemStack}, with an action
     *
     * @param item   The {@link ItemStack} to set
     * @param action The action to trigger when one of the item is clicked
     * @return The {@link QuickInventory}
     * @author <a href="https://github.com/MrMicky-FR/">MrMicky</a>
     * @author <a href="https://github.com/MrMicky-FR/FastInv/blob/ab91d148986be89c99d2f2149cbad4181c888fdd/src/main/java/fr/mrmicky/fastinv/FastInv.java#L301">FastInv</a>
     */
    public QuickInventory setCorners(ItemStack item, Consumer<InventoryClickEvent> action) {
        int size = this.inventory.getSize();
        return this.setSlots(IntStream.range(0, size)
                .filter(i -> i < 2 || (i > 6 && i < 10) || i == 17 || i == size - 18 || (i > size - 11 && i < size - 7) || i > size - 3)
                .toArray(), item, action);
    }

    /**
     * Set corners of the {@link QuickInventory} to an {@link ItemStack}, with an action
     *
     * @param item The {@link ItemStack} to set
     * @return The {@link QuickInventory}
     * @author <a href="https://github.com/MrMicky-FR/">MrMicky</a>
     * @author <a href="https://github.com/MrMicky-FR/FastInv/blob/ab91d148986be89c99d2f2149cbad4181c888fdd/src/main/java/fr/mrmicky/fastinv/FastInv.java#L301">FastInv</a>
     */
    public QuickInventory setCorners(ItemStack item) {
        return this.setCorners(item, null);
    }

    /**
     * Set corners of the {@link QuickInventory} to a {@link QuickItem}
     *
     * @param quickItem The {@link QuickItem} to set
     * @return The {@link QuickInventory}
     * @author <a href="https://github.com/MrMicky-FR/">MrMicky</a>
     * @author <a href="https://github.com/MrMicky-FR/FastInv/blob/ab91d148986be89c99d2f2149cbad4181c888fdd/src/main/java/fr/mrmicky/fastinv/FastInv.java#L301">FastInv</a>
     */
    public QuickInventory setCorners(QuickItem quickItem) {
        return this.setCorners(quickItem.build(), null);
    }

    /**
     * Set corners of the {@link QuickInventory} to a {@link QuickItem}, with an action
     *
     * @param quickItem The {@link ItemStack} to set
     * @param action    The action to trigger when one of the item is clicked
     * @return The {@link QuickInventory}
     * @author <a href="https://github.com/MrMicky-FR/">MrMicky</a>
     * @author <a href="https://github.com/MrMicky-FR/FastInv/blob/ab91d148986be89c99d2f2149cbad4181c888fdd/src/main/java/fr/mrmicky/fastinv/FastInv.java#L301">FastInv</a>
     */
    public QuickInventory setCorners(QuickItem quickItem, Consumer<InventoryClickEvent> action) {
        return this.setCorners(quickItem.build(), action);
    }

    /**
     * Set borders of the {@link QuickInventory} to an {@link ItemStack}, with an action
     *
     * @param item   The {@link ItemStack} to set
     * @param action The action to trigger when one of the item is clicked
     * @return The {@link QuickInventory}
     * @author <a href="https://github.com/MrMicky-FR/">MrMicky</a>
     * @author <a href="https://github.com/MrMicky-FR/FastInv/blob/ab91d148986be89c99d2f2149cbad4181c888fdd/src/main/java/fr/mrmicky/fastinv/FastInv.java#L291">FastInv</a>
     */
    public QuickInventory setBorders(ItemStack item, Consumer<InventoryClickEvent> action) {
        int size = this.inventory.getSize();
        return this.setSlots(IntStream.range(0, size)
                .filter(i -> size < 27 || i < 9 || i % 9 == 0 || (i - 8) % 9 == 0 || i > size - 9)
                .toArray(), item, action);
    }

    /**
     * Set borders of the {@link QuickInventory} to an {@link ItemStack}
     *
     * @param item The {@link QuickItem} to set
     * @return The {@link QuickInventory}
     * @author <a href="https://github.com/MrMicky-FR/">MrMicky</a>
     * @author <a href="https://github.com/MrMicky-FR/FastInv/blob/ab91d148986be89c99d2f2149cbad4181c888fdd/src/main/java/fr/mrmicky/fastinv/FastInv.java#L291">FastInv</a>
     */
    public QuickInventory setBorders(ItemStack item) {
        return this.setBorders(item, null);
    }

    /**
     * Set borders of the {@link QuickInventory} to a {@link QuickItem}
     *
     * @param quickItem The {@link QuickItem} to set
     * @return The {@link QuickInventory}
     * @author <a href="https://github.com/MrMicky-FR/">MrMicky</a>
     * @author <a href="https://github.com/MrMicky-FR/FastInv/blob/ab91d148986be89c99d2f2149cbad4181c888fdd/src/main/java/fr/mrmicky/fastinv/FastInv.java#L291">FastInv</a>
     */
    public QuickInventory setBorders(QuickItem quickItem) {
        return this.setBorders(quickItem.build(), null);
    }

    /**
     * Set borders of the {@link QuickInventory} to a {@link QuickItem}, with an action
     *
     * @param quickItem The {@link QuickItem} to set
     * @param action    The action to trigger when one of the item is clicked
     * @return The {@link QuickInventory}
     * @author <a href="https://github.com/MrMicky-FR/">MrMicky</a>
     * @author <a href="https://github.com/MrMicky-FR/FastInv/blob/ab91d148986be89c99d2f2149cbad4181c888fdd/src/main/java/fr/mrmicky/fastinv/FastInv.java#L291">FastInv</a>
     */
    public QuickInventory setBorders(QuickItem quickItem, Consumer<InventoryClickEvent> action) {
        return this.setBorders(quickItem.build(), action);
    }

    /**
     * Sets the {@link QuickInventory} to another {@link QuickInventory}
     *
     * @param otherInventory The {@link QuickInventory} to replace with this one
     * @return The {@link QuickInventory}
     */
    public QuickInventory setInventory(QuickInventory otherInventory) {
        this.inventory = otherInventory.getInventory();
        this.actions = otherInventory.getActions();
        return this;
    }

    /**
     * Shortcut to {@link QuickInventory#setSlot(int, QuickItem)}
     *
     * @param slot      The slot to set
     * @param quickItem The {@link QuickItem} to set
     * @return The {@link QuickInventory}
     * @see QuickInventory#setSlot(int, QuickItem)
     */
    public QuickInventory s(int slot, QuickItem quickItem) {
        return this.setSlot(slot, quickItem.build(), null);
    }

    /**
     * Shortcut to {@link QuickInventory#setSlot(int, ItemStack, Consumer)}
     *
     * @param slot      The slot to set
     * @param quickItem The {@link QuickItem} to set
     * @param action    The action to perform
     * @return The {@link QuickInventory}
     * @see QuickInventory#setSlot(int, QuickItem, Consumer)
     */
    public QuickInventory s(int slot, QuickItem quickItem, Consumer<InventoryClickEvent> action) {
        return this.setSlot(slot, quickItem.build(), action);
    }

    /**
     * Open the {@link QuickInventory} to a {@link Player}
     *
     * @param player The player to open the inventory
     * @return The {@link QuickInventory}
     */
    public QuickInventory open(Player player) {
        player.openInventory(this.inventory);
        QuickInventoryManager.addListener(this.inventory, this);
        return this;
    }

    /**
     * Static method to open a {@link QuickInventory} to a {@link Player}
     *
     * @param quickInventory The {@link QuickInventory} to open to the {@link Player}
     * @param player         The player to open the inventory
     * @return The {@link QuickInventory}
     */
    public static QuickInventory open(QuickInventory quickInventory, Player player) {
        return quickInventory.open(player);
    }

    @Override
    public Inventory getInventory() {
        return this.inventory;
    }

    protected Map<Integer, Consumer<InventoryClickEvent>> getActions() {
        return this.actions;
    }

}