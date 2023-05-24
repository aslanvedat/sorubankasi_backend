package proje.sorubankasi.service;

import proje.sorubankasi.dto.request.TestRequestDTO;
import proje.sorubankasi.entity.Test;

public interface TestService {
    Test saveTest(TestRequestDTO testRequestDTO);

   Test deleteById(long test_id);
}
