package at.geyerritter.dezsys07;

import org.springframework.data.annotation.Id;

/**
 * This class contains the entity data.
 *
 * @author Stefan Geyer
 * @version 20151205.1
 */
public class DataRecord {

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
}
