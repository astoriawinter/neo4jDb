package astoria.entity.relationships;

import astoria.dummymaker.annotation.string.GenOwnerType;
import astoria.entity.Author;
import astoria.entity.Page;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "OWN")
public class OwnRelationship {
    @Id
    @GeneratedValue
    private Long relationshipId;
    @StartNode Author author;
    @EndNode Page page;
    public OwnRelationship(){}
    public OwnRelationship(Author author, Page page){
        this.author = author;
        this.page = page;
    }
    public String getPageName(){
        return page.getName();
    }
}
