package astoria.entity.relationships;

import astoria.entity.Page;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "LINKED")
public class LinksRelations {
    @Id
    @GeneratedValue
    private Long relationshipId;
    @StartNode Page page;
    @EndNode Page pages;
    public LinksRelations(){}
    public LinksRelations(Page one, Page two){
        page = one;
        pages = two;
    }
    public String getPageName(){
        return pages.getName();
    }
}
