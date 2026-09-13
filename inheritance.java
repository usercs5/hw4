public class PayrollDriver {
    public static void main(String[] args) {
        // Instantiate and populate array of Employee objects with table data
        Employee[] employees = new Employee[7];

        employees[0] = new SalariedEmployee("Joe", "Jones", "111-11-1111", 2500.00);
        employees[1] = new HourlyEmployee("Stephanie", "Smith", "222-22-2222", 25.00, 32.0);
        employees[2] = new HourlyEmployee("Mary", "Quinn", "333-33-3333", 19.00, 47.0);
        employees[3] = new CommisionEmployee("Nicole", "Dior", "444-44-4444", 0.15, 50000.00);
        employees[4] = new SalariedEmployee("Renwa", "Chanel", "555-55-5555", 1700.00);
        employees[5] = new BaseEmployee("Mike", "Davenport", "666-66-6666", 95000.00);
        employees[6] = new CommisionEmployee("Mahnaz", "Vaziri", "777-77-7777", 0.22, 40000.00);

        // Display populated information
        for (Employee emp : employees) {
            System.out.println("--------------------------------------------------");
            System.out.println("Name: " + emp.getFirstName() + " " + emp.getLastName());
            System.out.println("SSN:  " + emp.getSocialSecurityNumber());
            
            if (emp instanceof SalariedEmployee) {
                System.out.println("Type: Salaried Employee");
                System.out.println("Weekly Salary: $" + ((SalariedEmployee) emp).getWeeklySalary());
            } else if (emp instanceof HourlyEmployee) {
                HourlyEmployee h = (HourlyEmployee) emp;
                System.out.println("Type: Hourly Employee");
                System.out.println("Wage: $" + h.getWage() + " | Hours Worked: " + h.getHoursWorked());
            } else if (emp instanceof BaseEmployee) {
                BaseEmployee b = (BaseEmployee) emp;
                System.out.println("Type: Base Employee");
                System.out.println("Base Salary: $" + b.getBaseSalary());
            } else if (emp instanceof CommisionEmployee) {
                CommisionEmployee c = (CommisionEmployee) emp;
                System.out.println("Type: Commission Employee");
                System.out.println("Commission Rate: " + (c.getCommissionRate() * 100) + "% | Gross Sales: $" + c.getGrossSales());
            }
        }
        System.out.println("--------------------------------------------------");
    }
}

class Employee {
    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    public Employee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }
}

class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, double weeklySalary) {
        super(firstName, lastName, socialSecurityNumber);
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }
}

class HourlyEmployee extends Employee {
    private double wage;
    private double hoursWorked;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, double wage, double hoursWorked) {
        super(firstName, lastName, socialSecurityNumber);
        this.wage = wage;
        this.hoursWorked = hoursWorked;
    }


public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}

class CommisionEmployee extends Employee {
    private double commissionRate;
    private double grossSales;

    public CommisionEmployee(String firstName, String lastName, String socialSecurityNumber, double commissionRate, double grossSales) {
        super(firstName, lastName, socialSecurityNumber);
        this.commissionRate = commissionRate;
        this.grossSales = grossSales;
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionRate = commissionRate;
    }

    public double getGrossSales() {
        return grossSales;
    }

    public void setGrossSales(double grossSales) {
        this.grossSales = grossSales;
    }
}

class BaseEmployee extends CommisionEmployee {
    private double baseSalary;

    public BaseEmployee(String firstName, String lastName, String socialSecurityNumber, double commissionRate, double grossSales, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, commissionRate, grossSales);
        this.baseSalary = baseSalary;
    }

    public BaseEmployee(String firstName, String lastName, String socialSecurityNumber, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, 0.0, 0.0);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}