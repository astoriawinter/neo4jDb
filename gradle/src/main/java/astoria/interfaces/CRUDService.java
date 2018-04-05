package astoria.interfaces;

public interface CRUDService<T> {
    Iterable<T> findAll();

    T find(Long id);

    void delete(Long id);

    T createOrUpdate(T object);

    void link(T object, Entity entity, Entity linked);

    void link(T object, Entity entity, Entity linked, Entity link);
}