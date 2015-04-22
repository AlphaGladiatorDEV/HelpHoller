package com.infinity.help.commands;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class HollerCmd implements Listener, CommandExecutor{
	
	String hs = ChatColor.BLACK + "[" + ChatColor.WHITE + "HelpHoller" + ChatColor.BLACK + "]" + ChatColor.RESET + " ";

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player p = (Player) sender;
		if(!(sender instanceof Player)){
			sender.sendMessage(hs + ChatColor.RED + "You must be a player to request help from a admin.");
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("holler")){
			if(p.hasPermission("helpholler.send")){
				if(args.length < 1){
					p.sendMessage(hs + ChatColor.RED + "Usage: /holler <message (spaces allowed!)>");
					return true;
				}
				if (args.length > 0) {
	                  String msg = "";
	                  for (String x: args){
	                      msg += x+" ";
	                  }
	                  for(Player admins : Bukkit.getOnlinePlayers()){
	                	  if(admins.hasPermission("helpholler.recieve")){
	                		  admins.sendMessage(hs + ChatColor.GREEN + "From: " + ChatColor.GOLD + ChatColor.BOLD + p.getName());
	                		  admins.sendMessage(hs + msg);
	                		  return true;
	                	  }
	                  }
				}
			}else if(!p.hasPermission("helpholler.send")){
				p.sendMessage(hs + ChatColor.RED + "You do not have permission to holler a message!");
			}
		}
		return false;
	}

}
