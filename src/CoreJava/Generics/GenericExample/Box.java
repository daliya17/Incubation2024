package CoreJava.Generics.GenericExample;

class Box<T> {
    private T value; // T is a type parameter
    public Box(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Box{" + "value=" + value + '}';
    }
}

