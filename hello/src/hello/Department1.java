package hello;



	public class Department {

		
		String id;
		String name;

		public String toString() {
			return " " + this.id + " " + this.name;

		}

		public Department(String id, String name) {

			this.id = id;
			this.name = name;
		}

	}
}
