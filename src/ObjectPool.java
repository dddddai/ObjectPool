import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class ObjectPool<T> {

    private WeakReference<ConcurrentLinkedQueue<T>> poolRef;

    public abstract T generate();

    public T get(){
        T obj=getPool().poll();
        return obj==null ? generate():obj;
    }

    public void put(T object){
        getPool().offer(object);
    }

    private ConcurrentLinkedQueue<T> getPool(){
        ConcurrentLinkedQueue<T> pool=poolRef.get();
        if(pool==null){
            pool=new ConcurrentLinkedQueue<>();
            poolRef=new WeakReference<>(pool);
        }
        return pool;
    }
}
