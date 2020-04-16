package alex.plugins.homes.Commands;

import alex.plugins.homes.Home;
import alex.plugins.homes.HomeContainer;
import alex.plugins.homes.Homes;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Properties;

public class ListHome implements CommandExecutor {
    public ListHome(Homes homes) {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("listhome")){
            if(args.length != 0)
                return false;
            Properties players = PlayerList.getPlayers();
            if (!players.containsKey(sender.getName()))
                players.put(sender.getName(), new HomeContainer());
            HomeContainer homes = new HomeContainer(players.getProperty(sender.getName()));
            sender.sendMessage("§6Your §nHomes§r§6 are below");
            String[] names = homes.toArray();
            for (int i = 0; i <names.length; i++){
                Home home = homes.homes.get(i);
                sender.sendMessage("§6 - §5"+names[i]+" §6("+homes.homes.get(i).world+": "+home.x+", "+home.y+", "+home.z+")");
            }
            return true;
        }
        return false;
    }
}
