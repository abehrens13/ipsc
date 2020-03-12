package de.openaqua.ipsc.entities;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document("Competition")
public class Competition {

	/*
	 * still missing: organiser_id NUMERIC, EVENTLOCATION NUMERIC, status_id
	 * NUMERIC,
	 */

	@Id
	private String id;

	@NotNull
	private CompetitionType competitionType;

	@NotNull
	private DevisionType devisionType;

	@NotNull
	private CountryType country;

	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	private Date dateStart;

	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	private Date dateEnd;

	private String level;

	private Integer stages;

	private Integer bulletCounts;

	private String title;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date regOpen;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date regClose;

	private Integer load_Factor;

	public Competition() {
		super();
	}

	public Competition(String id, @NotNull CompetitionType competitionType, @NotNull DevisionType devisionType,
			@NotNull CountryType country, @NotNull Date dateStart, @NotNull Date dateEnd, String level, Integer stages,
			Integer bulletCounts, String title, Time regOpen, Time regClose, Integer load_Factor) {
		super();
		this.id = id;
		this.competitionType = competitionType;
		this.devisionType = devisionType;
		this.country = country;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.level = level;
		this.stages = stages;
		this.bulletCounts = bulletCounts;
		this.title = title;
		this.regOpen = regOpen;
		this.regClose = regClose;
		this.load_Factor = load_Factor;
	}

	public Competition(@NotNull CompetitionType competitionType, @NotNull DevisionType devisionType,
			@NotNull CountryType country, @NotNull Date dateStart, @NotNull Date dateEnd, String level, Integer stages,
			Integer bulletCounts, String title, Time regOpen, Time regClose, Integer load_Factor) {
		super();
		this.competitionType = competitionType;
		this.devisionType = devisionType;
		this.country = country;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.level = level;
		this.stages = stages;
		this.bulletCounts = bulletCounts;
		this.title = title;
		this.regOpen = regOpen;
		this.regClose = regClose;
		this.load_Factor = load_Factor;
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

	public DevisionType getDevisionType() {
		return devisionType;
	}

	public void setDevisionType(DevisionType devisionType) {
		this.devisionType = devisionType;
	}

	public CountryType getCountry() {
		return country;
	}

	public void setCountry(CountryType country) {
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

	public Integer getStages() {
		return stages;
	}

	public void setStages(Integer stages) {
		this.stages = stages;
	}

	public Integer getBulletCounts() {
		return bulletCounts;
	}

	public void setBulletCounts(Integer bulletCounts) {
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

	public Integer getLoad_Factor() {
		return load_Factor;
	}

	public void setLoad_Factor(Integer load_Factor) {
		this.load_Factor = load_Factor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bulletCounts, competitionType, country, dateEnd, dateStart, devisionType, id, level,
				load_Factor, regClose, regOpen, stages, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Competition)) {
			return false;
		}
		Competition other = (Competition) obj;
		return Objects.equals(bulletCounts, other.bulletCounts)
				&& Objects.equals(competitionType, other.competitionType) && Objects.equals(country, other.country)
				&& Objects.equals(dateEnd, other.dateEnd) && Objects.equals(dateStart, other.dateStart)
				&& Objects.equals(devisionType, other.devisionType) && Objects.equals(id, other.id)
				&& Objects.equals(level, other.level) && Objects.equals(load_Factor, other.load_Factor)
				&& Objects.equals(regClose, other.regClose) && Objects.equals(regOpen, other.regOpen)
				&& Objects.equals(stages, other.stages) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Competition [id=" + id + ", competitionType=" + competitionType + ", devisionType=" + devisionType
				+ ", country=" + country + ", dateStart=" + dateStart + ", dateEnd=" + dateEnd + ", level=" + level
				+ ", stages=" + stages + ", bulletCounts=" + bulletCounts + ", title=" + title + ", regOpen=" + regOpen
				+ ", regClose=" + regClose + ", load_Factor=" + load_Factor + "]";
	}

}
