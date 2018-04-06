package astoria.entity.relationships;

import astoria.entity.Author;
import astoria.entity.Page;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "COMMENTED")
public class CommentedRelationship {
    @Id
    @GeneratedValue
    private Long relationshipId;
    @StartNode Author author;
    @EndNode Page page;
    public CommentedRelationship(){}
    public CommentedRelationship(Author author, Page page){
        this.author = author;
        this.page = page;
    }
}
