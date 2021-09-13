package ex24;

import java.util.LinkedList;

public class SourceBuffer {
    LinkedList<Source> list = new LinkedList<Source>();
    int buffSize = 2;

    synchronized void offer(Source source){
        if (list.size() < buffSize) {
            list.addLast(source);
        }
    }

    synchronized Source pop(){
        if (!list.isEmpty()) {
            return list.pop();
        }else {
            return null;
        }
    }
}
