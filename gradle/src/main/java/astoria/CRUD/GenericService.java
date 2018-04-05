package astoria.CRUD;
;
import astoria.Neo4jSessionFactory;
import astoria.interfaces.*;
import org.neo4j.ogm.session.Session;


abstract class GenericService<T> implements CRUDService<T> {

    private static final int DEPTH_LIST = 0;
    private static final int DEPTH_ENTITY = 1;
    protected Session session = Neo4jSessionFactory.getInstance().getNeo4jSession();
    @Override
    public Iterable<T> findAll() {
        return session.loadAll(getEntityType(), DEPTH_LIST);
    }

    @Override
    public T find(Long id) {
        return session.load(getEntityType(), id, DEPTH_ENTITY);
    }

    @Override
    public void delete(Long id) {
        session.delete(session.load(getEntityType(), id));
    }

    @Override
    public T createOrUpdate(T entity) {
        if (entity instanceof Entity) {
            Entity e = (Entity)entity;
            session.save(entity, DEPTH_ENTITY);
            return find(e.getId());
        }
        return null;
    }
    @Override
    public void link(T object, Entity entity, Entity linked) {
    }

    @Override
    public void link(T object, T owner, Entity entity, Entity linked) {
    }

    @Override
    public void link(T object, Entity entity, Entity linked, Entity link) {
    }

    abstract Class<T> getEntityType();
}