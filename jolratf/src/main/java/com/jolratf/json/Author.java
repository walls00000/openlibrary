package com.jolratf.json;

public class Author {
	private String name;
	private String personal_name;
	private String death_date;
	private LastModified last_modified;
	private String key;
	private String birth_date;
	private Type type;
	private int id;
	private int revision;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPersonal_name() {
		return personal_name;
	}
	public void setPersonal_name(String personal_name) {
		this.personal_name = personal_name;
	}
	public String getDeath_date() {
		return death_date;
	}
	public void setDeath_date(String death_date) {
		this.death_date = death_date;
	}
	public LastModified getLast_modified() {
		return last_modified;
	}
	public void setLast_modified(LastModified last_modified) {
		this.last_modified = last_modified;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRevision() {
		return revision;
	}
	public void setRevision(int revision) {
		this.revision = revision;
	}
	
	
}
class LastModified {
	private String type;
	private String value;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
class Type {
	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
}
