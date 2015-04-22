package com.infinity.help.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.infinity.help.commands.HollerCmd;

public class HelpHoller extends JavaPlugin{
	
	public static HelpHoller instance;
	
	public static HelpHoller getInstance(){
		return instance;
	}
	
	public void registerCommands(){
		getCommand("holler").setExecutor(new HollerCmd());
	}
	
	public void registerClasses(){
    PluginManager pm = Bukkit.getPluginManager();
		
		//Commands
		pm.registerEvents(new HollerCmd(), this);
	}
	
	public void consoleBroadcast(String s){
		Bukkit.getServer().getLogger().info(s);
	}
	
	@Override
	public void onEnable(){
		consoleBroadcast("[HelpHoller] HelpHoller has been enabled.");
		instance = this;
		registerClasses();
		registerCommands();
	}
	
	@Override
	public void onDisable(){
		consoleBroadcast("[HelpHoller] HelpHoller has been disabled.");
		instance = null;
	}

}

