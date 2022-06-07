package uz.pdp.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import uz.pdp.entity.ClassCom;

import java.util.List;

public class ClassRepositoryImpl implements ClassRepositoryC{

    JdbcTemplate jdbcTemplate;

    public ClassRepositoryImpl(DriverManagerDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int create(ClassCom classCom) {
        try {
            return jdbcTemplate.update("insert into comclass(name) values(?)",classCom.getName());
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public List<ClassCom> read() {
        return jdbcTemplate.query("select * from comclass", BeanPropertyRowMapper.newInstance(ClassCom.class));
    }

    @Override
    public ClassCom findStudentById(int classID) {
        return jdbcTemplate.queryForObject("select * from comclass where id = ?",BeanPropertyRowMapper.newInstance(ClassCom.class),classID);
    }

    @Override
    public ClassCom findStudentByEmail(String email) {
        return null;
    }

    @Override
    public ClassCom findStudentByCourse(String email) {
        return null;
    }

    @Override
    public int update(ClassCom classCom) {
        return jdbcTemplate.update("update comclass set name=? where id=?",classCom.getName(),classCom.getId());
    }

    @Override
    public int delete(int classID) {
        return jdbcTemplate.update("delete from comclass where id=?",classID);
    }
}
