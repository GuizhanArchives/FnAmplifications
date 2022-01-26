package net.guizhanss.minecraft.fnamplifications;

import io.github.thebusybiscuit.slimefun4.libraries.dough.common.ChatColors;
import org.bukkit.entity.Player;

public class Util {
    private Util() {}

    public static void send(Player p, String message) {
        p.sendMessage(ChatColors.color(message));
    }
}
