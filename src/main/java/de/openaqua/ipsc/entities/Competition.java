package de.openaqua.ipsc.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import de.openaqua.ipsc.types.CompetitionType;
import de.openaqua.ipsc.types.DevisionType;
import de.openaqua.ipsc.types.OpenType;

@Document("Competitions")
public class Competition implements IDocument {
	@Id
	private String id;

	private CompetitionType competitionType;

	private List<DevisionType> devisionType;

	private String country;

	@DateTimeFormat(iso = ISO.DATE)
	private Date dateStart;

	@DateTimeFormat(iso = ISO.DATE)
	private Date dateEnd;

	private String level;

	private int stages;

	private int bulletCounts;

	private String title;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date regOpen;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date regClose;

	private int berths;

	private OpenType openFor;

	public Competition() {
		super();
		devisionType = new ArrayList<>();
		this.competitionType = CompetitionType.IPSCHandgun;
		this.country = "DE";
		this.openFor = OpenType.CLUB;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CompetitionType getCompetitionType() {
		return competitionType;
	}

	public void setCompetitionType(CompetitionType competitionType) {
		this.competitionType = competitionType;
	}

	public List<DevisionType> getDevisionType() {
		return devisionType;
	}

	public void setDevisionType(List<DevisionType> devisionType) {
		this.devisionType = devisionType;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getDateStart() {
		return dateStart;
	}

	public void setDateStart(Date dateStart) {
		this.dateStart = dateStart;
	}

	public Date getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Date dateEnd) {
		this.dateEnd = dateEnd;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public int getStages() {
		return stages;
	}

	public void setStages(int stages) {
		this.stages = stages;
	}

	public int getBulletCounts() {
		return bulletCounts;
	}

	public void setBulletCounts(int bulletCounts) {
		this.bulletCounts = bulletCounts;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getRegOpen() {
		return regOpen;
	}

	public void setRegOpen(Date regOpen) {
		this.regOpen = regOpen;
	}

	public Date getRegClose() {
		return regClose;
	}

	public void setRegClose(Date regClose) {
		this.regClose = regClose;
	}

	public int getBerths() {
		return berths;
	}

	public void setBerths(int berths) {
		this.berths = berths;
	}

	public OpenType getOpenFor() {
		return openFor;
	}

	public void setOpenFor(OpenType openFor) {
		this.openFor = openFor;
	}

	@Override
	public String toString() {
		return "Competition [id=" + id + ", competitionType=" + competitionType + ", devisionType=" + devisionType
				+ ", country=" + country + ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + ", level=" + level
				+ ", stages=" + stages + ", bulletCounts=" + bulletCounts + ", title=" + title + ", regOpen=" + regOpen
				+ ", regClose=" + regClose + ", berths=" + berths + ", openFor=" + openFor + "]";
	}

}
