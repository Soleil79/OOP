package Animals;

public abstract class Mammal{ 
    protected String nickname;

    public String getNickname(){
        return nickname;
    }

    public int countLegs (){
        return 4;
    }
    
    public abstract String food();
    public abstract String says();
    public abstract String name();
}
