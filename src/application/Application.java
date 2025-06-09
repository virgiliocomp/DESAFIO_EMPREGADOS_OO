package application;

import entities.Address;
import entities.Department;
import entities.Employee;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        Department department = new Department();
        Address address = new Address();

        String departmentName;
        int departmentPayDay;
        String addressMail;
        String addressPhone;
        int departmentWorkersQuantity;

//        [TIP]   public Department(String name, int payDay, Address address) {
//        this.name = name;
//        this.payDay = payDay;
//        this.address = address;
//    }

//    public Address(String email, String phone) {
//        this.email = email;
//        this.phone = phone;
//    }

//    public Employee(String name, double salary) {
//        this.name = name;
//        this.salary = salary;
//    }


        System.out.print("Nome do departamento: ");
        departmentName = scanner.nextLine();

        System.out.print("Dia do pagamento: ");
        departmentPayDay = scanner.nextInt();

        System.out.print("Email: ");
        addressMail = scanner.next();
        address.setEmail(addressMail);

        System.out.print("Telefone: ");
        addressPhone = scanner.next();
        address.setPhone(addressPhone);

        department.setName(departmentName);
        department.setPayDay(departmentPayDay);
        department.setAddress(address);

        System.out.print("Quantos funcionários tem o departamento? ");
        departmentWorkersQuantity = scanner.nextInt();

        for (int i = 0; i < departmentWorkersQuantity; i++) {
            String workerName;
            double workerSalary;

            System.out.println("Dados do funcionário " + (i + 1) + ":");
            scanner.nextLine();
            System.out.print("Nome: ");
            workerName = scanner.nextLine();
            System.out.print("Salário: ");
            workerSalary = scanner.nextDouble();

            department.addEmployee(new Employee(workerName, workerSalary));
        }

        showReport(department);
        scanner.close();

    }

    private static void showReport(Department dept) {
        DecimalFormat df = new DecimalFormat("#.00");

        System.out.println("\nFOLHA DE PAGAMENTO:");
        System.out.print("Departamento " + dept.getName() + " = R$ " + df.format(dept.payroll()));
        System.out.print("\nPagamento realizado no dia " +dept.getPayDay());
        System.out.println("\nFuncionários:");
        for (Employee employee : dept.getEmployees()){
            System.out.println(employee.getName());
        }
        System.out.print("Para dúvidas favor entrar em contato: " + dept.getAddress().getEmail());
    }
}
