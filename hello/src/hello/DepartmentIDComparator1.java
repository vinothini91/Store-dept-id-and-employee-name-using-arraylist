package hello;

import java.util.Comparator;

public class DepartmentIDComparator1 implements Comparator <Department> {

	@Override
	public int compare(Department o1, Department o2) {
		int result = o1.id.compareTo(o2.id);
		if (result > 0)
			return +1;

		else if (result < 0)
			return -1;
		else {
			int compare = o1.name.compareTo(o2.name);
			if (compare > 0) {
				return +1;
			} else if (compare < 0) {
				return -1;
			}

		}
		return 0;
	}

	
	
	
 }