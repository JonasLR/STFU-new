package server.utility;

import org.apache.ibatis.jdbc.Null;
import server.models.Student;

//Kan lagre current students i server RAM'et.
public class CurrentStudentContext {

    private Student currentStudent;

    public Student getCurrentStudent() {
        return currentStudent;
    }

    public void setCurrentStudent(Student currentStudent){
        this.currentStudent = currentStudent;
    }
}