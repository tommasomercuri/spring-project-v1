package autoWiredV1.model.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class User {
    private String idUser;
    private String name;
    private String bornYear;

    public User(String name, String bornYear) {
        this.name = name;
        this.bornYear = bornYear;
    }
}
