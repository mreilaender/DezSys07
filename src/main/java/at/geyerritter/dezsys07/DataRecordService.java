package at.geyerritter.dezsys07;

public interface DataRecordService {

    DataRecordDTO create(DataRecordDTO todo);

    DataRecordDTO delete(String name);

    DataRecordDTO findByName(String name);

    DataRecordDTO update(DataRecordDTO todo);

}
