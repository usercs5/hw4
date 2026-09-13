import java.util.ArrayList;

public class PayableDriver {
    public static void main(String[] args) {
        // 1. Create an ArrayList of Payable objects and populate with data
        ArrayList<Payable> payableList = new ArrayList<>();

        payableList.add(new Freelancer("Alice", "Johnson", 40.0, 45.0)); // Overtime hours included
        payableList.add(new Freelancer("Bob", "Smith", 30.0, 35.0));    // Standard hours
        payableList.add(new VendorInvoice("Office Depot", "INV-1001", 250.50));
        payableList.add(new VendorInvoice("Tech Solutions", "INV-2002", 1200.00));

        double totalPayout = 0.0;

        System.out.println("==================================================");
        System.out.println("             PAYABLE PROCESSING SYSTEM            ");
        System.out.println("==================================================");

        // 2. Loop through the collection
        for (Payable item : payableList) {
            // Call print() using type checking / casting since print is defined in the classes
            if (item instanceof Freelancer) {
                ((Freelancer) item).print();
            } else if (item instanceof VendorInvoice) {
                ((VendorInvoice) item).print();
            }

            // Accumulate total payout
            totalPayout += item.calculatePayment();
            System.out.println("--------------------------------------------------");
        }

        // 3. Display the total payout after the loop
        System.out.printf("Total Payout for the Period: $%.2f%n", totalPayout);
        System.out.println("==================================================");
    }
}

// Payable Interface
interface Payable {
    double calculatePayment();
    String getPayeeName();
}

// CLASS 1: Freelancer
class Freelancer implements Payable {
    private String firstName;
    private String lastName;
    private double hourlyRate;
    private double hoursWorked;

    // Constructor
    public Freelancer(String firstName, String lastName, double hourlyRate, double hoursWorked) {
        this.firstName = firstName;
        this.lastName = lastName;
        setHourlyRate(hourlyRate);
        setHoursWorked(hoursWorked);
    }

    // Getters and Setters with Validation
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        if (hourlyRate >= 0) {
            this.hourlyRate = hourlyRate;
        } else {
            throw new IllegalArgumentException("Hourly rate cannot be negative.");
        }
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        if (hoursWorked >= 0) {
            this.hoursWorked = hoursWorked;
        } else {
            throw new IllegalArgumentException("Hours worked cannot be negative.");
        }
    }

    @Override
    public String getPayeeName() {
        return firstName + " " + lastName;
    }

    @Override
    public double calculatePayment() {
        if (hoursWorked <= 40) {
            return hourlyRate * hoursWorked;
        } else {
            // Regular pay for 40 hours + 1.5x overtime pay for hours over 40
            double regularPay = 40 * hourlyRate;
            double overtimePay = (hoursWorked - 40) * hourlyRate * 1.5;
            return regularPay + overtimePay;
        }
    }

    public void print() {
        System.out.println("Type: Freelancer");
        System.out.println("Name: " + getPayeeName());
        System.out.printf("Calculated Payment: $%.2f%n", calculatePayment());
    }
}

// CLASS 2: VendorInvoice
class VendorInvoice implements Payable {
    private String vendorName;
    private String invoiceNumber;
    
    private double amountDue;

    // Constructor
    public VendorInvoice(String vendorName, String invoiceNumber, double amountDue) {
        this.vendorName = vendorName;
        this.invoiceNumber = invoiceNumber;
        setAmountDue(amountDue);
    }

    // Getters and Setters with Validation
    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        if (amountDue >= 0) {
            this.amountDue = amountDue;
        } else {
            throw new IllegalArgumentException("Amount due cannot be negative.");
        }
    }

    @Override
    public String getPayeeName() {
        return vendorName;
    }

    @Override
    public double calculatePayment() {
        return amountDue;
    }

    public void print() {
        System.out.println("Type: Vendor Invoice");
        System.out.println("Vendor Name: " + vendorName);
        System.out.println("Invoice Number: " + invoiceNumber);
        System.out.printf("Calculated Payment: $%.2f%n", calculatePayment());
    }
}