package pattern;

public class StrMain {
    public static void main(String[] args) {
        FactoryStatusSaveMap.getStatusSaveMap().get(Status.CANCEL).save("Сейв");
        FactoryStatusSaveMap.getStatusSaveMap().get(Status.SUCCESS).save("Сейв");
    }
}
