public class Constants {
    public static final int ZERO_HP = 0;
    public static final int FIRE = 1;
    public static final int ELECTRIC = 2;
    public static final int PROBABILITY_OF_SELF_DAMAGE=4;
    public static final int PLAYER_ONE =0;
    public static final int PLAYER_TWO = 1;
    public static final int HP_NECESSARY_FOR_LVL_TWO =20;
    public static final int BP_NECESSARY_FOR_LVL_TWO =25;
    public static final int HP_NECESSARY_FOR_LVL_THREE =20;
    public static final int BP_NECESSARY_FOR_LVL_THREE =25;
    public static final String CHARMANDER = "Charmander";
    public static final String SALANDIT = "Salandit";
    public static final String MOLTRES = "Moltres";
    public static final String PIKACHU = "Pikachu";
    public static final String BLITZLE = "Blitzle";
    public static final String ELECTABUZZ = "Electabuzz";

    public static final int MIN_VALID_CHOICE = 1;
    public static final int MAX_VALID_CHOICE = 4;

    public static final int BATTLE = 1;
    public static final int PASS_TURN = 2;
    public static final int EVOLVE = 3;
    public static final int SPECIAL_ACTION = 4;

    public static final int MIN_RANDOM_HP = 0;
    public static final int MAX_RANDOM_HP = 5;

    public static final int MIN_RANDOM_BP = 0;
    public static final int MAX_RANDOM_BP = 5;

    public static final int BONUS_MIN = 1;
    public static final int BONUS_MAX = 4;

    public static final int BONUS_HP = 1;
    public static final int BONUS_HP_MIN = 5;
    public static final int BONUS_HP_MAX = 31;

    public static final int BONUS_BP = 2;
    public static final int BONUS_BP_MIN = 0;
    public static final int BONUS_BP_MAX = 41;

    public static final int ATTACK_POWER = 1;
    public static final int ATTACK_POWER_BONUS = 3;

    public static final int INITIALIZER=0;
    public static final Attack KICK = new Attack("Kick",0,2,2);
    public static final Attack SCRATCH  =new Attack("Scratch",15,25,30);
    public static final Attack LIVE_COAL = new Attack("Live Coal",10,0,25);
    public static final Attack ASSISTING_HEATER =  new Attack("Assisting Heater",30,10,60);
    public static final Attack FIRE_WING = new Attack("Fire Wing",30,30,30);
    public static final Attack QUICK_ATTACK = new Attack("Quick Attack",5,10,10);
    public static final Attack FLOP = new Attack("Flop",20,20,25);
    public static final Attack THUNDER = new Attack("Thunder",60,40,50);
    public static final Attack THUNDER_PUNCH = new Attack("Thunder Punch",80,50,120);
    public static final Attack FIRE_CLAWS = new Attack("Fire Claws",25,0,50);
    public static final Attack ELECTRO_BALL = new Attack("Electro Ball",10,30,40);
    public static final Attack ELECTRIC_SURFER = new Attack("Electric Surfer",60,20,120);
    public static final Attack ZAP_KICK = new Attack("Zap Kick",30,30,35);
    public static final Attack FLAME_TAIL = new Attack("flame tail",40,30,50);
    public static final Attack FIERY_TAIL = new Attack("fiery tail",40,30,50);
    public static final int NUMBER_OF_TRAINERS = 2;
    public static final int LEVEL_ONE = 1;
    public static final int LEVEL_TWO =2;
}
