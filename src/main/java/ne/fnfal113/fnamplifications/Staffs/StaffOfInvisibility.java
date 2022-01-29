package ne.fnfal113.fnamplifications.Staffs;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.LimitedUseItem;
import ne.fnfal113.fnamplifications.FNAmplifications;
import ne.fnfal113.fnamplifications.Items.FNAmpItems;
import ne.fnfal113.fnamplifications.Multiblock.FnAssemblyStation;
import net.guizhanss.minecraft.fnamplifications.Util;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import javax.annotation.Nonnull;

public class StaffOfInvisibility extends LimitedUseItem {

    public StaffOfInvisibility(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        setMaxUseCount(FNAmplifications.getInstance().getConfigManager().staffOfInvisibility());
    }

    @Override
    public @Nonnull ItemUseHandler getItemHandler() {
        return e -> {
            Player p = e.getPlayer();
            ItemStack item = e.getItem();
            Plugin plugin = FNAmplifications.getInstance();

            e.cancel();

            if (p.isInvisible()) {
                Util.send(p, "&e隐身状态下无法使用该法杖!");
                return;
            }

            damageItem(p, item);

            for(Player online : plugin.getServer().getOnlinePlayers()){
                online.hidePlayer(plugin, p);
                PotionEffect effect = new PotionEffect(PotionEffectType.GLOWING,115,1, false, false);
                PotionEffect effect2 = new PotionEffect(PotionEffectType.INVISIBILITY,115,1, false, false);
                p.addPotionEffect(effect);
                p.addPotionEffect(effect2);
            }
            Util.send(p, "&e你获得了超级隐身，所有玩家都无法看到你!");

            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ILLUSIONER_CAST_SPELL, 1, 1);

            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                if(!p.isOnline()){
                    return;
                }
                for(Player online : Bukkit.getOnlinePlayers()){
                    online.showPlayer(plugin, p);
                }
            }, 120L);
        };
    }

    public static void setup(){
        new StaffOfInvisibility(FNAmpItems.FN_STAFFS, FNAmpItems.FN_STAFF_INVI, FnAssemblyStation.RECIPE_TYPE, new ItemStack[]{
            new SlimefunItemStack(SlimefunItems.BLANK_RUNE, 2), SlimefunItems.MAGICAL_GLASS, new SlimefunItemStack(SlimefunItems.ENDER_LUMP_3, 6),
            SlimefunItems.AIR_RUNE, new ItemStack(Material.BLAZE_ROD), SlimefunItems.AIR_RUNE,
            new SlimefunItemStack(SlimefunItems.MAGIC_LUMP_3, 6), SlimefunItems.MAGIC_SUGAR,  new SlimefunItemStack(SlimefunItems.BLANK_RUNE, 2)})
                .register(FNAmplifications.getInstance());
    }
}
