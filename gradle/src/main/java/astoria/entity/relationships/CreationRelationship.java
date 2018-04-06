package astoria.entity.relationships;

import astoria.dummymaker.annotation.string.GenOwnerType;
import astoria.entity.Author;
import astoria.entity.Page;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "CREATED")
public class CreationRelationship {
    @Id
    @GeneratedValue
    private Long relationshipId;
    @StartNode Author author;
    @EndNode Page page;
    public CreationRelationship(){}
    public CreationRelationship(Author author, Page page){
        this.author = author;
        this.page = page;
    }
    public String getPageName(){
        return page.getName();
    }
}
