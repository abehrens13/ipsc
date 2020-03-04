package de.openaqua.ipsc.landscape;

public enum VehicleType {
	CAR("CAR"), TRUCK("TRUCK"), BIKE("BIKE"), BYCICLE("BYCICLE");

	private String text;

	VehicleType(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public static VehicleType fromString(String text) throws UnknownEnumValueException {
		if (null == text) {
			return null;
		}

		for (VehicleType b : VehicleType.values()) {
			if (b.text.equalsIgnoreCase(text)) {
				return b;
			}
		}
		throw new UnknownEnumValueException("VehicleType: unknown value: " + text);
	}

}
