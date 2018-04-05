package astoria.entity.relationships;

import astoria.entity.Author;
import astoria.entity.Page;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "CREATED")
public class CreationRelationship {
    public enum OwnerType{READ, MODIFY, ADMIN}
    @Id
    @GeneratedValue   private Long relationshipId;
    @StartNode Author author;
    @EndNode Page page;
    //@Property Author owner;
    //@Property OwnerType ownerType;
    public CreationRelationship(){}
    public CreationRelationship(Author author, Page page){
        this.author = author;
        this.page = page;
    }
}
