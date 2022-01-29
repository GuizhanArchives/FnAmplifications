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
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class StaffOfFangs extends LimitedUseItem {


    public StaffOfFangs(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        setMaxUseCount(FNAmplifications.getInstance().getConfigManager().staffOfFangs());
    }

    @Override
    public @Nonnull ItemUseHandler getItemHandler() {
        return e -> {
            Player p = e.getPlayer();
            ItemStack item = e.getItem();
            Block block = p.getTargetBlockExact(50);

            e.cancel();
            damageItem(p, item);

            for (int i = 0; i < 10; i++){
                Location loc = block.getLocation().clone().add(0.5, 1, 0.5).setDirection(p.getLocation().clone().getDirection());
                p.getWorld().spawnEntity(loc.add(loc.getDirection().clone().multiply(i).setY(0)), EntityType.EVOKER_FANGS);
            }

            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ILLUSIONER_CAST_SPELL, 1, 1);
        };
    }

    public static void setup(){
        new StaffOfFangs(FNAmpItems.FN_STAFFS, FNAmpItems.FN_STAFF_FANGS, FnAssemblyStation.RECIPE_TYPE, new ItemStack[]{
            SlimefunItems.BLANK_RUNE, new ItemStack(Material.BLAZE_POWDER, 14), SlimefunItems.BLANK_RUNE,
            new SlimefunItemStack(SlimefunItems.EARTH_RUNE, 2), new ItemStack(Material.BLAZE_ROD), new SlimefunItemStack(SlimefunItems.EARTH_RUNE, 2),
            new SlimefunItemStack(SlimefunItems.MAGIC_LUMP_3, 7), new ItemStack(Material.ROTTEN_FLESH, 24), new SlimefunItemStack(SlimefunItems.ENDER_LUMP_3, 7)})
                .register(FNAmplifications.getInstance());
    }

}