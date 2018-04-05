package astoria.entity.relationships;

import astoria.entity.Attachment;
import astoria.entity.Author;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "UPLOADED")
public class UploadRelationship {
    public enum OwnerType{READ, MODIFY, ADMIN}
    @Id
    @GeneratedValue   private Long relationshipId;
    @StartNode Author author;
    @EndNode Attachment attachment;
    //@Property Author owner;
    //@Property OwnerType ownerType;
    public UploadRelationship(){}
    public UploadRelationship(Author author, Attachment attachment){
        this.author = author;
        this.attachment = attachment;
    }
}
