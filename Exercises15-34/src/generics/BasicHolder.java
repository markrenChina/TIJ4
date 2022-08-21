package generics;

public class BasicHolder<T> {
    private T element;

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return element.getClass().getSimpleName();
    }
}
