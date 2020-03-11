package de.openaqua.ipsc.entities;

import java.sql.Time;
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
	private DevisionType devisionType;

	@NotNull
	private Country country;

	@NotNull
	private Time dateStart;

	@NotNull
	private Time dateEnd;

	private Integer level;

	private Integer stages;

	private Integer bulletCounts;

	private String title;

	private Time regOpen;

	private Time regClose;

	private Integer load_Factor;

	public Competition(String id, @NotNull CompetitionType competitionType, @NotNull DevisionType devisionType,
			@NotNull Country country, @NotNull Time dateStart, @NotNull Time dateEnd, Integer level, Integer stages,
			int bulletCounts, String title, Time regOpen, Time regClose, Integer load_Factor) {
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
			@NotNull Country country, @NotNull Time dateStart, @NotNull Time dateEnd, Integer level, Integer stages,
			int bulletCounts, String title, Time regOpen, Time regClose, Integer load_Factor) {
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

	public Competition() {
		super();
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Time getDateStart() {
		return (Time) dateStart.clone();
	}

	public void setDateStart(Time dateStart) {
		this.dateStart = (Time) dateStart.clone();
	}

	public Time getDateEnd() {
		return dateEnd;
	}

	public void setDateEnd(Time dateEnd) {
		this.dateEnd = dateEnd;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public Integer getStages() {
		return stages;
	}

	public void setStages(int stages) {
		this.stages = stages;
	}

	public Integer getBulletCounts() {
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

	public Integer getLoadFactor() {
		return load_Factor;
	}

	public void setLoadFactor(int loadFactor) {
		this.load_Factor = loadFactor;
	}

}
