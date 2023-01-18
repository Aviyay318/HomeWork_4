public class Salandit extends FirePokemon{
    public Salandit(String name, int level, int type, boolean canEvolve, int hp, int bp, int maxHp, int maxBp, Attack[] attacks) {
        super(name, level, type, canEvolve, hp, bp, maxHp, maxBp, attacks);
    }
    public boolean evolve(){
        boolean isEvolve = false;
            if (canEvolve(Constants.HP_NECESSARY_FOR_LVL_TWO,Constants.BP_NECESSARY_FOR_LVL_TWO)){
                printName();
                System.out.println(" evolved to Salazzle");
                setEvolve("Salazzle",2,160,80);
                subtractHp(Constants.HP_NECESSARY_FOR_LVL_TWO);
                subtractBp(Constants.BP_NECESSARY_FOR_LVL_TWO);
                Attack attack = Constants.FIRE_CLAWS;
                addAttack(attack);
                isEvolve =true;
            }else {
                System.out.println("Salandit cannot evolve right now. \n you need AT LEAST - 20 HP and 25 BP");
            }
            return isEvolve;
    }
}
