package com.lagou.dao.imp;

import com.lagou.bean.Student;
import com.lagou.bean.User;
import com.lagou.dao.StudentDao;
import com.lagou.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author baiaohou
 * @create 2020-08-31 8:46 PM
 */
public class StudentDaoImp implements StudentDao {

    /**
     * 获得所有学生
     * @return A list of all students
     */
    @Override
    public List<Student> getAllStudents() throws SQLException {
        // 1 创建QueryRunner对象，自动模式
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        // 2 准备sql语句
        String sql = "select * from t_student";
        // 3 查询操作，返回结果
        return queryRunner.query(sql, new BeanListHandler<Student>(Student.class));
    }

    /**
     * 根据学号查询学生
     * @param sid to be searched
     * @return Student to be searched
     */
    @Override
    public Student getStudentBySID(String sid) throws SQLException {
        // 1 创建QueryRunner对象，自动模式
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        // 2 准备sql语句
        String sql = "select * from t_student where sid = ?";
        // 3 查询操作，返回结果
        return queryRunner.query(sql, new BeanHandler<Student>(Student.class), sid);
    }

    /**
     * 添加学生
     * @param student to be added
     * @return Affected Row Number
     */
    @Override
    public int addStudent(Student student) throws SQLException {
        // 1 创建QueryRunner对象，自动模式
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        // 2 准备sql语句
        String sql = "insert into t_student values(?, ?, ?, ?, ?, ?)";
        // 3 插入操作，返回受影响行
        Object[] param = {student.getSid(), student.getSname(), student.getSex(),
                        student.getBirthday(), student.getEmail(), student.getNote()};
        return queryRunner.update(sql, param);
    }

    /**
     * 根据学生学号（sid）来删除学生
     * @param sid to me removed
     * @return Affected Row Number
     */
    @Override
    public int removeStudentBySID(String sid) throws SQLException {
        // 1 创建QueryRunner对象，自动模式
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        // 2 准备sql语句
        String sql = "delete from t_student where sid = ?";
        // 3 删除操作，返回受影响行
        return queryRunner.update(sql, sid);
    }

    /**
     * 根据学生学号（sid）来更新学生
     * @param student to be replaced
     * @return Affected Row Number
     * @throws SQLException
     */
    @Override
    public int updateStudentBySID(Student student) throws SQLException {
        // 1 创建QueryRunner对象，自动模式
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        // 2 准备sql语句
        String sql = "update t_student " +
                      "set sname = ?, " +
                            "sex = ?, " +
                            "birthday = ?, " +
                            "email = ?, " +
                            "note = ? " +
                            "where sid = ?";
        // 3 更新操作，返回受影响行
        Object[] param = { student.getSname(), student.getSex(),
                student.getBirthday(), student.getEmail(), student.getNote(),
                student.getSid()};
        return queryRunner.update(sql, param);
    }
}
