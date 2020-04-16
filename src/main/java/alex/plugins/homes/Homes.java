package alex.plugins.homes;

import alex.plugins.homes.Commands.AddHome;
import alex.plugins.homes.Commands.Home;
import alex.plugins.homes.Commands.ListHome;
import alex.plugins.homes.Commands.PlayerList;
import alex.plugins.homes.Commands.RemoveHome;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public final class Homes extends JavaPlugin {


    public void setupCommands(){
        getCommand("addhome").setExecutor((CommandExecutor) new AddHome(this));
        getCommand("rmhome").setExecutor((CommandExecutor) new RemoveHome(this));
        getCommand("listhome").setExecutor((CommandExecutor) new ListHome(this));
        getCommand("home").setExecutor((CommandExecutor) new Home(this));
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        setupCommands();
        try(FileInputStream fileInputStream = new FileInputStream("./homes")){
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            PlayerList.savePlayers(new Properties());
        } catch (IOException e) {
            e.printStackTrace();
            PlayerList.savePlayers(new Properties());
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
