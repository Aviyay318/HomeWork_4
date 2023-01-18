import java.util.Random;

public class FirePokemon extends Pokémon{

    public FirePokemon(String name, int level, int type, boolean canEvolve, int hp, int bp, int maxHp, int maxBp, Attack[] attacks) {
        super(name, level, type, canEvolve, hp, bp, maxHp, maxBp, attacks);
    }

    public void evolve(){};
    public void allRound() {}
    public int typeSpeciality(Attack attack){
        int damageForOpponent = attack.damageForOpponent();
        return damageForOpponent;
    }
    public void typeSpeciality() {
        Random random=new Random();
        if (random.nextInt(1,5)==Constants.PROBABILITY_OF_SELF_DAMAGE){ //TODO
            int randomSelfDamage = random.nextInt(3,11); //TODO
            subtractHp(randomSelfDamage);
            System.out.println("Oh no! your attack has burnt you, you lost: " + randomSelfDamage + " HP");
        }
    }
}
