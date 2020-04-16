package alex.plugins.homes.Commands;

import alex.plugins.homes.HomeContainer;
import alex.plugins.homes.Homes;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Properties;

public class RemoveHome implements CommandExecutor {
    public RemoveHome(Homes homes) {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("rmhome")){
            if(args.length != 1)
                return false;
            Properties players = PlayerList.getPlayers();
            if (!players.containsKey(sender.getName()))
                players.put(sender.getName(), new HomeContainer());
            HomeContainer homes = new HomeContainer(players.getProperty(sender.getName()));
            if (homes.remove(args[0]))
                sender.sendMessage("§6Home §5§l" + args[0] + "§r§6 removed successfully");
            else
                sender.sendMessage("§4Failed to add home §5§l" + args[0] + "§r§4. §r§c(No home named §l"+args[0]+"§r§c)");
            players.setProperty(sender.getName(), homes.toString());
            PlayerList.savePlayers(players);
            return true;
        }
        return false;
    }
}
