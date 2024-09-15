package edu.mum.cs.cs425.studentmgmt;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import jakarta.persistence.*;

import java.util.Date;

public class StudentMgmtApp {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-persistence-unit");

    public static void main(String[] args) {
        Transcript transcript = new Transcript("BS Computer Science");
        Classroom classroom = new Classroom("McLaughlin building", "M105");
        Student student = new Student("000-61-0001", "Anna", "Smith", new Date());
        student.setTranscript(transcript);
        student.setClassroom(classroom);

        saveStudent(student);
    }

    public static void saveStudent(Student student) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(student);
            transaction.commit();
            System.out.println("Student saved successfully: " + student);

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
    }
}
