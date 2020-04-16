package alex.plugins.homes.Commands;

import alex.plugins.homes.HomeContainer;
import alex.plugins.homes.Homes;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;

public class Home implements CommandExecutor {
    public Home(Homes homes) {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("home")){
            if(args.length == 0)
                args = new String[]{"default"};
            if(args.length != 1)
                return false;
            Properties players = PlayerList.getPlayers();
            if (!players.containsKey(sender.getName()))
                players.put(sender.getName(), new HomeContainer());
            HomeContainer homes = new HomeContainer(players.getProperty(sender.getName()));
            ArrayList<String> list = new ArrayList(Arrays.asList(homes.toArray()));
            if(! list.contains(args[0])){
                if(args[0].equals("default"))
                    sender.sendMessage("§4Please add a home first!");
                else
                    sender.sendMessage("§4No Home Named §l"+args[0]);
                return true;
            }else{
                alex.plugins.homes.Home home = homes.homes.get(list.indexOf(args[0]));
                Player player = sender.getServer().getPlayer(sender.getName());
                assert player != null;
                Location location = player.getLocation();
                location.setWorld(sender.getServer().getWorld(home.world));
                location.setX(home.x);
                location.setY(home.y);
                location.setZ(home.z);
                player.teleport(location);
                sender.sendMessage("§6Teleported you to home §5"+home.name);
            }
            return true;
        }
        return false;
    }
}
