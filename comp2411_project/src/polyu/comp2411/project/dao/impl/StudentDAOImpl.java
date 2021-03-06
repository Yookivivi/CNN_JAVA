package polyu.comp2411.project.dao.impl;

import polyu.comp2411.project.dao.StudentDAO;
import polyu.comp2411.project.entity.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class StudentDAOImpl extends BaseDAO implements StudentDAO {
    private Student stu;
    private ResultSet rs;

    private ResultSet result;
    StudentDAOImpl(){
        super();
    }



    @Override
    public Student searchByID(int id) {
        String sql = "SELECT * FROM STUDENT WHERE STU_ID = ?";
        try{
            setPs(sql);
            getPs().setInt(1,id);
            rs = getPs().executeQuery();
            while(rs.next()){

                String name = rs.getString("STU_NAME");
                Student result = new Student(id,name);
                this.stu = result; //set the stu field as this.
                return result;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            closeConn();
            closeStatement();
            closePreparedStatement();
        }
        return null;
    }

    @Override
    public void addStudent(Student stu) {
        String sql = "INSERT INTO STUDENT VALUES(?,?)"; // parameter to be set later
        try {
            setPs(sql);
            //set parameter of sql
            getPs().setInt(1,stu.getId());
            getPs().setString(2,stu.getName());
            getPs().execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            // close resources used
            closeConn();
            closeStatement();
            closePreparedStatement();
        }
    }

    @Override
    public List<Student> searchByExam(Exam ex) {
        String sql = String.format("SELECT * FROM EXAM_LIST NATUAL JOIN STUDENT WHERE TEST_ID = ?");
        try{
            setPs(sql);
            getPs().setInt(1,ex.getTestId());
            List ans = new ArrayList<Student>();
            while(rs.next()){
                int id = rs.getInt("STU_ID");
                String name = rs.getString("STU_NAME");
                ans.add(new Student(id,name));
            }
            return ans;
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            // close resources used
            closeConn();
            closeStatement();
            closePreparedStatement();
        }
        return null;
    }

    @Override
    public List<Student> searchByClass(Classe cls) {
        String sql = String.format("SELECT * FROM STUDENT WHERE CLASS_NO = %d",cls.getClassNo());
        try{
            rs = getStmt().executeQuery(sql);
            List ans = new ArrayList<Student>();
            while(rs.next()){
                int id = rs.getInt("STU_ID");
                String name = rs.getString("STU_NAME");
                ans.add(new Student(id,name));

            }
            return ans;
        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            // close resources used
            closeConn();
            closeStatement();
            closePreparedStatement();
        }
        return null;
    }


}
