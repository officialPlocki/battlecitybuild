package de.battlesucht.cbsystem.utils;

import de.battlesucht.api.utils.player.Language;
import de.battlesucht.cbsystem.BattleCitybuild;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class Tpahere extends Language {
  private Player player;
  
  private Player target;
  
  public Tpahere(Player player, Player target) {
    if (TpaManager.getTpahere(player) != null) {
      player.sendMessage(prefix + "Du hast diesem Spieler bereits eine Anfrage gesendet!");
      return;
    } 
    this.player = player;
    this.target = target;
    TpaManager.clearAll(target);
    TpaManager.tpaheres.add(this);
    player.sendMessage(prefix + "Anfrage wurde gesendet!");
    TextComponent accept = new TextComponent("§a/tpaccept");
    accept.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpaccept"));
    TextComponent deny = new TextComponent("§c/tpdeny");
    deny.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/tpdeny"));
    TextComponent msg = new TextComponent(prefix);
    msg.addExtra((BaseComponent)accept);
    msg.addExtra((BaseComponent)new TextComponent(" "));
    msg.addExtra((BaseComponent)deny);
    target.sendMessage(" ");
    target.sendMessage(prefix + "§e" + player.getName() + " §7möchte das du dich zu ihm teleportierst.");
    target.spigot().sendMessage((BaseComponent)msg);
    target.sendMessage(" ");
  }
  
  public void accept() {
    TpaManager.clearAll(this.player);
    TpaManager.clearAll(this.target);
    this.target.sendMessage(prefix + "Du wirst in §a3 §7Sekunden teleportiert!");
    this.player.sendMessage(prefix + "§e" + this.target.getName() + " §7hat die Anfrage §aangenommen§7!");
    Bukkit.getScheduler().runTaskLater(BattleCitybuild.getInstance(), new Runnable() {
          public void run() {
            Tpahere.this.target.sendMessage(prefix + "Du wirst in §a2 §7Sekunden teleportiert!");
          }
        },  20L);
    Bukkit.getScheduler().runTaskLater(BattleCitybuild.getInstance(), new Runnable() {
          public void run() {
            Tpahere.this.target.sendMessage(prefix + "Du wirst in §aeiner §7Sekunden teleportiert!");
          }
        },  40L);
    Bukkit.getScheduler().runTaskLater(BattleCitybuild.getInstance(), new Runnable() {
          public void run() {
            Tpahere.this.target.teleport((Entity)Tpahere.this.player);
            Tpahere.this.target.playSound(Tpahere.this.player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 5.0F, 5.0F);
          }
        }, 60L);
  }
  
  public void deny() {
    TpaManager.clearAll(this.player);
    TpaManager.clearAll(this.target);
    this.target.sendMessage(prefix + "Du hast die Anfrage §cabgelehnt!");
    this.player.sendMessage(prefix + "§e" + this.target.getName() + " §7hat die Anfrage §cabgelehnt§7!");
  }
  
  public Player getPlayer() {
    return this.player;
  }
  
  public Player getTarget() {
    return this.target;
  }
}
