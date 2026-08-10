package com.ktdsuniversity.edu.fp.objects;

import com.ktdsuniversity.edu.fp.objects.utils.ArrayUtil;

public class City {

	private int id;
	private String name;
	private int countryId;
	private String countryCode;
	private String countryName;
	private String iso2;
	private String iso31662;
	private String fipsCode;
	private String type;
	private int level;
	private int parentId;
	private String nativeStr;
	private String latitude;
	private String longitude;
	private String timezone;
	private String wikiDataId;
	private int population;

	public City() {
	}

	City(String cityLineString) {
		// CSV: Comma Separate Value
		String[] values = cityLineString.split(",");

		this.id = ArrayUtil.getInt(values, 0);
		this.name = ArrayUtil.getValue(values, 1);
		this.countryId = ArrayUtil.getInt(values, 2);
		this.countryCode = ArrayUtil.getValue(values, 3);
		this.countryName = ArrayUtil.getValue(values, 4);
		this.iso2 = ArrayUtil.getValue(values, 5);
		this.iso31662 = ArrayUtil.getValue(values, 6);
		this.fipsCode = ArrayUtil.getValue(values, 7);
		this.type = ArrayUtil.getValue(values, 8);
		this.level = ArrayUtil.getInt(values, 9);
		this.parentId = ArrayUtil.getInt(values, 10);
		this.nativeStr = ArrayUtil.getValue(values, 11);
		this.latitude = ArrayUtil.getValue(values, 12);
		this.longitude = ArrayUtil.getValue(values, 13);
		this.timezone = ArrayUtil.getValue(values, 14);
		this.wikiDataId = ArrayUtil.getValue(values, 15);
		this.population = ArrayUtil.getInt(values, 16);
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public int getCountryId() {
		return this.countryId;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public String getCountryName() {
		return this.countryName;
	}

	public String getIso2() {
		return this.iso2;
	}

	public String getIso31662() {
		return this.iso31662;
	}

	public String getFipsCode() {
		return this.fipsCode;
	}

	public String getType() {
		return this.type;
	}

	public int getLevel() {
		return this.level;
	}

	public int getParentId() {
		return this.parentId;
	}

	public String getNativeStr() {
		return this.nativeStr;
	}

	public String getLatitude() {
		return this.latitude;
	}

	public String getLongitude() {
		return this.longitude;
	}

	public String getTimezone() {
		return this.timezone;
	}

	public String getWikiDataId() {
		return this.wikiDataId;
	}

	public int getPopulation() {
		return this.population;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("City [id=");
		builder.append(this.id);
		builder.append(", name=");
		builder.append(this.name);
		builder.append(", countryId=");
		builder.append(this.countryId);
		builder.append(", countryCode=");
		builder.append(this.countryCode);
		builder.append(", countryName=");
		builder.append(this.countryName);
		builder.append(", iso2=");
		builder.append(this.iso2);
		builder.append(", iso31662=");
		builder.append(this.iso31662);
		builder.append(", fipsCode=");
		builder.append(this.fipsCode);
		builder.append(", type=");
		builder.append(this.type);
		builder.append(", level=");
		builder.append(this.level);
		builder.append(", parentId=");
		builder.append(this.parentId);
		builder.append(", nativeStr=");
		builder.append(this.nativeStr);
		builder.append(", latitude=");
		builder.append(this.latitude);
		builder.append(", longitude=");
		builder.append(this.longitude);
		builder.append(", timezone=");
		builder.append(this.timezone);
		builder.append(", wikiDataId=");
		builder.append(this.wikiDataId);
		builder.append(", population=");
		builder.append(this.population);
		builder.append("]");
		return builder.toString();
	}

}
