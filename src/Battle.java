import java.util.Random;
import java.util.Scanner;

public class Battle {

    //O(n)
    public void startGame(){
        Random random = new Random();
        Pokémon [] trainers = new Pokémon[Constants.NUMBER_OF_TRAINERS];
        boolean specialActionElectric = true;
        int counterTurnForDamagePower = 0;
        int indexTrainer = Constants.PLAYER_ONE;
        boolean switchTurn;
        boolean isWinner = false;
        for (int i = 0;i<trainers.length;i++){
            trainers[i] = randomPokémon();
        }
        System.out.println("\n\nWel come to Pokemon!" +
                "\nThe rules are simple:\n" +
                "1. WIN!\n");      //7 years old humor  #Ram
        System.out.print("Trainer #1: ");
                 trainers[Constants.PLAYER_ONE].printName();
        System.out.print( " of type ");
        trainers[Constants.PLAYER_ONE].printType();
        System.out.print(" I CHOOSE YOU\n" +
                "-----------VS-----------\n" +"Trainer #2: ");
                trainers[Constants.PLAYER_TWO].printName();
        System.out.print( " of type ");
        trainers[Constants.PLAYER_TWO].printType();
         System.out.println( " I CHOOSE YOU\n\n");
        while (!isWinner){
            System.out.println("\nTrainer #1: "+trainers[Constants.PLAYER_ONE]);
            System.out.println("-----------VS-----------");
            System.out.println("Trainer #2: "+trainers[Constants.PLAYER_TWO]+"\n");
            switchTurn = false;
            if (indexTrainer==Constants.PLAYER_ONE){
                System.out.println("It's Trainer #1's turn\n" + "----------------------");
            }else {
                System.out.println("it's Trainer #2's turn\n" + "----------------------");
            }
            switch (printMenuAndScan(trainers[indexTrainer])){
                case Constants.BATTLE -> switchTurn = attack(trainers,indexTrainer);
                case Constants.PASS_TURN -> {
                    passTurn(trainers[indexTrainer]);
                    switchTurn = true;
                }
                case Constants.EVOLVE -> switchTurn = evolve(trainers[indexTrainer]);
                case Constants.SPECIAL_ACTION -> {
                   if (trainers[indexTrainer].isFire()){
                          specialActionForFire(trainers,indexTrainer);
                          switchTurn = true;
                   }else {
                       if (specialActionElectric){
                           specialActionForElectric(trainers[indexTrainer]);
                           specialActionElectric = false;
                           switchTurn =true;
                       }else {
                           System.out.println("You already used it, try something else.");
                       }
                   }
                }

            }
            if (indexTrainer==Constants.PLAYER_ONE){
                isWinner=isWinner(trainers[Constants.PLAYER_TWO]);
            }else {
                isWinner=isWinner(trainers[Constants.PLAYER_ONE]);
            }
            if (isWinner){
                if (indexTrainer==Constants.PLAYER_ONE){
                    trainers[Constants.PLAYER_TWO].printName();
                }else {
                    trainers[Constants.PLAYER_ONE].printName();
                }
                System.out.println(" has fainted");
                trainers[indexTrainer].printName();
                System.out.println(" is the winner");
                break;
            }

          if (switchTurn){
              if (trainers[indexTrainer].isAttackPower(Constants.ATTACK_POWER_BONUS)){
                  counterTurnForDamagePower++;
                  trainers[indexTrainer].addToAttackPower(counterTurnForDamagePower);
              }

              int randomHp = random.nextInt(Constants.MIN_RANDOM_HP,Constants.MAX_RANDOM_HP);
              int randomBp = random.nextInt(Constants.MIN_RANDOM_BP,Constants.MAX_RANDOM_BP);
              trainers[indexTrainer].printName();
              System.out.println(" gained " + randomHp + " HP and " + randomBp +" BP\n");
              trainers[indexTrainer].addHp(randomHp);
              trainers[indexTrainer].addBp(randomBp);
              trainers[indexTrainer].selfAllRound();
              if (indexTrainer==Constants.PLAYER_ONE){
                  indexTrainer = Constants.PLAYER_TWO;
                      trainers[Constants.PLAYER_TWO].opponentAllRound();
              }else {
                  indexTrainer = Constants.PLAYER_ONE;
                      trainers[Constants.PLAYER_ONE].opponentAllRound();
              }
          }
          if (counterTurnForDamagePower==Constants.RESET_POWER){
              counterTurnForDamagePower=Constants.INITIALIZER ;
              trainers[indexTrainer].setCounterOfTriplePower(Constants.INITIALIZER);
              if (trainers[indexTrainer].isAttackPower(Constants.ATTACK_POWER_BONUS)){
                  trainers[indexTrainer].setAttackPower(Constants.ATTACK_POWER);
              }
          }
        }
    }

    //O(1)
    private boolean attack(Pokémon [] trainers, int indexTrainers){
        Scanner scanner = new Scanner(System.in);
        boolean switchTurn = false;
        boolean isUserChoiceValid = true;
            int userAttackChoice=Constants.INITIALIZER;
        do {
            if (!isUserChoiceValid){
                trainers[indexTrainers].printName();
                System.out.println(".... " + userAttackChoice + " is NOT one of the options, try again.\n");
            }
            printAttack(trainers[indexTrainers]);
            System.out.println("Enter your desired attack: \n");
            userAttackChoice = scanner.nextInt();
            isUserChoiceValid = false;
        } while (userAttackChoice<1||userAttackChoice>trainers[indexTrainers].getAttacks().length);
        int attackCost = trainers[indexTrainers].getAttacks()[userAttackChoice-1].getAttackPointCost();
        if (trainers[indexTrainers].canAttack(attackCost)){
            switchTurn = true;
            trainers[indexTrainers].subtractBp(attackCost);
            Attack userChoiceAttack = trainers[indexTrainers].getAttacks()[userAttackChoice-1];
            int damageForOpponent = trainers[indexTrainers].typeSpeciality(userChoiceAttack);
            damageForOpponent*=trainers[indexTrainers].getAttackPower();

            if (indexTrainers==Constants.PLAYER_ONE){
                trainers[Constants.PLAYER_TWO].subtractHp(damageForOpponent);
                trainers[Constants.PLAYER_TWO].printName();
            }else {
                trainers[Constants.PLAYER_ONE].subtractHp(damageForOpponent);
                trainers[Constants.PLAYER_TWO].printName();
            }
            System.out.println(" got HIT and lost " + damageForOpponent + "HP");
       }else {
           System.out.println("You dont have enough BP, please choose something else.\n");
       }
     return switchTurn;
    }

    //O(n)
    private void printAttack(Pokémon pokémon){
        System.out.println("Your attacks are:");
     for (int i=0;i<pokémon.getAttacks().length;i++){
         System.out.println((i+1)+")"+pokémon.getAttacks()[i]);
     }
    }

    //O(1)
    private void passTurn(Pokémon pokémon){
        Random random = new Random();
        int bonus = random.nextInt(Constants.BONUS_MIN,Constants.BONUS_MAX);
        switch (bonus){
            case Constants.BONUS_HP -> {
                bonus = random.nextInt(Constants.BONUS_HP_MIN,Constants.BONUS_HP_MAX);
                pokémon.addHp(bonus);
                pokémon.printName();
                System.out.println(" got " + bonus + " HP\n");
            }
            case Constants.BONUS_BP ->{
                bonus = random.nextInt(Constants.BONUS_BP_MIN,Constants.BONUS_BP_MAX);
                pokémon.addBp(bonus);
                pokémon.printName();
                System.out.println(" got " + bonus + " BP\n");
            }
            case Constants.ATTACK_POWER_BONUS -> {
                pokémon.setAttackPower(Constants.ATTACK_POWER_BONUS);
                pokémon.printName();
                System.out.println("'s attack power has multiplied by 3\n");
            }
        }
    }

    //O(1)
    private boolean evolve(Pokémon pokémon){
        boolean switchTurn = false;
        if (pokémon.isCanEvolve()){
            switchTurn=pokémon.evolve();
        }else {
            pokémon.printName();
            System.out.println("can't evolve");
        }
       return switchTurn;
    }

    //O(1)
    private void specialActionForFire(Pokémon [] trainers, int indexTrainer){
        int damageForOpponent = randomDamage(trainers[indexTrainer]);
        damageForOpponent+=randomDamage(trainers[indexTrainer]);
        trainers[indexTrainer].initializeBp();
        trainers[indexTrainer].makeHpHalf();
        if (indexTrainer==Constants.PLAYER_ONE){
            trainers[Constants.PLAYER_TWO].subtractHp(damageForOpponent);
        }else {
            trainers[Constants.PLAYER_ONE].subtractHp(damageForOpponent);
        }

    }

    //O(1)
    private int randomDamage(Pokémon pokémon){
        Random random = new Random();
        int randomAttack = random.nextInt(pokémon.getAttacks().length);
        int damageForOpponent = pokémon.getAttacks()[randomAttack].damageForOpponent();
        return damageForOpponent;
    }

    //O(1)
    private void specialActionForElectric(Pokémon  pokémon){
        pokémon.fullHp();
        pokémon.fullBp();
    }

    //O(n)
    private int printMenuAndScan(Pokémon pokémon){
        int userInput = Constants.INITIALIZER;
        boolean isUserChoiceValid = true;
        System.out.print("What will ");
        pokémon.printName();
        System.out.println(" do?");
        do {
            if (!isUserChoiceValid){
                pokémon.printName();
                System.out.println(".... " + userInput + " is NOT one of the options, try again.");
            }
            System.out.print("1: Fight" +
                    "\n2: Pass the turn to get a bonus" +
                    "\n3: Evolve ");
            pokémon.printEvolveCost();
            System.out.println("\n" +
                    "4: Special Action "+ printExplanation(pokémon)+"\n");
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextInt();isUserChoiceValid = false;
        }while (userInput<Constants.MIN_VALID_CHOICE||userInput>Constants.MAX_VALID_CHOICE);

        return userInput;
    }

    //O(1)
    private String printExplanation(Pokémon pokémon){
        String printExplanation ="[Your HP and BP will be maximized, however! you can only use it once.]";
       if (pokémon.isFire()){
           printExplanation= " [You attack twice with random attacks, but! that will drain your BP to 0 and your HP will cut in half.]";
       }
       return printExplanation;
    }

    //O(1)
    public Pokémon randomPokémon(){
        Random random = new Random();
        int pokémonIndex = random.nextInt(Constants.POKEMON_NAMES.length);
        Pokémon randomPokémon = null;
        switch (Constants.POKEMON_NAMES[pokémonIndex]){
            case Constants.CHARMANDER -> randomPokémon= new Charmander("Charmander",1,1,true,80,30,80,40,
                    new Attack [] {Constants.KICK,
                            Constants.SCRATCH});
            case Constants.SALANDIT -> {
                randomPokémon =  new Salandit("Salandit",1,1,true,100,45,100,60,
                        new Attack [] {Constants.KICK,
                                Constants.LIVE_COAL});
            }
            case Constants.MOLTRES -> {
                randomPokémon = new Moltres("Moltres",1,1,false,120,45,120,60,
                        new Attack [] {Constants.KICK, Constants.ASSISTING_HEATER,Constants.FIRE_WING});
            }
            case Constants.PIKACHU -> {
                randomPokémon = new Pikachu("Pichu",1,2,true,40,22,40,30,
                        new Attack [] {Constants.KICK,Constants.QUICK_ATTACK});
            }
            case Constants.BLITZLE -> {
                randomPokémon = new Blitzle("Blitzle",1,2,true,90,26,90,35,
                        new Attack [] {Constants.KICK,Constants.FLOP});
            }
            case Constants.ELECTABUZZ -> {
                randomPokémon = new Electabuzz("Electabuzz",1,2,true,30,75,30,100,
                        new Attack [] {Constants.KICK,Constants.THUNDER});
            }
        }
      return randomPokémon;
    }

    //O(1)
    private boolean isWinner(Pokémon pokémon){
        boolean isWinner=false;
       if (!pokémon.isAlive()) {
           isWinner = true;
       }
        return isWinner;
    }
}
