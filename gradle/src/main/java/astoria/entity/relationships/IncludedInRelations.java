package astoria.entity.relationships;

import astoria.entity.Page;
import astoria.entity.Space;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "INCLUDED_IN")
public class IncludedInRelations {
    @Id
    @GeneratedValue
    private Long relationshipId;
    @StartNode Page page;
    @EndNode Space space;
    public IncludedInRelations(){}
    public IncludedInRelations(Page page, Space space){
        this.page = page;
        this.space = space;
    }
}
