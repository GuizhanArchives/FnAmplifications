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
import org.bukkit.entity.Arrow;
import org.bukkit.entity.LivingEntity;
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

public class MysteryStick9 extends SlimefunItem {

    private static final SlimefunAddon plugin = FNAmplifications.getInstance();

    private final NamespacedKey defaultUsageKey;
    private final NamespacedKey defaultUsageKey2;

    @ParametersAreNonnullByDefault
    public MysteryStick9(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        this.defaultUsageKey = new NamespacedKey(FNAmplifications.getInstance(), "bowexp_xpfinal");
        this.defaultUsageKey2 = new NamespacedKey(FNAmplifications.getInstance(), "bowdamage_damagefinal");
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
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 13, true);
        meta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        meta.addEnchant(Enchantment.ARROW_FIRE, 10, true);
        meta.addEnchant(Enchantment.ARROW_KNOCKBACK, 7, true);
        meta.setUnbreakable(true);
        meta.setLore(loreUpdate(lore2, damageAll, xpamount));
        item1.setItemMeta(meta);

        if(!(item1.getType() == Material.BOW)) {
            item1.setType(Material.BOW);
            player.playSound(player.getLocation(), Sound.ENTITY_ILLUSIONER_MIRROR_MOVE, 1, 1);
            player.getWorld().playEffect(player.getLocation().add(0.3, 0.4, 0.45), Effect.ENDER_SIGNAL, 1);
            player.getWorld().spawnParticle(Particle.FLASH, player.getLocation().add(0.3, 0.4, 0.45), 2, 0.1, 0.1, 0.1, 0.1);
            player.getWorld().spawnParticle(Particle.CLOUD, player.getLocation().add(0.3, 0.4, 0.45), 2, 0.1, 0.1, 0.1, 0.1);
        }

    }

    public void onSwing(EntityDamageByEntityEvent event){
        Arrow arrow = (Arrow) event.getDamager();
        Player player = ((Player) arrow.getShooter());
        if(player == null){
            return;
        }

        ItemStack item = player.getInventory().getItemInMainHand();
        if(item.getType() != Material.BOW) {
            return;
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

        if(event.getEntity() instanceof LivingEntity) {
            LivingEntity victim = (LivingEntity) event.getEntity();
            if(ThreadLocalRandom.current().nextInt(100) < 9 && !(victim.hasPotionEffect(PotionEffectType.LEVITATION))){
                victim.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 60, 1, false, true));
            }
            if(ThreadLocalRandom.current().nextInt(100) < 8 && !(victim.hasPotionEffect(PotionEffectType.HARM))){
                victim.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 80, 1, false, true));
            }
            if(ThreadLocalRandom.current().nextInt(100) < 8 && !(victim.hasPotionEffect(PotionEffectType.BLINDNESS))){
                victim.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 1, false, true));
            }
        }

        if(player.getLevel() <= 20) {
            player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 300, 2, false, false));
            player.sendTitle(ChatColor.DARK_RED + "你的视野变暗了!", ChatColor.RED + "神秘棍是不可预测的", 45, 120, 135);
            player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD  + "[FN" + ChatColor.AQUA + "" + ChatColor.BOLD + "科技] > " + ChatColor.YELLOW + "你太虚弱了，请先确保你的经验值大于20");
            transformWeapon(player, item);
        }
    }

    public List<String> loreUpdate(List<String> lore2, int get_Damage, int xpamount){
        lore2.add(0,ChatColor.GOLD + "精灵的遗物");
        lore2.add(1, ChatColor.YELLOW + "经验损耗: " + ChatColor.WHITE + xpamount);
        lore2.add(2, ChatColor.YELLOW + "伤害总量: " + ChatColor.WHITE + get_Damage);
        lore2.add(3, "");
        lore2.add(4, ChatColor.RED + "◢◤◢◤◢◤◢◤| "+ ChatColor.DARK_RED + "" + ChatColor.BOLD + "效果 " + ChatColor.WHITE + "|◥◣◥◣◥◣◥◣");
        lore2.add(5, ChatColor.BLUE +"◆ 9%几率  3s 漂浮");
        lore2.add(6, ChatColor.BLUE +"◆ 8%几率  4s 瞬间伤害");
        lore2.add(7, ChatColor.BLUE +"◆ 8%几率  3s 失明");
        lore2.add(8, ChatColor.RED + "◢◤◢◤◢◤◢◤| " + ChatColor.DARK_RED + "  ◢◤◤◥◤◥◥◣   " + ChatColor.WHITE + "|◥◣◥◣◥◣◥◣");
        return lore2;
    }

    public void LevelChange(PlayerLevelChangeEvent event){
        Player p = event.getPlayer();
        ItemStack item = p.getInventory().getItemInMainHand();
        if(event.getOldLevel() > event.getNewLevel() && p.getLevel() > 20) {
            transformWeapon(p, item);
        }
    }

    public void transformWeapon(Player p, ItemStack item) {
        CustomItemStack item2 = new CustomItemStack(FNAmpItems.FN_STICK_9);

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
        int amount = ++xpamount + 2;
        expUsed.set(key, PersistentDataType.INTEGER, amount);

        List<String> lore = new ArrayList<>();
        meta.setLore(loreUpdate(lore, damageamount, amount));
        item.setItemMeta(meta);

        if (p.getLevel() <= 20) {
            lore.remove(3);
            lore.remove(3);
            lore.remove(3);
            lore.remove(3);
            lore.remove(3);
            lore.remove(3);
            lore.set(0, ChatColor.WHITE + "法力");
            lore.set(1, ChatColor.YELLOW + "经验损耗: " + ChatColor.WHITE + amount);
            lore.set(2, ChatColor.YELLOW + "伤害总量: " + ChatColor.WHITE + damageamount);
            meta.setLore(lore);
            meta.removeEnchant(Enchantment.ARROW_DAMAGE);
            meta.removeEnchant(Enchantment.ARROW_INFINITE);
            meta.removeEnchant(Enchantment.ARROW_FIRE);
            meta.removeEnchant(Enchantment.ARROW_KNOCKBACK);
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
        new MysteryStick9(FNAmpItems.MYSTERY_STICKS, FNAmpItems.FN_STICK_9, FnMysteryStickAltar.RECIPE_TYPE, new ItemStack[]{
                new SlimefunItemStack(SlimefunItems.ESSENCE_OF_AFTERLIFE, 4), new SlimefunItemStack(SlimefunItems.AIR_RUNE, 10), new SlimefunItemStack(SlimefunItems.ESSENCE_OF_AFTERLIFE, 4),
                new SlimefunItemStack(SlimefunItems.FIRE_RUNE, 8), FNAmpItems.FN_STICK_6, new SlimefunItemStack(SlimefunItems.EARTH_RUNE, 8),
                new SlimefunItemStack(SlimefunItems.ESSENCE_OF_AFTERLIFE, 4), new SlimefunItemStack(SlimefunItems.ENDER_RUNE, 10), new SlimefunItemStack(SlimefunItems.ESSENCE_OF_AFTERLIFE, 4)})
                .register(plugin);
    }
}
