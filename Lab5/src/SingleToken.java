/**
 * Defines a single-symbol token
 */
public abstract class SingleToken extends Token{
    protected char l;   //Char symbol that is contained inside token

    @Override
    public String toString() {
        return (Character.toString(l));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SingleToken that = (SingleToken) o;

        return l == that.l;
    }

    @Override
    public int hashCode() {
        return l;
    }
}
