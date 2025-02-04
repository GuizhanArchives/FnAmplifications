package ne.fnfal113.fnamplifications.MaterialGenerators;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import ne.fnfal113.fnamplifications.Multiblock.FnAssemblyStation;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;

import ne.fnfal113.fnamplifications.config.ConfigManager;
import ne.fnfal113.fnamplifications.FNAmplifications;
import ne.fnfal113.fnamplifications.Items.FNAmpItems;
import ne.fnfal113.fnamplifications.MaterialGenerators.Methods.CustomBrokenGenerator;
import ne.fnfal113.fnamplifications.MaterialGenerators.Methods.CustomGeneratorMultiblock;
import ne.fnfal113.fnamplifications.MaterialGenerators.Methods.CustomMaterialGenerator;

public class FNMaterialGenerators {

    private static final SlimefunAddon plugin = FNAmplifications.getInstance();
    private static final ConfigManager value = FNAmplifications.getInstance().getConfigManager();

    public static ItemStack SMG_ITEMSTACK_GRAVEL = new ItemStack(Material.DIAMOND_PICKAXE);
    public static ItemStack SMG_ITEMSTACK_COBBLE = SlimefunItems.DAMASCUS_STEEL_INGOT;
    public static ItemStack SMG_ITEMSTACK_COBBLE_2 = new ItemStack(Material.DIAMOND_PICKAXE);
    public static ItemStack SMG_ITEMSTACK_NETHERRACK = FNAmpItems.FMG_GENERATOR_WARPED_BROKEN;
    public static ItemStack SMG_ITEMSTACK_SOUL_SAND = FNAmpItems.FMG_GENERATOR_FNFAL_CLAY;

    static {
        if (Bukkit.getServer().getPluginManager().isPluginEnabled("SimpleMaterialGenerators") && value.smgRecipe()) {
            SlimefunItem smg_gravel = SlimefunItem.getById("SMG_GENERATOR_GRAVEL");
            SlimefunItem smg_cobble = SlimefunItem.getById("SMG_GENERATOR_COBBLESTONE");
            SlimefunItem smg_netherrack = SlimefunItem.getById("SMG_GENERATOR_NETHERRACK");
            SlimefunItem smg_stone = SlimefunItem.getById("SMG_GENERATOR_STONE");
            SlimefunItem smg_sand = SlimefunItem.getById("SMG_GENERATOR_SAND");
            SlimefunItem smg_soul_sand = SlimefunItem.getById("SMG_GENERATOR_SOUL_SAND");
            if (smg_gravel != null && smg_cobble != null && !smg_gravel.isDisabled() && !smg_cobble.isDisabled()) {
                SMG_ITEMSTACK_GRAVEL = smg_gravel.getItem().clone();
                SMG_ITEMSTACK_COBBLE = smg_cobble.getItem().clone();
                SMG_ITEMSTACK_COBBLE_2 = smg_cobble.getItem().clone();
            }
            if (smg_netherrack != null && smg_cobble != null && smg_stone != null && !smg_netherrack.isDisabled() && !smg_cobble.isDisabled() && !smg_stone.isDisabled()) {
                SMG_ITEMSTACK_NETHERRACK = smg_netherrack.getItem().clone();
            }
            if (smg_gravel != null && smg_cobble != null && smg_sand != null && smg_soul_sand != null && !smg_gravel.isDisabled() && !smg_cobble.isDisabled() && !smg_sand.isDisabled()) {
                SMG_ITEMSTACK_SOUL_SAND = smg_soul_sand.getItem().clone();
            }
        }
    }

    public static void setup() {

        new CustomGeneratorMultiblock(FNAmpItems.MATERIAL_GENERATORS, FNAmpItems.FMG_GENERATOR_MULTIBLOCK).register(plugin);

        new CustomBrokenGenerator(FNAmpItems.MATERIAL_GENERATORS,
                FNAmpItems.FMG_GENERATOR_CLAY_BROKEN,
                FnAssemblyStation.RECIPE_TYPE,
                new ItemStack[]{
                        SlimefunItems.CARBON, new ItemStack(Material.DIAMOND_PICKAXE), SlimefunItems.CARBON,
                        new ItemStack(Material.BOWL), new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.BOWL),
                        SlimefunItems.CARBON, SlimefunItems.GOLD_PAN, SlimefunItems.CARBON})
                .register(plugin);

        new CustomMaterialGenerator(FNAmpItems.MATERIAL_GENERATORS,
                FNAmpItems.FMG_GENERATOR_FNFAL_CLAY,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.GOLD_PAN, new ItemStack(Material.CLAY), SlimefunItems.GOLD_PAN,
                        FNAmpItems.FMG_GENERATOR_CLAY_BROKEN, SMG_ITEMSTACK_GRAVEL, FNAmpItems.FMG_GENERATOR_CLAY_BROKEN,
                        new ItemStack(Material.DIAMOND_PICKAXE), new ItemStack(Material.FURNACE), new ItemStack(Material.DIAMOND_PICKAXE)})
                .setItem(Material.CLAY)
                .setRate(value.clayTickrate())
                .getMaterialName("&3&l粘土")
                .register(plugin);

        new CustomBrokenGenerator(FNAmpItems.MATERIAL_GENERATORS,
                FNAmpItems.FMG_GENERATOR_WARPED_BROKEN,
                FnAssemblyStation.RECIPE_TYPE,
                new ItemStack[]{
                        SlimefunItems.CARBONADO, new ItemStack(Material.DIAMOND_SHOVEL), SlimefunItems.CARBONADO,
                        new ItemStack(Material.NETHERITE_PICKAXE), new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.NETHERITE_PICKAXE),
                        SlimefunItems.CARBONADO, SlimefunItems.NETHER_GOLD_PAN, SlimefunItems.CARBONADO})
                .register(plugin);

        new CustomMaterialGenerator(FNAmpItems.MATERIAL_GENERATORS,
                FNAmpItems.FMG_GENERATOR_FNFAL_WARPED1,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        new ItemStack(Material.NETHERITE_SHOVEL), new ItemStack(Material.WARPED_NYLIUM), new ItemStack(Material.NETHERITE_SHOVEL),
                        SMG_ITEMSTACK_NETHERRACK, new ItemStack(Material.NETHERITE_PICKAXE), SMG_ITEMSTACK_NETHERRACK,
                        FNAmpItems.FMG_GENERATOR_WARPED_BROKEN, new ItemStack(Material.BLAST_FURNACE), FNAmpItems.FMG_GENERATOR_WARPED_BROKEN})
                .setItem(Material.WARPED_NYLIUM)
                .setRate(value.warpedTickrate())
                .getMaterialName("&4&c诡异菌岩")
                .register(plugin);

        new CustomBrokenGenerator(FNAmpItems.MATERIAL_GENERATORS,
                FNAmpItems.FMG_GENERATOR_TERRACOTTA_BROKEN,
                FnAssemblyStation.RECIPE_TYPE,
                new ItemStack[]{
                        SlimefunItems.FERROSILICON, new ItemStack(Material.DIAMOND_PICKAXE), SlimefunItems.FERROSILICON,
                        new ItemStack(Material.DIAMOND_SHOVEL), new ItemStack(Material.BUCKET), new ItemStack(Material.DIAMOND_SHOVEL),
                        SlimefunItems.FERROSILICON, new ItemStack(Material.COAL), SlimefunItems.FERROSILICON})
                .register(plugin);

        new CustomMaterialGenerator(FNAmpItems.MATERIAL_GENERATORS,
                FNAmpItems.FMG_GENERATOR_FNFAL_TERRACOTTA,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SMG_ITEMSTACK_COBBLE, SMG_ITEMSTACK_GRAVEL, SMG_ITEMSTACK_COBBLE,
                        FNAmpItems.FMG_GENERATOR_FNFAL_CLAY, new ItemStack(Material.TERRACOTTA), FNAmpItems.FMG_GENERATOR_FNFAL_CLAY,
                        FNAmpItems.FMG_GENERATOR_TERRACOTTA_BROKEN, new ItemStack(Material.BLAST_FURNACE), FNAmpItems.FMG_GENERATOR_TERRACOTTA_BROKEN})
                .setItem(Material.TERRACOTTA)
                .setRate(value.terracottaTickrate())
                .getMaterialName("&4&l陶瓦")
                .register(plugin);

        new CustomBrokenGenerator(FNAmpItems.MATERIAL_GENERATORS,
                FNAmpItems.FMG_GENERATOR_BONE_BROKEN,
                FnAssemblyStation.RECIPE_TYPE,
                new ItemStack[]{
                        new ItemStack(Material.BONE_MEAL), new ItemStack(Material.DIAMOND_SWORD), new ItemStack(Material.BONE_MEAL),
                        new ItemStack(Material.BONE_BLOCK), new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.BONE_BLOCK),
                        SlimefunItems.BLISTERING_INGOT_2, new ItemStack(Material.COAL), SlimefunItems.BLISTERING_INGOT_2})
                .register(plugin);

        new CustomMaterialGenerator(FNAmpItems.MATERIAL_GENERATORS,
                FNAmpItems.FMG_GENERATOR_FNFAL_BONE,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.BLISTERING_INGOT_3, SMG_ITEMSTACK_SOUL_SAND, SlimefunItems.BLISTERING_INGOT_3,
                        FNAmpItems.FMG_GENERATOR_BONE_BROKEN, new ItemStack(Material.BONE_BLOCK), FNAmpItems.FMG_GENERATOR_BONE_BROKEN,
                        SlimefunItems.PROGRAMMABLE_ANDROID, new ItemStack(Material.BLAST_FURNACE), SlimefunItems.PROGRAMMABLE_ANDROID})
                .setItem(Material.BONE)
                .setRate(value.boneTickrate())
                .getMaterialName("&f&l骨头")
                .register(plugin);

        new CustomBrokenGenerator(FNAmpItems.MATERIAL_GENERATORS,
                FNAmpItems.FMG_GENERATOR_DIAMOND_BROKEN,
                FnAssemblyStation.RECIPE_TYPE,
                new ItemStack[]{
                        SlimefunItems.SYNTHETIC_DIAMOND, SMG_ITEMSTACK_COBBLE_2, SlimefunItems.SYNTHETIC_DIAMOND,
                        new ItemStack(Material.DIAMOND_BLOCK), new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.DIAMOND_BLOCK),
                        SlimefunItems.SYNTHETIC_DIAMOND, new ItemStack(Material.DIAMOND_PICKAXE), SlimefunItems.SYNTHETIC_DIAMOND})
                .register(plugin);

        new CustomMaterialGenerator(FNAmpItems.MATERIAL_GENERATORS,
                FNAmpItems.FMG_GENERATOR_FNFAL_DIAMOND,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.PROGRAMMABLE_ANDROID_MINER, FNAmpItems.FMG_GENERATOR_DIAMOND_BROKEN, SlimefunItems.PROGRAMMABLE_ANDROID_MINER,
                        FNAmpItems.FMG_GENERATOR_DIAMOND_BROKEN, new ItemStack(Material.DIAMOND_BLOCK), FNAmpItems.FMG_GENERATOR_DIAMOND_BROKEN,
                        SlimefunItems.PROGRAMMABLE_ANDROID, new ItemStack(Material.BLAST_FURNACE), SlimefunItems.PROGRAMMABLE_ANDROID})
                .setItem(Material.DIAMOND)
                .setRate(value.diamondTickrate())
                .getMaterialName("&b&l钻石")
                .register(plugin);

        new CustomBrokenGenerator(FNAmpItems.MATERIAL_GENERATORS,
                FNAmpItems.FMG_GENERATOR_EMERALD_BROKEN,
                FnAssemblyStation.RECIPE_TYPE,
                new ItemStack[]{
                        new ItemStack(Material.EMERALD), new ItemStack(Material.EMERALD_ORE), new ItemStack(Material.EMERALD),
                        new ItemStack(Material.EMERALD_BLOCK), new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.EMERALD_BLOCK),
                        SlimefunItems.SYNTHETIC_EMERALD, new ItemStack(Material.DIAMOND_PICKAXE), SlimefunItems.SYNTHETIC_EMERALD})
                .register(plugin);

        new CustomMaterialGenerator(FNAmpItems.MATERIAL_GENERATORS,
                FNAmpItems.FMG_GENERATOR_FNFAL_EMERALD,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.PROGRAMMABLE_ANDROID_MINER, FNAmpItems.FMG_GENERATOR_FNFAL_DIAMOND, SlimefunItems.PROGRAMMABLE_ANDROID_MINER,
                        FNAmpItems.FMG_GENERATOR_EMERALD_BROKEN, new ItemStack(Material.EMERALD_BLOCK), FNAmpItems.FMG_GENERATOR_EMERALD_BROKEN,
                        SlimefunItems.PROGRAMMABLE_ANDROID, new ItemStack(Material.BLAST_FURNACE), SlimefunItems.PROGRAMMABLE_ANDROID})
                .setItem(Material.EMERALD)
                .setRate(value.emeraldTickrate())
                .getMaterialName("&a&l绿宝石")
                .register(plugin);

        new CustomBrokenGenerator(FNAmpItems.MATERIAL_GENERATORS,
                FNAmpItems.FMG_GENERATOR_DIRT_BROKEN,
                FnAssemblyStation.RECIPE_TYPE,
                new ItemStack[]{
                        new ItemStack(Material.DIRT), new ItemStack(Material.DIAMOND_SHOVEL), new ItemStack(Material.DIRT),
                        new ItemStack(Material.DIAMOND_SHOVEL), new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.IRON_SHOVEL),
                        SlimefunItems.SOLDER_INGOT, new ItemStack(Material.DIAMOND_PICKAXE), SlimefunItems.SOLDER_INGOT})
                .register(plugin);

        new CustomMaterialGenerator(FNAmpItems.MATERIAL_GENERATORS,
                FNAmpItems.FMG_GENERATOR_FNFAL_DIRT,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        new ItemStack(Material.GOLDEN_SHOVEL), FNAmpItems.FMG_GENERATOR_FNFAL_CLAY, new ItemStack(Material.DIAMOND_SHOVEL),
                        FNAmpItems.FMG_GENERATOR_DIRT_BROKEN, new ItemStack(Material.DIRT), FNAmpItems.FMG_GENERATOR_DIRT_BROKEN,
                        SlimefunItems.MAGNESIUM_INGOT, new ItemStack(Material.BLAST_FURNACE), SlimefunItems.MAGNESIUM_INGOT})
                .setItem(Material.DIRT)
                .setRate(value.dirtTickrate())
                .getMaterialName("&6&l泥土")
                .register(plugin);

        new CustomBrokenGenerator(FNAmpItems.MATERIAL_GENERATORS,
                FNAmpItems.FMG_GENERATOR_HONEYCOMB_BROKEN,
                FnAssemblyStation.RECIPE_TYPE,
                new ItemStack[]{
                        new ItemStack(Material.HONEYCOMB), new ItemStack(Material.HONEY_BOTTLE), new ItemStack(Material.HONEYCOMB),
                        new ItemStack(Material.DIAMOND_SHOVEL), new ItemStack(Material.WATER_BUCKET), new ItemStack(Material.IRON_SHOVEL),
                        SlimefunItems.REINFORCED_PLATE, new ItemStack(Material.HONEY_BLOCK), SlimefunItems.REINFORCED_PLATE})
                .register(plugin);

        new CustomMaterialGenerator(FNAmpItems.MATERIAL_GENERATORS,
                FNAmpItems.FMG_GENERATOR_FNFAL_HONEYCOMB,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        new ItemStack(Material.HONEYCOMB_BLOCK), FNAmpItems.FMG_GENERATOR_FNFAL_DIRT, new ItemStack(Material.HONEYCOMB_BLOCK),
                        FNAmpItems.FMG_GENERATOR_HONEYCOMB_BROKEN, new ItemStack(Material.HONEYCOMB), FNAmpItems.FMG_GENERATOR_HONEYCOMB_BROKEN,
                        SlimefunItems.REINFORCED_ALLOY_INGOT, new ItemStack(Material.BLAST_FURNACE), SlimefunItems.REINFORCED_ALLOY_INGOT})
                .setItem(Material.HONEYCOMB)
                .setRate(value.honeycombTickrate())
                .getMaterialName("&6&l蜜脾")
                .register(plugin);
    }
}
