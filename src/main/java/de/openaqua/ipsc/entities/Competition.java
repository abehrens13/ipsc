package de.openaqua.ipsc.entities;

import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "competitions")
public class Competition {

	/*
	 * still missing: organiser_id NUMERIC, EVENTLOCATION NUMERIC, status_id
	 * NUMERIC,
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	private CompetitionType competitionType;

	@NotNull
//	@Column(name = "DEVISION_TYPE_ID")
	@ManyToOne(cascade = CascadeType.ALL)
	private DevisionType devisionType;

	@NotNull
	@ManyToOne(cascade = CascadeType.ALL)
	private Country country;

	@NotNull
	@Column(name = "DATE_START")
	private Time dateStart;

	@NotNull
	@Column(name = "DATE_END")
	private Time dateEnd;

	@Column(name = "LEVEL")
	private Integer level;

	@Column(name = "STAGES")
	private Integer stages;

	@Column(name = "BULLET_COUNTS")
	private Integer bulletCounts;

	@Column(name = "title")
	private String title;

	@Column(name = "reg_open")
	private Time regOpen;

	@Column(name = "reg_close")
	private Time regClose;

	private Integer load_Factor;

	public Competition(Long id, @NotNull CompetitionType competitionType, @NotNull DevisionType devisionType,
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
