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
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.SkeletonHorse;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;
import java.util.Random;

public class StaffOfStallion extends LimitedUseItem {

    public StaffOfStallion(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        setMaxUseCount(FNAmplifications.getInstance().getConfigManager().staffOfStallion());
    }

    @Override
    public @Nonnull ItemUseHandler getItemHandler() {
        return e -> {
            Player p = e.getPlayer();
            ItemStack item = e.getItem();
            Block block = p.getLocation().getBlock();

            if (!Slimefun.getProtectionManager().hasPermission(p, block, Interaction.BREAK_BLOCK)) {
                Util.send(p, "&4你没有权限召唤骷髅马!");
                return;
            }

            e.cancel();
            damageItem(p, item);

            SkeletonHorse skeletonHorse = (SkeletonHorse) p.getWorld().spawnEntity(p.getLocation() , EntityType.SKELETON_HORSE);
            skeletonHorse.setAdult();
            skeletonHorse.setTamed(true);
            skeletonHorse.setCustomName("FN_SKELETON_HORSE");
            skeletonHorse.setCustomNameVisible(false);
            skeletonHorse.getPersistentDataContainer().set(new NamespacedKey(FNAmplifications.getInstance(), "Horsey"), PersistentDataType.INTEGER, new Random().nextInt(9999));
            skeletonHorse.setOwner(p);
            skeletonHorse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
            skeletonHorse.addPassenger(p);

            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ILLUSIONER_CAST_SPELL, 1, 1);
        };
    }

    public static void setup(){
        new StaffOfStallion(FNAmpItems.FN_STAFFS, FNAmpItems.FN_STAFF_STALLION, FnAssemblyStation.RECIPE_TYPE, new ItemStack[]{
                new SlimefunItemStack(SlimefunItems.MAGIC_LUMP_3, 32), new ItemStack(Material.SADDLE), new SlimefunItemStack(SlimefunItems.ENDER_LUMP_3, 32),
                SlimefunItems.ESSENCE_OF_AFTERLIFE, new ItemStack(Material.BLAZE_ROD),  SlimefunItems.ESSENCE_OF_AFTERLIFE,
                new ItemStack(Material.BONE, 32), SlimefunItems.MAGIC_SUGAR, new ItemStack(Material.BONE, 32)})
                .register(FNAmplifications.getInstance());
    }
}