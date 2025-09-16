package pattern;

public class DeleteSave implements Save{
    @Override
    public void save(String str) {
        System.out.println("Delete Save == " + str);
    }
}
