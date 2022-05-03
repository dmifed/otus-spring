package hwsolution.service.create;

import hwsolution.domain.Student;

public interface Create {
    Student create(String firstName, String lastName);
    void close();
}
