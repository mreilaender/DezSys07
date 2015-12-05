package at.geyerritter.dezsys07;

import java.util.List;

public interface DataRecordService {

    DataRecordDTO create(DataRecordDTO todo);

    DataRecordDTO delete(String id);

    DataRecordDTO findById(String id);

    DataRecordDTO findByName(String name);

    List<DataRecordDTO> findAll();

    DataRecordDTO update(DataRecordDTO todo);

}
