package bank;

public class Employee {
	private String name;
	private String role;
	
	public Employee() {
		
	}

	public Employee(String name) {
		
		this.name = name;
		
	}
	
	public String getName() {
		return name;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void promoteToManager() {
		Manager manger = new Manager();
		this.setRole(manger.getRoleName());
		
	}
	
	public void promoteToCEO() throws CustomException {
		CEO ceo = new CEO();
		
		if(this.getRole() == null || !this.getRole().equals("Manager")) {
			throw new CustomException(this.getName());
		}else if(this.getRole().equals("Manager")) {
			this.setRole(ceo.getRoleName());
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		Employee emp1 = new Employee("Brian");
		Employee emp2 = new Employee("BLaze");
		
//		emp1.promoteToCEO();
//		System.out.println(emp1.getRole());
		emp1.promoteToManager();
		System.out.println("Role: " + emp1.getRole());
		emp1.promoteToCEO();
		System.out.println("Role: " + emp1.getRole());
		
		emp2.promoteToCEO();
		
		
		
	}
	
	
	
}
