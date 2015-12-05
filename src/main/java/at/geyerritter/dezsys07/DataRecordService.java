package at.geyerritter.dezsys07;

public interface DataRecordService {

    DataRecordDTO create(DataRecordDTO todo);

    DataRecordDTO delete(String id);

    DataRecordDTO findById(String id);

    DataRecordDTO findByName(String name);

    DataRecordDTO update(DataRecordDTO todo);

}
