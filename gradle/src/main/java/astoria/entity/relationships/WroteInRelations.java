package astoria.entity.relationships;

import astoria.entity.Comment;
import astoria.entity.Page;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "WROTE_IN")
public class WroteInRelations {
    @Id
    @GeneratedValue
    private Long relationshipId;
    @StartNode Comment comment;
    @EndNode Page page;
    public WroteInRelations(){}
    public WroteInRelations(Comment comment, Page page){
        this.comment = comment;
        this.page = page;
    }
}
