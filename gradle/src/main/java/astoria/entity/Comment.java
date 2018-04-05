package astoria.entity;

import astoria.dummymaker.annotation.string.GenPhrase;
import astoria.entity.relationships.WroteInRelations;
import astoria.entity.relationships.WroteRelations;
import astoria.interfaces.Entity;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;
@NodeEntity
public class Comment implements Entity {
    @Id
    @GeneratedValue
    private Long id;
    @GenPhrase
    private String description;
    @Relationship(type = "WROTE_BY")
    private Set<WroteRelations> authors = new HashSet<>();
    @Relationship(type = "WROTE_IN")
    private Set<WroteInRelations> pages = new HashSet<>();

    public Comment() {
    }

    public void wrote(Author author, Page page) {
        authors.add(new WroteRelations(author, this));
        pages.add(new WroteInRelations(this, page));
    }

    @Override
    public Long getId() {
        return id;
    }
}
