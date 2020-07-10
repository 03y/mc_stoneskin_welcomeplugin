package mc.stoneskin.WelcomePlugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WelcomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //return super.onCommand(sender, command, label, args);
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if(player.isOp()){
                Bukkit.getServer().getLogger().info("welcomeCommand:"+command.getName());
                if(command.getName().equalsIgnoreCase("Welcome")) {
                    if(args.length > 0) {
                        if(args[0].equalsIgnoreCase("reload")){
                            ConfigHelper.Instance().Reload();
                        }else{
                            sender.sendMessage("Invalid Command.");
                        }
                    }else {
                        ConfigHelper.Instance().SendWelcomeMessages(player);
                    }
                }
            }


            // Here we need to give items to our player
        }

        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}