public abstract class ElectricPokemon extends Pokémon{

    private int charge;

    //O(1)
    public ElectricPokemon(String name, int level, int type, boolean canEvolve, int hp, int bp, int maxHp, int maxBp, Attack[] attacks) {
        super(name, level, type, canEvolve, hp, bp, maxHp, maxBp, attacks);
        this.charge = Constants.INITIALIZER;
    }

    //O(1)
    public void evolve(int hp,int bp){}

    //O(1)
    public boolean evolve() {return false;}

    //O(1)
    public void selfAllRound() {
        charge();
        checkHpPointForCharge();
    }

    //O(1)
    public void opponentAllRound(){
        checkHpPointForCharge();
    }

    //O(1)
    public int typeSpeciality(Attack attack) {

        int damageForOpponent = attack.damageForOpponent();
        damageForOpponent+=damageForOpponent*this.charge/100;
        return damageForOpponent;
    }

    //O(1)
    private void charge(){
        this.charge+=5;
    }

    //O(1)
    private void checkHpPointForCharge(){
        if (!haveEnoughHp()){
           this.charge = Constants.INITIALIZER;
        }
    }

    //O(1)
    public String toString() {
        return super.toString() + " Charge: " + charge;


    }
}
