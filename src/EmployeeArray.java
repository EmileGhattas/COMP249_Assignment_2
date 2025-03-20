public class EmployeeArray {
    private Employee[] employees;
    private int count;

    public EmployeeArray() {
        // Initial capacity is 100.
        employees = new Employee[100];
        count = 0;
    }

    public void add(Employee emp) {
        if (count == employees.length) {
            // Resize array by doubling its capacity.
            Employee[] temp = new Employee[employees.length * 2];
            for (int i = 0; i < employees.length; i++) {
                temp[i] = employees[i];
            }
            employees = temp;
        }
        employees[count] = emp;
        count++;
    }

    // Returns an array with exactly the number of valid Employee objects.
    public Employee[] getEmployees() {
        Employee[] result = new Employee[count];
        for (int i = 0; i < count; i++) {
            result[i] = employees[i];
        }
        return result;
    }

    public int size() {
        return count;
    }
}
