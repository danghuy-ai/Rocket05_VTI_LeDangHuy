package entity;

public class Car {
	
	private String name;
	private String type;
	private Engine engine;
	
	public class Engine {
		private String engineType;
		
		public Engine(String engineType) {
			this.engineType = engineType;
		}

		public String getEngineType() {
			return engineType;
		}

		public void setEngineType(String engineType) {
			this.engineType = engineType;
		}
	}

	public Car(String name, String type, String engineType) {
		this.name = name;
		this.type = type;
		engine = new Engine(engineType);
	}

	@Override
	public String toString() {
		return "Car [name = " + name + ", type = " + type + ", Engine Type: " + engine.getEngineType() + "]";
	}

}
