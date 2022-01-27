public class Creature implements Alive{
    protected String name;
    protected String type;
    protected int health;
    protected int stamina;
    protected int attackDamage;
    protected int defence;

    // things that change how we perceive creatures
    private boolean isAlive = true;
    private boolean isHostile;


    // Constructor
    public Creature(String name, String type, int health, int stamina, int attackdmg, int defence, boolean isHostile) {
        this.name = name;
        this.type = type;
        this.health = health;
        this.stamina = stamina;
        this.attackDamage = attackdmg;
        this.defence = defence;
        this.isHostile = isHostile;
    }

    // functions from interface
    public boolean isAlive(){
        return this.isAlive;
    }
    public boolean isDead(){
        return !this.isAlive;
    }
    public boolean isHostile() {
        return this.isHostile;
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
    @Override
    public void attack(Alive a) {
        a.takeDamage(this.attackDamage);
        
    }
    @Override
    public void defence(int dmg) {
        this.takeDamage(dmg-defence);
        
    }

    // get functions
    public String getName(){
        return this.name;
    }

    // update functions
    public void uppdateAttack(int dmg){
        this.attackDamage = dmg;
    }

    public void uppdateDefence(int def) {
        this.defence = def;
    }

}
