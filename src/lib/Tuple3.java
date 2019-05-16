
package lib;

/**
 *
 * @author dpf
 * @param <X>
 * @param <Y>
 * @param <Z>
 */
public class Tuple3< X, Y, Z> {

    public final X x;
    public final Y y;
    public final Z z;

    public Tuple3(X x, Y y, Z z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object obj) {
        Tuple3 t = (Tuple3) obj;
        return this.x.equals(t.x) && this.y.equals(t.y) && this.z.equals(t.z);
    }

}
