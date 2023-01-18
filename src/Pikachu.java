public class Pikachu extends ElectricPokemon{
    public Pikachu(String name, int level, int type, boolean canEvolve, int hp, int bp, int maxHp, int maxBp, Attack[] attacks) {
        super(name, level, type, canEvolve, hp, bp, maxHp, maxBp, attacks);
    }
    public void evolve(){
        if (getLevel()==Constants.LEVEL_ONE){
            if (canEvolve(Constants.HP_NECESSARY_FOR_LVL_TWO,Constants.BP_NECESSARY_FOR_LVL_TWO)){
                printName();
                System.out.println(" evolved to Pikachu ");
                setEvolve("Pikachu",2,50,40);
                subtractHp(Constants.HP_NECESSARY_FOR_LVL_TWO);
                subtractBp(Constants.BP_NECESSARY_FOR_LVL_TWO);
                Attack attack = Constants.ELECTRO_BALL;
                addAttack(attack);
            }else {
                System.out.println("Pichu cannot evolve right now. \n you need AT LEAST - 20 HP and 25 BP");
            }
        }else if (getLevel()==Constants.LEVEL_TWO){
            if (canEvolve(Constants.HP_NECESSARY_FOR_LVL_THREE,Constants.BP_NECESSARY_FOR_LVL_THREE)){
                printName();
                System.out.println(" evolved to Raichu ");
                setEvolve("Raichu",3,160,80);
                subtractHp(Constants.HP_NECESSARY_FOR_LVL_THREE);
                subtractBp(Constants.BP_NECESSARY_FOR_LVL_THREE);
                Attack attack = Constants.ELECTRIC_SURFER;
                addAttack(attack);
            }else {
                System.out.println("Pikachu cannot evolve right now. \n you need AT LEAST - 30 HP and 40 BP");
            }

        }
    }
}
