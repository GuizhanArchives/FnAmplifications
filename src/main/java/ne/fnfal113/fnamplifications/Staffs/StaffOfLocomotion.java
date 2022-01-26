package ne.fnfal113.fnamplifications.Staffs;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import ne.fnfal113.fnamplifications.config.ConfigManager;
import ne.fnfal113.fnamplifications.FNAmplifications;
import ne.fnfal113.fnamplifications.Items.FNAmpItems;
import ne.fnfal113.fnamplifications.Multiblock.FnAssemblyStation;
import net.guizhanss.guizhanlib.minecraft.helper.entity.EntityHelper;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import javax.annotation.Nonnull;
import java.util.*;

public class StaffOfLocomotion extends SlimefunItem {

    private final Map<PersistentDataContainer, LivingEntity> ENTITY_OWNER = new HashMap<>();

    private static final SlimefunAddon plugin = FNAmplifications.getInstance();

    private static final ConfigManager value = FNAmplifications.getInstance().getConfigManager();

    private final NamespacedKey defaultUsageKey;

    private final NamespacedKey defaultUsageKey2;

    public StaffOfLocomotion(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        this.defaultUsageKey = new NamespacedKey(FNAmplifications.getInstance(), "movestaff");
        this.defaultUsageKey2 = new NamespacedKey(FNAmplifications.getInstance(), "identifier");
    }

    public @Nonnull
    NamespacedKey getStorageKey() {
        return defaultUsageKey;
    }

    public @Nonnull
    NamespacedKey getStorageKey2() {
        return defaultUsageKey2;
    }

    public void onRightClick(PlayerInteractEntityEvent event){
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        NamespacedKey key = getStorageKey();
        NamespacedKey key2 = getStorageKey2();
        ItemMeta meta = item.getItemMeta();

        if(meta == null){
            return;
        }

        PersistentDataContainer data = meta.getPersistentDataContainer();
        PersistentDataContainer max_Uses = meta.getPersistentDataContainer();

        int uses_Left = max_Uses.getOrDefault(key, PersistentDataType.INTEGER, value.staffOfLocomotion());

        List<String> lore = meta.getLore();

        LivingEntity en = (LivingEntity) event.getRightClicked();

        if (!Slimefun.getProtectionManager().hasPermission(
                Bukkit.getOfflinePlayer(player.getUniqueId()),
                en.getLocation(),
                Interaction.INTERACT_ENTITY)
        ) {
            player.sendMessage(ChatColor.DARK_RED + "你没有权限选中该实体!");
            return;
        }

        if(!ENTITY_OWNER.containsValue(en)) {
            ENTITY_OWNER.remove(data);
            data.set(key2, PersistentDataType.DOUBLE, Math.random());
            lore.set(4, ChatColor.YELLOW + "剩余使用次数: " + uses_Left);
            if (lore.size() <= 5) {
                lore.add("");
                lore.add(ChatColor.WHITE + "已选中实体: " + ChatColor.ITALIC + EntityHelper.getDisplayName(en));
                lore.add(ChatColor.WHITE + "实体ID: " + ChatColor.ITALIC + en.getEntityId());
            } else {
                lore.set(6, ChatColor.WHITE + "已选中实体: " + ChatColor.ITALIC + EntityHelper.getDisplayName(en));
                if (lore.size() <= 7) {
                    lore.add(ChatColor.WHITE + "实体ID: " + ChatColor.ITALIC + en.getEntityId());
                } else {
                    lore.set(7, ChatColor.WHITE + "实体ID: " + ChatColor.ITALIC + en.getEntityId());
                }
            }
            meta.setLore(lore);
            item.setItemMeta(meta);
            ENTITY_OWNER.put(data, en);
            Objects.requireNonNull(player.getLocation().getWorld()).playSound(player.getLocation(), Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, 1 ,1);
        } else {
            player.sendMessage("该实体已被选中!");
        }
    }

    public void onLeftClick(PlayerInteractEvent event){
        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();
        NamespacedKey key = getStorageKey();

        if(item.getItemMeta() == null){
            return;
        }

        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer data = meta.getPersistentDataContainer();

        Block block = player.getTargetBlockExact(100);

        if (block == null) {
            return;
        }

        if (!Slimefun.getProtectionManager().hasPermission(
                Bukkit.getOfflinePlayer(player.getUniqueId()),
                block,
                Interaction.INTERACT_BLOCK)
        ) {
            player.sendMessage(ChatColor.DARK_RED + "你没有权限将实体传送至到目标点!");
            return;
        }

        if(ENTITY_OWNER.get(data) == null){
            player.sendMessage(ChatColor.WHITE + "你需要选择一个新的实体");
            return;
        }

        if(ENTITY_OWNER.containsKey(data)) {
            LivingEntity entity = ENTITY_OWNER.get(data);
            entity.teleport(block.getLocation().add(0.5, 1, 0.5));
            ENTITY_OWNER.remove(data);
            Objects.requireNonNull(player.getLocation().getWorld()).playSound(player.getLocation(), Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, 1 ,1);
            updateMeta(item, meta, key, player);
        }

    }

    public void updateMeta(ItemStack item, ItemMeta meta, NamespacedKey key, Player player){
        PersistentDataContainer max_Uses = meta.getPersistentDataContainer();
        int uses_Left = max_Uses.getOrDefault(key, PersistentDataType.INTEGER, value.staffOfLocomotion());
        int decrement = uses_Left - 1;

        List<String> lore = meta.getLore();

        if(decrement > 0) {
            max_Uses.set(key, PersistentDataType.INTEGER, decrement);
            lore.set(4, ChatColor.YELLOW + "剩余使用次数: " + uses_Left);
            lore.set(6, ChatColor.WHITE + "已选中实体: " + ChatColor.ITALIC + "无");
            lore.remove(7);
            meta.setLore(lore);
            item.setItemMeta(meta);
        } else {
            player.getInventory().setItemInMainHand(null);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d&l机动法杖使用次数已达上限!"));
            player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1 ,1);
        }

    }

    public static void setup(){
        new StaffOfLocomotion(FNAmpItems.FN_STAFFS, FNAmpItems.FN_STAFF_LOCOMOTION, FnAssemblyStation.RECIPE_TYPE, new ItemStack[]{
                SlimefunItems.BLANK_RUNE, SlimefunItems.MAGICAL_GLASS, new SlimefunItemStack(SlimefunItems.ENDER_LUMP_3, 6),
                SlimefunItems.AIR_RUNE, new ItemStack(Material.BLAZE_ROD), SlimefunItems.AIR_RUNE,
                new SlimefunItemStack(SlimefunItems.MAGIC_LUMP_3, 6), SlimefunItems.MAGIC_EYE_OF_ENDER, SlimefunItems.BLANK_RUNE})
                .register(plugin);
    }
}
