package ne.fnfal113.fnamplifications.Quiver;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import ne.fnfal113.fnamplifications.FNAmplifications;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class BaseQuiver extends SlimefunItem {

    private final NamespacedKey storageKey;

    private Material material;
    private int maxStorage;

    public BaseQuiver(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);

        this.storageKey = new NamespacedKey(FNAmplifications.getInstance(), "arrows");
    }

    public @Nonnull Material getMaterial() {
        return material;
    }

    public void setMaterial(Material mat) {
        this.material = mat;
    }

    public int getMaxStorage() {
        return maxStorage;
    }

    public void setMaxStorage(int storage) {
        this.maxStorage = storage;
    }

    public @Nonnull NamespacedKey getStorageKey() {
        return storageKey;
    }
}
