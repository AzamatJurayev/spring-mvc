package uz.pdp.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import uz.pdp.entity.Group;
import uz.pdp.entity.Group;

import java.util.List;

public class GroupRepositoryImpl implements GroupRepository{
    JdbcTemplate jdbcTemplate;

    public GroupRepositoryImpl(DriverManagerDataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public int create(Group groupId) {
        try {
            return jdbcTemplate.update("insert into comgroup(name,clas_id) values(?,?)",groupId.getName(),groupId.getClasId());
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public List<Group> read() {
        return jdbcTemplate.query("select * from comgroup", BeanPropertyRowMapper.newInstance(Group.class));
    }

    @Override
    public Group findStudentById(int classID) {
        return jdbcTemplate.queryForObject("select * from comgroup where id = ?",BeanPropertyRowMapper.newInstance(Group.class),classID);
    }

    @Override
    public Group findStudentByEmail(String email) {
        return null;
    }

    @Override
    public Group findStudentByCourse(String email) {
        return null;
    }

    @Override
    public int update(Group groupId) {
        return jdbcTemplate.update("update comgroup set name=?,clas_id=? where id=?",groupId.getName(),groupId.getClasId(),groupId.getId());
    }

    @Override
    public int delete(int classID) {
        return jdbcTemplate.update("delete from comgroup where id=?",classID);
    }
}
