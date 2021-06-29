package de.battlesucht.cbsystem.utils;

import java.util.ArrayList;
import org.bukkit.entity.Player;

public class TpaManager {
  public static ArrayList<Tpa> tpas = new ArrayList<>();
  
  public static ArrayList<Tpahere> tpaheres = new ArrayList<>();
  
  public static Tpa getTpa(Player player) {
    for (Tpa tpa : tpas) {
      if (tpa.getPlayer() == player)
        return tpa; 
    } 
    return null;
  }
  
  public static Tpahere getTpahere(Player player) {
    for (Tpahere tpahere : tpaheres) {
      if (tpahere.getPlayer() == player)
        return tpahere; 
    } 
    return null;
  }
  
  public static Tpa getTpa2(Player player) {
    for (Tpa tpa : tpas) {
      if (tpa.getTarget() == player)
        return tpa; 
    } 
    return null;
  }
  
  public static Tpahere getTpahere2(Player player) {
    for (Tpahere tpahere : tpaheres) {
      if (tpahere.getTarget() == player)
        return tpahere; 
    } 
    return null;
  }
  
  public static ArrayList<Tpa> getAllTpas(Player player) {
    ArrayList<Tpa> list = new ArrayList<>();
    for (Tpa tpa : tpas) {
      if (tpa.getPlayer() == player || tpa.getTarget() == player)
        list.add(tpa); 
    } 
    return list;
  }
  
  public static ArrayList<Tpahere> getAllTpaheres(Player player) {
    ArrayList<Tpahere> list = new ArrayList<>();
    for (Tpahere tpahere : tpaheres) {
      if (tpahere.getPlayer() == player || tpahere.getTarget() == player)
        list.add(tpahere); 
    } 
    return list;
  }
  
  public static void clearAll(Player player) {
    for (Tpa tpa : getAllTpas(player))
      tpas.remove(tpa); 
    for (Tpahere tpahere : getAllTpaheres(player))
      tpaheres.remove(tpahere); 
  }
}
