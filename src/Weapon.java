public class Weapon extends Item {
    private int durability;
    private int damage;
    

    // constructor
    public Weapon(String name, String description, int durability, int damage){
        super(name, description);
        this.durability = durability;
        this.damage = damage;
    }

    // Functions
    public int getDurability(){
        return this.durability;
    }

    public int getDamage(){
        return this.damage;
    }
    
}
