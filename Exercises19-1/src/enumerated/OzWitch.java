package enumerated;

public enum OzWitch {
    //Instances must be defined first. before methods:
    WEST("Miss Gulch, aka the Wicked Witch of the West"),
    NORTH("Glinds, the Good Witch of the North"),
    EAST("...E"),
    SOUTH("...S");
    private String description;
    //Constructor must be package or private access

    //不能在外边使用enum的构造函数
    OzWitch(String description) {
        this.description = description;
    }

    public static void main(String[] args) {
        for (var item: OzWitch.values()){
            System.out.println(item.getDescription());
        }
    }

    public String getDescription() {
        return description;
    }
}
