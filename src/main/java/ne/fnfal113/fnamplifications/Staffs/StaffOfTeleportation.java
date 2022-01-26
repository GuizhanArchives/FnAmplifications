package ne.fnfal113.fnamplifications.Staffs;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.LimitedUseItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import ne.fnfal113.fnamplifications.config.ConfigManager;
import ne.fnfal113.fnamplifications.FNAmplifications;
import ne.fnfal113.fnamplifications.Items.FNAmpItems;
import ne.fnfal113.fnamplifications.Multiblock.FnAssemblyStation;
import net.guizhanss.minecraft.fnamplifications.Util;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import javax.annotation.Nonnull;
import java.util.Objects;

public class StaffOfTeleportation extends LimitedUseItem {

    private static final ConfigManager value = FNAmplifications.getInstance().getConfigManager();

    private static final NamespacedKey usageKey = new NamespacedKey(FNAmplifications.getInstance(), "tpstaff");

    public StaffOfTeleportation(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        setMaxUseCount(value.staffOfTeleportation());
    }

    @Override
    protected @Nonnull NamespacedKey getStorageKey() {
        return usageKey;
    }

    @Override
    public @Nonnull ItemUseHandler getItemHandler() {
        return e -> {
            Player p = e.getPlayer();
            ItemStack item = e.getItem();
            Block block = p.getTargetBlockExact(100);
            Vector directional = p.getLocation().getDirection();

            if (block == null || item.getType() == Material.AIR){
                return;
            }

            if (!Slimefun.getProtectionManager().hasPermission(
                Bukkit.getOfflinePlayer(p.getUniqueId()),
                block,
                Interaction.BREAK_BLOCK)
            ) {
                Util.send(p, "&4你没有权限传送到目标地点!");
                return;
            }

            e.cancel();
            damageItem(p, item);
            p.teleport(block.getLocation().add(0.5, 1, 0.5).setDirection(directional));
            Objects.requireNonNull(p.getLocation().getWorld()).playSound(p.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
        };
    }

    public static ItemStack ALT_RECIPE = SlimefunItems.COMMON_TALISMAN;

    static {
        SlimefunItem alt_recipe = SlimefunItem.getByItem(SlimefunItems.SCROLL_OF_DIMENSIONAL_TELEPOSITION);
        if(alt_recipe != null && !alt_recipe.isDisabled()){
            ALT_RECIPE = alt_recipe.getItem().clone();
        }
    }

    public static void setup(){
        new StaffOfTeleportation(FNAmpItems.FN_STAFFS, FNAmpItems.FN_STAFF_TP, FnAssemblyStation.RECIPE_TYPE, new ItemStack[]{
                new SlimefunItemStack(SlimefunItems.MAGIC_LUMP_3, 5), ALT_RECIPE, new SlimefunItemStack(SlimefunItems.ENDER_LUMP_3, 5),
                SlimefunItems.ENDER_RUNE, new ItemStack(Material.BLAZE_ROD), SlimefunItems.ENDER_RUNE,
                new SlimefunItemStack(SlimefunItems.BLANK_RUNE, 2), SlimefunItems.MAGIC_EYE_OF_ENDER, new SlimefunItemStack(SlimefunItems.BLANK_RUNE, 2)})
                .register(FNAmplifications.getInstance());
    }
}
