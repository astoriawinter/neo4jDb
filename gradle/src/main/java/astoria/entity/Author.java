package astoria.entity;
import astoria.dummymaker.annotation.string.GenName;
import astoria.dummymaker.annotation.string.GenNick;
import astoria.dummymaker.annotation.string.GenTag;
import astoria.dummymaker.factory.IPopulateFactory;
import astoria.dummymaker.factory.impl.GenPopulateFactory;
import astoria.entity.relationships.CommentedRelationship;
import astoria.entity.relationships.CreationRelationship;
import astoria.entity.relationships.OwnRelationship;
import astoria.entity.relationships.UploadRelationship;
import astoria.interfaces.Entity;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

@NodeEntity
public class Author implements Entity {
    @Id
    @GeneratedValue
    private Long id;
    @GenName
    private String name;
    @GenNick
    private String login;
    @GenTag
    private String status;
    @Relationship(type = "CREATED")
    private Set<CreationRelationship> pageCreated = new HashSet<>();
    @Relationship(type = "COMMENTED")
    private Set<CommentedRelationship> pageCommented = new HashSet<>();
    @Relationship(type = "OWN")
    private Set<OwnRelationship> pageOwn = new HashSet<>();
    @Relationship(type = "UPLOADED")
    private Set<UploadRelationship> attachments = new HashSet<>();
    private static final IPopulateFactory factory = new GenPopulateFactory();
    public Author() {
    }
    public void setPageCreated(Page page) {
        pageCreated.add(factory.populate(new CreationRelationship(this, page)));
    }
    public void setOwner(Page page) {
        pageOwn.add(factory.populate(new OwnRelationship(this, page)));
    }
    public void setPageCommented(Page page) {
        pageCommented.add(factory.populate(new CommentedRelationship(this, page)));
    }
    public void setAttachment(Attachment attachment) {
        attachments.add(factory.populate(new UploadRelationship(this, attachment)));
    }
    public void removePageCreated(Page page){
        Predicate<CreationRelationship> predicate =  p -> p.getPageName().equals(page.getName());
        pageCreated.removeIf(predicate);
    }
    public void removePageAttachment(Attachment attachment){
        Predicate<UploadRelationship> predicate =  p -> p.getAttachmentName().equals(attachment.getName());
        attachments.removeIf(predicate);
    }
    public void removePageOwner(Page page){
        Predicate<OwnRelationship> predicate =  p -> p.getPageName().equals(page.getName());
        pageOwn.removeIf(predicate);
    }
    public void removePageCommented(Page page){
        Predicate<CommentedRelationship> predicate =  p -> p.getPageName().equals(page.getName());
        pageCommented.removeIf(predicate);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
