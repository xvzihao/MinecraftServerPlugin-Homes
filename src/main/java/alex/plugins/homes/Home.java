package alex.plugins.homes;

public class Home {
    public int x,y,z;
    public String name;
    public String world;
    public Home(String world, String name, int x, int y, int z){
        this.name = name;
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Home(String info){
        String[] s_home = info.split(":");
        String[] s_pos = s_home[2].split(",");
        this.name = s_home[1];
        this.world = s_home[0];
        this.x = Integer.parseInt(s_pos[0]);
        this.y = Integer.parseInt(s_pos[1]);
        this.z = Integer.parseInt(s_pos[2]);
    }
    public String toString(){
        return this.world+":"+this.name+':'+this.x+','+this.y+','+this.z;
    }
}
