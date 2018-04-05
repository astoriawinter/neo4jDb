package astoria.entity;
import astoria.dummymaker.annotation.string.GenName;
import astoria.dummymaker.annotation.string.GenNick;
import astoria.dummymaker.annotation.string.GenTag;
import astoria.dummymaker.factory.IPopulateFactory;
import astoria.dummymaker.factory.impl.GenPopulateFactory;
import astoria.entity.relationships.CreationRelationship;
import astoria.entity.relationships.UploadRelationship;
import astoria.interfaces.Entity;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import java.util.HashSet;
import java.util.Set;
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
    private Set<CreationRelationship> pages = new HashSet<>();
    @Relationship(type = "UPLOADED")
    private Set<UploadRelationship> attachments = new HashSet<>();
    public Author() {
    }
    public void created(Author owner, Page page, Attachment attachment) {
        IPopulateFactory factory = new GenPopulateFactory();
        pages.add(factory.populate(new CreationRelationship(owner, this, page)));
        attachments.add(factory.populate(new UploadRelationship(owner, this, attachment)));
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
