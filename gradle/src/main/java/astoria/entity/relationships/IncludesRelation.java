package astoria.entity.relationships;

import astoria.entity.Attachment;
import astoria.entity.Page;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "INCLUDES")
public class IncludesRelation {
    @Id
    @GeneratedValue
    private Long relationshipId;
    @StartNode Page page;
    @EndNode Attachment attachment;
    public IncludesRelation(){}
    public IncludesRelation(Page page, Attachment attachment){
        this.page = page;
        this.attachment = attachment;
    }
    public String getAttachmentName() {
        return attachment.getName(); }
}
