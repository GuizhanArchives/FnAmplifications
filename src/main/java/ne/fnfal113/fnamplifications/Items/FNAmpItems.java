package ne.fnfal113.fnamplifications.Items;

import dev.j3fftw.extrautils.utils.LoreBuilderDynamic;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerSkin;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import ne.fnfal113.fnamplifications.FNAmplifications;
import ne.fnfal113.fnamplifications.PowerGenerators.PowahGenerator;
import ne.fnfal113.fnamplifications.config.ConfigManager;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class FNAmpItems {

    private static final ConfigManager value = FNAmplifications.getInstance().getConfigManager();

    private FNAmpItems() {
    }

    private static final ItemStack STICK = new ItemStack(Material.STICK);

    private static final ItemStack ARMOR = new ItemStack(Material.NETHERITE_CHESTPLATE);

    static {
        ItemMeta meta = STICK.getItemMeta();
        if (meta != null) {
            meta.addEnchant(Enchantment.BINDING_CURSE, 1, false);
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            STICK.setItemMeta(meta);
        }

        ItemMeta armorMeta = ARMOR.getItemMeta();
        if (armorMeta != null) {
            armorMeta.addEnchant(Enchantment.BINDING_CURSE, 1, false);
            armorMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            ARMOR.setItemMeta(armorMeta);
        }

    }

    public static final NestedItemGroup FN_ITEMS = new NestedItemGroup(
        new NamespacedKey(FNAmplifications.getInstance(), "FN_ITEMS"),
        new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromHashCode(
            "115b670a704ba080a730acf246da64c413901644847edd671c3da9a97441ddc5")),
            "&e&lFN&c&l科技"));

    public static final SubItemGroup POWER_GENERATORS = new SubItemGroup(
        new NamespacedKey(FNAmplifications.getInstance(), "POWER_GENERATORS"),
        FN_ITEMS,
        new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromHashCode(
            "ecb316f7a227a8c59d58ae0dd6768fe4fa546d55b9cfdd56cfe40b6586d81c24")),
            "&eFN发电机"));

    public static final SubItemGroup MATERIAL_GENERATORS = new SubItemGroup(
        new NamespacedKey(FNAmplifications.getInstance(), "MATERIAL_GENERATORS"),
        FN_ITEMS,
        new CustomItemStack(Material.EMERALD_BLOCK,
            "&eFN材料生成器"));

    public static final SubItemGroup SOLAR_GENERATORS = new SubItemGroup(
        new NamespacedKey(FNAmplifications.getInstance(), "SOLAR_GENERATORS"),
        FN_ITEMS,
        new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromHashCode(
            "e7f4c00356d1addb85b45ba5352992d3ecc0c9d11feb9041482f8531fd27d014")),
            "&eFN太阳能发电机"));

    public static final SubItemGroup MACHINES = new SubItemGroup(
        new NamespacedKey(FNAmplifications.getInstance(), "MACHINERY"),
        FN_ITEMS,
        new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromHashCode(
            "4a7d54ca45a398c364cebbffb5390ce5e0345e0c7bc5e863acabf57d1342c4bd")),
            "&eFN机器"));

    public static final SubItemGroup ITEMS = new SubItemGroup(
        new NamespacedKey(FNAmplifications.getInstance(), "MACHINERY_ITEMS"),
        FN_ITEMS,
        new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromHashCode(
            "8245a1c3e8d7c3d59d05e3634b04af4cbf8d11b70e2a40e2e6364386db49e737")),
            "&eFN零件"));

    public static final SubItemGroup MULTIBLOCK = new SubItemGroup(
        new NamespacedKey(FNAmplifications.getInstance(), "MULTIBLOCK"),
        FN_ITEMS,
        new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromHashCode(
            "550c3306bb11522fec380ea248eb6a5b180f4a7ab8843d635d14d4a778d6351")),
            "&eFN多方块结构"));

    public static final SubItemGroup METAL_SCRAP_RECIPES = new SubItemGroup(
        new NamespacedKey(FNAmplifications.getInstance(), "METAL_SCRAP_RECIPES"),
        FN_ITEMS,
        new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromHashCode(
            "3ff0bee591e5f0000ef16f966b949adcb5c2f409a14ccfc5b91222fd925045db")),
            "&e金属废料配方"));

    public static final SubItemGroup MYSTERY_STICKS = new SubItemGroup(
        new NamespacedKey(FNAmplifications.getInstance(), "MYSTERY_STICKS"),
        FN_ITEMS,
        new CustomItemStack(STICK,
            "&eFN神秘PVP/PVE棍"));

    public static final SubItemGroup FN_GEARS = new SubItemGroup(
        new NamespacedKey(FNAmplifications.getInstance(), "FN_GEARS"),
        FN_ITEMS,
        new CustomItemStack(ARMOR,
            "&eFN盔甲"));

    public static final SubItemGroup FN_STAFFS = new SubItemGroup(
        new NamespacedKey(FNAmplifications.getInstance(), "FN_STAFFS"),
        FN_ITEMS,
        new CustomItemStack(Material.BLAZE_ROD,
            "&eFN法杖"));

    public static final SubItemGroup FN_MISC = new SubItemGroup(
        new NamespacedKey(FNAmplifications.getInstance(), "FN_MISC"),
        FN_ITEMS,
        new CustomItemStack(Material.CHEST,
            "&eFN箭袋"));

    public static final ItemGroup FN_AMPLIFICATIONS = new ItemGroup(
        new NamespacedKey(FNAmplifications.getInstance(), "FN_AMPLIFICATIONS"),
        new CustomItemStack(PlayerHead.getItemStack(PlayerSkin.fromHashCode(
            "115b670a704ba080a730acf246da64c413901644847edd671c3da9a97441ddc5")),
            "&e&lFN&c&l科技"));

    public static final SlimefunItemStack FN_XPANSION_POWER_R1 = new SlimefunItemStack(
        "FN_POWER_XPANSION_POWER_R1",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode(
            "33165e254de7863459343543f933481f0dcf8d4730a23433b9a7ff0d3ff79c5a")),
        "&d&lFN发电机 R1",
        "",
        "&9可在夜间工作",
        "",
        "&7放置并右键点击该方块",
        "&7以获取功率信息",
        "",
        LoreBuilderDynamic.powerBuffer(PowahGenerator.FN_POWERGEN_RANK_I_STORAGE),
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_I_DAYRATE) + " (日间)",
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_I_NIGHTRATE) + " (夜间)"
    );

    public static final SlimefunItemStack FN_XPANSION_POWER_R2 = new SlimefunItemStack(
        "FN_POWER_XPANSION_POWER_R2",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode(
            "5b78e55e3ea6b3682bd7cead43eb1c91b2527a81aa2894f095801f6ee47a3")),
        "&d&lFN发电机 R2",
        "",
        "&9可在夜间工作",
        "",
        "&7放置并右键点击该方块",
        "&7以获取功率信息",
        "",
        LoreBuilderDynamic.powerBuffer(PowahGenerator.FN_POWERGEN_RANK_II_STORAGE),
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_II_DAYRATE) + " (日间)",
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_II_NIGHTRATE) + " (夜间)"
    );

    public static final SlimefunItemStack FN_XPANSION_POWER_R3 = new SlimefunItemStack(
        "FN_POWER_XPANSION_POWER_R3",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode(
            "45ff60d863d1cf76742f275e2ac5749dd0a978a231d3c51e816132c75aef608a")),
        "&d&lFN发电机 R3",
        "",
        "&9可在夜间工作",
        "",
        "&7放置并右键点击该方块",
        "&7以获取功率信息",
        "",
        LoreBuilderDynamic.powerBuffer(PowahGenerator.FN_POWERGEN_RANK_III_STORAGE),
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_III_DAYRATE) + " (日间)",
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_III_NIGHTRATE) + " (夜间)"
    );

    public static final SlimefunItemStack FN_XPANSION_POWER_R4 = new SlimefunItemStack(
        "FN_POWER_XPANSION_POWER_R4",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode(
            "efc05af0e88c6fb10b4c8c8b81b7aa658e64649724cb73bb9bb0f25f28bd")),
        "&d&lFN发电机 R4",
        "",
        "&9可在夜间工作",
        "",
        "&7放置并右键点击该方块",
        "&7以获取功率信息",
        "",
        LoreBuilderDynamic.powerBuffer(PowahGenerator.FN_POWERGEN_RANK_IV_STORAGE),
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_IV_DAYRATE) + " (日间)",
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_IV_NIGHTRATE) + " (夜间)"
    );

    public static final SlimefunItemStack FN_XPANSION_POWER_R5 = new SlimefunItemStack(
        "FN_POWER_XPANSION_POWER_R5",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode(
            "8f14f3179b86f69b3efa7472dacaeb2339f6290d2d817362793348abd98e021")),
        "&d&lFN发电机 R5",
        "",
        "&9可在夜间工作",
        "",
        "&7放置并右键点击该方块",
        "&7以获取功率信息",
        "",
        LoreBuilderDynamic.powerBuffer(PowahGenerator.FN_POWERGEN_RANK_V_STORAGE),
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_V_DAYRATE) + " (日间)",
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_V_NIGHTRATE) + " (夜间)"
    );

    public static final SlimefunItemStack FN_XPANSION_POWER_R6 = new SlimefunItemStack(
        "FN_POWER_XPANSION_POWER_R6",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode(
            "1d5a09884cb83ef5c908dddd385f246fefdee221712c010177f54376da238fdd")),
        "&d&lFN发电机 R6",
        "",
        "&9可在夜间工作",
        "",
        "&7放置并右键点击该方块",
        "&7以获取功率信息",
        "",
        LoreBuilderDynamic.powerBuffer(PowahGenerator.FN_POWERGEN_RANK_VI_STORAGE),
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_VI_DAYRATE) + " (日间)",
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_VI_NIGHTRATE) + " (夜间)"
    );

    public static final SlimefunItemStack FN_XPANSION_POWER_R7 = new SlimefunItemStack(
        "FN_POWER_XPANSION_POWER_R7",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode(
            "f7e541dfb4ba1f7dc28b548e347abbdc987ebe0e61c49fa87111ef1b2dcb2218")),
        "&d&lFN发电机 R7",
        "",
        "&9可在夜间工作",
        "",
        "&7放置并右键点击该方块",
        "&7以获取功率信息",
        "",
        LoreBuilderDynamic.powerBuffer(PowahGenerator.FN_POWERGEN_RANK_VII_STORAGE),
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_VII_DAYRATE) + " (日间)",
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_VII_NIGHTRATE) + " (夜间)"
    );

    public static final SlimefunItemStack FN_XPANSION_POWER_R8 = new SlimefunItemStack(
        "FN_POWER_XPANSION_POWER_R8",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode(
            "de31efefdd9551af8a4349d3d21e5ec8f37e53c801eb25b14279d6a89fe0c01e")),
        "&d&lFN发电机 R8",
        "",
        "&9可在夜间工作",
        "",
        "&7放置并右键点击该方块",
        "&7以获取功率信息",
        "",
        LoreBuilderDynamic.powerBuffer(PowahGenerator.FN_POWERGEN_RANK_VIII_STORAGE),
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_VIII_DAYRATE) + " (日间)",
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_VIII_NIGHTRATE) + " (夜间)"
    );

    public static final SlimefunItemStack FN_XPANSION_POWER_R9 = new SlimefunItemStack(
        "FN_POWER_XPANSION_POWER_R9",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode(
            "6db32b15d7f32704ed626fa52d06fb2b4071d336fdbfe61e6e41c669d6e37f47")),
        "&d&lFN发电机 R9",
        "",
        "&9可在夜间工作",
        "",
        "&7放置并右键点击该方块",
        "&7以获取功率信息",
        "",
        LoreBuilderDynamic.powerBuffer(PowahGenerator.FN_POWERGEN_RANK_IX_STORAGE),
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_IX_DAYRATE) + " (日间)",
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_IX_NIGHTRATE) + " (夜间)"
    );

    public static final SlimefunItemStack FN_XPANSION_POWER_R10 = new SlimefunItemStack(
        "FN_POWER_XPANSION_POWER_R10",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode(
            "56a7d2195ff7674bbb12e2f7578a2a63c54a980e64744450ac6656e05a790499")),
        "&d&lFN发电机 R10",
        "",
        "&9可在夜间工作",
        "",
        "&7放置并右键点击该方块",
        "&7以获取功率信息",
        "",
        LoreBuilderDynamic.powerBuffer(PowahGenerator.FN_POWERGEN_RANK_X_STORAGE),
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_X_DAYRATE) + " (日间)",
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_X_NIGHTRATE) + " (夜间)"
    );

    public static final SlimefunItemStack FN_XPANSION_POWER_R11 = new SlimefunItemStack(
        "FN_POWER_XPANSION_POWER_R11",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode(
            "7f9f356f5fe7d1bc92cddfaeba3ee773ac9df1cc4d1c2f8fe5f47013032c551d")),
        "&d&lFN发电机 R11",
        "",
        "&9可在夜间工作",
        "",
        "&7放置并右键点击该方块",
        "&7以获取功率信息",
        "",
        LoreBuilderDynamic.powerBuffer(PowahGenerator.FN_POWERGEN_RANK_XI_STORAGE),
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_XI_DAYRATE) + " (日间)",
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_XI_NIGHTRATE) + " (夜间)"
    );

    public static final SlimefunItemStack FN_XPANSION_POWER_R12 = new SlimefunItemStack(
        "FN_POWER_XPANSION_POWER_R12",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode(
            "3464874df452c1d717eddd0fb3b848202ad15571245af6fade2ecf514f3c80bb")),
        "&d&lFN发电机 R12",
        "",
        "&9可在夜间工作",
        "",
        "&7放置并右键点击该方块",
        "&7以获取功率信息",
        "",
        LoreBuilderDynamic.powerBuffer(PowahGenerator.FN_POWERGEN_RANK_XII_STORAGE),
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_XII_DAYRATE) + " (日间)",
        LoreBuilderDynamic.powerPerTick(PowahGenerator.FN_POWERGEN_RANK_XII_NIGHTRATE) + " (夜间)"
    );

    public static final SlimefunItemStack FMG_GENERATOR_MULTIBLOCK = new SlimefunItemStack(
        "FMG_GENERATOR_MULTIBLOCK",
        Material.BEDROCK,
        "&9FN材料生成器",
        "",
        "&a在任意FN材料生成器上",
        "&a放置一个箱子",
        "&a即可开始生产"
    );

    public static final SlimefunItemStack FMG_GENERATOR_CLAY_BROKEN = new SlimefunItemStack(
        "FMG_GENERATOR_CLAY_BROKEN",
        Material.CLAY,
        "&3FN粘土生成器 &8(破损)",
        "",
        "&7需要修复"
    );

    public static SlimefunItemStack FMG_GENERATOR_FNFAL_CLAY = new SlimefunItemStack(
        "FMG_GENERATOR_FNFAL_CLAY",
        Material.CLAY,
        "&3FN粘土生成器",
        "",
        "&6自动生产粘土"
    );

    public static final SlimefunItemStack FMG_GENERATOR_WARPED_BROKEN = new SlimefunItemStack(
        "FMG_GENERATOR_WARPED_BROKEN",
        Material.WARPED_NYLIUM,
        "&4FN诡异菌岩生成器 &8(破损)",
        "",
        "&7需要修复"
    );

    public static final SlimefunItemStack FMG_GENERATOR_FNFAL_WARPED1 = new SlimefunItemStack(
        "FMG_GENERATOR_FNFAL_WARPED1",
        Material.WARPED_NYLIUM,
        "&4FN诡异菌岩生成器",
        "",
        "&6自动生产诡异菌岩"
    );

    public static final SlimefunItemStack FMG_GENERATOR_TERRACOTTA_BROKEN = new SlimefunItemStack(
        "FMG_GENERATOR_TERRACOTTA_BROKEN",
        Material.TERRACOTTA,
        "&4FN陶瓦生成器 &8(破损)",
        "",
        "&7需要修复"
    );

    public static final SlimefunItemStack FMG_GENERATOR_FNFAL_TERRACOTTA = new SlimefunItemStack(
        "FMG_GENERATOR_FNFAL_TERRACOTTA",
        Material.TERRACOTTA,
        "&4FN陶瓦生成器",
        "",
        "&6自动生产陶瓦"
    );

    public static final SlimefunItemStack FMG_GENERATOR_BONE_BROKEN = new SlimefunItemStack(
        "FMG_GENERATOR_BONE_BROKEN",
        Material.BONE_BLOCK,
        "&fFN骨头生成器 &8(破损)",
        "",
        "&7需要修复"
    );

    public static final SlimefunItemStack FMG_GENERATOR_FNFAL_BONE = new SlimefunItemStack(
        "FMG_GENERATOR_FNFAL_BONE",
        Material.BONE_BLOCK,
        "&fFN骨头生成器",
        "",
        "&6自动生产骨头"
    );

    public static final SlimefunItemStack FMG_GENERATOR_DIAMOND_BROKEN = new SlimefunItemStack(
        "FMG_GENERATOR_DIAMOND_BROKEN",
        Material.DIAMOND_BLOCK,
        "&bFN_FAL钻石生成器 &8(破损)",
        "",
        "&7需要修复"
    );

    public static final SlimefunItemStack FMG_GENERATOR_FNFAL_DIAMOND = new SlimefunItemStack(
        "FMG_GENERATOR_FNFAL_DIAMOND",
        Material.DIAMOND_BLOCK,
        "&bFN钻石生成器",
        "",
        "&6自动生产钻石"
    );

    public static final SlimefunItemStack FMG_GENERATOR_EMERALD_BROKEN = new SlimefunItemStack(
        "FMG_GENERATOR_EMERALD_BROKEN",
        Material.EMERALD_BLOCK,
        "&aFN绿宝石生成器 &8(破损)",
        "",
        "&7需要修复"
    );

    public static final SlimefunItemStack FMG_GENERATOR_FNFAL_EMERALD = new SlimefunItemStack(
        "FMG_GENERATOR_FNFAL_EMERALD",
        Material.EMERALD_BLOCK,
        "&aFN绿宝石生成器",
        "",
        "&6自动生产绿宝石"
    );

    public static final SlimefunItemStack FMG_GENERATOR_DIRT_BROKEN = new SlimefunItemStack(
        "FMG_GENERATOR_DIRT_BROKEN",
        Material.DIRT,
        "&fFN泥土生成器 &8(破损)",
        "",
        "&7需要修复"
    );

    public static final SlimefunItemStack FMG_GENERATOR_FNFAL_DIRT = new SlimefunItemStack(
        "FMG_GENERATOR_FNFAL_DIRT",
        Material.DIRT,
        "&fFN泥土生成器",
        "",
        "&6自动生产泥土"
    );

    public static final SlimefunItemStack FMG_GENERATOR_HONEYCOMB_BROKEN = new SlimefunItemStack(
        "FMG_GENERATOR_HONEYCOMB_BROKEN",
        Material.HONEYCOMB_BLOCK,
        "&6FN蜜脾生成器 &8(破损)",
        "",
        "&7需要修复"
    );

    public static final SlimefunItemStack FMG_GENERATOR_FNFAL_HONEYCOMB = new SlimefunItemStack(
        "FMG_GENERATOR_FNFAL_HONEYCOMB",
        Material.HONEYCOMB_BLOCK,
        "&6FN蜜脾生成器",
        "",
        "&6自动生产蜜脾"
    );

    public static final SlimefunItemStack FN_FAL_GENERATOR_TIER1 = new SlimefunItemStack(
        "FN_FAL_GENERATOR_TIER1",
        "6d2822cedb3abd579d6dfa2966c1433c3c36cb9732e2c23ec0cc81daedd4403b",
        "&dFN太阳能发电机组 I",
        "",
        "&e为你提供基础电力",
        value.tier1Lore(),
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR),
        LoreBuilder.powerBuffer(value.tier1Buffer()),
        LoreBuilder.powerPerSecond(value.tier1Power() * 2) + " (日间)",
        LoreBuilder.powerPerSecond(value.tier1PowerNight() * 2) + " (夜间)");

    public static final SlimefunItemStack FN_FAL_GENERATOR_TIER2 = new SlimefunItemStack(
        "FN_FAL_GENERATOR_TIER2",
        "35dd37f729fc88133e314a552204c0fa2c0168428b353f957bf15ff24b7707e0",
        "&dFN太阳能发电机组 II",
        "",
        "&e为你提供基础电力",
        value.tier2Lore(),
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR),
        LoreBuilder.powerBuffer(value.tier2Buffer()),
        LoreBuilder.powerPerSecond(value.tier2Power() * 2) + " (日间)",
        LoreBuilder.powerPerSecond(value.tier2PowerNight() * 2) + " (夜间)");

    public static final SlimefunItemStack FN_FAL_GENERATOR_TIER3 = new SlimefunItemStack(
        "FN_FAL_GENERATOR_TIER3",
        "25ddf6af2d6271d8fdfadbdc54faaad5a68d7b8ac20e163883fc38d76336ea6",
        "&dFN太阳能发电机组 III",
        "",
        "&e为你提供基础电力",
        value.tier3Lore(),
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR),
        LoreBuilder.powerBuffer(value.tier3Buffer()),
        LoreBuilder.powerPerSecond(value.tier3Power() * 2) + " (日间)",
        LoreBuilder.powerPerSecond(value.tier3PowerNight() * 2) + " (夜间)");

    public static final SlimefunItemStack FN_FAL_GENERATOR_TIER4 = new SlimefunItemStack(
        "FN_FAL_GENERATOR_TIER4",
        "e7f4c00356d1addb85b45ba5352992d3ecc0c9d11feb9041482f8531fd27d014",
        "&dFN太阳能发电机组 IV",
        "",
        "&e为你提供基础电力",
        value.tier4Lore(),
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR),
        LoreBuilder.powerBuffer(value.tier4Buffer()),
        LoreBuilder.powerPerSecond(value.tier4Power() * 2) + " (日间)",
        LoreBuilder.powerPerSecond(value.tier4PowerNight() * 2) + " (夜间)");

    public static final SlimefunItemStack FN_FAL_GENERATOR_TIER5 = new SlimefunItemStack(
        "FN_FAL_GENERATOR_TIER5",
        "afdd9e588d2461d2d3d058cb3e0af2b3a3367607aa14d124ed92a833f25fb112",
        "&dFN太阳能发电机组 V",
        "",
        "&e为你提供基础电力",
        value.tier5Lore(),
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR),
        LoreBuilder.powerBuffer(value.tier5Buffer()),
        LoreBuilder.powerPerSecond(value.tier5Power() * 2) + " (日间)",
        LoreBuilder.powerPerSecond(value.tier5PowerNight() * 2) + " (夜间)");

    public static final SlimefunItemStack FN_FAL_GENERATOR_TIER6 = new SlimefunItemStack(
        "FN_FAL_GENERATOR_TIER6",
        "224ad26209fa02f559ef6aa863ee9ba8f3bef0a02f1e9cff8fdc09196402fb6f",
        "&dFN太阳能发电机组 VI",
        "",
        "&e为你提供基础电力",
        value.tier6Lore(),
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR),
        LoreBuilder.powerBuffer(value.tier6Buffer()),
        LoreBuilder.powerPerSecond(value.tier6Power() * 2) + " (日间)",
        LoreBuilder.powerPerSecond(value.tier6PowerNight() * 2) + " (夜间)");

    public static final SlimefunItemStack FN_FAL_GENERATOR_TIER7 = new SlimefunItemStack(
        "FN_FAL_GENERATOR_TIER7",
        "c4fe135c311f7086edcc5e6dbc4ef4b23f819fddaa42f827dac46e3574de2287",
        "&dFN太阳能发电机组 VII",
        "",
        "&e为你提供基础电力",
        value.tier7Lore(),
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR),
        LoreBuilder.powerBuffer(value.tier7Buffer()),
        LoreBuilder.powerPerSecond(value.tier7Power() * 2) + " (日间)",
        LoreBuilder.powerPerSecond(value.tier7PowerNight() * 2) + " (夜间)");

    public static final SlimefunItemStack FN_FAL_GENERATOR_TIER8 = new SlimefunItemStack(
        "FN_FAL_GENERATOR_TIER8",
        "240775c3ad75763613f32f04986881bbe4eee4366d0c57f17f7c7514e2d0a77d",
        "&dFN太阳能发电机组 VIII",
        "",
        "&e为你提供基础电力",
        value.tier8Lore(),
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.GENERATOR),
        LoreBuilder.powerBuffer(value.tier8Buffer()),
        LoreBuilder.powerPerSecond(value.tier8Power() * 2) + " (日间)",
        LoreBuilder.powerPerSecond(value.tier8PowerNight() * 2) + " (夜间)");

    public static final SlimefunItemStack FN_FAL_TRANSFORMER_1 = new SlimefunItemStack(
        "FN_FAL_TRANSFORMER_1",
        Material.BLUE_GLAZED_TERRACOTTA,
        "&dFN转换器 I",
        "",
        "&e使用一些材料",
        "&e来快速升级机器/物品",
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.speed(1),
        LoreBuilder.powerPerSecond(256));

    public static final SlimefunItemStack FN_FAL_TRANSFORMER_2 = new SlimefunItemStack(
        "FN_FAL_TRANSFORMER_2",
        Material.BLUE_GLAZED_TERRACOTTA,
        "&dFN转换器 II",
        "",
        "&e使用一些材料",
        "&e来快速升级机器/物品",
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.speed(2),
        LoreBuilder.powerPerSecond(384));

    public static final SlimefunItemStack FN_FAL_TRANSFORMER_3 = new SlimefunItemStack(
        "FN_FAL_TRANSFORMER_3",
        Material.BLUE_GLAZED_TERRACOTTA,
        "&dFN转换器 III",
        "",
        "&e使用一些材料",
        "&e来快速升级机器/物品",
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.speed(4),
        LoreBuilder.powerPerSecond(768));

    public static final SlimefunItemStack FN_FAL_COMPRESSOR_1 = new SlimefunItemStack(
        "FN_FAL_COMPRESSOR_1",
        Material.GREEN_GLAZED_TERRACOTTA,
        "&dFN液压机 I",
        "",
        "&e它可以自动压缩一些特定物品",
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.speed(1),
        LoreBuilder.powerPerSecond(128));

    public static final SlimefunItemStack FN_FAL_COMPRESSOR_2 = new SlimefunItemStack(
        "FN_FAL_COMPRESSOR_2",
        Material.GREEN_GLAZED_TERRACOTTA,
        "&dFN液压机 II",
        "",
        "&e它可以自动压缩一些特定物品",
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.speed(2),
        LoreBuilder.powerPerSecond(256));

    public static final SlimefunItemStack FN_FAL_COMPRESSOR_3 = new SlimefunItemStack(
        "FN_FAL_COMPRESSOR_3",
        Material.GREEN_GLAZED_TERRACOTTA,
        "&dFN液压机 III",
        "",
        "&e它可以自动压缩一些特定物品",
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.speed(4),
        LoreBuilder.powerPerSecond(512));

    public static final SlimefunItemStack FN_FAL_CONDENSER_1 = new SlimefunItemStack(
        "FN_FAL_CONDENSER_1",
        Material.YELLOW_STAINED_GLASS,
        "&dFN电锭冷凝机 I",
        "",
        "&e它可以将两种材料熔融混合",
        "&e并冷凝成新的材料",
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.speed(1),
        LoreBuilder.powerPerSecond(256));

    public static final SlimefunItemStack FN_FAL_CONDENSER_2 = new SlimefunItemStack(
        "FN_FAL_CONDENSER_2",
        Material.YELLOW_STAINED_GLASS,
        "&dFN电锭冷凝机 II",
        "",
        "&e它可以将两种材料熔融混合",
        "&e并冷凝成新的材料",
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.speed(2),
        LoreBuilder.powerPerSecond(384));

    public static final SlimefunItemStack FN_FAL_CONDENSER_3 = new SlimefunItemStack(
        "FN_FAL_CONDENSER_3",
        Material.YELLOW_STAINED_GLASS,
        "&dFN电锭冷凝机 III",
        "",
        "&e它可以将两种材料熔融混合",
        "&e并冷凝成新的材料",
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.speed(4),
        LoreBuilder.powerPerSecond(768));

    public static final SlimefunItemStack FN_FAL_RECYCLER_1 = new SlimefunItemStack(
        "FN_FAL_RECYCLER_1",
        Material.PURPLE_STAINED_GLASS,
        "&dFN电动回收机 I",
        "",
        "&e它可以将物品回收成低一级的产品",
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.speed(1),
        LoreBuilder.powerPerSecond(168));

    public static final SlimefunItemStack FN_FAL_RECYCLER_2 = new SlimefunItemStack(
        "FN_FAL_RECYCLER_2",
        Material.PURPLE_STAINED_GLASS,
        "&dFN电动回收机 II",
        "",
        "&e它可以将物品回收成低一级的产品",
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.speed(2),
        LoreBuilder.powerPerSecond(336));

    public static final SlimefunItemStack FN_FAL_RECYCLER_3 = new SlimefunItemStack(
        "FN_FAL_RECYCLER_3",
        Material.PURPLE_STAINED_GLASS,
        "&dFN电动回收机 III",
        "",
        "&e它可以将物品回收成低一级的产品",
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.speed(2),
        LoreBuilder.powerPerSecond(672));

    public static final SlimefunItemStack FN_FAL_DOWNGRADER = new SlimefunItemStack(
        "FN_FAL_DOWNGRADER",
        Material.WHITE_GLAZED_TERRACOTTA,
        "&d电机降级器",
        "",
        "&e一种可以使粘液机器降级的机器",
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.speed(4),
        LoreBuilder.powerPerSecond(1500));

    public static final SlimefunItemStack MACHINE_PART = new SlimefunItemStack(
        "FN_MACHINERY_MACHINE_PART",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode("6ddd4a12da1cc2c9f9d6cd49fc778e3a11f3757de6dd312d70a0d47885189c0")),
        "&d机器零件",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack MACHINE_PART_SCRAP = new SlimefunItemStack(
        "FN_MACHINERY_MACHINE_PART_SCRAP",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode("6ddd4a12da1cc2c9f9d6cd49fc778e3a11f3757de6dd312d70a0d47885189c0")),
        "&d机器零件",
        "",
        "&f使用金属废料制作",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack COMPONENT_PART = new SlimefunItemStack(
        "FN_MACHINERY_COMPONENT_PART",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode("74657e89167b17ed581e87ce4215ce8d47145ab34038202d5ccefb0a9bd0d8f4")),
        "&d散热器",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack COMPONENT_PART_SCRAP = new SlimefunItemStack(
        "FN_MACHINERY_COMPONENT_PART_SCRAP",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode("74657e89167b17ed581e87ce4215ce8d47145ab34038202d5ccefb0a9bd0d8f4")),
        "&d散热器",
        "",
        "&f使用金属废料制作",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack MOTOR_SWITCH = new SlimefunItemStack(
        "FN_MACHINERY_MOTOR_SWITCH",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode("48748ce96cedbfecaa463966d8fb1ac83c408feea89bd60d76d6024d3befe")),
        "&d马达开关",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack MOTOR_SWITCH_SCRAP = new SlimefunItemStack(
        "FN_MACHINERY_MOTOR_SWITCH_SCRAP",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode("48748ce96cedbfecaa463966d8fb1ac83c408feea89bd60d76d6024d3befe")),
        "&d马达开关",
        "",
        "&f使用金属废料制作",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack POWER_COMPONENT = new SlimefunItemStack(
        "FN_MACHINERY_POWER_COMPONENT",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode("25ba8456e92f0790222c19c06f61180a195af1008569ed352b93a3c6d9ec7a98")),
        "&d电源组件",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack POWER_COMPONENT_SCRAP = new SlimefunItemStack(
        "FN_MACHINERY_POWER_COMPONENT_SCRAP",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode("25ba8456e92f0790222c19c06f61180a195af1008569ed352b93a3c6d9ec7a98")),
        "&d电源组件",
        "",
        "&f使用金属废料制作",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack GEAR_PART = new SlimefunItemStack(
        "FN_MACHINERY_GEAR_PART",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode("faf0c95ceba34c7fe6d33404feb87b4184ccce143978622c1647feaed2b63274")),
        "&d齿轮",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack GEAR_PART_SCRAP = new SlimefunItemStack(
        "FN_MACHINERY_GEAR_PART_SCRAP",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode("faf0c95ceba34c7fe6d33404feb87b4184ccce143978622c1647feaed2b63274")),
        "&d齿轮",
        "",
        "&f使用金属废料制作",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack THREAD_PART = new SlimefunItemStack(
        "FN_MACHINERY_THREAD_PART",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode("87ec65d6649ac1bf7b282575cef299f8601e51d8418d6e546e4fc71b218f7")),
        "&d镶件螺纹",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack THREAD_PART_SCRAP = new SlimefunItemStack(
        "FN_MACHINERY_THREAD_PART_SCRAP",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode("87ec65d6649ac1bf7b282575cef299f8601e51d8418d6e546e4fc71b218f7")),
        "&d镶件螺纹",
        "",
        "&f使用金属废料制作",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack COMPRESSOR_PART = new SlimefunItemStack(
        "FN_MACHINERY_COMPRESSOR_PART",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode("e48337f7ede15c3b2f8dc6a63bd92874cdf74ec862b4118c7e35559ce8b4d")),
        "&d压缩零件",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack CONDENSER_PART = new SlimefunItemStack(
        "FN_MACHINERY_CONDENSER_PART",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode("63be652b2e1b93ed8e93b427de455d446582e6c8d929f8fc96ac488a8f7f53")),
        "&d冷凝器",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack RECYCLER_PART = new SlimefunItemStack(
        "FN_MACHINERY_RECYCLER_PART",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode("4817fc8e16b8e994efb908b71acd1d1352ca5aefa09fecc9339ebea450d83fb8")),
        "&d回收器",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack DOWNGRADER_PART = new SlimefunItemStack(
        "FN_MACHINERY_DOWNGRADER_PART",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode("a44c5ce2eb643f8671c667e8802c9317ad8cc6af680d4ef671d8c0c63277900a")),
        "&d降级器",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack FUNNEL_PART = new SlimefunItemStack(
        "FN_MACHINERY_FUNNEL_PART",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode("bb2abd66939f4cb7257a88cf52fbc6fdceec1433ec2a6ef16d62e34f6238781")),
        "&d金属漏斗",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack FUNNEL_PART_SCRAP = new SlimefunItemStack(
        "FN_MACHINERY_FUNNEL_PART_SCRAP",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode("bb2abd66939f4cb7257a88cf52fbc6fdceec1433ec2a6ef16d62e34f6238781")),
        "&d金属漏斗",
        "",
        "&f使用金属废料制作",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack DIAMOND_PLATING = new SlimefunItemStack(
        "FN_MACHINERY_DIAMOND_PLATING",
        Material.LIGHT_BLUE_CARPET,
        "&d金刚石镀膜",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack ALUMINUM_PLATING = new SlimefunItemStack(
        "FN_MACHINERY_ALUMINUM_PLATING",
        Material.WHITE_CARPET,
        "&d铝镀膜",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack GOLD_PLATING = new SlimefunItemStack(
        "FN_MACHINERY_GOLD_PLATING",
        Material.YELLOW_CARPET,
        "&d黄金镀膜",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack BRASS_PLATING = new SlimefunItemStack(
        "FN_MACHINERY_BRASS_PLATING",
        Material.BROWN_CARPET,
        "&d黄铜镀膜",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack REINFORCED_CASING = new SlimefunItemStack(
        "FN_MACHINERY_REINFORCED_CASING",
        Material.LIGHT_GRAY_CARPET,
        "&d强化合金镀膜",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack BASIC_MACHINE_BLOCK = new SlimefunItemStack(
        "FN_MACHINERY_BASIC_MACHINE_BLOCK",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode("883dd0f90df05fe6a09aaccaf54bc043e455e1c865bda1fd272e3f47fb9bb910")),
        "&d基础机器核心",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack HIGHTECH_MACHINE_BLOCK = new SlimefunItemStack(
        "FN_MACHINERY_HIGHTECH_MACHINE_BLOCK",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode("5a7b3b16e5d0c4cfd21c4eb9133e969aad7cc7303ccdf317512e26a4879b51")),
        "&d高科技机器核心",
        "",
        "&b合成材料",
        "");

    public static final SlimefunItemStack FN_ASSEMBLY_STATION = new SlimefunItemStack(
        "FN_ASSEMBLY_STATION",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode("583150f055935058634576185977ffba49ff4679faa03ad0008feaa0161865b3")),
        "&dFN组装台",
        "&f在这里制作FN物品"
    );

    public static final SlimefunItemStack FN_SCRAP_RECYCLER = new SlimefunItemStack(
        "FN_SCRAP_RECYCLER",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode("656634b556caf5382de65038a10e4d79c7c18695048599df74f9c67c1e1e8736")),
        "&dFN废料回收器",
        "&f使用废料来制作部分零件",
        "&f可用配方在\"金属废料配方\"页面查看"
    );

    public static final SlimefunItemStack FN_METAL_SCRAPS = new SlimefunItemStack(
        "FN_METAL_SCRAPS",
        PlayerHead.getItemStack(PlayerSkin.fromHashCode("3ff0bee591e5f0000ef16f966b949adcb5c2f409a14ccfc5b91222fd925045db")),
        "&d金属废料",
        "",
        "&f电机降级器的副产物",
        "&f用于合成机器零件",
        ""
    );

    public static final SlimefunItemStack FN_BLOCK_BREAKER_1 = new SlimefunItemStack(
        "FN_BLOCK_BREAKER_I",
        Material.DISPENSER,
        "&4电动方块挖掘机 I",
        "",
        "&6将方块放在机口前",
        "&6便可自动破坏该方块",
        "&d(原版)",
        "",
        "&e挖掘间隔: " + value.blockBreaker1Ticks() + " t",
        "",
        LoreBuilder.machine(MachineTier.AVERAGE, MachineType.MACHINE),
        LoreBuilder.powerBuffer(512),
        LoreBuilderDynamic.powerPerTick(32)
    );

    public static final SlimefunItemStack FN_BLOCK_BREAKER_2 = new SlimefunItemStack(
        "FN_BLOCK_BREAKER_II",
        Material.DISPENSER,
        "&4电动方块挖掘机 II",
        "",
        "&6将方块放在机口前",
        "&6便可自动破坏该方块",
        "&d(原版)",
        "",
        "&e挖掘间隔: " + value.blockBreaker2Ticks() + " t",
        "",
        LoreBuilder.machine(MachineTier.ADVANCED, MachineType.MACHINE),
        LoreBuilder.powerBuffer(1024),
        LoreBuilderDynamic.powerPerTick(64)
    );

    public static final SlimefunItemStack FN_BLOCK_BREAKER_3 = new SlimefunItemStack(
        "FN_BLOCK_BREAKER_III",
        Material.DISPENSER,
        "&4电动方块挖掘机 III",
        "",
        "&6将方块放在机口前",
        "&6便可自动破坏该方块",
        "&d(原版)",
        "",
        "&e挖掘间隔: " + value.blockBreaker3Ticks() + " t",
        "",
        LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE),
        LoreBuilder.powerBuffer(2048),
        LoreBuilderDynamic.powerPerTick(128)
    );

    public static final SlimefunItemStack FN_STICK = new SlimefunItemStack(
        "FN_MYSTERY_STICK_1",
        Material.STICK,
        "&c神秘棍 I",
        "&f我想知道这棍子有什么用"
    );


    public static final SlimefunItemStack FN_STICK_2 = new SlimefunItemStack(
        "FN_MYSTERY_STICK_2",
        Material.STICK,
        "&c神秘棍 II",
        "&f另一根不知如何使用的棍子"
    );

    public static final SlimefunItemStack FN_STICK_3 = new SlimefunItemStack(
        "FN_MYSTERY_STICK_3",
        Material.STICK,
        "&c神秘棍 III",
        "&f我感受到了力量..."
    );

    public static final SlimefunItemStack FN_STICK_4 = new SlimefunItemStack(
        "FN_MYSTERY_STICK_4",
        Material.STICK,
        "&c神秘棍 IV",
        "&f我是否真该使用它？"
    );

    public static final SlimefunItemStack FN_STICK_5 = new SlimefunItemStack(
        "FN_MYSTERY_STICK_5",
        Material.STICK,
        "&c神秘棍 V",
        "&f我知道你拿这跟棍子很累..."
    );

    public static final SlimefunItemStack FN_STICK_6 = new SlimefunItemStack(
        "FN_MYSTERY_STICK_6",
        Material.STICK,
        "&c神秘棍 VI",
        "&f愿力量与你同在"
    );

    public static final SlimefunItemStack FN_STICK_7 = new SlimefunItemStack(
        "FN_MYSTERY_STICK_7",
        Material.STICK,
        "&c神秘棍 VII",
        "&f它的光环令人着迷"
    );

    public static final SlimefunItemStack FN_STICK_8 = new SlimefunItemStack(
        "FN_MYSTERY_STICK_8",
        Material.STICK,
        "&c神秘棍 VIII",
        "&f这棍子...太重了..."
    );

    public static final SlimefunItemStack FN_STICK_9 = new SlimefunItemStack(
        "FN_MYSTERY_STICK_9",
        Material.STICK,
        "&c神秘棍 IX",
        "&f你需要更多法力"
    );

    public static final SlimefunItemStack FN_STICK_10 = new SlimefunItemStack(
        "FN_MYSTERY_STICK_10",
        Material.STICK,
        "&c神秘棍 X",
        "&f它致命并令人毛骨悚然"
    );

    public static final SlimefunItemStack FN_STICK_11 = new SlimefunItemStack(
        "FN_MYSTERY_STICK_11",
        Material.STICK,
        "&c神秘棍 XI",
        "&f定海神针..."
    );

    public static final SlimefunItemStack FN_STICK_ALTAR = new SlimefunItemStack(
        "FN_STICK_ALTAR",
        Material.ENCHANTING_TABLE,
        "&dFN神秘棍祭坛"
    );

    public static final SlimefunItemStack FN_GEAR_HELMET = new SlimefunItemStack(
        "FN_GEAR_HELMET",
        Material.NETHERITE_HELMET,
        "&c斗牛士头盔",
        "&c◬◬◬◬◬◬| &d&l介绍 &6|◬◬◬◬◬◬",
        "",
        "&f传说中的斗牛士曾使用过这个帽子",
        "&f据神话记载",
        "&f戴上它的人会被赐予无穷之力",
        "",
        "&c◈◈◈◈◈◈| &d&l数据 &6|◈◈◈◈◈◈",
        ChatColor.YELLOW + "头盔等级: 0",
        ChatColor.YELLOW + "进阶进度:",
        ChatColor.GRAY + "[" + "■■■■■■■■■■" + ChatColor.GRAY + "]"

    );

    public static final SlimefunItemStack FN_GEAR_CHESTPLATE = new SlimefunItemStack(
        "FN_GEAR_CHESTPLATE",
        Material.NETHERITE_CHESTPLATE,
        "&c罗马胸甲",
        "&c◬◬◬◬◬◬| &d&l介绍 &6|◬◬◬◬◬◬",
        "",
        "&f罗马帝国的勇士所穿的盔甲",
        "&f在每场战斗之中",
        "&f它都会不断强化自己",
        "",
        "&c◈◈◈◈◈◈| &d&l数据 &6|◈◈◈◈◈◈",
        ChatColor.YELLOW + "胸甲等级: 0",
        ChatColor.YELLOW + "进阶进度:",
        ChatColor.GRAY + "[" + "■■■■■■■■■■" + ChatColor.GRAY + "]"

    );

    public static final SlimefunItemStack FN_GEAR_LEGGINGS = new SlimefunItemStack(
        "FN_GEAR_LEGGINGS",
        Material.NETHERITE_LEGGINGS,
        "&c亚历山大护腿",
        "&c◬◬◬◬◬◬| &d&l介绍 &6|◬◬◬◬◬◬",
        "",
        "&f亚历山大远征时所着的护腿",
        "&f据说穿上它的人是不可战胜的",
        "&f它将会给予你无限大的勇气",
        "",
        "&c◈◈◈◈◈◈| &d&l数据 &6|◈◈◈◈◈◈",
        ChatColor.YELLOW + "护腿等级: 0",
        ChatColor.YELLOW + "进阶进度:",
        ChatColor.GRAY + "[" + "■■■■■■■■■■" + ChatColor.GRAY + "]"

    );

    public static final SlimefunItemStack FN_GEAR_BOOTS = new SlimefunItemStack(
        "FN_GEAR_BOOTS",
        Material.NETHERITE_BOOTS,
        "&c远征战靴",
        "&c◬◬◬◬◬◬| &d&l介绍 &6|◬◬◬◬◬◬",
        "",
        "&f远征者--残暴、血腥",
        "&f它的脚下是被征服者的血液",
        "&f在此刻，所有良知都会萧然褪去",
        "",
        "&c◈◈◈◈◈◈| &d&l数据 &6|◈◈◈◈◈◈",
        ChatColor.YELLOW + "战靴等级: 0",
        ChatColor.YELLOW + "进阶进度:",
        ChatColor.GRAY + "[" + "■■■■■■■■■■" + ChatColor.GRAY + "]"

    );

    public static final SlimefunItemStack FN_STAFF_TP = new SlimefunItemStack(
        "FN_STAFF_TP",
        Material.BLAZE_ROD,
        "&c传送法杖",
        "",
        "&e右键点击&7传送到看向的方块上",
        "",
        LoreBuilder.usesLeft(value.staffOfTeleportation())
    );

    public static final SlimefunItemStack FN_STAFF_INVI = new SlimefunItemStack(
        "FN_STAFF_INVI",
        Material.BLAZE_ROD,
        "&c隐身法杖",
        "",
        "&e右键点击&7获得6秒超级隐身",
        "&7你的护甲与名字也会隐身",
        "&7就像从世界中消失了一样",
        "",
        LoreBuilder.usesLeft(value.staffOfInvisibility())
    );

    public static final SlimefunItemStack FN_STAFF_LOCOMOTION = new SlimefunItemStack(
        "FN_STAFF_LOCOMOTION",
        Material.BLAZE_ROD,
        "&c机动法杖",
        "",
        "&eShift + 右键点击&7绑定生物",
        "&e右键点击&7将绑定的生物传送到看向的位置",
        "",
        LoreBuilder.usesLeft(value.staffOfLocomotion()),
        "",
        "&7当前绑定生物: &e无"
    );

    public static final SlimefunItemStack FN_STAFF_HELLFIRE = new SlimefunItemStack(
        "FN_STAFF_HELLFIRE",
        Material.BLAZE_ROD,
        "&c地狱火法杖",
        "",
        "&e右键点击&7在看向的方块上",
        "&7制造一片地狱火区域，持续8s",
        "&7在该区域内的生物会被点燃",
        "",
        LoreBuilder.usesLeft(value.staffOfHellFire())
    );

    public static final SlimefunItemStack FN_STAFF_DEEPFREEZE = new SlimefunItemStack(
        "FN_STAFF_DEEPFREEZE",
        Material.BLAZE_ROD,
        "&c北极冰法杖",
        "",
        "&e右键点击&7在看向的方块上",
        "&7制造一片北极冰区域，持续8s",
        "&7在该区域内的生物会被减速",
        "",
        LoreBuilder.usesLeft(value.staffOfDeepFreeze())
    );

    public static final SlimefunItemStack FN_STAFF_CONFUSION = new SlimefunItemStack(
        "FN_STAFF_CONFUSION",
        Material.BLAZE_ROD,
        "&c混乱法杖",
        "",
        "&e右键点击&7在看向的方块上",
        "&7制造一片混乱区域，持续8s",
        "&7在该区域内的生物会迷失方向",
        "",
        LoreBuilder.usesLeft(value.staffOfConfusion())
    );

    public static final SlimefunItemStack FN_STAFF_GRAVITY = new SlimefunItemStack(
        "FN_STAFF_GRAVITY",
        Material.BLAZE_ROD,
        "&c引力法杖",
        "",
        "&e右键点击&7在看向的方块上",
        "&7制造一片引力区域，持续8s",
        "&7在该区域内的生物",
        "&7将被不断地拉向区域中心",
        "",
        LoreBuilder.usesLeft(value.staffOfGravity())
    );

    public static final SlimefunItemStack FN_STAFF_STALLION = new SlimefunItemStack(
        "FN_STAFF_STALLION",
        Material.BLAZE_ROD,
        "&c骷髅法杖",
        "",
        "&e右键点击&7召唤骷髅马坐骑",
        "&7下马后坐骑消失",
        "",
        LoreBuilder.usesLeft(value.staffOfStallion())
    );

    public static final SlimefunItemStack FN_STAFF_FORCE = new SlimefunItemStack(
        "FN_STAFF_FORCE",
        Material.BLAZE_ROD,
        "&c力量法杖",
        "",
        "&e右键点击&7在看向的方块上",
        "&7制造一片力量区域，持续8s",
        "&7进入该区域的生物会获得一个瞬间的正向力",
        "&7(与行进方向相同)",
        "",
        "&e右键点击&7在看向的方块上",
        "&7制造一片反向力量区域，持续8s",
        "&7进入该区域的生物会获得一个瞬间的反向力",
        "&7(与行进方向相反)",
        "",
        LoreBuilder.usesLeft(value.staffOfForce())
    );

    public static final SlimefunItemStack FN_STAFF_HEALING = new SlimefunItemStack(
        "FN_STAFF_HEALING",
        Material.BLAZE_ROD,
        "&c治愈法杖",
        "",
        "&e右键点击&7在看向的方块上",
        "&7制造一片力量区域，持续8s",
        "&7在该区域内的生物",
        "&7将会不断地恢复2点生命值",
        "",
        LoreBuilder.usesLeft(value.staffOfHealing())
    );

    public static final SlimefunItemStack FN_STAFF_INVULNERABILITY = new SlimefunItemStack(
        "FN_STAFF_INVULNERABILITY",
        Material.BLAZE_ROD,
        "&c无敌法杖",
        "",
        "&e右键点击&7在看向的方块上",
        "&7制造一片无敌区域，持续8s",
        "&7在该区域内的生物不会受到任何伤害",
        "",
        LoreBuilder.usesLeft(value.staffOfInvulnerable())
    );

    public static final SlimefunItemStack FN_STAFF_EXPLOSION = new SlimefunItemStack(
        "FN_STAFF_EXPLOSION",
        Material.BLAZE_ROD,
        "&c爆裂法杖",
        "",
        "&e右键点击&7在看向的方块上",
        "&7制造一次爆炸并造成伤害",
        "&7不会破坏地形",
        "",
        LoreBuilder.usesLeft(value.staffOfExplosion())
    );

    public static final SlimefunItemStack FN_STAFF_MUSTER = new SlimefunItemStack(
        "FN_STAFF_MUSTER",
        Material.BLAZE_ROD,
        "&c聚集法杖",
        "",
        "&e右键点击&7任意方块",
        "&7将50格内所有生物传送至该方块上",
        "",
        LoreBuilder.usesLeft(value.staffOfMuster())
    );

    public static final SlimefunItemStack FN_STAFF_AWARENESS = new SlimefunItemStack(
        "FN_STAFF_AWARENESS",
        Material.BLAZE_ROD,
        "&c探测法杖",
        "",
        "&e右键点击&7获取",
        "&750格内所有玩家的信息",
        "",
        LoreBuilder.usesLeft(value.staffOfAwareness())
    );

    public static final SlimefunItemStack FN_STAFF_MINERALS = new SlimefunItemStack(
        "FN_STAFF_MINERALS",
        Material.BLAZE_ROD,
        "&c矿工法杖",
        "",
        "&e右键点击&7获取",
        "&7当前区块所有矿物的信息",
        "",
        LoreBuilder.usesLeft(value.staffOfMinerals())
    );

    public static final SlimefunItemStack FN_STAFF_FANGS = new SlimefunItemStack(
        "FN_STAFF_FANGS",
        Material.BLAZE_ROD,
        "&c尖牙法杖",
        "",
        "&e右键点击&7目标方向",
        "&7向该方向释放尖牙",
        "&7并造成伤害",
        "",
        LoreBuilder.usesLeft(value.staffOfFangs())
    );

    public static final SlimefunItemStack FN_STAFF_SKULLS = new SlimefunItemStack(
        "FN_STAFF_SKULLS",
        Material.BLAZE_ROD,
        "&c凋灵法杖",
        "",
        "&e右键点击&7目标方向",
        "&7向该方向释放凋灵头",
        "&7并造成伤害和凋零效果",
        "",
        LoreBuilder.usesLeft(value.staffOfSkulls())
    );

    public static final SlimefunItemStack FN_QUIVER = new SlimefunItemStack(
        "FN_QUIVER",
        Material.LEATHER,
        "&b箭袋 (箭)",
        "",
        "&d右键点击 储存箭",
        "&dshift+右键点击 取出箭",
        "",
        "&e左键点击/右键点击 切换形态",
        "&e容量: 192 支",
        "&e箭数: " + ChatColor.WHITE + "0"
    );

    public static final SlimefunItemStack FN_SPECTRAL_QUIVER = new SlimefunItemStack(
        "FN_SPECTRAL_QUIVER",
        Material.LEATHER,
        "&a箭袋 (光灵箭)",
        "",
        "&d右键点击 储存光灵箭",
        "&dshift+右键点击 取出光灵箭",
        "",
        "&e左键点击/右键点击 切换形态",
        "&e容量: 192 支",
        "&e箭数: " + ChatColor.WHITE + "0"
    );

    public static final SlimefunItemStack FN_UPGRADED_QUIVER = new SlimefunItemStack(
        "FN_UPGRADED_QUIVER",
        Material.LEATHER,
        "&6强化箭袋 (箭)",
        "",
        "&d右键点击 储存箭",
        "&dshift+右键点击 取出箭",
        "",
        "&e左键点击/右键点击 切换形态",
        "&e容量: 288 支",
        "&e箭数: " + ChatColor.WHITE + "0"
    );

    public static final SlimefunItemStack FN_UPGRADED_SPECTRAL_QUIVER = new SlimefunItemStack(
        "FN_UPGRADED_SPECTRAL_QUIVER",
        Material.LEATHER,
        "&c强化箭袋 (光灵箭)",
        "",
        "&d右键点击 储存光灵箭",
        "&dshift+右键点击 取出光灵箭",
        "",
        "&e左键点击/右键点击 切换形态",
        "&e容量: 288 支",
        "&e箭数: " + ChatColor.WHITE + "0"
    );

}
