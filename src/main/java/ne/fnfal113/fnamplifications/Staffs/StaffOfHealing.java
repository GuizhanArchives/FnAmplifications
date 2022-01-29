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
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.AreaEffectCloud;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import javax.annotation.Nonnull;

public class StaffOfHealing extends LimitedUseItem {

    private final NamespacedKey cloudKey;

    public StaffOfHealing(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        this.cloudKey = new NamespacedKey(FNAmplifications.getInstance(), "cloudfn");

        setMaxUseCount(FNAmplifications.getInstance().getConfigManager().staffOfHealing());
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
                Util.send(p, "&4你没有权限在目标地点召唤治愈区域!");
                return;
            }

            e.cancel();
            damageItem(p, item);

            AreaEffectCloud effectCloud = (AreaEffectCloud) p.getWorld().spawnEntity(block.getLocation().add(0.5, 1, 0.5) , EntityType.AREA_EFFECT_CLOUD);
            effectCloud.setParticle(Particle.HEART);
            effectCloud.setDuration(160);
            effectCloud.setRadius(2.85F);
            effectCloud.setCustomName("FN_HEALING");
            effectCloud.setCustomNameVisible(false);
            effectCloud.setReapplicationDelay(0);
            effectCloud.getPersistentDataContainer().set(cloudKey, PersistentDataType.STRING, p.getName());
            effectCloud.addCustomEffect(new PotionEffect(PotionEffectType.GLOWING, 0 , 0, false, false, false), true);

            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ILLUSIONER_CAST_SPELL, 1, 1);
        };
    }

    public static void setup(){
        new StaffOfHealing(FNAmpItems.FN_STAFFS, FNAmpItems.FN_STAFF_HEALING, FnAssemblyStation.RECIPE_TYPE, new ItemStack[]{
            new SlimefunItemStack(SlimefunItems.ENDER_LUMP_3, 8), new ItemStack(Material.SPLASH_POTION), new SlimefunItemStack(SlimefunItems.MAGIC_LUMP_3, 8),
            new SlimefunItemStack(SlimefunItems.BANDAGE, 8), new ItemStack(Material.BLAZE_ROD), new SlimefunItemStack(SlimefunItems.BANDAGE, 8),
            new SlimefunItemStack(SlimefunItems.ESSENCE_OF_AFTERLIFE, 1), SlimefunItems.MAGIC_SUGAR, new SlimefunItemStack(SlimefunItems.ESSENCE_OF_AFTERLIFE, 1)})
                .register(FNAmplifications.getInstance());
    }
}
