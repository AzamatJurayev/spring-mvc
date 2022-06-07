package uz.pdp.repository;

import uz.pdp.entity.Group;

import java.util.List;

public interface GroupRepository {
    public int create(Group student);

    public List<Group> read();

    public Group findStudentById(int studentId);

    public Group findStudentByEmail(String email);

    public Group findStudentByCourse(String email);

    public int update(Group student);

    public int delete(int studentId);
}
