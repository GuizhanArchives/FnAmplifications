package ne.fnfal113.fnamplifications.MysteriousItems.Listeners;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;

import ne.fnfal113.fnamplifications.MysteriousItems.*;
import net.guizhanss.minecraft.fnamplifications.Util;
import org.bukkit.ChatColor;

import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import org.bukkit.event.player.PlayerInteractEvent;

import org.bukkit.event.player.PlayerLevelChangeEvent;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.concurrent.ThreadLocalRandom;

public class MysteryStickListener implements Listener {

    private int level;

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        MysteryStickListener click = new MysteryStickListener();
        Player p = e.getPlayer();
        if(p.getInventory().getItemInMainHand().getType() == Material.AIR){
            return;
        }
        SlimefunItem stick = SlimefunItem.getByItem(p.getInventory().getItemInMainHand());

        if (stick == null){
            return;
        }

        if(stick instanceof MysteryStick && (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)){
            click.setLevelReq(5);
            if(p.getLevel() >= click.getLevelReq() && checkStick(stick)) {
                ((MysteryStick) stick).interact(e);
            } else {
                blindPlayer(p, click.getLevelReq());
            }
        }

        if(stick instanceof MysteryStick2 && (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)){
            click.setLevelReq(5);
            if(p.getLevel() >= click.getLevelReq() && checkStick(stick)) {
                ((MysteryStick2) stick).interact(e);
            } else {
                blindPlayer(p, click.getLevelReq());
            }
        }

        if(stick instanceof MysteryStick3 && (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)){
            click.setLevelReq(5);
            if(p.getLevel() >= click.getLevelReq() && checkStick(stick)) {
                ((MysteryStick3) stick).interact(e);
            } else {
                blindPlayer(p, click.getLevelReq());
            }
        }

        if(stick instanceof MysteryStick4 && (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)){
            click.setLevelReq(15);
            if(p.getLevel() >= click.getLevelReq() && checkStick(stick)) {
                ((MysteryStick4) stick).interact(e);
            } else {
                blindPlayer(p, click.getLevelReq());
            }
        }

        if(stick instanceof MysteryStick5 && (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)){
            click.setLevelReq(15);
            if(p.getLevel() >= click.getLevelReq() && checkStick(stick)) {
                ((MysteryStick5) stick).interact(e);
            } else {
                blindPlayer(p, click.getLevelReq());
            }
        }

        if(stick instanceof MysteryStick6 && (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)){
            click.setLevelReq(15);
            if(p.getLevel() >= click.getLevelReq() && checkStick(stick)) {
                ((MysteryStick6) stick).interact(e);
            } else {
                blindPlayer(p, click.getLevelReq());
            }
        }

        if(stick instanceof MysteryStick7 && (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)){
            click.setLevelReq(20);
            if(p.getLevel() >= click.getLevelReq() && checkStick(stick)) {
                ((MysteryStick7) stick).interact(e);
            } else {
                blindPlayer(p, click.getLevelReq());
            }
        }

        if(stick instanceof MysteryStick8 && (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)){
            click.setLevelReq(20);
            if(p.getLevel() >= click.getLevelReq() && checkStick(stick)) {
                ((MysteryStick8) stick).interact(e);
            } else {
                blindPlayer(p, click.getLevelReq());
            }
        }

        if(stick instanceof MysteryStick9 && (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)){
            click.setLevelReq(20);
            if(p.getLevel() >= click.getLevelReq()  && checkStick(stick)) {
                ((MysteryStick9) stick).interact(e);
            } else {
                blindPlayer(p, click.getLevelReq());
            }
        }

        if(stick instanceof MysteryStick10 && (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)){
            click.setLevelReq(25);
            if(p.getLevel() >= click.getLevelReq()  && checkStick(stick)) {
                ((MysteryStick10) stick).interact(e);
            } else {
                blindPlayer(p, click.getLevelReq());
            }
        }

        if(stick instanceof MysteryStick11 && (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)){
            click.setLevelReq(25);
            if(p.getLevel() >= click.getLevelReq()  && checkStick(stick)) {
                ((MysteryStick11) stick).interact(e);
            } else {
                blindPlayer(p, click.getLevelReq());
            }
        }

    }

    public boolean checkStick(SlimefunItem stick){
        return !(stick.getItem().getType() == Material.DIAMOND_SWORD)
                && !(stick.getItem().getType() == Material.DIAMOND_AXE) && !(stick.getItem().getType() == Material.BOW);
    }

    public void blindPlayer(Player p, int levelReq){
        p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 300, 2, false, false));
        Util.send(p, "&4&l 你现在太弱了，还无法使用神秘棍。你需要至少" + levelReq + "级才能使用");
        p.sendTitle(ChatColor.DARK_RED + "你的视野变暗了!", ChatColor.RED + "你无法掌控神秘棍的力量", 15, 40, 45);
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onClick(EntityDamageByEntityEvent e) {
        MysteryStickListener level = new MysteryStickListener();
        if (e.getDamager() instanceof Arrow) {
            Arrow arrow = (Arrow) e.getDamager();

            if (!(arrow.getShooter() instanceof Player)) {
                return;
            }
            Player player = ((Player) arrow.getShooter());
            if(player.getInventory().getItemInMainHand().getType() == Material.AIR){
                return;
            }
            SlimefunItem stickBow = SlimefunItem.getByItem(player.getInventory().getItemInMainHand());
            if(stickBow instanceof MysteryStick3) {
                level.setLevelReq(5);
                if (player.getLevel() >= level.getLevelReq()) {
                    if (ThreadLocalRandom.current().nextInt(100) < 15) {
                        player.setLevel(player.getLevel() - 1);
                    }
                    ((MysteryStick3) stickBow).onSwing(e);
                } else {
                    ((MysteryStick3) stickBow).onSwing(e);
                }
            } else if (stickBow instanceof MysteryStick6) {
                level.setLevelReq(15);
                if (player.getLevel() >= level.getLevelReq()) {
                    if (ThreadLocalRandom.current().nextInt(100) < 25) {
                        player.setLevel(player.getLevel() - 2);
                    }
                    ((MysteryStick6) stickBow).onSwing(e);
                } else {
                    ((MysteryStick6) stickBow).onSwing(e);
                }
            } else if (stickBow instanceof MysteryStick9) {
                level.setLevelReq(20);
                if (player.getLevel() >= level.getLevelReq()) {
                    if (ThreadLocalRandom.current().nextInt(100) < 35) {
                        player.setLevel(player.getLevel() - 3);
                    }
                    ((MysteryStick9) stickBow).onSwing(e);
                } else {
                    ((MysteryStick9) stickBow).onSwing(e);
                }
            } else {
                return;
            }
        }

        if(!(e.getDamager() instanceof Player)) {
            return;
        }

        Player p = (Player) e.getDamager();
        if(p.getInventory().getItemInMainHand().getType() == Material.AIR){
            return;
        }
        SlimefunItem stick = SlimefunItem.getByItem(p.getInventory().getItemInMainHand());

        if (stick == null) {
            return;
        }

        if (stick instanceof MysteryStick) {
            ((MysteryStick) stick).onSwing(e);
        } else if (stick instanceof MysteryStick2) {
            ((MysteryStick2) stick).onSwing(e);
        } else if (stick instanceof MysteryStick4) {
            ((MysteryStick4) stick).onSwing(e);
        } else if (stick instanceof MysteryStick5) {
            ((MysteryStick5) stick).onSwing(e);
        } else if (stick instanceof MysteryStick7) {
            ((MysteryStick7) stick).onSwing(e);
        } else if (stick instanceof MysteryStick8) {
            ((MysteryStick8) stick).onSwing(e);
        } else if (stick instanceof MysteryStick10) {
            ((MysteryStick10) stick).onSwing(e);
        } else if (stick instanceof MysteryStick11) {
            ((MysteryStick11) stick).onSwing(e);
        }

    }

    @EventHandler
    public void onExpConsume(PlayerLevelChangeEvent event) {
        Player p = event.getPlayer();
        if(p.getInventory().getItemInMainHand().getType() == Material.AIR){
            return;
        }
        SlimefunItem stick = SlimefunItem.getByItem(p.getInventory().getItemInMainHand());

        if (stick == null){
            return;
        }

        if (stick instanceof MysteryStick) {
            ((MysteryStick) stick).LevelChange(event);
        } else if (stick instanceof MysteryStick2) {
            ((MysteryStick2) stick).LevelChange(event);
        } else if (stick instanceof MysteryStick3) {
            ((MysteryStick3) stick).LevelChange(event);
        } else if (stick instanceof MysteryStick4) {
            ((MysteryStick4) stick).LevelChange(event);
        } else if (stick instanceof MysteryStick5) {
            ((MysteryStick5) stick).LevelChange(event);
        } else if (stick instanceof MysteryStick6) {
            ((MysteryStick6) stick).LevelChange(event);
        } else if (stick instanceof MysteryStick7) {
            ((MysteryStick7) stick).LevelChange(event);
        } else if (stick instanceof MysteryStick8) {
            ((MysteryStick8) stick).LevelChange(event);
        } else if (stick instanceof MysteryStick9) {
            ((MysteryStick9) stick).LevelChange(event);
        } else if (stick instanceof MysteryStick10) {
            ((MysteryStick10) stick).LevelChange(event);
        } else if (stick instanceof MysteryStick11) {
            ((MysteryStick11) stick).LevelChange(event);
        }

    }

    public void setLevelReq(int level) {
        this.level = level;
    }

    public int getLevelReq() {
        return this.level;
    }

}
