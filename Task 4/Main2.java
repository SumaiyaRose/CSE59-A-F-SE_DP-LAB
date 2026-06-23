abstract class TeamMember {
    protected String name;
    
    public TeamMember(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}

interface BonusEligible {
    void calculateBonus();
}

class Employee extends TeamMember implements BonusEligible {
    
    public Employee(String name) {
        super(name);
    }
    
    public void calculateBonus() {
        System.out.println("Calculating standard employee bonus...");
    }
}

class Contractor extends TeamMember {
    
    public Contractor(String name) {
        super(name);
    }
    
    public void performWork() {
        System.out.println(name + "is working as a contractor.");
    }
}

public class Main {
    public static void main(String[] args) {
        
        Employee emp = new Employee("John");
        Contractor contractor = new Contractor("Alice");
        
        emp.calculateBonus();
        
        contractor.performWork();
        
        System.out.println("Employee: " + emp.getName());
        System.out.println("Contractor: " + contractor.getName());
    }
}
