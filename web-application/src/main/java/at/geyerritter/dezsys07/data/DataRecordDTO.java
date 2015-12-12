package at.geyerritter.dezsys07.data;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class DataRecordDTO {

    private String id;

    @NotEmpty
    @Size(max = DataRecord.MAX_LENGTH_NAME)
    private String name;

    @Size(max = DataRecord.MAX_LENGTH_DESCRIPTION)
    private String description;

    public DataRecordDTO(String id, String name, String description) {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public DataRecordDTO() {
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
