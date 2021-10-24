package ne.fnfal113.fnamplifications.Machines;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerSkin;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineRecipe;
import ne.fnfal113.fnamplifications.FNAmplifications;
import ne.fnfal113.fnamplifications.Items.FNAmpItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class ElectricTransformer extends AContainer implements RecipeDisplayItem {

    private static final SlimefunAddon plugin = FNAmplifications.getInstance();

    public ElectricTransformer(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public List<ItemStack> getDisplayRecipes() {
        List<ItemStack> displayRecipes = new ArrayList<>(recipes.size() * 4);

        for (MachineRecipe recipe : recipes) {
            displayRecipes.add(recipe.getInput()[0]);
            displayRecipes.add(recipe.getInput()[1]);
            displayRecipes.add(new ItemStack(Material.AIR));
            displayRecipes.add(PlayerHead.getItemStack(PlayerSkin.fromHashCode(
                    "682ad1b9cb4dd21259c0d75aa315ff389c3cef752be3949338164bac84a96e")));
            displayRecipes.add(new ItemStack(Material.AIR));
            displayRecipes.add(recipe.getOutput()[0]);
            displayRecipes.add(new ItemStack(Material.AIR));
            displayRecipes.add(new ItemStack(Material.AIR));
            displayRecipes.add(new ItemStack(Material.AIR));
            displayRecipes.add(new ItemStack(Material.AIR));
        }

        return displayRecipes;
    }

    @Override
    protected void registerDefaultRecipes() {
        registerRecipe(8, new SlimefunItemStack[]{new SlimefunItemStack(SlimefunItems.AUTO_ENCHANTER, 1),
                        new SlimefunItemStack(SlimefunItems.CARBONADO,5)},
                new SlimefunItemStack[]{new SlimefunItemStack(SlimefunItems.AUTO_ENCHANTER_2, 1)});
        registerRecipe(8, new SlimefunItemStack[]{new SlimefunItemStack(SlimefunItems.AUTO_DISENCHANTER, 1),
                        new SlimefunItemStack(SlimefunItems.CARBONADO,12)},
                new SlimefunItemStack[]{new SlimefunItemStack(SlimefunItems.AUTO_DISENCHANTER_2, 1)});
        registerRecipe(8, new SlimefunItemStack[]{new SlimefunItemStack(SlimefunItems.AUTO_ANVIL, 1),
                        new SlimefunItemStack(SlimefunItems.ELECTRIC_MOTOR,16)},
                new SlimefunItemStack[]{new SlimefunItemStack(SlimefunItems.AUTO_ANVIL_2, 1)});
        registerRecipe(8, new SlimefunItemStack[]{new SlimefunItemStack(SlimefunItems.ELECTRO_MAGNET, 2),
                        new SlimefunItemStack(SlimefunItems.ELECTRIC_MOTOR,4)},
                new SlimefunItemStack[]{new SlimefunItemStack(SlimefunItems.CARGO_CONNECTOR_NODE, 2)});
        registerRecipe(8, new ItemStack[]{new SlimefunItemStack(SlimefunItems.CARGO_CONNECTOR_NODE, 2),
                        new ItemStack(Material.HOPPER, 2)},
                new SlimefunItemStack[]{new SlimefunItemStack(SlimefunItems.CARGO_CONNECTOR_NODE, 3)});
        registerRecipe(8, new SlimefunItemStack[]{new SlimefunItemStack(SlimefunItems.CARGO_OUTPUT_NODE, 2),
                        new SlimefunItemStack(SlimefunItems.CARGO_MOTOR, 2)},
                new SlimefunItemStack[]{new SlimefunItemStack(SlimefunItems.CARGO_OUTPUT_NODE_2, 4)});
        registerRecipe(8, new SlimefunItemStack[]{new SlimefunItemStack(SlimefunItems.PROGRAMMABLE_ANDROID, 1),
                        new SlimefunItemStack(SlimefunItems.ANDROID_MEMORY_CORE, 8)},
                new SlimefunItemStack[]{new SlimefunItemStack(SlimefunItems.PROGRAMMABLE_ANDROID_2, 1)});
        registerRecipe(8, new SlimefunItemStack[]{new SlimefunItemStack(SlimefunItems.PROGRAMMABLE_ANDROID_2, 1),
                        new SlimefunItemStack(SlimefunItems.ANDROID_MEMORY_CORE, 16)},
                new SlimefunItemStack[]{new SlimefunItemStack(SlimefunItems.PROGRAMMABLE_ANDROID_3, 1)});


    }

    public static void setup(){
        new ElectricTransformer(FNAmpItems.MACHINES, FNAmpItems.FN_FAL_TRANSFORMER_1, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                FNAmpItems.FUNNEL_PART, FNAmpItems.THREAD_PART, FNAmpItems.POWER_COMPONENT,
                FNAmpItems.GEAR_PART, FNAmpItems.BASIC_MACHINE_BLOCK, FNAmpItems.GEAR_PART,
                FNAmpItems.COMPRESSOR_PART, FNAmpItems.BRASS_PLATING, FNAmpItems.CONDENSER_PART
        }).setCapacity(1536).setEnergyConsumption(128).setProcessingSpeed(1).register(plugin);

        new ElectricTransformer(FNAmpItems.MACHINES, FNAmpItems.FN_FAL_TRANSFORMER_2, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                new SlimefunItemStack(FNAmpItems.FUNNEL_PART, 4), new SlimefunItemStack(FNAmpItems.THREAD_PART, 6), new SlimefunItemStack(FNAmpItems.POWER_COMPONENT, 4),
                new SlimefunItemStack(FNAmpItems.GEAR_PART, 4), FNAmpItems.BASIC_MACHINE_BLOCK, new SlimefunItemStack(FNAmpItems.GEAR_PART, 4),
                new SlimefunItemStack(FNAmpItems.COMPONENT_PART, 6), new SlimefunItemStack(FNAmpItems.ALUMINUM_PLATING, 7), new SlimefunItemStack(FNAmpItems.CONDENSER_PART, 6)
        }).setCapacity(1536).setEnergyConsumption(192).setProcessingSpeed(2).register(plugin);

        new ElectricTransformer(FNAmpItems.MACHINES, FNAmpItems.FN_FAL_TRANSFORMER_3, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
                new SlimefunItemStack(FNAmpItems.FUNNEL_PART, 8), new SlimefunItemStack(FNAmpItems.THREAD_PART, 12), new SlimefunItemStack(FNAmpItems.POWER_COMPONENT, 8),
                new SlimefunItemStack(FNAmpItems.GEAR_PART, 8), FNAmpItems.HIGHTECH_MACHINE_BLOCK, new SlimefunItemStack(FNAmpItems.GEAR_PART, 8),
                new SlimefunItemStack(FNAmpItems.COMPONENT_PART, 12), new SlimefunItemStack(FNAmpItems.REINFORCED_CASING, 14), new SlimefunItemStack(FNAmpItems.CONDENSER_PART, 12)
        }).setCapacity(1536).setEnergyConsumption(384).setProcessingSpeed(4).register(plugin);



    }


    @Override
    public String getMachineIdentifier() {
        return "ELECTRIC_TRANSFORMER";
    }

    @Override
    public ItemStack getProgressBar() {
        return new SlimefunItemStack(FNAmpItems.MACHINE_PART, 1);
    }
}
