package com.kish.jpa.tutorial;


import com.kish.jpa.tutorial.dao.manytomany.model.Student;
import com.kish.jpa.tutorial.dao.manytomany.model.Subject;
import com.kish.jpa.tutorial.dao.manytomany.service.StudentRepoService;
import com.kish.jpa.tutorial.dao.manytomany.service.SubjectRepoService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class JpaManytoManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaManytoManyApplication.class,args);
    }


    @Component
    class ManytomanyApplicationRunner implements ApplicationRunner{

        private final StudentRepoService studentRepository;
        private final SubjectRepoService subjectRepository;


        public ManytomanyApplicationRunner(StudentRepoService studentRepoService, SubjectRepoService subjectRepoService) {
            this.studentRepository = studentRepoService;
            this.subjectRepository = subjectRepoService;
        }

        @Transactional
        @Override
        public void run(ApplicationArguments args) throws Exception {
            Student jack = new Student("Jack");
            Student peter = new Student("Peter");

            Subject math = new Subject("Mathematics");
            Subject computer = new Subject("Computer");

		/*subjectRepository.save(math);
		subjectRepository.save(computer);*/

            Set<Subject> subjects = new HashSet<Subject>();
            subjects.add(math);
            subjects.add(computer);

            jack.setSubjects(subjects);
            peter.setSubjects(subjects);

            studentRepository.save(jack);
            studentRepository.save(peter);


            Set<Student> students = new HashSet<Student>();
            students.add(jack);
            students.add(peter);

            math.setStudents(students);
            computer.setStudents(students);

            subjectRepository.save(math);
            subjectRepository.save(computer);

            List<Student> studentLst = studentRepository.findAll();
            List<Subject> subLst = subjectRepository.findAll();

            System.out.println(studentLst.size());
            System.out.println(subLst.size());


            System.out.println("===================Students info:==================");
            studentLst.forEach(student->System.out.println(student.toString()));

            System.out.println("===================Students info:==================");
            subLst.forEach(subject->System.out.println(subject.toString()));
        }


    }
}
