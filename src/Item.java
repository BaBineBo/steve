public class Item {
    // Declare constants
    private String name;
    private String description;

    // Constructor
    public Item(String name, String description) {
        this.name           = name;
        this.description    = description;
    }


    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }
    
}
