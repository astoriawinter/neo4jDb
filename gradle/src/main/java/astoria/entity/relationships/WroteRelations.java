package astoria.entity.relationships;

import astoria.entity.Author;
import astoria.entity.Comment;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "WROTE_BY")
public class WroteRelations {
    @Id
    @GeneratedValue
    private Long relationshipId;
    @StartNode Author author;
    @EndNode Comment comment;
    public WroteRelations(){}
    public WroteRelations(Author author, Comment comment){
        this.author = author;
        this.comment = comment;
    }
}
