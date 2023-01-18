import java.util.Random;

public class Attack {
     private String name;
     private int attackPointCost;
     private int minimumDamage;
     private int maximumDamage;

     //O(1)
     public Attack(String name, int attackPointCost, int minimumDamage, int maximumDamage) {
          this.name = name;
          this.attackPointCost = attackPointCost;
          this.minimumDamage = minimumDamage;
          this.maximumDamage = maximumDamage;
     }
     //O(1)
     public int getAttackPointCost() {
          return this.attackPointCost;
     }
     //O(1)
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
                  " [BP: " + attackPointCost + "]" +
                  " ,"+printAttackInformation();
     }
     //O(1)
     private String printAttackInformation(){
          String attackInformatio="[Damage: " + minimumDamage +
          "-" + maximumDamage +"]";
           if (this.minimumDamage==this.maximumDamage){
                attackInformatio =  "[Damage:" + minimumDamage + "]";
           }
          return attackInformatio;
     }
}
