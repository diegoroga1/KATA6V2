package kata6.v2;

import kata6.*;

public interface Attribute<T,S> {
    S get(T item);
}
