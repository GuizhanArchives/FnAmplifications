package ne.fnfal113.fnamplifications.Staffs;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
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
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StaffOfSkulls extends LimitedUseItem {

    public StaffOfSkulls(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        setMaxUseCount(FNAmplifications.getInstance().getConfigManager().staffOfSkulls());
    }


    @Override
    public @Nonnull ItemUseHandler getItemHandler() {
        return e -> {
            Player p = e.getPlayer();
            ItemStack item = e.getItem();
            Block block = p.getTargetBlock(null, 50);

            if (block.getType() == Material.AIR) {
                return;
            }

            if (!Slimefun.getProtectionManager().hasPermission(p, block, Interaction.BREAK_BLOCK)) {
                Util.send(p, "&4你没有权限在目标地点召唤凋灵头!");
                return;
            }

            e.cancel();
            damageItem(p, item);

            for (int i = 0; i < 7; i++) {
                WitherSkull skull = (WitherSkull) p.getWorld().spawnEntity(
                    p.getEyeLocation().clone().add(
                        p.getLocation().getDirection().clone().multiply(i).setY(-0.5)
                    ),
                    EntityType.WITHER_SKULL
                );
                skull.setDirection(p.getLocation().getDirection().clone());
                skull.setGlowing(true);
                skull.setIsIncendiary(true);
                skull.setBounce(false);
            }

            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ILLUSIONER_CAST_SPELL, 1, 1);
        };
    }

    public static void setup(){
        new StaffOfSkulls(FNAmpItems.FN_STAFFS, FNAmpItems.FN_STAFF_SKULLS, FnAssemblyStation.RECIPE_TYPE, new ItemStack[]{
                new SlimefunItemStack(SlimefunItems.NECROTIC_SKULL, 2), new ItemStack(Material.WITHER_SKELETON_SKULL, 3),  new SlimefunItemStack(SlimefunItems.NECROTIC_SKULL, 2),
                new SlimefunItemStack(SlimefunItems.BLANK_RUNE, 6), new ItemStack(Material.BLAZE_ROD), new SlimefunItemStack(SlimefunItems.BLANK_RUNE, 6),
                new SlimefunItemStack(SlimefunItems.MAGIC_LUMP_3, 8), new ItemStack(Material.BLAZE_POWDER, 14), new SlimefunItemStack(SlimefunItems.MAGIC_LUMP_3, 8)})
                .register(FNAmplifications.getInstance());
    }

}