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

    public boolean isCanEvolve() {
        return this.canEvolve;
    }

    public void setAttacks(Attack[] attacks) {
        this.attacks = attacks;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void fullHp(){
        this.hp = this.maxHp;
    }
    public void makeHpHalf(){
        this.hp /= 2;
    }
    public void makeBpZero(){
        this.bp = 0;
    }
    public void fullBp(){
        this.bp = this.maxBp;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getHp() {
        return hp;
    }

    public Attack[] getAttacks() {
        return attacks;
    }

    public boolean isAlive(){
        boolean isAlive = true;
        if (this.hp==Constants.ZERO_HP){
            isAlive = false;
        }
        return isAlive;
    }

    public boolean canAttack (int bp){
       boolean isCanAttack = false;
       if (this.bp>=bp){
           isCanAttack = true;
       }
       return isCanAttack;
    }

    public void addHp(int hpToAdd){
        if (this.hp+hpToAdd<=this.maxHp){
            this.hp+=hpToAdd;
        }else {
            this.hp = this.maxHp;
        }
    }
    public boolean isFire(){
        boolean isFire = true;
        if (this.type==Constants.ELECTRIC){
            isFire = false;
        }
        return isFire;
    }

    public void subtractHp(int hpToSub){
        if (this.hp-hpToSub>=0){
            this.hp-=hpToSub;
        }else {
            this.hp = Constants.ZERO_HP;
        }
    }
    public void addBp(int bpToAdd){
       if (this.bp+bpToAdd<=this.maxBp){
           this.bp+=bpToAdd;
       }else {
           this.bp = this.maxBp;
       }
    }
    public void subtractBp(int bpToSub){
      if (canAttack(bpToSub)){
          this.bp -= bpToSub;
      }
    }
    public abstract int typeSpeciality(Attack attack);
    public abstract void allRound();
    public boolean isHaveEnoughHp(){ //TODO
        boolean isisHaveHp = false;
        if (this.hp>=(this.maxHp*20)/100){
           isisHaveHp=true;
        }
        return isisHaveHp;
    }
    public void setEvolve(String name, int level, int maxHp, int maxBp){
        this.name = name;
        this.level = level;
        this.maxHp = maxHp;
        this.maxBp = maxBp;
    }
    public boolean canEvolve(int hp,int bp){
      boolean isCanEvolve = false;
      if (this.hp>=hp&&this.bp>=bp){
         isCanEvolve = true;
      }
     return isCanEvolve;
    }
    public int getLevel() {
        return level;
    }

    public abstract boolean evolve();
    public void printName(){
        System.out.print(this.name);
    }
    public void addAttack(Attack attack){
        Attack [] tempAttack = new Attack[getAttacks().length+1];
        for (int i=0;i<getAttacks().length;i++){
            tempAttack[i] = getAttacks()[i];
        }
        tempAttack[tempAttack.length-1] = attack;
        setAttacks(tempAttack);
    }
    //TODO
    public String toString() {
        return name +
                "\nlevel=" + this.level +
                ", hp=[" + this.hp + "/" + this.maxHp + "]" +
                ", bp=[" + this.bp +"/" + this.maxBp + "]";

    }
}

