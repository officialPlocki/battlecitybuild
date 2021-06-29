package de.battlesucht.cbsystem.utils;

import java.util.Arrays;
import java.util.List;
import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Wool;

public class ItemBuilder {
  private ItemStack item;
  
  public ItemBuilder(Material material, int amount) {
    this.item = new ItemStack(material, amount);
  }
  
  public ItemBuilder setName(String name) {
    ItemMeta meta = this.item.getItemMeta();
    meta.setDisplayName(name);
    this.item.setItemMeta(meta);
    return this;
  }
  
  public ItemBuilder setLore(String... lore) {
    ItemMeta meta = this.item.getItemMeta();
    meta.setLore(Arrays.asList(lore));
    this.item.setItemMeta(meta);
    return this;
  }
  
  public ItemBuilder setLore(List<String> lore) {
    ItemMeta meta = this.item.getItemMeta();
    meta.setLore(lore);
    this.item.setItemMeta(meta);
    return this;
  }
  
  public ItemBuilder setUnbreakable() {
    ItemMeta meta = this.item.getItemMeta();
    meta.setUnbreakable(true);
    this.item.setItemMeta(meta);
    return this;
  }
  
  public ItemBuilder setLeatherColor(Color color) {
    if (this.item.getType() == Material.LEATHER_HELMET || this.item.getType() == Material.LEATHER_CHESTPLATE || this.item
      .getType() == Material.LEATHER_LEGGINGS || this.item.getType() == Material.LEATHER_BOOTS) {
      LeatherArmorMeta meta = (LeatherArmorMeta)this.item.getItemMeta();
      meta.setColor(color);
      this.item.setItemMeta((ItemMeta)meta);
    } 
    return this;
  }
  
  public ItemBuilder setData(MaterialData data) {
    this.item.setData(data);
    return this;
  }
  
  public ItemBuilder setSkullOwner(String owner) {
    if (this.item.getType() == Material.PLAYER_HEAD || this.item.getType() == Material.PLAYER_WALL_HEAD) {
      SkullMeta meta = (SkullMeta)this.item.getItemMeta();
      meta.setOwner(owner);
      this.item.setItemMeta((ItemMeta)meta);
    } 
    return this;
  }
  
  public ItemBuilder addEnchantment(Enchantment enchantment, int level) {
    ItemMeta meta = this.item.getItemMeta();
    meta.addEnchant(enchantment, level, true);
    this.item.setItemMeta(meta);
    return this;
  }
  
  public ItemBuilder addItemFlag(ItemFlag flag) {
    ItemMeta meta = this.item.getItemMeta();
    meta.addItemFlags(new ItemFlag[] { flag });
    this.item.setItemMeta(meta);
    return this;
  }
  
  public ItemBuilder hideAll() {
    addItemFlag(ItemFlag.HIDE_ATTRIBUTES);
    addItemFlag(ItemFlag.HIDE_DESTROYS);
    addItemFlag(ItemFlag.HIDE_ENCHANTS);
    addItemFlag(ItemFlag.HIDE_PLACED_ON);
    addItemFlag(ItemFlag.HIDE_POTION_EFFECTS);
    addItemFlag(ItemFlag.HIDE_UNBREAKABLE);
    return this;
  }
  
  public ItemStack build() {
    return this.item;
  }
}
