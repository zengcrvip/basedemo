package demo.javaconcurrentshizhan.chap4.service;

import java.io.Serializable;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @Description:
 * @Author: changrong.zeng
 * @Date: Created in 17:59 2018/4/10 .
 */
public class Mutex implements Serializable {

    private static class Sync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if(getState() == 0){
                throw  new IllegalMonitorStateException();
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected int tryAcquireShared(int arg) {
            return super.tryAcquireShared(arg);
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            return super.tryReleaseShared(arg);
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState() == 1;
        }
    }

    private Sync sync = new Sync();

    public void lock(){
        sync.acquire(1);

    }

    public void unlock(){
        sync.release(1);

    }

    public boolean tryLock(){
       return sync.tryAcquire(1);
    }

    public boolean isLocked(){
        return sync.isHeldExclusively();
    }
}
