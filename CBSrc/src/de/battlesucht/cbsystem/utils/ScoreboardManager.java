package de.battlesucht.cbsystem.utils;

import de.battlesucht.api.utils.player.BattlePlayer;
import de.battlesucht.api.utils.server.local.CoinsAPI;
import de.battlesucht.cbsystem.BattleCitybuild;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.HashMap;

public class ScoreboardManager {

  private static HashMap<Scoreboard, Player> boards = new HashMap<>();

  @SuppressWarnings("deprecation")
public static void update() {
    Bukkit.getScheduler().scheduleAsyncRepeatingTask(BattleCitybuild.getInstance(), () -> {
      for(Scoreboard board : boards.keySet()) {
        if(boards.get(board).isOnline()) {
          Player p = boards.get(board);
          BattlePlayer bp = new BattlePlayer(p);
          board.getTeam("coins").setSuffix("§7"+ CoinsAPI.getCoins(p));
          board.getTeam("bits").setSuffix("§7"+bp.getBits());
        }
      }

    }, 20, 20);
  }
  public static void setScoreboard(Player p) {
    BattlePlayer bp = new BattlePlayer(p);
    Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
    Objective obj = board.registerNewObjective("aaa", "bbb");
    obj.setDisplaySlot(DisplaySlot.SIDEBAR);
    obj.setDisplayName("§b§lBattle§5§lSucht");
    obj.getScore("§a").setScore(10);
    obj.getScore("§5Profil").setScore(9);
    obj.getScore("§8● §7" + p.getName()).setScore(8);
    obj.getScore( "§9 ").setScore(7);
    obj.getScore( "§5Coins").setScore(6);
    obj.getScore( "§c").setScore(4);
    obj.getScore( "§5Bits").setScore(3);
    obj.getScore( "§d").setScore(1);

    Team coins = board.registerNewTeam("coins");
    coins.setPrefix("§8● §7");
    coins.setSuffix("§7"+CoinsAPI.getCoins(p));
    coins.addEntry(ChatColor.AQUA.toString());
    obj.getScore(ChatColor.AQUA.toString()).setScore(5);

    Team bits = board.registerNewTeam("bits");
    bits.setPrefix("§8● §7");
    bits.setSuffix("§7"+bp.getBits());
    bits.addEntry(ChatColor.YELLOW.toString());
    obj.getScore(ChatColor.YELLOW.toString()).setScore(2);

    boards.put(board, p);
    p.setScoreboard(board);
  }
}
