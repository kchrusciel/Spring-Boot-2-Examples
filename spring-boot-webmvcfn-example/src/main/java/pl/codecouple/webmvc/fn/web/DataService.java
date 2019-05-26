package pl.codecouple.webmvc.fn.web;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
class DataService {

    List<String> getAll() {
        return Arrays.asList("Code", "Couple", "Rox");
    }

    List<String> getById(long id) {
        return Arrays.asList("Code", "Couple", "Rox");
    }

    void save(String stringToSave) {

    }

}