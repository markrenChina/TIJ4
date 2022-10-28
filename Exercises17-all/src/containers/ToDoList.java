package containers;

import java.util.PriorityQueue;

public class ToDoList extends PriorityQueue<ToDoList.ToDoItem> {

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.add("Empty trash",'C',4);
        toDoList.add("Feed dog",'A',2);
        toDoList.add("Feed bird",'B',7);
        toDoList.add("Mow lawn",'C',3);
        //...
        while (!toDoList.isEmpty()){
            System.out.println(toDoList.remove());
        }
    }

    public void add(String td, char pri, int sec) {
        super.add(new ToDoItem(td,pri,sec));
    }

    static class ToDoItem implements Comparable<ToDoItem> {
        private char primary;
        private int secondary;
        private String item;

        public ToDoItem(String td, char pri, int sec) {
            this.primary = pri;
            this.secondary = sec;
            this.item = td;
        }

        @Override
        public int compareTo(ToDoItem arg) {
            if (primary > arg.primary) {
                return  + 1;
            }
            if (primary == arg.secondary) {
                if (secondary > arg.secondary) {
                    return +1;
                }else if (secondary == arg.secondary) {
                    return 0;
                }
            }
            return -1;
        }

        @Override
        public String toString() {
            return Character.toString(primary) + secondary +": "+ item;
        }
    }
}
