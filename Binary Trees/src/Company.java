import java.io.*;

public class Company {

	public static String itrim(String source) {
		return source.replaceAll("\\b\\s{2,}\\b", " ");
	}

	public void menu(String inString) {

		TreeBag <Employee> tree = new TreeBag <Employee> ();

		inString = Company.itrim(inString);

		String[] split = inString.split(",|-| - | | -");
		//System.out.println(split[0]);

		switch (Integer.parseInt(split[0])) {
		case 1:
			try {
				BufferedReader in = new BufferedReader(new FileReader(split[1]));

				String str;
				while ((str = in.readLine()) != null) {
					str = Company.itrim(str);
					String[] lSplit = str.split(",|-| - | | -");

					Employee employee = new Employee(Integer.parseInt(lSplit[0]), lSplit[2], lSplit[1], Double.parseDouble(lSplit[3]));
					tree.add(employee);

				}
				in.close();
				tree.display(tree.getRoot());
			} catch (IOException e) {
			}

			break;

		case 2:
			Employee employee = new Employee(Integer.parseInt(split[1]), split[2], split[3], Double.parseDouble(split[4]));
			tree.add(employee);

			break;

		case 3:
			Employee tempEmployee = new Employee(Integer.parseInt(split[1]), null, null, 0.0);
			tree.remove(tempEmployee);
			break;

		case 4:
			Employee searchEmployee = new Employee(Integer.parseInt(split[1]), null, null, 0.0);
			searchEmployee = (Employee) tree.retrieveNode(searchEmployee, tree.getRoot());

			System.out.println(searchEmployee.toString());
			break;

		case 5:
			Employee updateEmployee = new Employee(Integer.parseInt(split[1]),
					null, null, 0.0);
			updateEmployee = (Employee) tree.retrieveNode(updateEmployee,
					tree.getRoot());

			if (updateEmployee != null) {
				updateEmployee.setSalary(Double.parseDouble(split[2]));
			}

			System.out.println(updateEmployee.toString());
			break;

		case 6:
			tree.display(tree.getRoot());
			break;

		case 7:
			break;
		}

	}
}
