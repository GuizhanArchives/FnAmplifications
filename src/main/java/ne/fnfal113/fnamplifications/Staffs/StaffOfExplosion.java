package ne.fnfal113.fnamplifications.Staffs;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.LimitedUseItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import ne.fnfal113.fnamplifications.FNAmplifications;
import ne.fnfal113.fnamplifications.Items.FNAmpItems;
import ne.fnfal113.fnamplifications.Multiblock.FnAssemblyStation;
import net.guizhanss.minecraft.fnamplifications.Util;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class StaffOfExplosion extends LimitedUseItem {

    public StaffOfExplosion(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        setMaxUseCount(FNAmplifications.getInstance().getConfigManager().staffOfExplosion());
    }

    @Override
    public @Nonnull ItemUseHandler getItemHandler() {
        return e -> {
            Player p = e.getPlayer();
            ItemStack item = e.getItem();
            Block block = p.getTargetBlockExact(50);

            if (block == null) {
                return;
            }

            if (!Slimefun.getProtectionManager().hasPermission(p, block, Interaction.BREAK_BLOCK)) {
                Util.send(p, "&4你没有权限在目标地点生成爆炸!");
                return;
            }

            e.cancel();
            damageItem(p, item);

            block.getWorld().createExplosion(block.getLocation().clone().add(0.5, 1, 0.5), 2, false, false);

            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ILLUSIONER_CAST_SPELL, 1, 1);
        };
    }

    public static void setup(){
        new StaffOfExplosion(FNAmpItems.FN_STAFFS, FNAmpItems.FN_STAFF_EXPLOSION, FnAssemblyStation.RECIPE_TYPE, new ItemStack[]{
            new SlimefunItemStack(SlimefunItems.EARTH_RUNE, 3), new ItemStack(Material.TNT, 8), new SlimefunItemStack(SlimefunItems.EARTH_RUNE, 3),
            SlimefunItems.MAGIC_SUGAR, new ItemStack(Material.BLAZE_ROD), SlimefunItems.MAGIC_SUGAR,
            new SlimefunItemStack(SlimefunItems.MAGIC_LUMP_3, 12), new ItemStack(Material.GUNPOWDER, 16), new SlimefunItemStack(SlimefunItems.ENDER_LUMP_3, 12)})
                .register(FNAmplifications.getInstance());
    }

}
