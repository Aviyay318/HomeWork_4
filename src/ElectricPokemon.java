public class ElectricPokemon extends Pokémon{

    private int charge;

    public ElectricPokemon(String name, int level, int type, boolean canEvolve, int hp, int bp, int maxHp, int maxBp, Attack[] attacks) {
        super(name, level, type, canEvolve, hp, bp, maxHp, maxBp, attacks);
        this.charge = Constants.INITIALIZER;
    }

    public void evolve(int hp,int bp){}


    public boolean evolve() {return false;}

    public void allRound() {
        charge();
        checkHpPointForCharge();
    }


    public int typeSpeciality(Attack attack) {

        int damageForOpponent = attack.damageForOpponent();
        damageForOpponent+=damageForOpponent*this.charge/100;
        return damageForOpponent;
    }

    private void charge(){
        this.charge+=5;
    }
    private void checkHpPointForCharge(){
        if (!isHaveEnoughHp()){
           this.charge = Constants.INITIALIZER;
        }
    }


    public String toString() {
        return super.toString() + " Charge: " + charge;


    }
}
