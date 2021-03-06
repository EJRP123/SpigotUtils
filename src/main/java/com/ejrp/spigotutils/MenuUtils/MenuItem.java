package com.ejrp.spigotutils.MenuUtils;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

/**
 * Represents an item in a menu. It has an item that will be displayed in the inventory.
 * You can override the clicked method to set the code to run when this item is clicked.
 * Please note that it is up to the implementation of the inventory to execute the clicked
 * method or not.
 */
public abstract class MenuItem {

    @NotNull private final ItemStack item;

    /**
     * Creates a new Menu Item object
     * @param item The item that will be displayed
     */
    public MenuItem(@NotNull ItemStack item) { this.item = item; }

    /**
     * Gets the item of this Menu Item object
     * @return The item of this Menu Item object
     */
    @NotNull public ItemStack getItem() { return this.item; }

    /**
     * Applies the listener of this menu item
     * @param event The event that was passed when the player clicked on this item.
     */
    public void clicked(@NotNull InventoryClickEvent event) { }

}
