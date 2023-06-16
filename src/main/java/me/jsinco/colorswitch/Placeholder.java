package me.jsinco.colorswitch;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static me.jsinco.colorswitch.TeamSwitcher.board;

public class Placeholder extends PlaceholderExpansion {
    @Override
    public @NotNull String getIdentifier() {
        return "colorswitch";
    }

    @Override
    public @NotNull String getAuthor() {
        return "Jsinco";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0";
    }

    @Override
    public boolean canRegister() {
        return true;
    }

    @Override
    public boolean persist() {
        return true;
    }

    @Override
    public @Nullable String onPlaceholderRequest(Player player, @NotNull String params) {
        if (params.equals("color")){
            if (board.getPlayerTeam(player) != null) {
                return TeamSwitcher.getCodebyChatcolor(board.getPlayerTeam(player).getColor());
            }
        }
        return "§f";
    }
}
