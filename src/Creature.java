public class Creature implements Alive{
    protected String name;
    protected String type;
    protected int health;
    protected int stamina;
    protected int defence;
    private boolean isAlive;



    // functions from interface
    public boolean isAlive(){
        return this.isAlive;
    }

    public void takeDamage(int dmg){
        if(!this.isAlive) return;

        this.health -= dmg;
        System.out.print(this.name + " the " + this.type + "Took " + dmg + "damage. ");
        
        this.isAlive = this.health > 0;
        if(!this.isAlive){
            System.out.print(this.name + " the " + this.type + " died from the damage");
        }
    }

    // get functions
    public String getName(){
        return this.name;
    }
}
