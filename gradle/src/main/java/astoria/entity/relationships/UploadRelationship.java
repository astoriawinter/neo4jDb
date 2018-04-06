package astoria.entity.relationships;

import astoria.dummymaker.annotation.string.GenOwnerType;
import astoria.entity.Attachment;
import astoria.entity.Author;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "UPLOADED")
public class UploadRelationship {
    @Id
    @GeneratedValue   private Long relationshipId;
    @StartNode Author author;
    @EndNode Attachment attachment;
    public UploadRelationship(){}
    public UploadRelationship(Author author, Attachment attachment){
        this.author = author;
        this.attachment = attachment;
    }
    public String getAttachmentName() {
        return attachment.getName();
    }
}
