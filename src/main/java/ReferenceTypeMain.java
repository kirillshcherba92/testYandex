import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceTypeMain {
    public static void main(String[] args) throws InterruptedException {
        /**
         * сильная ссылка
         */
        Object o = new Object(); // сильная ссылка

        /**
         * мягкая ссылка - это ссылка при которой обьект будет удалён из памяти только в том случаи,
         * если будет не хватать памяти, в остальном она похожа н сильную ссылку
         */
        SoftReference<Object> softReference = new SoftReference<>(o); // мягкая ссылка

        /**
         * слабая ссылка - это ссылка при которой обьект будет удалён сразу после того как отработает GC.
         */
        WeakReference<Object> weakReference = new WeakReference<>(o); // слабая ссылка

        print(o, softReference, weakReference);
        o = null;
        print(o, softReference, weakReference);
        System.gc();
        Thread.sleep(1000);
        print(o, softReference, weakReference);
    }

    public static <T> void print(T object, SoftReference<T> softReference,  WeakReference<T> weakReference) {
        System.out.println(object);
        System.out.println(softReference.get());
        System.out.println(weakReference.get());

        System.out.println("================");
    }
}
