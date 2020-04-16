package alex.plugins.homes;

import alex.plugins.homes.Commands.PlayerList;

import java.util.Arrays;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Home home = new Home("world", "default", 0, 0, 0);
        String code = home.toString();
        System.out.println(home);
        Home dft = new Home(code);
        System.out.println(dft);

    }
}
