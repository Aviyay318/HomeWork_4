public abstract class Pokémon {
    private String name;
    private int  level;
    private int type;
    private int hp;
    private int bp;
    private int maxHp;
    private int maxBp;
    private int attackPower;
    private boolean canEvolve;
    private Attack [] attacks;

    //O(1)
    public Pokémon(String name, int level, int type,boolean canEvolve, int hp, int bp, int maxHp, int maxBp, Attack[] attacks) {
        this.name = name;
        this.level = level;
        this.type = type;
        this.canEvolve = canEvolve;
        this.hp = hp;
        this.bp = bp;
        this.maxHp = maxHp;
        this.maxBp = maxBp;
        this.attacks = attacks;
        this.attackPower = 1;
    }

    //O(1)
    public boolean isCanEvolve() {
        return this.canEvolve;
    }

    //O(1)
    public void setAttacks(Attack[] attacks) {
        this.attacks = attacks;
    }

    //O(1)
    public int getAttackPower() {
        return attackPower;
    }

    //O(1)
    public void fullHp(){
        this.hp = this.maxHp;
    }

    //O(1)
    public void makeHpHalf(){
        this.hp /= Constants.HALF_HP;
    }

    //O(1)
    public void initializeBp(){
        this.bp = Constants.INITIALIZER;
    }

    //O(1)
    public void fullBp(){
        this.bp = this.maxBp;
    }

    //O(1)
    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    //O(1)
    public int getHp() {
        return hp;
    }

    //O(1)
    public Attack[] getAttacks() {
        return attacks;
    }

    //O(1)
    public boolean isAlive(){
        boolean isAlive = true;
        if (this.hp==Constants.ZERO_HP){
            isAlive = false;
        }
        return isAlive;
    }

    //O(1)
    public boolean canAttack (int bp){
       boolean isCanAttack = false;
       if (this.bp>=bp){
           isCanAttack = true;
       }
       return isCanAttack;
    }

    //O(1)
    public void addHp(int hpToAdd){
        if (this.hp+hpToAdd<=this.maxHp){
            this.hp+=hpToAdd;
        }else {
            this.hp = this.maxHp;
        }
    }

    //O(1)
    public boolean isFire(){
        boolean isFire = true;
        if (this.type==Constants.ELECTRIC){
            isFire = false;
        }
        return isFire;
    }

    //O(1)
    public void subtractHp(int hpToSub){
        if (this.hp-hpToSub>=0){
            this.hp-=hpToSub;
        }else {
            this.hp = Constants.ZERO_HP;
        }
    }

    //O(1)
    public void addBp(int bpToAdd){
       if (this.bp+bpToAdd<=this.maxBp){
           this.bp+=bpToAdd;
       }else {
           this.bp = this.maxBp;
       }
    }

    //O(1)
    public void subtractBp(int bpToSub){
      if (canAttack(bpToSub)){
          this.bp -= bpToSub;
      }
    }

    //O(1)
    public abstract int typeSpeciality(Attack attack);

    //O(1)
    public abstract void selfAllRound();

    //O(1)
    public abstract void opponentAllRound();

    //O(1)
    public boolean haveEnoughHp(){
        boolean haveHp = false;
        if (this.hp>=((this.maxHp*20)/100)){
           haveHp=true;
        }
        return haveHp;
    }

    //O(1)
    public void setEvolve(String name,boolean canEvolve, int level, int maxHp, int maxBp){
        this.name = name;
        this.canEvolve = canEvolve;
        this.level = level;
        this.maxHp = maxHp;
        this.maxBp = maxBp;
    }

    //O(1)
    public boolean canEvolve(int hp,int bp){
      boolean isCanEvolve = false;
      if (this.hp>=hp&&this.bp>=bp){
         isCanEvolve = true;
      }
     return isCanEvolve;
    }

    //O(1)
    public int getLevel() {
        return level;
    }

    //O(1)
    public abstract boolean evolve();

    //O(1)
    public void printName(){
        System.out.print(this.name);
    }

    //O(1)
    public void printType(){
        if(this.type == Constants.FIRE) {
            System.out.print("Fire");
        }
        else {
            System.out.print("Electric");
        }
    }

    //O(1)
    public void printEvolveCost(){
        if (this.level==Constants.LEVEL_ONE){
            System.out.print("[you need AT LEAST - 20 HP and 25 BP]");
        }
        else if (this.level==Constants.LEVEL_TWO){
            System.out.print("[you need AT LEAST - 30 HP and 40 BP]");
        }
    }

    //O(n)
    public void addAttack(Attack attack){
        Attack [] tempAttack = new Attack[getAttacks().length+1];
        for (int i=0;i<getAttacks().length;i++){
            tempAttack[i] = getAttacks()[i];
        }
        tempAttack[tempAttack.length-1] = attack;
        setAttacks(tempAttack);
    }

    //O(1)
    public String toString() {
        return name +
                "\nlevel=" + this.level +
                ", hp=[" + this.hp + "/" + this.maxHp + "]" +
                ", bp=[" + this.bp +"/" + this.maxBp + "]";

    }
}

