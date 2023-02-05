package Animals;

import java.util.ArrayList;
import java.util.List;


public class program {
    public static void main(String[] args) {
        Lion simba = new Lion("Simba");
        Cow blackbeauty = new Cow("BlackBeauty");
        List <Mammal> animals = new ArrayList <Mammal> ();
        animals.add(simba);
        animals.add(blackbeauty);
        for(Mammal item: animals){
            System.out.printf("%s %s %s, %s \n", item.name(), item.getNickname(), item.says(), item.food());

        }
    }

    
}
