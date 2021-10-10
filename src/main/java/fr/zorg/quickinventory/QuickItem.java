package fr.zorg.quickinventory;

import dev.dbassett.skullcreator.SkullCreator;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class QuickItem {

    private ItemStack item;
    private ItemMeta itemMeta;

    /**
     * Creates a new {@link QuickItem}
     *
     * @param itemStack The {@link ItemStack} of the {@link QuickItem}
     */
    public QuickItem(ItemStack itemStack) {
        this.item = itemStack;
        this.itemMeta = this.item.getItemMeta();
    }

    /**
     * Creates a new {@link QuickItem}
     *
     * @param material The {@link Material} of the {@link QuickItem}
     * @return A new {@link QuickItem}
     */
    public static QuickItem of(Material material) {
        return new QuickItem(new ItemStack(material));
    }

    /**
     * Creates a new {@link QuickItem}
     *
     * @param itemStack The {@link ItemStack} of the {@link QuickItem}
     * @return A new {@link QuickItem}
     */
    public static QuickItem of(ItemStack itemStack) {
        return new QuickItem(itemStack);
    }

    /**
     * Set the amount of the {@link QuickItem} to the parameter
     *
     * @param size The size expected
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem setSize(int size) {
        this.item.setAmount(size);
        return this;
    }

    /**
     * Set the amount of the {@link QuickItem} to the parameter
     *
     * @param size The size expected
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem size(int size) {
        return this.setSize(size);
    }

    /**
     * Set the amount of the {@link QuickItem} to the parameter
     *
     * @param amount The size expected
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem setAmount(int amount) {
        return this.setSize(amount);
    }

    /**
     * Set the amount of the {@link QuickItem} to the parameter
     *
     * @param amount The size expected
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem amount(int amount) {
        return this.setSize(amount);
    }

    /**
     * Sets the name of the {@link QuickItem} to the parameter
     *
     * @param name The name to apply
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem setName(String name) {
        this.itemMeta.setDisplayName(name);
        return this;
    }

    /**
     * Sets the name of the {@link QuickItem} to the parameter
     *
     * @param name The name to apply
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem name(String name) {
        return this.setName(name);
    }

    /**
     * Set the lore of the {@link QuickItem} to the parameter
     *
     * @param lore The lore to apply
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem setLore(List<String> lore) {
        this.itemMeta.setLore(lore);
        return this;
    }

    /**
     * Set the lore of the {@link QuickItem} to the parameter
     *
     * @param lore The lore to apply
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem setLore(String... lore) {
        return this.setLore(Arrays.asList(lore));
    }

    /**
     * Set the lore of the {@link QuickItem} to the parameter
     *
     * @param lore The lore to apply
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem lore(List<String> lore) {
        return this.setLore(lore);
    }

    /**
     * Set the lore of the {@link QuickItem} to the parameter
     *
     * @param lore The lore to apply
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem lore(String... lore) {
        return this.setLore(Arrays.asList(lore));
    }

    /**
     * Add the parameter to the lore of the {@link QuickItem}
     *
     * @param lore The line to add
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem addLore(String lore) {
        this.itemMeta.getLore().add(lore);
        return this;
    }

    /**
     * Add the parameter to the lore of the {@link QuickItem}
     *
     * @param lore The lines to add
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem addLore(List<String> lore) {
        this.itemMeta.getLore().addAll(lore);
        return this;
    }

    /**
     * Add the parameter to the lore of the {@link QuickItem}
     *
     * @param lore The line(s) to add
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem addLore(String... lore) {
        return this.addLore(Arrays.asList(lore));
    }

    /**
     * Resets the lore of the {@link QuickItem}
     *
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem resetLore() {
        this.itemMeta.setLore(Collections.emptyList());
        return this;
    }

    /**
     * Enchant the {@link QuickItem} with a specific level
     *
     * @param enchantment The enchantment to apply
     * @param level       The level of the enchantment to apply
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem setEnchant(Enchantment enchantment, int level) {
        this.itemMeta.addEnchant(enchantment, level, true);
        return this;
    }

    /**
     * Enchant the {@link QuickItem} with a specific level
     *
     * @param enchantment The enchantment to apply
     * @param level       The level of the enchantment to apply
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem enchant(Enchantment enchantment, int level) {
        return this.setEnchant(enchantment, level);
    }

    /**
     * Remove the enchantment from the {@link QuickItem}
     *
     * @param enchantment The enchantment to remove
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem removeEnchant(Enchantment enchantment) {
        this.itemMeta.removeEnchant(enchantment);
        return this;
    }

    /**
     * Reset all enchantments from the {@link QuickItem}
     *
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem resetEnchants() {
        this.itemMeta.getEnchants().forEach((enchantment, integer) -> this.itemMeta.removeEnchant(enchantment));
        return this;
    }

    /**
     * Set the durability of the {@link QuickItem}
     *
     * @param durability The durability to set
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem setDurability(int durability) {
        this.item.setDurability((short) durability);
        return this;
    }

    /**
     * Set the durability of the {@link QuickItem}
     *
     * @param durability The durability to set
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem durability(int durability) {
        return this.setDurability(durability);
    }

    /**
     * Add one or more {@link ItemFlag} to the {@link QuickItem}
     *
     * @param itemFlags The {@link ItemFlag} to apply
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem addItemFlag(ItemFlag... itemFlags) {
        this.itemMeta.addItemFlags(itemFlags);
        return this;
    }

    /**
     * Remove one or more {@link ItemFlag} to the {@link QuickItem}
     *
     * @param itemFlags The {@link ItemFlag} to remove
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem removeItemFlag(ItemFlag... itemFlags) {
        this.itemMeta.removeItemFlags(itemFlags);
        return this;
    }

    /**
     * Chose if an item in unbreakable or not
     *
     * @param unbreakable Is unbreakable or not
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem setUnbreakable(boolean unbreakable) {
        this.itemMeta.spigot().setUnbreakable(unbreakable);
        return this;
    }

    /**
     * Chose if an item in unbreakable or not
     *
     * @param unbreakable Is unbreakable or not
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem unbreakable(boolean unbreakable) {
        return this.setUnbreakable(unbreakable);
    }

    /**
     * Set the value of a skull to its Base64 value
     *
     * @param base64String The value "Value:" from a skull on <a href="https://minecraft-heads.com">minecraft-heads</a> skull
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem setBase64SkullValue(String base64String) {
        if (this.item.getItemMeta() instanceof SkullMeta)
            this.item = SkullCreator.itemWithBase64(this.item, base64String);
        return this;
    }

    /**
     * Make an item glow without its enchantments written in its lore
     *
     * @param glowing If the item should glow or not
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem setGlowing(boolean glowing) {
        if (glowing)
            return this.removeEnchant(Enchantment.LURE).removeItemFlag(ItemFlag.HIDE_ENCHANTS);
        return this.setEnchant(Enchantment.LURE, 1).addItemFlag(ItemFlag.HIDE_ENCHANTS);
    }

    /**
     * Make an item glow without its enchantments written in its lore
     *
     * @return The {@link QuickItem}, useful for chaining
     */
    public QuickItem glow() {
        return this.setGlowing(true);
    }

    /**
     * Builds the {@link QuickItem}
     *
     * @return The {@link ItemStack} that represents the {@link QuickItem}
     */
    public ItemStack build() {
        this.item.setItemMeta(this.itemMeta);
        return this.item;
    }

    /**
     * Return the amount of the {@link QuickItem}
     *
     * @return The amount of the {@link QuickItem}
     */
    public int getAmount() {
        return this.item.getAmount();
    }

    /**
     * Return the display name of the {@link QuickItem}
     *
     * @return The display name of the {@link QuickItem}
     */
    public String getName() {
        return this.itemMeta.getDisplayName();
    }

    /**
     * Return a list of the lore of the {@link QuickItem}
     *
     * @return The lore of the {@link QuickItem}
     */
    public List<String> getLore() {
        return this.itemMeta.getLore();
    }

    /**
     * Return a map of the {@link Enchantment} | its level of the {@link QuickItem}
     *
     * @return Enchantments of the {@link QuickItem}
     */
    public Map<Enchantment, Integer> getEnchants() {
        return this.itemMeta.getEnchants();
    }

    /**
     * Return a list of all {@link ItemFlag} of the {@link QuickItem}
     *
     * @return All ItemFlags applied to the {@link QuickItem}
     */
    @SuppressWarnings("unchecked")
    public List<ItemFlag> getItemFlags() {
        return (List<ItemFlag>) this.itemMeta.getItemFlags();
    }

    /**
     * Check if the {@link QuickItem} is unbreakable
     *
     * @return The unbreakable state of the {@link QuickItem}
     */
    public boolean isUnbreakable() {
        return this.itemMeta.spigot().isUnbreakable();
    }

    /**
     * Check if the {@link QuickItem} is glowing (or enchanted if you prefer)
     *
     * @return The glowing state of the {@link QuickItem}
     */
    public boolean isGlowing() {
        return this.itemMeta.hasEnchants();
    }

}