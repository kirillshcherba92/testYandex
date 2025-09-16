package pattern;

public class SuccessSave implements Save{
    @Override
    public void save(String str) {
        System.out.println("SuccessSave == "  + str);
    }
}
