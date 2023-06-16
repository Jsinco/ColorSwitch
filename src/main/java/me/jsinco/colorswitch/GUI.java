package me.jsinco.colorswitch;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

import static me.jsinco.colorswitch.TeamSwitcher.colors;

public class GUI implements Listener {

    private static final Inventory inv = Bukkit.createInventory(null, 18, "§fColor Switch");


    public static void initGUI() {
        for (int i = 0; i < colors.length; i++) {
            inv.setItem(i, createGuiItem(true, new ItemStack(Material.BOOK), ChatColor.valueOf(colors[i]) + "§l" + colors[i]));
        }
    }

    private static ItemStack createGuiItem(boolean enchanted, ItemStack itemStack, String name, String... lore) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(Arrays.asList(lore));
        if (enchanted) meta.addEnchant(Enchantment.DIG_SPEED, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        itemStack.setItemMeta(meta);
        return itemStack;
    }


    @EventHandler
    public void invClick(InventoryClickEvent e) {
        if (!e.getInventory().equals(inv)) return;
        e.setCancelled(true);

        Player player = (Player) e.getWhoClicked();
        ItemStack clickedItem = e.getCurrentItem();

        if (clickedItem == null) return;

        if (TeamSwitcher.switchPlayerTeam(player, ChatColor.stripColor(clickedItem.getItemMeta().getDisplayName()))) {
            player.sendMessage("§aYou have been colored!");
        } else {
            player.sendMessage("§cYou do not have permission for this color!");
        }
    }

    public static void openInventory(final HumanEntity ent) {
        ent.openInventory(inv);
    } //getter for inventory
}
