package at.geyerritter.dezsys07.data;

import org.springframework.data.annotation.Id;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import static org.thymeleaf.util.Validate.*;

/**
 * This class contains the entity data.
 *
 * @author Stefan Geyer
 * @version 20151205.1
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "datarecord", propOrder = {
        "id",
        "name",
        "description"
})
public class DataRecord {

    static final int MAX_LENGTH_NAME = 100;
    static final int MAX_LENGTH_DESCRIPTION = 500;

    @Id
    @XmlElement(required = true)
    private String id;
    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private String description;

    public DataRecord() {
    }

    private DataRecord(Builder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.id = builder.id;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    @Override
    public String toString() {
        return "DataRecord{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public static class Builder {

        private String name;
        private String description;
        private String id;

        private Builder() {
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public DataRecord build() {
            DataRecord record = new DataRecord(this);

            checkRecordData();

            return record;
        }

        private void checkRecordData() {
            notNull(this.name, "Name cannot be null");
            notEmpty(this.name, "Name cannot be empty");
            isTrue(this.name.length() <= MAX_LENGTH_NAME, "Name cannot be longer than " + MAX_LENGTH_NAME + " characters");

            if (this.description != null) {
                isTrue(this.description.length() <= MAX_LENGTH_DESCRIPTION, "Description cannot be longer than " + MAX_LENGTH_DESCRIPTION + " characters");
            }
        }
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