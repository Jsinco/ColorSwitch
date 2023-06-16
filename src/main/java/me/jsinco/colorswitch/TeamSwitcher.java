package me.jsinco.colorswitch;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;

public class TeamSwitcher {
    public static Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
    public static final String[] colors = {"RED","BLUE","GREEN","YELLOW","AQUA","GOLD","GRAY","DARK_AQUA","DARK_BLUE","DARK_GRAY","DARK_GREEN","DARK_PURPLE","DARK_RED","LIGHT_PURPLE","WHITE","BLACK"};

    public static void RegisterGlowColors() {
        for (String color : colors) {
            if (board.getTeam(color) == null) {
                board.registerNewTeam(color).setColor(ChatColor.valueOf(color));
            }
        }
    }

    public static boolean switchPlayerTeam(Player player, String color) {
        if (!player.hasPermission("colorswitch." + color)) {
            return false;
        }
        try {
            board.getTeam(color).addEntry(player.getName());
        } catch (NullPointerException e){
            RegisterGlowColors();
            board.getTeam(color).addEntry(player.getName());
        }
        return true;
    }

    public static String getCodebyChatcolor(ChatColor colorCode){
        return switch (colorCode) {
            case AQUA -> "§b";
            case BLACK -> "§0";
            case BLUE -> "§9";
            case DARK_AQUA -> "§3";
            case DARK_BLUE -> "§1";
            case DARK_GRAY -> "§8";
            case DARK_GREEN -> "§2";
            case DARK_PURPLE -> "§5";
            case DARK_RED -> "§4";
            case GOLD -> "§6";
            case GRAY -> "§7";
            case GREEN -> "§a";
            case LIGHT_PURPLE -> "§d";
            case RED -> "§c";
            case YELLOW -> "§e";
            default -> "§f";
        };
    }
}
