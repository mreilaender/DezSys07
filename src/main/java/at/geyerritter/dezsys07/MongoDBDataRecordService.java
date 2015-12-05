package at.geyerritter.dezsys07;

import org.springframework.beans.factory.annotation.Autowired;

public class MongoDBDataRecordService implements DataRecordService {

    private DataRecordRepository repository;

    @Autowired
    MongoDBDataRecordService(DataRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public DataRecordDTO create(DataRecordDTO todo) {
        return null;
    }

    @Override
    public DataRecordDTO delete(String name) {
        return null;
    }

    @Override
    public DataRecordDTO findByName(String name) {
        return null;
    }

    @Override
    public DataRecordDTO update(DataRecordDTO todo) {
        return null;
    }

    private DataRecordDTO convertToDTO(DataRecord record) {
        return new DataRecordDTO(record.getId(), record.getName(), record.getDescription());
    }
}
