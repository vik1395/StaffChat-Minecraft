package me.vik1395.staffchat;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class StaffChat extends JavaPlugin implements Listener 
{
	
	private HashMap<String, Boolean> mctoggle = new HashMap<String, Boolean>();
	private HashMap<String, Boolean> actoggle = new HashMap<String, Boolean>();

	public void onEnable()
	{
		getServer().getPluginManager().registerEvents(this, this);
		getLogger().info("StaffChat has successfully started!");
		getLogger().info("Created by Vik1395");
		/*try {
			new AutoUpdate(this);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		saveDefaultConfig();
		/*try {
		    MetricsLite metrics = new MetricsLite(this);
		    metrics.start();
		} catch (IOException e) {
		    System.out.println("Unable to bind to MCStats");
		}*/
	}

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args)
	{
		if(cmd.getName().equalsIgnoreCase("modchat"))
		{
			if(s instanceof Player){
				Player m = (Player)s;
				if(m.hasPermission("staffchat.mod"))
				{
					if(args.length == 0)
					{
						m.sendMessage("Please type /mc [message], /md [message] or #[message] to chat privately with mods.");
					} 
					else 
					{
						String path = getConfig().getString("Format");
						String msg = "";
						for(int i = 0; i < args.length; i++)
						{
							msg = msg + args[i] + ' ';
						}
						path = path.replace("{TYPE}", "Mod");
						path = path.replace("{NAME}", m.getName());
						path = ChatColor.translateAlternateColorCodes('&', path);
						path = path.replace("{MESSAGE}", format(msg));
						sendmods(path);
					}
				}
			}
		}
		else if(cmd.getName().equalsIgnoreCase("adminchat"))
		{
			if(s instanceof Player)
			{
				Player a = (Player)s;
				if(a.hasPermission("staffchat.admin"))
				{
					if(args.length == 0)
					{
						a.sendMessage("Please type /ac [message], /ad [message] or @[message] to chat privately with admins.");
					} 
					else 
					{
						String path = getConfig().getString("Format");
						String msg = "";
						for(int i = 0; i < args.length; i++)
						{
							msg = msg + args[i] + ' ';
						}
						path = path.replace("{TYPE}", "Admin");
						path = path.replace("{NAME}", a.getName());
						path = ChatColor.translateAlternateColorCodes('&', path);
						path = path.replace("{MESSAGE}", format(msg));
						sendadmins(path);
					}
				}
			}
		}
		
		else if(cmd.getName().equalsIgnoreCase("mctoggle"))
		{
			if(s instanceof Player)
			{
				Player a = (Player)s;
				if(a.hasPermission("staffchat.mod"))
				{
					if(mctoggle.containsKey(a.getName()))
					{
						mctoggle.remove(a.getName());
						a.sendMessage(ChatColor.GOLD + "Your normal messages will now go to public chat");
					} 
					else if(actoggle.containsKey(a.getName()))
					{
						a.sendMessage(ChatColor.DARK_RED + "You cannot toggle Admin and Mod Chat streams on at the same time. Please toggle Admin Chat off.");
					}
					else 
					{
						mctoggle.put(a.getName(), false);
						a.sendMessage(ChatColor.GOLD + "You have switched on Mod Chat. All your messages will now go to the Mod Chat Stream.");
					}
				}
			}
		}
		else if(cmd.getName().equalsIgnoreCase("actoggle"))
		{
			if(s instanceof Player)
			{
				Player a = (Player)s;
				if(a.hasPermission("staffchat.admin"))
				{
					if(actoggle.containsKey(a.getName()))
					{
						actoggle.remove(a.getName());
						a.sendMessage(ChatColor.GOLD + "Your normal messages will now go to public chat");
					} 
					else if(mctoggle.containsKey(a.getName()))
					{
						a.sendMessage(ChatColor.DARK_RED + "You cannot toggle Admin and Mod Chat streams on at the same time. Please toggle Mod Chat off.");
					}
					else 
					{
						actoggle.put(a.getName(), false);
						a.sendMessage(ChatColor.GOLD + "You have switched on Admin Chat. All your messages will now go to the Admin Chat Stream.");
					}
				}
			}
		}
		
		return true;
	}

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e)
	{
		String mAlias = getConfig().getString("Mod Chat Message Alias");
		String aAlias = getConfig().getString("Admin Chat Message Alias");
		Player m = e.getPlayer();
		String s = e.getMessage();
		String path = getConfig().getString("Format");
		if(m.hasPermission("staffchat.mod"))
		{
			if(mctoggle.containsKey(m.getName()))
			{
				if(s.startsWith("/"))
				{
					
				}
				else
				{
					path = path.replace("{TYPE}", "Mod");
					path = path.replace("{NAME}", m.getName());
					path = ChatColor.translateAlternateColorCodes('&', path);
					path = path.replace("{MESSAGE}", format(s));
					sendmods(path);
					e.setCancelled(true);
				}
			}
		}
		if(m.hasPermission("staffchat.admin"))
		{
			if(actoggle.containsKey(m.getName()))
			{
				if(s.startsWith("/"))
				{
					
				}
				else
				{
					path = path.replace("{TYPE}", "Admin");
					path = path.replace("{NAME}", m.getName());
					path = ChatColor.translateAlternateColorCodes('&', path);
					path = path.replace("{MESSAGE}", format(s));
					sendadmins(path);
					e.setCancelled(true);
				}
			}
		}
		
		
		if(s.startsWith(aAlias))
		{
            if(m.hasPermission("staffchat.admin"))
            {
            	path = path.replace("{TYPE}", "Admin");
            	path = path.replace("{NAME}", m.getName());
				path = ChatColor.translateAlternateColorCodes('&', path);
				String msg = s.substring(1,s.length());
				path = path.replace("{MESSAGE}", format(msg));
				sendadmins(path);
				e.setCancelled(true);
            }
		}
		if(s.startsWith(mAlias))
		{
            if(m.hasPermission("staffchat.mod"))
            {
            	path = path.replace("{TYPE}", "Mod");
            	path = path.replace("{NAME}", m.getName());
				path = ChatColor.translateAlternateColorCodes('&', path);
				String msg = s.substring(1,s.length());
				path = path.replace("{MESSAGE}", format(msg));
				sendmods(path);
				e.setCancelled(true);
            }
		}
	}

	private void sendmods(String msg)
	{
		for(Player ms : getServer().getOnlinePlayers())
		{
			if(ms.hasPermission("staffchat.mod"))
			{
				ms.sendMessage(msg);
			}
		}
	}
	
	private void sendadmins(String msg)
	{
		for(Player as : getServer().getOnlinePlayers())
		{
			if(as.hasPermission("staffchat.admin"))
			{
				as.sendMessage(msg);
			}
		}
	}

	private String format(String input)
	{
		String Color = getConfig().getString("Chat Color");
		
		if(Color.equalsIgnoreCase("Allow"))
		{
			return ChatColor.translateAlternateColorCodes('&', input);
		}
		else
		{
			return(ChatColor.stripColor(input));
		}
	}

}
