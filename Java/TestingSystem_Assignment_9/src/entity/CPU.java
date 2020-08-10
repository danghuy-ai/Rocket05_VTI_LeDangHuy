package entity;

public class CPU {

	public class Processor {
		private int coreAmount;
		private String manufacturer;

		public float getCache() {
			return 4.3f;
		}
	}

	public class Ram {
		private int memory;
		private String manufacturer;

		public float getClockSpeed() {
			return 5.5f;
		}
	}

}
