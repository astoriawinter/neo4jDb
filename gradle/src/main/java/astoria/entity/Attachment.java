package astoria.entity;

import astoria.dummymaker.annotation.string.GenName;
import astoria.dummymaker.annotation.time.GenDate;
import astoria.interfaces.Entity;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import astoria.dummymaker.annotation.string.GenPhrase;
import java.util.Date;

@NodeEntity
public class Attachment implements Entity {
    @Override
    public Long getId() {
        return id;
    }

    public enum FileType {IMAGE, AUDIO, VIDEO}
    @Id
    @GeneratedValue
    private Long id;
    @GenName
    private String filename;
    private FileType fileType = FileType.IMAGE;
    @GenPhrase
    private String description;
    @GenDate
    private Date creationTime;
    @GenDate
    private Date modificationTime;
    public Attachment() {
    }
}
