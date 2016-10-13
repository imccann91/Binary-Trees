public class Employee implements Comparable {

	private int acctID;
	private String firstName;
	private String lastName;
	private double salary;

	public Employee(int id, String lName, String fName, double amount) {
		acctID = id;
		lastName = lName;
		firstName = fName;
		salary = amount;
	}

	public int getID() {
		return acctID;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double amount) {
		salary = amount;
	}

	public String toString() {
		String aString = ("Account ID: " + acctID + "\n First Name: " + firstName + "\n Last Name: " + lastName + "\n Salary: " + salary);
		return aString;
	}

	public int compareTo(Object emp2) {
		Employee emp3 = (Employee) emp2;
		int flag = 0;
		if (this.acctID > emp3.getID())
			flag = -1;
		else
			flag = 1;

		return flag;
	}
}
