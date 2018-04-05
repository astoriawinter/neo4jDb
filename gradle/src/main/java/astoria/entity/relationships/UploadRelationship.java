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
    @Property String owner;
    @GenOwnerType
    @Property String ownerType;
    public UploadRelationship(){}
    public UploadRelationship(Author author, Author owner, Attachment attachment){
        this.author = author;
        this.attachment = attachment;
        this.owner = owner.toString();
    }
}
