public class Moltres extends FirePokemon{

    //O(1)
    public Moltres(String name, int level, int type, boolean canEvolve, int hp, int bp, int maxHp, int maxBp, Attack[] attacks) {
        super(name, level, type, canEvolve, hp, bp, maxHp, maxBp, attacks);
    }

    //O(1)
    public boolean evolve() {
        System.out.println("Moltres cannot evolve.");return false;
    }
}
