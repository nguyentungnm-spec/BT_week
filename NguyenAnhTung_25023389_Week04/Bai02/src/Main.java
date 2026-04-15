//  Định nghĩa các Interface
interface CanFly {
    void fly();
}

interface CanSwim {
    void swim();
}

interface CanFight {
    void fight();
}

//  Định nghĩa lớp cha
class ActionCharacter {
    public void fight() {
        System.out.println("Đấm bốc...");
    }
}

//  Lớp Hero đa kế thừa
class Hero extends ActionCharacter implements CanFly, CanSwim, CanFight {
    @Override
    public void fly() {
        System.out.println("Hero is flying");
    }

    @Override
    public void swim() {
        System.out.println("Hero is swimming");
    }

    // Không cần viết lại fight() vì ActionCharacter đã có
}

//  Hàm Main chạy thử nghiệm
public class Main {
    public static void main(String[] args) {
        Hero spiderMan = new Hero();

        // Thử ép kiểu về CanSwim
        CanSwim swimmer = (CanSwim) spiderMan;
        swimmer.swim();

        // Thử ép kiểu về CanFight
        CanFight fighter = (CanFight) spiderMan;
        fighter.fight();
    }
}