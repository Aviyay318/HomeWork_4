public class Blitzle extends ElectricPokemon{
    public Blitzle(String name, int level, int type, boolean canEvolve, int hp, int bp, int maxHp, int maxBp, Attack[] attacks) {
        super(name, level, type, canEvolve, hp, bp, maxHp, maxBp, attacks);
    }
        public boolean evolve(){
            boolean isEvolve = false;
                if (canEvolve(Constants.HP_NECESSARY_FOR_LVL_TWO,Constants.BP_NECESSARY_FOR_LVL_TWO)){
                    printName();
                    System.out.println( " evolved to Zebstrika");
                    setEvolve("Zebstrika",2,100,50);
                    subtractHp(Constants.HP_NECESSARY_FOR_LVL_TWO);
                    subtractBp(Constants.BP_NECESSARY_FOR_LVL_TWO);
                    Attack attack = Constants.ZAP_KICK;
                    addAttack(attack);
                    isEvolve = true;
                }else {
                    System.out.println("Blitzle cannot evolve right now. \n you need AT LEAST - 20 HP and 25 BP");
                }
return isEvolve;
    }}

