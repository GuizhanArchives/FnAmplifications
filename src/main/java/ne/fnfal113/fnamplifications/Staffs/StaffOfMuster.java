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
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class StaffOfMuster extends LimitedUseItem {

    public StaffOfMuster(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        setMaxUseCount(FNAmplifications.getInstance().getConfigManager().staffOfMuster());
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
                Util.send(p, "&4你没有权限在目标地点释放聚集法术!");
                return;
            }

            e.cancel();
            damageItem(p, item);

            int amount = 0;
            for (Entity entity : block.getWorld().getNearbyEntities(block.getLocation(), 50, 50, 50)) {
                if (Slimefun.getProtectionManager().hasPermission(p, entity.getLocation(), Interaction.INTERACT_ENTITY)) {

                    if (entity instanceof LivingEntity && !(entity instanceof ArmorStand)
                        && !((LivingEntity) entity).isLeashed() && !entity.isInWater() && !(entity instanceof Player)) {
                        entity.teleport(block.getLocation().clone().add(0.5, 1, 0.5));
                        amount++;
                    } // instanceof check
                } // permission check
            } // for each

            Util.send(p, "&a聚集了 " + amount + " 个实体");

            block.getWorld().playEffect(block.getLocation().clone().add(0.5, 1, 0.5), Effect.ENDER_SIGNAL, 1);

            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ILLUSIONER_CAST_SPELL, 1, 1);
        };
    }

    public static void setup(){
        new StaffOfMuster(FNAmpItems.FN_STAFFS, FNAmpItems.FN_STAFF_MUSTER, FnAssemblyStation.RECIPE_TYPE, new ItemStack[]{
            new SlimefunItemStack(SlimefunItems.ENDER_RUNE, 2), new ItemStack(Material.ENDER_PEARL, 16), new SlimefunItemStack(SlimefunItems.ENDER_RUNE, 2),
            SlimefunItems.MAGIC_EYE_OF_ENDER, new ItemStack(Material.BLAZE_ROD), SlimefunItems.MAGIC_EYE_OF_ENDER,
            new SlimefunItemStack(SlimefunItems.ENDER_LUMP_3, 10), SlimefunItems.MAGIC_SUGAR, new SlimefunItemStack(SlimefunItems.ENDER_LUMP_3, 10)})
                .register(FNAmplifications.getInstance());
    }

}
