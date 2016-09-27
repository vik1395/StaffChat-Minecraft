StaffChat creates two additional chat streams to the basic public chat, One for Administrators, and another for Moderators. These streams can be viewed and used by only those who have the permissions. The benefit of this plugin is that admins and mods can chat amongst themselves without having to /msg each other or reveal what they are talking about in public.

Toggle Feature: A toggle feature has been added to this plugin where, when a player toggles one of the chat streams, all their future messages go directly to that chat stream instead of public chat. This continues until the player toggles it again.

Please report any issues with this plugin [HERE](https://github.com/vik1395/StaffChat-Minecraft/issues)

If you like my work, please consider donating, I would greatly appreciate it. [![Image](https://www.paypalobjects.com/en_US/i/btn/btn_donate_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=vik1395lp%40gmail%2ecom&lc=US&item_name=Spigot%20Plugins&item_number=LegitPlay%2enet%20Plugin%20Dev&no_note=0&currency_code=USD&bn=PP%2dDonationsBF%3abtn_donateCC_LG%2egif%3aNonHostedGuest)

**Permissions**
-------------
    staffchat.admin - Allows you to view and use the Admin chat stream.
    
    staffchat.mod - Allows you to view and use the Moderator chat stream.
    
    staffchat.admin.toggle - Allows you to toggle Admin chat stream.
    
    staffchat.mod.toggle - Allows you to toggle Moderator chat stream.

**Commands**
-------------
    Administrator Chat Aliases: /adminchat, /ac, /ad, [Custom Alias from Config]
    
    /ac [message] - For Admin chat stream
    
    
    Administrator Chat Toggle Aliases: /actoggle, /act, /adt
    
    /actoggle - Toggle Admin chat stream
    
    
    Moderator Chat Aliases: /modchat, /mc, /md, [Custom Alias from Config]
    
    /mc [message] - For Moderator chat stream
    
    
	Moderator Chat Toggle Aliases: /mctoggle, /mct, /mdt
    
    /mctoggle - Toggle Moderator chat stream

To change the prefix of the Chat streams, please see the config.yml file.

    Format: '&7[&6{TYPE} Chat&7] &c{NAME} &6: &r&e{MESSAGE}'
    
    # This is the format of the chat message that will come up in Moderator chat. '&*' represent color codes.
    
    Chat Color: Allow
    
    # Type "Allow" to allow players to use chat colors. Else type "Deny".
    
    Admin Chat Message Alias: '@'
    
    # An optional alias for /adminchat. Please Do not leave this empty.
    
    Mod Chat Message Alias: '#'
    
    # An optional alias for /modchat. Please Do not leave this empty.

{TYPE} = Shows the name of the chat stream (Admin or Mod)

{NAME} = Displays the name of the player who sent the message on the chat stream.

{MESSAGE} = the actual message being sent through the chat stream.

These are all automatically replaced by the plugin itself.

Here is an example of how the plugin works/is used:

Here is an example of how the plugin works/is used:
![enter image description here](http://i.imgur.com/0KrDRiC.jpg?1)

To type in Administrator Chat: ![Image](http://i.imgur.com/Lu3QUMj.jpg?1)

To type in Moderator Chat: ![Image](http://i.imgur.com/TSiRQ0Z.jpg?1)

This plugin is licensed under [CC Attribution-NonCommercial-ShareAlike 4.0 International](http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en_US). 

In very basic terms, Do whatever you want with the code of this plugin, as long as you give credits to the author and/or the plugin itself.

The **Bungee** version of this plugin can be found **[HERE](http://www.spigotmc.org/resources/staffchatbungee.376/)**
