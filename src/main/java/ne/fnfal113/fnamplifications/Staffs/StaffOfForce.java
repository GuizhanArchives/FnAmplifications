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
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import javax.annotation.Nonnull;

public class StaffOfForce extends LimitedUseItem {

    public StaffOfForce(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        setMaxUseCount(FNAmplifications.getInstance().getConfigManager().staffOfForce());
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
                Util.send(p, "&4你没有权限在目标地点召唤力量区域!");
                return;
            }

            e.cancel();
            damageItem(p, item);

            if(p.isSneaking()) {
                AreaEffectCloud effectCloudBack = (AreaEffectCloud) p.getWorld().spawnEntity(block.getLocation().add(0.5, 1, 0.5), EntityType.AREA_EFFECT_CLOUD);
                effectCloudBack.setParticle(Particle.END_ROD);
                effectCloudBack.setDuration(160);
                effectCloudBack.setRadius(2.85F);
                effectCloudBack.setCustomName("FN_BACKWARD_FORCE");
                effectCloudBack.setCustomNameVisible(false);
                effectCloudBack.addCustomEffect(new PotionEffect(PotionEffectType.GLOWING, 0, 0, false, false, false), true);
                Util.send(p, "&c你召唤了反向力量区域");
            } else {
                AreaEffectCloud effectCloudForward = (AreaEffectCloud) p.getWorld().spawnEntity(block.getLocation().add(0.5, 1, 0.5), EntityType.AREA_EFFECT_CLOUD);
                effectCloudForward.setParticle(Particle.ELECTRIC_SPARK);
                effectCloudForward.setDuration(160);
                effectCloudForward.setRadius(2.85F);
                effectCloudForward.setCustomName("FN_FORCE");
                effectCloudForward.setCustomNameVisible(false);
                effectCloudForward.addCustomEffect(new PotionEffect(PotionEffectType.GLOWING, 0, 0, false, false, false), true);
                Util.send(p, "&a你召唤了力量区域");
            }

            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ILLUSIONER_CAST_SPELL, 1, 1);
        };
    }

    public static void setup(){
        new StaffOfForce(FNAmpItems.FN_STAFFS, FNAmpItems.FN_STAFF_FORCE, FnAssemblyStation.RECIPE_TYPE, new ItemStack[]{
            new SlimefunItemStack(SlimefunItems.MAGIC_LUMP_3, 24), new ItemStack(Material.FEATHER, 12), new SlimefunItemStack(SlimefunItems.ENDER_LUMP_3, 24),
            new SlimefunItemStack(SlimefunItems.AIR_RUNE, 3), new ItemStack(Material.BLAZE_ROD),  new SlimefunItemStack(SlimefunItems.AIR_RUNE, 3),
            new ItemStack(Material.BLAZE_POWDER, 12), SlimefunItems.MAGIC_SUGAR, new ItemStack(Material.BLAZE_POWDER, 12)})
                .register(FNAmplifications.getInstance());
    }
}