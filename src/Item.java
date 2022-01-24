public class Item {
    // Declare constants
    private String name;
    private String description;
    private String placement;

    // Constructor
    public Item(String name, String description, String placement) {
        this.name           = name;
        this.description    = description;
        this.placement      = placement;
    }


    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public String getPlacement(){
        return this.placement;
    }
    
}
