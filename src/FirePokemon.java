import java.util.Random;

public class FirePokemon extends Pokémon{

    public FirePokemon(String name, int level, int type, boolean canEvolve, int hp, int bp, int maxHp, int maxBp, Attack[] attacks) {
        super(name, level, type, canEvolve, hp, bp, maxHp, maxBp, attacks);
    }

    public boolean evolve(){return false;};
    public void allRound() {}
    public int typeSpeciality(Attack attack){
        if (attack!=Constants.KICK){
            selfDamage();
        }
        int damageForOpponent = attack.damageForOpponent();
        return damageForOpponent;
    }
    public void selfDamage() {
        Random selfDamage = new Random();
        if (selfDamage.nextInt(Constants.WILL_TAKE_DAMAGE_MINIMUM,Constants.WILL_TAKE_DAMAGE_MAXIMUM)==Constants.PROBABILITY_OF_SELF_DAMAGE){
            int randomSelfDamage = selfDamage.nextInt(Constants.DAMAGE_TAKEN_MINIMUM,Constants.DAMAGE_TAKEN_MAXIMUM);
            subtractHp(randomSelfDamage);
            System.out.println("Oh no! your attack has burnt you, you lost: " + randomSelfDamage + " HP");
        }
    }
}
