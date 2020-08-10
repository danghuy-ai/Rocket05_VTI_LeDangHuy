package entity;

public class Student {
	
	private static int idIncrement = 1;
	private int id;
	private String name;
	
	public Student(String name){
		this.id = idIncrement;
		this.name = name;
		idIncrement++;
	}
	
	/**
	 * @deprecated replaced by {@link #getIdStr()}
	 */
	public int getId() {
		return id;
	}
	
	public String getIdStr() {
		return "MSV: " + this.id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
}
