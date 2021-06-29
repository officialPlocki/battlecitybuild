package de.battlesucht.cbsystem.commands;

import java.util.ArrayList;
import java.util.List;

import de.battlesucht.api.utils.player.Language;

import de.battlesucht.api.utils.server.local.CoinsAPI;
import de.battlesucht.cbsystem.utils.JobManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JobCommand extends Language implements CommandExecutor, Listener {
	
	private static List<String> enchanterLore = new ArrayList<String>();
	private static List<String> builderLore = new ArrayList<String>();
	private static List<String> minerLore = new ArrayList<String>();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		JobManager.getJob(e.getPlayer());
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if (sender instanceof Player) {
			Player p = (Player) sender;
			if(JobManager.getJob(p).equalsIgnoreCase("none")) {
				Inventory inv = Bukkit.createInventory(null, 3*9, "§6Jobs");
				
				enchanterLore.add("§k");
				enchanterLore.add("§8» §eEnchante Items um Geld zu erhalten. §8«");
				enchanterLore.add("§k");
				
				builderLore.add("§k");
				builderLore.add("§8» §eBaue mit Blöcken, um Geld zu erhalten. §8«");
				builderLore.add("§8» §eDazu zählt auch das Fällen von Bäumen. §8«");
				builderLore.add("§k");
				
				minerLore.add("§k");
				minerLore.add("§8» §eBaue Erze und Steine ab, um Geld zu erhalten. §8«");
				minerLore.add("§k");
				
				ItemStack enchanter = new ItemStack(Material.ENCHANTING_TABLE);
				ItemMeta enchanterMeta = enchanter.getItemMeta();
				enchanterMeta.setDisplayName("§bZauberer");
				enchanterMeta.setLore(enchanterLore);
				enchanter.setItemMeta(enchanterMeta);
				
				ItemStack miner = new ItemStack(Material.DIAMOND_PICKAXE);
				ItemMeta minerMeta = miner.getItemMeta();
				minerMeta.setDisplayName("§aMinenarbeiter");
				minerMeta.setLore(minerLore);
				miner.setItemMeta(minerMeta);
				
				ItemStack builder = new ItemStack(Material.GRASS);
				ItemMeta builderMeta = builder.getItemMeta();
				builderMeta.setDisplayName("§6Bauarbeiter");
				builderMeta.setLore(builderLore);
				builder.setItemMeta(builderMeta);
				
				ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
				ItemMeta glassMeta = glass.getItemMeta();
				glassMeta.setDisplayName("§k");
				glass.setItemMeta(glassMeta);
				
				minerLore.clear();
				enchanterLore.clear();
				builderLore.clear();

		        inv.setItem(0, glass);
		    	inv.setItem(1, glass);
		    	inv.setItem(2, glass);
		    	inv.setItem(3, glass);
		    	inv.setItem(4, glass);
		    	inv.setItem(5, glass);
		    	inv.setItem(6, glass);
		    	inv.setItem(7, glass);
		    	inv.setItem(8, glass);
		       inv.setItem(9, glass);
		       inv.setItem(10, glass);
		       inv.setItem(11, glass);
		       inv.setItem(12, glass);
		       inv.setItem(13, glass);
		       inv.setItem(14, glass);
		       inv.setItem(15, glass);
		       inv.setItem(16, glass);
		       inv.setItem(17, glass);
		       inv.setItem(18, glass);
		       inv.setItem(19, glass);
		       inv.setItem(20, glass);
		       inv.setItem(21, glass);
		       inv.setItem(22, glass);
		       inv.setItem(23, glass);
		       inv.setItem(24, glass);
		       inv.setItem(25, glass);
		       inv.setItem(26, glass);
		       inv.setItem(11, enchanter);
		       inv.setItem(13, builder);
		       inv.setItem(15, miner);
		       
		       p.openInventory(inv);
		        
			} else {
				Inventory inv = Bukkit.createInventory(null, 3*9, "§6Jobs");
				ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
				ItemMeta glassMeta = glass.getItemMeta();
				glassMeta.setDisplayName("§k");
				glass.setItemMeta(glassMeta);
		        inv.setItem(0, glass);
		    	inv.setItem(1, glass);
		    	inv.setItem(2, glass);
		    	inv.setItem(3, glass);
		    	inv.setItem(4, glass);
		    	inv.setItem(5, glass);
		    	inv.setItem(6, glass);
		    	inv.setItem(7, glass);
		    	inv.setItem(8, glass);
		            inv.setItem(9, glass);
		            inv.setItem(10, glass);
		            inv.setItem(11, glass);
		            inv.setItem(12, glass);
		            inv.setItem(13, glass);
		            inv.setItem(14, glass);
		            inv.setItem(15, glass);
		            inv.setItem(16, glass);
		            inv.setItem(17, glass);
		                inv.setItem(18, glass);
		                inv.setItem(19, glass);
		                inv.setItem(20, glass);
		                inv.setItem(21, glass);
		                inv.setItem(22, glass);
		                inv.setItem(23, glass);
		                inv.setItem(24, glass);
		                inv.setItem(25, glass);
		                inv.setItem(26, glass);
		                ItemStack leave = new ItemStack(Material.BARRIER);
		                ItemMeta leaveMeta = leave.getItemMeta();
		                leaveMeta.setDisplayName("§cJob verlassen");
		                leave.setItemMeta(leaveMeta);
		                inv.setItem(13, leave);
		                p.openInventory(inv);
			}
			
		}
		return true;
	}

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getView().getTitle().equalsIgnoreCase("§6Jobs")) {
			e.setCancelled(true);
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§aMinenarbeiter")) {
				p.closeInventory();
				JobManager.setJob(p, "miner");
				p.sendMessage(prefix+"Du bist nun §aMinenarbeiter§7.");
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§6Bauarbeiter")) {
				//p.closeInventory();
				//JobManager.setJob(p, "bauarbeiter");
				//p.sendMessage(Main.prefix+"Du bist nun §6Bauarbeiter§7.");
				p.sendMessage(prefix+"Dieser Job ist temporär deaktiviert.");
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§bZauberer")) {
				p.closeInventory();
				JobManager.setJob(p, "zauberer");
				p.sendMessage(prefix+"Du bist nun §bZauberer§7.");
			} else if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cJob verlassen")) {
				p.closeInventory();
				JobManager.setJob(p, "none");
				p.sendMessage(prefix+"Du hast deinen aktuellen Job verlassen.");
			}
		}
	}
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		Player p = (Player) e.getPlayer();
		
		if(JobManager.getJob(p).equalsIgnoreCase("miner")) {
			if(e.getBlock().getType().equals(Material.STONE)||e.getBlock().getType().equals(Material.DIAMOND_ORE) || e.getBlock().getType().equals(Material.GOLD_ORE) || e.getBlock().getType().equals(Material.EMERALD_ORE) || e.getBlock().getType().equals(Material.COAL_ORE) || e.getBlock().getType().equals(Material.LAPIS_ORE) || e.getBlock().getType().equals(Material.NETHER_QUARTZ_ORE) || e.getBlock().getType().equals(Material.NETHER_GOLD_ORE) || e.getBlock().getType().equals(Material.REDSTONE_ORE) || e.getBlock().getType().equals(Material.IRON_ORE)||e.getBlock().getType().equals(Material.COBBLESTONE)) {
				Material type = e.getBlock().getType();
				if(type == Material.COBBLESTONE) {
					CoinsAPI.addCoins(e.getPlayer(), 0.50);
					sendActionbar(p, "Du hast 0,50 Coins erhalten. Du hast nun "+ CoinsAPI.getCoins(p));
				} else if(type == Material.COAL_ORE) {
					CoinsAPI.addCoins(e.getPlayer(), 1);
					sendActionbar(p, "Du hast einen Coin erhalten. Du hast nun "+CoinsAPI.getCoins(p));
				} else if(type == Material.DIAMOND_ORE) {
					CoinsAPI.addCoins(e.getPlayer(), 4);
					sendActionbar(p, "Du hast 4 Coins erhalten. Du hast nun "+CoinsAPI.getCoins(p));
				} else if(type == Material.EMERALD_ORE) {
					CoinsAPI.addCoins(e.getPlayer(), 5);
					sendActionbar(p, "Du hast 5 Coins erhalten. Du hast nun "+CoinsAPI.getCoins(p));
				} else if(type == Material.GOLD_ORE) {
					CoinsAPI.addCoins(e.getPlayer(), 4);
					sendActionbar(p, "Du hast 4 Coins erhalten. Du hast nun "+CoinsAPI.getCoins(p));
				} else if(type == Material.IRON_ORE) {
					CoinsAPI.addCoins(e.getPlayer(), 3);
					sendActionbar(p, "Du hast 3 Coins erhalten. Du hast nun "+CoinsAPI.getCoins(p));
				} else if(type == Material.STONE) {
					CoinsAPI.addCoins(e.getPlayer(), 1);
					sendActionbar(p, "Du hast einen Coin erhalten. Du hast nun "+CoinsAPI.getCoins(p));
				} else if(type == Material.LAPIS_ORE) {
					CoinsAPI.addCoins(e.getPlayer(), 4);
					sendActionbar(p, "Du hast 4 Coins erhalten. Du hast nun "+CoinsAPI.getCoins(p));
				} else if(type == Material.REDSTONE_ORE) {
					CoinsAPI.addCoins(e.getPlayer(), 3);
					sendActionbar(p, "Du hast 3 Coins erhalten. Du hast nun "+CoinsAPI.getCoins(p));
				} else if(type == Material.NETHER_QUARTZ_ORE||type==Material.NETHER_GOLD_ORE) {
					CoinsAPI.addCoins(e.getPlayer(), 2);
					sendActionbar(p, "Du hast 2 Coins erhalten. Du hast nun "+CoinsAPI.getCoins(p));
				} else if(type == Material.NETHERRACK) {
					CoinsAPI.addCoins(e.getPlayer(), 1);
					sendActionbar(p, "Du hast einen Coin erhalten. Du hast nun "+CoinsAPI.getCoins(p));
				}
			}
		} else if(JobManager.getJob(p).equalsIgnoreCase("bauarbeiter")) {
			if(e.getBlock().getType().equals(Material.OAK_LOG) || e.getBlock().getType().equals(Material.BIRCH_LOG) || e.getBlock().getType().equals(Material.DARK_OAK_LOG) || e.getBlock().getType().equals(Material.JUNGLE_LOG) || e.getBlock().getType().equals(Material.SPRUCE_LOG)) {
				CoinsAPI.addCoins(p, 1.50);
				sendActionbar(p, "Du hast 1,50 Coins erhalten. Du hast nun "+CoinsAPI.getCoins(p));
			} else {
				CoinsAPI.addCoins(p, 1);
				sendActionbar(p, "Du hast einen Coin erhalten. Du hast nun "+CoinsAPI.getCoins(p));
			}
		}
	}
	
	private static void sendActionbar(Player p, String msg) {
		p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§6Jobs ● §e"+msg));
	}
	
	@EventHandler
	public void onEnchant(EnchantItemEvent e) {
		Player p = (Player) e.getEnchanter();
		if(JobManager.getJob(p).equalsIgnoreCase("zauberer")) {
			CoinsAPI.addCoins(p, 5);
			sendActionbar(p, "Du hast 5 Coins erhalten. Du hast nun "+CoinsAPI.getCoins(p));
		}
	}
	@EventHandler
	public void onPlace(BlockPlaceEvent e) {
		Player p = (Player) e.getPlayer();
		if(JobManager.getJob(p).equalsIgnoreCase("bauarbeiter")) {
			CoinsAPI.addCoins(p, 0.25);
			sendActionbar(p, "Du hast 0,25 Coins erhalten. Du hast nun "+CoinsAPI.getCoins(p));
		}
	}

}
