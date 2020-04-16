package alex.plugins.homes.Commands;
import alex.plugins.homes.Home;
import alex.plugins.homes.HomeContainer;
import alex.plugins.homes.  Homes;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Properties;

public class AddHome implements CommandExecutor {

    public AddHome(Homes homes) {

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("addhome")) {
            if (args.length == 0)
                args = new String[]{"default"};
            if(args.length != 1)
                return false;
            Properties players = PlayerList.getPlayers();
            if (!players.containsKey(sender.getName())) {
                players.put(sender.getName(), new HomeContainer());
            }
            HomeContainer homes = new HomeContainer(players.getProperty(sender.getName()));
            if (!homes.contains(args[0])) {
                sender.sendMessage("§6Home §5§l" + args[0] + "§r§6 added successfully");
                Player player = sender.getServer().getPlayer(sender.getName());
                assert player != null;
                Location location = player.getLocation();
                int x = location.getBlockX();
                int y = location.getBlockY();
                int z = location.getBlockZ();
                homes.addHome(new Home(location.getWorld().getName(), args[0], x, y, z));
                players.setProperty(sender.getName(), homes.toString());
                PlayerList.savePlayers(players);
                sender.sendMessage("§6Position §4§lX:§r" + x + ", §4§lY:§r" + y + ", §4§lX:§r" + z);
            } else {
                sender.sendMessage("§4Failed to add home §5§l" + args[0] + ". §c(Home §l" + args[0] + "§r§c is already existed)");
            }
            return true;
        }
        return false;
    }
}
