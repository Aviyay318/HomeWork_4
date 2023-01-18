public class Charmander extends FirePokemon {

    //O(1)
    public Charmander(String name, int level, int type, boolean canEvolve, int hp, int bp, int maxHp, int maxBp, Attack[] attacks) {
        super(name, level, type, canEvolve, hp, bp, maxHp, maxBp, attacks);
    }

    //O(1)
    public boolean evolve(){
        boolean isEvolve = false;
        if (getLevel()==Constants.LEVEL_ONE){
            if (canEvolve(Constants.HP_NECESSARY_FOR_LVL_TWO,Constants.BP_NECESSARY_FOR_LVL_TWO)){
                printName();
                System.out.println(" evolved to Charmeleon");
                setEvolve("Charmeleon",true,2,90,60);
                subtractHp(Constants.HP_NECESSARY_FOR_LVL_TWO);
                subtractBp(Constants.BP_NECESSARY_FOR_LVL_TWO);
                Attack attack = Constants.FLAME_TAIL;
                addAttack(attack);
                isEvolve = true;
            }else {
                System.out.println("Charmender cannot evolve right now. \n you need AT LEAST - 20 HP and 25 BP");
            }
        }else if (getLevel()==Constants.LEVEL_TWO){
            if (canEvolve(Constants.HP_NECESSARY_FOR_LVL_THREE,Constants.BP_NECESSARY_FOR_LVL_THREE)){
                printName();
                System.out.println(" evolved to Charizard");
                setEvolve("Charizard",false,3,130,80);
                subtractHp(Constants.HP_NECESSARY_FOR_LVL_THREE);
                subtractBp(Constants.BP_NECESSARY_FOR_LVL_THREE);
                Attack attack = Constants.FIERY_TAIL;
                addAttack(attack);
                isEvolve = true;
            }else {
                System.out.println("Charmeleon cannot evolve right now. \n you need AT LEAST - 30 HP and 40 BP");
            }

        }
        return isEvolve;
    }

}
