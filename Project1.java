// Employee details tracking System 
import java.util.*;

class Employee {
    int empNo;
    String empName;
    String joinDate;
    char desigCode;
    String department;
    int basic;
    int hra;
    int it;

    Employee(int empNo, String empName, String joinDate, char desigCode,
             String department, int basic, int hra, int it) {
        this.empNo = empNo;
        this.empName = empName;
        this.joinDate = joinDate;
        this.desigCode = desigCode;
        this.department = department;
        this.basic = basic;
        this.hra = hra;
        this.it = it;
    }
}

class Designation {
    char desigCode;
    String designation;
    int da;

    Designation(char desigCode, String designation, int da) {
        this.desigCode = desigCode;
        this.designation = designation;
        this.da = da;
    }
}

public class Project1 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide Employee Number as a command-line argument.");
            return;
        }

        int empNoToSearch = Integer.parseInt(args[0]);

        Employee[] employees = {
            new Employee(1001, "Ashish", "01/04/2009", 'e', "R&D", 20000, 8000, 3000),
            new Employee(1002, "Sushma", "23/08/2012", 'c', "PM", 30000, 12000, 9000),
            new Employee(1003, "Rahul",  "12/11/2008", 'k', "Acct", 10000, 8000, 1000),
            new Employee(1004, "Chahat", "29/01/2013", 'r', "Front Desk", 12000, 6000, 2000),
            new Employee(1005, "Ranjan", "16/07/2005", 'm', "Engg", 50000, 20000, 20000),
            new Employee(1006, "Suman",  "01/01/2000", 'e', "Manufacturing", 23000, 9000, 4400),
            new Employee(1007, "Tanmay", "12/06/2006", 'c', "PM", 29000, 12000, 10000)
        };

        Designation[] designations = {
            new Designation('e', "Engineer", 20000),
            new Designation('c', "Consultant", 32000),
            new Designation('k', "Clerk", 12000),
            new Designation('r', "Receptionist", 15000),
            new Designation('m', "Manager", 40000)
        };

        Employee foundEmp = null;
        for (Employee emp : employees) {
            if (emp.empNo == empNoToSearch) {
                foundEmp = emp;
                break;
            }
        }

        if (foundEmp == null) {
            System.out.println("There is no employee with empid : " + empNoToSearch);
            return;
        }

        String designationName = "";
        int da = 0;
        for (Designation desig : designations) {
            if (desig.desigCode == foundEmp.desigCode) {
                designationName = desig.designation;
                da = desig.da;
                break;
            }
        }

        int salary = foundEmp.basic + foundEmp.hra + da - foundEmp.it;

        System.out.printf("%-8s %-10s %-15s %-15s %s\n", 
                "Emp No", "Emp Name", "Department", "Designation", "Salary");
        System.out.printf("%-8d %-10s %-15s %-15s %d\n",
                foundEmp.empNo, foundEmp.empName, foundEmp.department,
                designationName, salary);
    }
}

