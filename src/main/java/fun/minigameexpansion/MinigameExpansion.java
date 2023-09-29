package fun.minigameexpansion;

import fun.kaituo.gameutils.GameUtils;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * This class will automatically register as a placeholder expansion
 * when a jar including this class is added to the /plugins/placeholderapi/expansions/ folder
 *
 */
public class MinigameExpansion extends PlaceholderExpansion {

    @Override
    public boolean canRegister() {
        return true;
    }
    @Override
    public String getAuthor() {
        return "YFshadaow";
    }

    @Override
    public String getIdentifier() {
        return "minigame";
    }

    /**
     * This is the version of this expansion
     */
    @Override
    public String getVersion() {
        return "1.1.0";
    }

    /**
     * This is the method called when a placeholder with our identifier is found and needs a value
     * We specify the value identifier in this method
     */
    @Override
    public String onPlaceholderRequest(Player p, String identifier) {
        GameUtils gameUtils = (GameUtils) Bukkit.getPluginManager().getPlugin("GameUtils");
        if (gameUtils == null) {
            return "!GameUtilsNotLoaded!";
        }
        if (identifier.equals("game")) {
            if ((p) != null) {
                return gameUtils.getPlayerGame(p).getName() ;
            } else {
                return "!GameIsNull!";
            }
        } else if (identifier.equals("game_full_name")) {
            if ((p) != null) {
                return gameUtils.getPlayerGame(p).getFullName();
            } else {
                return "!GameIsNull!";
            }
        }
        return "!ExpansionError!";
    }
}