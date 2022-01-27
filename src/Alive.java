interface Alive {
    public boolean isAlive();
    public boolean isDead();
    public boolean isHostile();
    public void takeDamage(int dmg);
    public void attack(Alive a);
    public void defence(int dmg);
    public String getName();
    
}
