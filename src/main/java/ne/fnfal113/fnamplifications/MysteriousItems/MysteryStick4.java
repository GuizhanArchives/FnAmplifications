package ne.fnfal113.fnamplifications.MysteriousItems;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import ne.fnfal113.fnamplifications.FNAmplifications;
import ne.fnfal113.fnamplifications.Items.FNAmpItems;
import ne.fnfal113.fnamplifications.Multiblock.FnMysteryStickAltar;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MysteryStick4 extends SlimefunItem {

    private static final SlimefunAddon plugin = FNAmplifications.getInstance();

    private final NamespacedKey defaultUsageKey;
    private final NamespacedKey defaultUsageKey2;

    @ParametersAreNonnullByDefault
    public MysteryStick4(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        this.defaultUsageKey = new NamespacedKey(FNAmplifications.getInstance(), "expstickupgraded");
        this.defaultUsageKey2 = new NamespacedKey(FNAmplifications.getInstance(), "damage");
    }

    protected @Nonnull
    NamespacedKey getStorageKey() {
        return defaultUsageKey;
    }

    protected @Nonnull
    NamespacedKey getStorageKey2() {
        return defaultUsageKey2;
    }

    public void interact(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack item1 = player.getInventory().getItemInMainHand();

        ItemMeta meta = item1.getItemMeta();
        NamespacedKey key = getStorageKey();
        NamespacedKey key2 = getStorageKey2();
        if(meta == null){
            return;
        }

        PersistentDataContainer expUsed = meta.getPersistentDataContainer();
        PersistentDataContainer damageAmount = meta.getPersistentDataContainer();
        int xpamount = expUsed.getOrDefault(key, PersistentDataType.INTEGER, 0);
        int damageAll = damageAmount.getOrDefault(key2, PersistentDataType.INTEGER, 0);

        List<String> lore2 = new ArrayList<>();
        lore2.add(0,ChatColor.GOLD + "It was indeed a magical improvement");
        lore2.add(1, ChatColor.YELLOW + "Exp Levels Consumed: " + ChatColor.WHITE + xpamount);
        lore2.add(2, ChatColor.YELLOW + "Total Damage inflicted: " + ChatColor.WHITE + damageAll);
        meta.addEnchant(Enchantment.SWEEPING_EDGE, 6, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 7, true);
        meta.addEnchant(Enchantment.FIRE_ASPECT, 4, true);
        meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 5, true);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 6, true);
        meta.setUnbreakable(true);
        meta.setLore(lore2);
        item1.setItemMeta(meta);

        if(!(item1.getType() == Material.DIAMOND_SWORD)) {
            item1.setType(Material.DIAMOND_SWORD);
            player.playSound(player.getLocation(), Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, 1, 1);
            player.getWorld().playEffect(player.getLocation().add(0.3, 0.4, 0.45), Effect.ENDER_SIGNAL, 1);
            player.getWorld().spawnParticle(Particle.FLASH, player.getLocation().add(0.3, 0.4, 0.45), 2, 0.1, 0.1, 0.1, 0.1);
        }

    }


    public void onSwing(EntityDamageByEntityEvent event){
        if(!(event.getDamager() instanceof Player)){
            return;
        }
        Player player = (Player) event.getDamager();
        ItemStack item = player.getInventory().getItemInMainHand();

        if(item.getType() != Material.DIAMOND_SWORD){
            return;
        }

        if(player.getLevel() >= 15)  {
            if(ThreadLocalRandom.current().nextInt(100) < 30) {
                player.setLevel(player.getLevel() - 2);
            }
        }
        else{
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 300, 2, false, false));
            player.sendTitle(ChatColor.DARK_RED + "你的视野变暗了!", ChatColor.RED + "神秘棍是不可预测的", 45, 120, 135);
            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD  + "[FN" + ChatColor.AQUA + "" + ChatColor.BOLD + "科技] > " + ChatColor.YELLOW + "你太虚弱了，请先确保你的经验值大于15");
            transformWeapon(player, item);
        }
        ItemMeta meta = item.getItemMeta();
        NamespacedKey key = getStorageKey();
        NamespacedKey key2 = getStorageKey2();
        if(meta == null){
            return;
        }

        PersistentDataContainer expUsed = meta.getPersistentDataContainer();
        PersistentDataContainer damage = meta.getPersistentDataContainer();
        int damageamount = damage.getOrDefault(key2, PersistentDataType.INTEGER, 0);
        int get_Damage = (int) event.getDamage() + damageamount;
        int xpamount = expUsed.getOrDefault(key, PersistentDataType.INTEGER, 0);
        damage.set(key2, PersistentDataType.INTEGER, get_Damage);

        List<String> lore2 = new ArrayList<>();
        meta.setLore(loreUpdate(lore2, get_Damage, xpamount));
        item.setItemMeta(meta);

    }

    public List<String> loreUpdate(List<String> lore2, int get_Damage, int xpamount){
        lore2.add(0,ChatColor.GOLD + "高级魔法");
        lore2.add(1, ChatColor.YELLOW + "经验损耗: " + ChatColor.WHITE + xpamount);
        lore2.add(2, ChatColor.YELLOW + "伤害总量: " + ChatColor.WHITE + get_Damage);
        return lore2;
    }

    public void LevelChange(PlayerLevelChangeEvent event){
        Player p = event.getPlayer();
        ItemStack item = p.getInventory().getItemInMainHand();
        if(event.getOldLevel() > event.getNewLevel()) {
            transformWeapon(p, item);
        }
    }

    public void transformWeapon(Player p, ItemStack item) {
        CustomItemStack item2 = new CustomItemStack(FNAmpItems.FN_STICK_4);
        ItemMeta meta = item.getItemMeta();
        NamespacedKey key = getStorageKey();
        NamespacedKey key2 = getStorageKey2();
        if(meta == null){
            return;
        }

        PersistentDataContainer expUsed = meta.getPersistentDataContainer();
        PersistentDataContainer damage = meta.getPersistentDataContainer();
        int xpamount = expUsed.getOrDefault(key, PersistentDataType.INTEGER, 0);
        int damageamount = damage.getOrDefault(key2, PersistentDataType.INTEGER, 0);
        int amount = ++xpamount + 1;
        expUsed.set(key, PersistentDataType.INTEGER, amount);

        List<String> lore = new ArrayList<>();
        meta.setLore(loreUpdate(lore, damageamount, amount));
        item.setItemMeta(meta);

        if (p.getLevel() <= 15) {
            lore.set(0, ChatColor.WHITE + "老练");
            lore.set(1, ChatColor.YELLOW + "经验损耗: " + ChatColor.WHITE + amount);
            lore.set(2, ChatColor.YELLOW + "伤害总量: " + ChatColor.WHITE + damageamount);
            meta.setLore(lore);
            meta.removeEnchant(Enchantment.SWEEPING_EDGE);
            meta.removeEnchant(Enchantment.DAMAGE_ALL);
            meta.removeEnchant(Enchantment.FIRE_ASPECT);
            meta.removeEnchant(Enchantment.DAMAGE_ARTHROPODS);
            meta.removeEnchant(Enchantment.DAMAGE_UNDEAD);
            item.setItemMeta(meta);
            item.setType(item2.getType());
        }

    }

    @Override
    public boolean isEnchantable() {
        return false;
    }

    @Override
    public boolean isDisenchantable() {
        return false;
    }

    @Override
    public boolean isUseableInWorkbench() {
        return false;
    }

    public static void setup(){
        new MysteryStick4(FNAmpItems.MYSTERY_STICKS, FNAmpItems.FN_STICK_4, FnMysteryStickAltar.RECIPE_TYPE, new ItemStack[]{
                new SlimefunItemStack(SlimefunItems.ESSENCE_OF_AFTERLIFE, 1), new SlimefunItemStack(SlimefunItems.EARTH_RUNE, 4), new SlimefunItemStack(SlimefunItems.ENDER_LUMP_3, 16),
                new SlimefunItemStack(SlimefunItems.FIRE_RUNE, 4), FNAmpItems.FN_STICK, new SlimefunItemStack(SlimefunItems.AIR_RUNE, 4),
                new SlimefunItemStack(SlimefunItems.ENDER_LUMP_3, 16), new SlimefunItemStack(SlimefunItems.ENDER_RUNE, 4), new SlimefunItemStack(SlimefunItems.ESSENCE_OF_AFTERLIFE, 1)})
                .register(plugin);
    }
}
