public class Electabuzz extends ElectricPokemon{
    public Electabuzz(String name, int level, int type, boolean canEvolve, int hp, int bp, int maxHp, int maxBp, Attack[] attacks) {
        super(name, level, type, canEvolve, hp, bp, maxHp, maxBp, attacks);
    }
        public boolean evolve(){
            boolean isEvolve = false;
            if (canEvolve(Constants.HP_NECESSARY_FOR_LVL_TWO,Constants.BP_NECESSARY_FOR_LVL_TWO)){
                printName();
                System.out.println(" evolved to Electivire ");
                setEvolve("Electivire",2,35,120);
                subtractHp(Constants.HP_NECESSARY_FOR_LVL_TWO);
                subtractBp(Constants.BP_NECESSARY_FOR_LVL_TWO);
                Attack attack = Constants.THUNDER_PUNCH;
                addAttack(attack);
                isEvolve = true;
            }else {
                System.out.println("Electrabuzz cannot evolve right now. \n you need AT LEAST - 20 HP and 25 BP");
            }
          return isEvolve;
        }
    }

