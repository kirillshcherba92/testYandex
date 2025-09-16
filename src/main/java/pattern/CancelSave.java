package pattern;

public class CancelSave implements Save{
    @Override
    public void save(String str) {
        System.out.println("Cancel Save == " + str);
    }
}
