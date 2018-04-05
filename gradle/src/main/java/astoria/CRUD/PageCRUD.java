package astoria.CRUD;

import astoria.entity.Attachment;
import astoria.entity.Page;
import astoria.entity.Space;
import astoria.interfaces.Entity;

public class PageCRUD extends GenericService<Page>{
    @Override
    Class<Page> getEntityType() {
        return Page.class;
    }

    @Override
    public void link(Page page, Entity attachment, Entity space, Entity linkedPage) {
        page.has((Attachment)attachment, (Space)space, (Page)linkedPage);
    }
}
