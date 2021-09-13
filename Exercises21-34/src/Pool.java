import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * 信号量 Semaphore示例对象池
 * @param <T>
 */
public class Pool<T> {

    private int size;
    private List<T> items = new ArrayList<T>();
    //跟踪池中对象状态
    private volatile  boolean[] checkedOut;
    private Semaphore available;

    public Pool(Class<T> classObj,int size) {
        this.size = size;
        checkedOut = new boolean[size];
        available = new Semaphore(size,true);
        //Load pool with objects that can be checked out
        for (int i = 0; i < size; i++) {
            try {
                //Assumes a default constructor
                items.add(classObj.newInstance());
            }catch (Exception e){
                throw new RuntimeException(e);
            }
        }
    }

    //签出池中对象
    public T checkOut() throws InterruptedException {
        available.acquire();
        return getItem();
    }

    //交回对象，如果签入对象有效，往信号量添加一个许可证。
    public void checkIn(T x) {
        if (releaseItem(x)){
            available.release();
        }
    }

    private synchronized T getItem(){
        for (int i = 0; i < size; i++) {
            if (!checkedOut[i]){
                checkedOut[i] = true;
                return items.get(i);
            }
        }
        //Semaphore prevents reaching here
        return null;
    }

    private synchronized boolean releaseItem(T item) {
        int index = items.indexOf(item);
        if (index == -1) {
            //Not in the list
            return false;
        }
        if (checkedOut[index]) {
            checkedOut[index] = false;
            return true;
        }
        //Wasn't checked out
        return false;
    }
}
