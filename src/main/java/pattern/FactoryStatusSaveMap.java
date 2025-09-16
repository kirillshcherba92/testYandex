package pattern;

import java.util.HashMap;
import java.util.Map;

final public class FactoryStatusSaveMap {
    private static volatile Map<Status, Save> statusSaveMap = null;

    private FactoryStatusSaveMap() {
    }

    public static Map<Status, Save> getStatusSaveMap() {
        if (statusSaveMap == null) {
            synchronized (FactoryStatusSaveMap.class) {
                if (statusSaveMap==null) {
                    createStatusSaveMap();
                }
            }
        }
        return statusSaveMap;
    }

    private static void createStatusSaveMap() {
        statusSaveMap = new HashMap<>();
        statusSaveMap.put(Status.SUCCESS, new SuccessSave());
        statusSaveMap.put(Status.DELETE, new DeleteSave());
        statusSaveMap.put(Status.CANCEL, new CancelSave());
    }
}
