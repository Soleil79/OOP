package Animals;

public class Lion extends Predator {
    
    public String says(){
        return "says roo";
    }
    @Override 
    public String name(){
        return "Lion";
    }
    public Lion (String nickname){
        this.nickname = nickname;
    }
}
