import java.util.Random;

public class Attack {
     private String name;
     private int attackPointCost;
     private int minimumDamage;
     private int maximumDamage;

     public Attack(String name, int attackPointCost, int minimumDamage, int maximumDamage) {
          this.name = name;
          this.attackPointCost = attackPointCost;
          this.minimumDamage = minimumDamage;
          this.maximumDamage = maximumDamage;
     }
     public int getAttackPointCost() {
          return this.attackPointCost;
     }
     public int damageForOpponent(){
          int damageForOpponent;
          Random random = new Random();
          if (this.minimumDamage<this.maximumDamage){
               damageForOpponent = random.nextInt(this.minimumDamage,this.maximumDamage);
          }else {
               damageForOpponent = this.maximumDamage;
          }
          return damageForOpponent;
     }

     public String toString() {
          return
                  name +
                  " [AP: " + attackPointCost + "]" +
                  " ,"+printAttackInformation();
     }
     private String printAttackInformation(){
          String attackInformatio="[Damage: " + minimumDamage +
          "-" + maximumDamage +"]";
           if (this.minimumDamage==this.maximumDamage){
                attackInformatio =  "[Damage:" + minimumDamage + "]";
           }
          return attackInformatio;
     }
}
