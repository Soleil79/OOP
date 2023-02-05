package Animals;

public class Cow extends Herbivore{
    
    public String says (){
        return "says moo";
    }
    @Override 
    public String name(){
        return "Cow";
    }
    public Cow (String nickname){
        this.nickname = nickname;
    }
}
