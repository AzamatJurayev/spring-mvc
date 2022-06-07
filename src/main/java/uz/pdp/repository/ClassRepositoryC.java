package uz.pdp.repository;

import uz.pdp.entity.ClassCom;

import java.util.List;

public interface ClassRepositoryC {
    public int create(ClassCom student);

    public List<ClassCom> read();

    public ClassCom findStudentById(int studentId);

    public ClassCom findStudentByEmail(String email);

    public ClassCom findStudentByCourse(String email);

    public int update(ClassCom student);

    public int delete(int studentId);
}
