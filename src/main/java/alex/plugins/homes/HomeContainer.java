package alex.plugins.homes;

import java.util.ArrayList;
import java.util.Arrays;

public class HomeContainer {
    public ArrayList<Home> homes = new ArrayList<>();
    public HomeContainer(){}
    public HomeContainer(String info){
        try {
            for (String str_home : info.split(";")) {
                this.homes.add(new Home(str_home));
            }
        } catch (Exception e){}
    }
    public boolean remove(String name){
        ArrayList array = new ArrayList(Arrays.asList(this.toArray()));
        int index = array.indexOf(name);
        if (index != -1)
            this.homes.remove(homes.get(index));
        return index != -1;
    }
    public boolean contains(String name){
        ArrayList array = new ArrayList(Arrays.asList(this.toArray()));
        return array.indexOf(name) != -1;
    }
    public String[] toArray(){
        String[] array = new String[this.homes.size()];
        for (int i = 0; i < this.homes.size(); i++) {
            array[i] = this.homes.get(i).toString().split(":")[1];
        }
        return array;
    }
    public void addHome(Home home){
        this.homes.add(home);
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (Home home : homes) {
            str.append(home.toString()).append(';');
        }
        return str.toString();
    }
}
