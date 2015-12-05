package at.geyerritter.dezsys07;

import org.springframework.data.annotation.Id;

/**
 * This class contains the entity data.
 *
 * @author Stefan Geyer
 * @version 20151205.1
 */
public class DataRecord {

    static final int MAX_LENGTH_NAME = 100;
    static final int MAX_LENGTH_DESCRIPTION = 500;

    @Id
    private String id;

    private String name;
    private String description;

    public DataRecord() {}

    public DataRecord(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "DataRecord{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
