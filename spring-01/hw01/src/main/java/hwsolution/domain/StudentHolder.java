package hwsolution.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class StudentHolder {
    @Getter
    private static final List<Student> students = new ArrayList<>();
}
