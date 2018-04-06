package astoria.entity;

import astoria.dummymaker.annotation.string.GenPageName;
import astoria.dummymaker.annotation.string.GenPhrase;
import astoria.dummymaker.annotation.time.GenDate;
import astoria.entity.relationships.IncludedInRelations;
import astoria.entity.relationships.IncludesRelation;
import astoria.entity.relationships.LinksRelations;
import astoria.interfaces.Entity;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Page implements Entity {
    @Id
    @GeneratedValue
    private Long id;
    @GenPageName
    private String name;
    @GenPhrase
    private String content;
    @GenDate
    private Date creationTime;
    @GenDate
    private Date modificationTime;
    @Relationship(type = "LINKED")
    private Set<LinksRelations> pages = new HashSet<>();
    @Relationship(type = "INCLUDES")
    private Set<IncludesRelation> attachments = new HashSet<>();
    @Relationship(type = "INCLUDED_IN")
    private Set<IncludedInRelations> spaces = new HashSet<>();
    public Page() {
    }
    public void addSpace(Space space){
        spaces.add(new IncludedInRelations(this, space));
    }
    public void addAttachment(Attachment attachment){
        attachments.add(new IncludesRelation(this, attachment));
    }
    public void addPage(Page page) {
        pages.add(new LinksRelations(this, page));
    }

    @Override
    public Long getId() {
        return id;
    }
}
