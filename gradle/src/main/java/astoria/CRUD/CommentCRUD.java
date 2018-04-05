package astoria.CRUD;

import astoria.entity.Author;
import astoria.entity.Comment;
import astoria.entity.Page;
import astoria.interfaces.Entity;

public class CommentCRUD extends GenericService<Comment> {
    @Override
    Class<Comment> getEntityType() {
        return Comment.class;
    }

    @Override
    public void link(Comment comment, Entity authors, Entity pages) {
        comment.wrote((Author)authors, (Page)pages);
    }
}
