package test_gui.co.za.rest;

import java.util.List;

public interface RestAPI<E, ID> {
    E get(ID id);

    E post(E entity);

    E put(E entity);

    void delete(ID id);

    List<E> getAll();

}
