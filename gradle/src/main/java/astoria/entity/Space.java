package astoria.entity;

import astoria.dummymaker.annotation.string.GenName;
import astoria.dummymaker.annotation.string.GenSpaceType;
import astoria.dummymaker.annotation.time.GenDate;
import astoria.interfaces.Entity;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import java.util.Date;

@NodeEntity
public class Space implements Entity {
    @Id
    @GeneratedValue
    private Long id;
    @GenSpaceType
    private String filename;
    private String description;
    @GenDate
    private Date creationTime;
    @GenDate
    private Date modificationTime;
    public Space() {
    }

    @Override
    public Long getId() {
        return id;
    }
}
