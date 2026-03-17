package com.example.HQLDemo;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class App {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        /* -------------------------------
           1. Named Parameter Example
        -------------------------------- */
        Query<Student> q1 = session.createQuery(
                "FROM Student WHERE department = :dept", Student.class);
        q1.setParameter("dept", "CSE");

        List<Student> list1 = q1.list();
        System.out.println("Students from CSE:");
        for (Student s : list1) {
            System.out.println(s.getName());
        }

        /* -------------------------------
           2. Positional Parameter Example
        -------------------------------- */
        Query<Student> q2 = session.createQuery(
                "FROM Student WHERE marks > ?0", Student.class);
        q2.setParameter(0, 70);

        List<Student> list2 = q2.list();
        System.out.println("\nStudents with marks > 70:");
        for (Student s : list2) {
            System.out.println(s.getName());
        }

        /* -------------------------------
           3. Aggregate Function Example
        -------------------------------- */
        Query<Long> q3 = session.createQuery(
                "SELECT count(s.id) FROM Student s", Long.class);

        Long count = q3.uniqueResult();
        System.out.println("\nTotal Students: " + count);

        /* -------------------------------
           4. Sorting Example
        -------------------------------- */
        Query<Student> q4 = session.createQuery(
                "FROM Student ORDER BY marks DESC", Student.class);

        List<Student> sortedList = q4.list();
        System.out.println("\nStudents Sorted by Marks:");
        for (Student s : sortedList) {
            System.out.println(s.getName() + " - " + s.getMarks());
        }

        /* -------------------------------
           5. Pagination Example
        -------------------------------- */
        Query<Student> q5 = session.createQuery(
                "FROM Student ORDER BY id", Student.class);
        q5.setFirstResult(0);
        q5.setMaxResults(3);

        List<Student> pageList = q5.list();
        System.out.println("\nFirst 3 Students:");
        for (Student s : pageList) {
            System.out.println(s.getName());
        }

        /* -------------------------------
           6. HCQL (Criteria API) Example
        -------------------------------- */
        Criteria c = session.createCriteria(Student.class);
        c.add(Restrictions.gt("marks", 80));

        List<Student> criteriaList = c.list();
        System.out.println("\nHCQL (Criteria) - Marks > 80:");
        for (Student s : criteriaList) {
            System.out.println(s.getName());
        }

        tx.commit();
        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}

