package ne.fnfal113.fnamplifications.Staffs;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.LimitedUseItem;
import io.github.thebusybiscuit.slimefun4.utils.WorldUtils;
import io.github.thebusybiscuit.slimefun4.utils.tags.SlimefunTag;
import ne.fnfal113.fnamplifications.FNAmplifications;
import ne.fnfal113.fnamplifications.Items.FNAmpItems;
import ne.fnfal113.fnamplifications.Multiblock.FnAssemblyStation;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class StaffOfMinerals extends LimitedUseItem {

    public StaffOfMinerals(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        setMaxUseCount(FNAmplifications.getInstance().getConfigManager().staffOfMinerals());
    }

    @Override
    public @Nonnull ItemUseHandler getItemHandler() {
        return e -> {
            Player p = e.getPlayer();
            ItemStack item = e.getItem();
            Chunk chunk = p.getLocation().getChunk();
            Set<Material> materials = SlimefunTag.ORES.getValues();
            Map<String, Integer> MINERALS = new HashMap<>();
            List<String> contents = new ArrayList<>();
            List<String> firstPage = new ArrayList<>();
            int amount = 0;

            for (int y = WorldUtils.getMinHeight(chunk.getWorld()); y <= chunk.getWorld().getMaxHeight(); y++) {
                for (int x = 0; x <= 15; x++) {
                    for (int z = 0; z <= 15; z++) {
                        Block itemStack = chunk.getBlock(x, y, z);

                        if (materials.contains(itemStack.getType())) {
                            MINERALS.put(itemStack.getType().name(), MINERALS.getOrDefault(itemStack.getType().name(), 0) + 1);
                            amount++;
                        }
                    }
                }
            }

            ItemStack writtenBook = new ItemStack(Material.WRITTEN_BOOK);
            BookMeta bookMeta = (BookMeta) writtenBook.getItemMeta();
            if (bookMeta == null) {
                return;
            }
            bookMeta.setTitle("矿石情况");
            bookMeta.setAuthor("FN_FAL113");

            if(amount != 0) {
                MINERALS.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEachOrdered(ore -> contents.add(ChatColor.DARK_GREEN + ore.getValue().toString() + "x " + ChatColor.GOLD + ore.getKey()));


                firstPage.add(ChatColor.BLUE + "    矿工法杖\n\n " + ChatColor.GRAY +
                    "矿工法杖的力量可以探明当前区块的所有矿物信息");
                bookMeta.addPage(firstPageBook(firstPage));

                for (int i = 0; i < contents.size(); i = i + 5) {
                    bookMeta.addPage(contents.subList(i, Math.min(i + 5, contents.size())).toString()
                        .replace("[", "")
                        .replace("]", "")
                        .replace(":", ChatColor.GRAY + " =")
                        .replace(", ", "\n\n")
                        .replace("_", " "));
                }

            } else {
                firstPage.add(ChatColor.BLUE + "    矿工法杖\n\n " + ChatColor.GRAY +
                    "当前区块已经没有任何矿石了");
                bookMeta.addPage(firstPageBook(firstPage));
            }

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
        new StaffOfMinerals(FNAmpItems.FN_STAFFS, FNAmpItems.FN_STAFF_MINERALS, FnAssemblyStation.RECIPE_TYPE, new ItemStack[]{
            new SlimefunItemStack(SlimefunItems.EARTH_RUNE, 2), new ItemStack(Material.BLAZE_POWDER, 12), new SlimefunItemStack(SlimefunItems.EARTH_RUNE, 2),
            new SlimefunItemStack(SlimefunItems.MAGIC_LUMP_3, 14), new ItemStack(Material.BLAZE_ROD), new SlimefunItemStack(SlimefunItems.MAGIC_LUMP_3, 14),
            new SlimefunItemStack(SlimefunItems.EARTH_RUNE, 2), SlimefunItems.MAGIC_SUGAR, new SlimefunItemStack(SlimefunItems.EARTH_RUNE, 2)})
                .register(FNAmplifications.getInstance());
    }

}