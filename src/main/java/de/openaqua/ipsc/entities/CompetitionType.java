package de.openaqua.ipsc.entities;

public enum CompetitionType {

	SURTLW("SURT-LW"), SURTKW("SURT-KW"), IPSCHandgun("IPSC Handgun"), IPSCRifle("IPSC Rifle");

	private String text;

	CompetitionType(String text) {
		this.text = text;
	}

	public String getText() {
		return this.text;
	}

	public static CompetitionType fromString(String text) {
		for (CompetitionType b : CompetitionType.values()) {
			if (b.text.equalsIgnoreCase(text)) {
				return b;
			}
		}
		return null;
	}
}
