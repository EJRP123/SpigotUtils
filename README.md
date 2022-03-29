# Spigot Utils

Spigot Utils is a library to aid you in Spigot plugin development. 
It currently contains some command utilities, menu utilities and item utilities.
If you want to use this library in your plugin, you will have to clone this repo 
and run maven clean install to install this jar to your local maven repo.
This will install the jar with the source code and the javadocs.


## Code examples: 

This is how to create a command using the PluginCommand class:

```java
import com.ejrp.spigotutils.CommandUtils.*;

@CommandInfo(name = "example", permission = "admin", requiresPlayer = true)
public class CommandExample {

  @Override
  public void execute(Player player, String[] args) { 
       // If requiresPlayer is equal false, then override the execute method with the commandSender parameter
  }

}
```

This is how to create an item and add lore:

```java
ItemStack item = new ItemBuilder(Material.DIAMOND)
        .setItemAmount(42)
        .setDisplayName(ChatColor.GOLD + "What is 42?")
        .setLore(ChatColor.GREEN + "The answer to the universe and everything!")
        .getItem();
```

Here is how you can create a speed potion with a custom effect, color and hidden attributes. 
Please take note that this only works in 1.9 or above. If you are using 1.8, then use the Potion class in the spigot API

```java
ItemStack potion = PotionBuilder.getDrinkablePotion()
        .addCustomEffect(new PotionEffect(
                PotionEffectType.SPEED,
                45 * 20,
                1,
                false,
                false,
                true),true)
        .modifyMeta(potionMeta -> potionMeta.setBasePotionData(new PotionData(PotionType.SPEED)))
        .modifyMeta(potionMeta -> potionMeta.setColor(Color.PURPLE))
        .modifyMeta(potionMeta -> potionMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES,ItemFlag.HIDE_POTION_EFFECTS))
        .getItem();
```

This is how to create a scrolling menu and add items to it.
Note that an item index can be as big as it wants but bigger not smaller than 0.
```java
ScrollingMenu menu = new ScrollingMenu(
        pluginInstance,
        "Example", // Name of the inventory
        36, // Size of the inventory
        event -> event.getWhoClicked().sendMessage("You just clicked your bottom inventory!"),
        new HashMap<>(), // Empty inventory for now
        null, // There is no inventory to open when this one closes
        1, // Line scolled when the player clicks the scroll button
        Material.LADDER, // The scroll button material
        ScrollingMenu.InventoryCorner.BOTTOM_RIGHT, // Scroll down button corner
        ScrollingMenu.InventoryCorner.TOP_RIGHT, // Scroll up bottun corner
        Sound.UI_BUTTON_CLICK, // Sound to play on scroll
        Sound.BLOCK_ANVIL_BREAK, // Scroll to play when you cannot scroll
        false // Do not go back to the first line when you reopen the inventory
);
  
menu.addItem(10,
        new MenuItem(new ItemStack(Material.WATER_BUCKET)) // Do nothing when this item is clicked
);
        
menu.addItem(60,
        new MenuItem(
                new ItemStack(Material.GOLD_BLOCK),
                event -> event.getWhoClicked().sendMessage(ChatColor.GOLD + "You found me!"))
);
```
Please note that you can extend the Menu class to create your own custom menu, like a menu that can scroll sideways and upwards, for example.
