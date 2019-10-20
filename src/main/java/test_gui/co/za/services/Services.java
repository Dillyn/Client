package test_gui.co.za.services;

import java.util.List;

public interface Services<E,ID> {

    public E findById(ID id);

    public E save(E entity);

    public E update(E entity);

    public void delete(ID id);

    public List<E> findAll();
}
