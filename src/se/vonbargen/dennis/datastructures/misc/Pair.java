package se.vonbargen.dennis.datastructures.misc;

/**
 * @author      Dennis von Bargen
 * @param <T1>  First data type
 * @param <T2>  Second data type
 */
public class Pair<T1, T2> {

    private T1 first;
    private T2 second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public void setFirst(T1 first) {
        this.first = first;
    }

    public T2 getSecond() { return second; }

    public void setSecond(T2 second) {
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (getFirst() != null ? !getFirst().equals(pair.getFirst()) : pair.getFirst() != null) return false;
        return getSecond() != null ? getSecond().equals(pair.getSecond()) : pair.getSecond() == null;
    }

    @Override
    public int hashCode() {
        int result = getFirst() != null ? getFirst().hashCode() : 0;
        result = 31 * result + (getSecond() != null ? getSecond().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first +
                ", second=" + second +
                '}';
    }
}
