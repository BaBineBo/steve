public class Human extends Creature implements Fighter {
    private int armour;
    private String tauntDescritpion;
    private String catchphrase;

    Weapon weapon;

    public Human (String name, int health, int stamina, Weapon weapon, int armour, String taunt, String catchphrase, boolean isHostile) {
        super(name, "Human", health, stamina, weapon.getDamage(), armour,  isHostile);
        this.weapon = weapon;
        this.tauntDescritpion = taunt;
        this.catchphrase = catchphrase;


    }


    // Fighter functions
    // --------------------------------------------------------------------

    public void taunt(){
        System.out.print(tauntDescritpion);
    }

    public void catchphrase(){
        System.out.print(catchphrase);
    }


    @Override
    public void changeWeapon( Weapon weapon) {
        this.weapon = weapon;
        
    }
}
