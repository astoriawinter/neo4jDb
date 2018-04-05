package astoria.CRUD;
import astoria.entity.Attachment;
import astoria.entity.Author;
import astoria.entity.Page;
import astoria.interfaces.Entity;

public class AuthorCRUD extends GenericService<Author> {
    @Override
    public Author createOrUpdate(Author entity) {
        return super.createOrUpdate(entity);
    }

    @Override
    public Author find(Long id) {
        return super.find(id);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    public void link(Author author, Entity page, Entity attachment) {
        author.created((Page)page, (Attachment)attachment);
    }

    @Override
    Class<Author> getEntityType() {
        return Author.class;
    }
}
