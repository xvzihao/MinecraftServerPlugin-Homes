package alex.plugins.homes.Commands;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PlayerList {
    public static Properties getPlayers(){
        try(FileInputStream inputStream = new FileInputStream("./homes")) {
            Properties players = new Properties();
            players.load(inputStream);
            inputStream.close();
            return players;
        } catch (IOException e) {
            return new Properties();
        }
    }
    public static boolean savePlayers(Properties players){
        try(FileOutputStream outputStream = new FileOutputStream("./homes")) {
            players.store(outputStream, null);
            outputStream.close();
        }catch (IOException e){
            return false;
        }
        return true;
    }
}
