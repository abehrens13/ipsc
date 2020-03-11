package de.openaqua.ipsc.entities;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Department")
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
	private String devisionType;

	@NotNull
	private String country;

	@NotNull
	private Date dateStart;

	@NotNull
	private Date dateEnd;

	private String level;

	private Integer stages;

	private Integer bulletCounts;

	private String title;

	private Time regOpen;

	private Time regClose;

	private Integer load_Factor;

	public Competition() {
		super();
	}

	public Competition(String id, @NotNull CompetitionType competitionType, @NotNull String devisionType,
			@NotNull String country, @NotNull Date dateStart, @NotNull Date dateEnd, String level, Integer stages,
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

	public Competition(@NotNull CompetitionType competitionType, @NotNull String devisionType, @NotNull String country,
			@NotNull Date dateStart, @NotNull Date dateEnd, String level, Integer stages, Integer bulletCounts,
			String title, Time regOpen, Time regClose, Integer load_Factor) {
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

	public String getDevisionType() {
		return devisionType;
	}

	public void setDevisionType(String devisionType) {
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

	public Time getRegOpen() {
		return regOpen;
	}

	public void setRegOpen(Time regOpen) {
		this.regOpen = regOpen;
	}

	public Time getRegClose() {
		return regClose;
	}

	public void setRegClose(Time regClose) {
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
