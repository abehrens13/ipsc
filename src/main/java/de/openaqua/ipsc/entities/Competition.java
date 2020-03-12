package de.openaqua.ipsc.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import de.openaqua.ipsc.types.CompetitionType;
import de.openaqua.ipsc.types.CountryType;
import de.openaqua.ipsc.types.DevisionType;
import de.openaqua.ipsc.types.OpenType;

@Document("Competitions")
public class Competition {
	@Id
	public String id;

	@NotNull
	public CompetitionType competitionType;

	@NotNull
	public List<DevisionType> devisionType;

	@NotNull
	public CountryType country;

	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	public Date dateStart;

	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	public Date dateEnd;

	public String level;

	public int stages;

	public int bulletCounts;

	public String title;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	public Date regOpen;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	public Date regClose;

	public int berths;

	public OpenType openFor;

	public Competition() {
		super();
		devisionType = new ArrayList<DevisionType>();
		this.competitionType = CompetitionType.IPSCHandgun;
		this.country = CountryType.DE;
		this.openFor = OpenType.CLUB;
	}

}
