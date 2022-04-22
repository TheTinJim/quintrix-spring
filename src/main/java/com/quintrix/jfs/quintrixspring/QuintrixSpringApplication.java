package com.quintrix.jfs.quintrixspring;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.quintrix.jfs.quintrixspring.entity.Employee;
import com.quintrix.jfs.quintrixspring.repository.EmployeeRepository;

@SpringBootApplication
public class QuintrixSpringApplication implements CommandLineRunner {

  @Autowired
  EmployeeRepository employeeRepository;

  public static void main(String[] args) {
    SpringApplication.run(QuintrixSpringApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    Optional<Employee> employee = employeeRepository.findById(1L);
    long countOfRecords = employeeRepository.count();
    if (employee.isPresent()) {
      System.out.println(employee.get());
    }
  }

}
