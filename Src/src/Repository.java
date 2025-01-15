import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    private final List<T> repository;

    public Repository(List<T> repository) {
        this.repository = repository;
    }

    public Repository() {
        this.repository = new ArrayList();
    }

    public void addElement(T t) {
        this.repository.add(t);
    }

    public List<T> getAllElements() {
        return this.repository;
    }

    public T getElement(int index) {
        return this.repository.get(index);
    }

    public void updateElement(int index, T t) {
        this.repository.set(index, t);
    }

    public void remove(T t) {
        this.repository.remove(t);
    }
}
