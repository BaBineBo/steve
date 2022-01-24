public class Human extends Creature implements Fighter {
    private int armour;
    private String tauntDescritpion;
    private String catchphrase;


    // Fighter functions
    public void attack(Alive a){
        return;
    }

    public void defence(int dmg){
        this.takeDamage(dmg - this.defence - this.armour);
    }

    public void taunt(){
        System.out.print(tauntDescritpion);
    }

    public void catchphrase(){
        System.out.print(catchphrase);
    }
}
