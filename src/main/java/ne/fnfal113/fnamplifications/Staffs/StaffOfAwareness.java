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
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaffOfAwareness extends LimitedUseItem {

    public StaffOfAwareness(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        setMaxUseCount(FNAmplifications.getInstance().getConfigManager().staffOfAwareness());
    }

    @Override
    public @Nonnull ItemUseHandler getItemHandler() {
        return e -> {
            Player p = e.getPlayer();
            ItemStack item = e.getItem();
            Map<Entity, String> PLAYERS = new HashMap<>();
            List<String> players = new ArrayList<>();
            List<String> firstPage = new ArrayList<>();
            int amount = 0;

            ItemStack writtenBook = new ItemStack(Material.WRITTEN_BOOK);
            BookMeta bookMeta = (BookMeta) writtenBook.getItemMeta();
            if (bookMeta == null) {
                return;
            }

            bookMeta.setTitle("玩家探测结果");
            bookMeta.setAuthor("FN_FAL113");

            for (Entity entity: p.getWorld().getNearbyEntities(p.getLocation().clone(), 50, 50, 50)) {
                if (entity instanceof Player && !entity.getName().equals(p.getName())){
                    PLAYERS.put(entity, entity.getName());
                    amount++;
                }
            }

            if (amount != 0) {
                PLAYERS.forEach((key1, value1) -> players.add(ChatColor.DARK_GREEN + value1));

                firstPage.add(ChatColor.GOLD + "         探测法杖\n\n " + ChatColor.GRAY +
                    "探测法杖的力量可以找出你附近50格内的其他玩家");
                bookMeta.addPage(firstPageBook(firstPage));

                for (int i = 0; i < players.size(); i = i + 5) {
                    bookMeta.addPage(players.subList(i, Math.min(i + 5, players.size())).toString()
                        .replace("[", "")
                        .replace("]", "")
                        .replace(":", ChatColor.GRAY + " =")
                        .replace(", ", "\n\n")
                        .replace("_", " "));
                }
            } else {
                firstPage.add(ChatColor.GOLD + "         探测法杖\n\n " + ChatColor.GRAY +
                    "  你附近没有任何玩家");
                bookMeta.addPage(firstPageBook(firstPage));
            }

            writtenBook.setItemMeta(bookMeta);

            e.cancel();
            damageItem(p, item);
            p.openBook(writtenBook);

            p.getWorld().playSound(p.getLocation(), Sound.ENTITY_ILLUSIONER_CAST_SPELL, 1, 1);
        };
    }

    public String firstPageBook(List<String> firstPage){
        return firstPage.toString().replace("[", "").replace("]", "");
    }

    public static void setup(){
        new StaffOfAwareness(FNAmpItems.FN_STAFFS, FNAmpItems.FN_STAFF_AWARENESS, FnAssemblyStation.RECIPE_TYPE, new ItemStack[]{
            new SlimefunItemStack(SlimefunItems.EARTH_RUNE, 2), new ItemStack(Material.BLAZE_POWDER, 16), new SlimefunItemStack(SlimefunItems.LIGHTNING_RUNE, 2),
            SlimefunItems.MAGICAL_GLASS, new ItemStack(Material.BLAZE_ROD), SlimefunItems.MAGICAL_GLASS,
            new SlimefunItemStack(SlimefunItems.FIRE_RUNE, 2), SlimefunItems.MAGIC_SUGAR, new SlimefunItemStack(SlimefunItems.AIR_RUNE, 2)})
            .register(FNAmplifications.getInstance());
    }

}
