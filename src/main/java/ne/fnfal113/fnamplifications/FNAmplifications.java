package ne.fnfal113.fnamplifications;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import ne.fnfal113.fnamplifications.Gears.Listeners.GearListener;
import ne.fnfal113.fnamplifications.Gears.Runnables.ArmorEquipRunnable;
import ne.fnfal113.fnamplifications.Items.FNAmpItemSetup;
import ne.fnfal113.fnamplifications.Gems.Listeners.GemListener;
import ne.fnfal113.fnamplifications.MysteriousItems.Listeners.MysteryStickListener;
import ne.fnfal113.fnamplifications.Quiver.Listener.QuiverListener;
import ne.fnfal113.fnamplifications.Staffs.Listener.StaffListener;
import ne.fnfal113.fnamplifications.Tools.Listener.HoeListener;
import ne.fnfal113.fnamplifications.Utils.PlayerJoinLister;
import ne.fnfal113.fnamplifications.config.ConfigManager;
import net.guizhanss.guizhanlib.updater.GuizhanBuildsUpdater;
import org.bstats.bukkit.Metrics;
import org.bstats.charts.AdvancedPie;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public final class FNAmplifications extends JavaPlugin implements SlimefunAddon {

    private static FNAmplifications instance;

    private ConfigManager configManager;

    @Override
    public void onEnable() {
        setInstance(this);

        Metrics metrics = new Metrics(this, 13219);
        addPieChartMatGen(metrics);

        getLogger().info("************************************************************");
        getLogger().info("              FN Amplifications - FN 科技                   ");
        getLogger().info("           作者: FN_FAL113  汉化: haiman233, ybw0014         ");
        getLogger().info("    感谢 Jeff(LiteXpansion) 与 Walshy(Slimefun) 提供的工具包   ");
        getLogger().info("               如有任何问题，请前往问题追踪器汇报                 ");
        getLogger().info("                作者 Discord: FN_FAL#7779                    ");
        getLogger().info("************************************************************");

        configManager = new ConfigManager(this);

        FNAmpItemSetup.INSTANCE.init();

        getServer().getPluginManager().registerEvents(new MysteryStickListener(), this);
        getServer().getPluginManager().registerEvents(new GearListener(), this);
        getServer().getPluginManager().registerEvents(new StaffListener(), this);
        getServer().getPluginManager().registerEvents(new QuiverListener(), this);
        getServer().getPluginManager().registerEvents(new HoeListener(), this);
        getServer().getPluginManager().registerEvents(new GemListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoinLister(), this);
        getServer().getScheduler().runTaskTimerAsynchronously(this, new ArmorEquipRunnable(), 0L, getConfig().getInt("armor-update-period") * 20L);

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        if (getConfig().getBoolean("auto-update") &&
            getDescription().getVersion().startsWith("Build")) {
            new GuizhanBuildsUpdater(this, getFile(), "ybw0014", "FnAmplifications-CN", "main", false).start();
        }
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/ybw0014/FNAmplifications/issues";
    }

    private static void setInstance(FNAmplifications ins) {
        instance = ins;
    }

    public static FNAmplifications getInstance() {
        return instance;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public void addPieChartMatGen(Metrics metrics){
        metrics.addCustomChart(new AdvancedPie("material_gen_tickrates", new Callable<Map<String, Integer>>() {
            @Override
            public Map<String, Integer> call() {
                Map<String, Integer> matGens = new HashMap<>();
                for(Map.Entry<String, Object> config: getConfig().getValues(true).entrySet()){
                    if(config.getKey().startsWith("FN_")){
                        matGens.put(config.getKey() + ": " + config.getValue().toString(),
                                matGens.getOrDefault(config.getKey() + ": " + config.getValue().toString(), 0) + 1);
                    }
                }

                return matGens;
            }
        }));
    }

}
