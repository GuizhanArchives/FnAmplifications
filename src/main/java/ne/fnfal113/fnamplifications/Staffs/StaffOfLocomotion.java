package ne.fnfal113.fnamplifications.Staffs;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.EntityInteractHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.LimitedUseItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.common.ChatColors;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import ne.fnfal113.fnamplifications.FNAmplifications;
import ne.fnfal113.fnamplifications.Items.FNAmpItems;
import ne.fnfal113.fnamplifications.Multiblock.FnAssemblyStation;
import net.guizhanss.guizhanlib.minecraft.helper.entity.EntityHelper;
import net.guizhanss.minecraft.fnamplifications.Util;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;

import javax.annotation.Nonnull;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaffOfLocomotion extends LimitedUseItem {

    private static final Map<PersistentDataContainer, LivingEntity> ENTITY_OWNER = new HashMap<>();

    public StaffOfLocomotion(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        addItemHandler(getInteractHandler());
    }

    @Override
    public @Nonnull ItemUseHandler getItemHandler() {
        return e -> {
            Player p = e.getPlayer();
            ItemStack item = e.getItem();
            Block block = p.getTargetBlockExact(100);

            if (p.isSneaking()) {
                return;
            }
            if (block == null) {
                return;
            }

            if (!item.hasItemMeta()){
                return;
            }

            ItemMeta meta = item.getItemMeta();
            PersistentDataContainer data = meta.getPersistentDataContainer();

            if (!Slimefun.getProtectionManager().hasPermission(p, block, Interaction.INTERACT_BLOCK)) {
                Util.send(p, "&4你没有权限将生物传送到目标地点!");
                return;
            }

            if (!ENTITY_OWNER.containsKey(data)) {
                return;
            }

            if (ENTITY_OWNER.get(data) == null) {
                Util.send(p, "&c需要重新选择实体!");
                return;
            }

            LivingEntity entity = ENTITY_OWNER.get(data);
            entity.teleport(block.getLocation().add(0.5, 1, 0.5));
            ENTITY_OWNER.remove(data);

            List<String> lore = meta.getLore();
            lore.set(lore.size() - 1, ChatColors.color("&7当前绑定生物: &e无"));

            meta.setLore(lore);
            item.setItemMeta(meta);

            e.cancel();
            damageItem(p, item);

            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, 1 ,1);
        };
    }

    public @Nonnull EntityInteractHandler getInteractHandler() {
        return (e, item, offhand) -> {
            Player p = e.getPlayer();

            if (!(e.getRightClicked() instanceof LivingEntity)) {
                return;
            }

            LivingEntity entity = (LivingEntity) e.getRightClicked();
            if (entity instanceof Player) {
                Util.send(p, "&4你不能选中玩家!");
                return;
            }

            if (!p.isSneaking()) {
                return;
            }
            if (!item.hasItemMeta()) {
                return;
            }

            if (!Slimefun.getProtectionManager().hasPermission(p, entity.getLocation(), Interaction.INTERACT_ENTITY)) {
                Util.send(p, "&4你没有权限选中该实体!");
                return;
            }

            ItemMeta meta = item.getItemMeta();
            PersistentDataContainer data = meta.getPersistentDataContainer();

            if (!ENTITY_OWNER.containsValue(entity)) {
                ENTITY_OWNER.remove(data);
                ENTITY_OWNER.put(data, entity);

                List<String> lore = meta.getLore();
                lore.set(lore.size() - 1, ChatColors.color(MessageFormat.format(
                    "&7当前绑定生物: &e{0}&7(ID: {1})",
                    EntityHelper.getDisplayName(entity),
                    entity.getEntityId()
                )));

                meta.setLore(lore);
                item.setItemMeta(meta);

                p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, 1 ,1);
            } else {
                Util.send(p, "&4该实体已被选中!");
            }
        };
    }

    public static void setup(){
        new StaffOfLocomotion(FNAmpItems.FN_STAFFS, FNAmpItems.FN_STAFF_LOCOMOTION, FnAssemblyStation.RECIPE_TYPE, new ItemStack[]{
            SlimefunItems.BLANK_RUNE, SlimefunItems.MAGICAL_GLASS, new SlimefunItemStack(SlimefunItems.ENDER_LUMP_3, 6),
            SlimefunItems.AIR_RUNE, new ItemStack(Material.BLAZE_ROD), SlimefunItems.AIR_RUNE,
            new SlimefunItemStack(SlimefunItems.MAGIC_LUMP_3, 6), SlimefunItems.MAGIC_EYE_OF_ENDER, SlimefunItems.BLANK_RUNE})
                .register(FNAmplifications.getInstance());
    }
}
