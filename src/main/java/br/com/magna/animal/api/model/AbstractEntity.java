package br.com.magna.animal.api.model;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity<T, ID> {

	@Column(name = "USER_DATABASE_CREATE", nullable = false)
	private String userDatabaseCreate = "admin";
	
	@Column(name = "USER_DATABASE_UPDATE", nullable = false)
	private String userDatabaseUpdate = "admin";

	@Column(name = "TIME_STAMP_FIRST_CREATED", nullable = false)
	private ZonedDateTime timeStampFirstCreated;

	@Column(name = "TIME_STAMP_LAST_UPDATE", nullable = false)
	private ZonedDateTime timeStampLastUpdate;
	
	@Column(name = "TIMESTAMP_TIME_ZOME")
	private ZoneId timestampTimeZone;


	public String getUserDatabaseCreate() {
		return userDatabaseCreate;
	}

	public void setUserDatabaseCreate(String userDatabase) {
		this.userDatabaseCreate = userDatabase;
	}

	public void setUserDatabaseUpdate(String userDatabaseUpdate) {
		this.userDatabaseUpdate = userDatabaseUpdate;
	}

	public ZonedDateTime getTimestampFirstCreated() {
		return timeStampFirstCreated;
	}

	public void setTimestampFirstCreated(ZonedDateTime timestampFirstCreated) {
		this.timeStampFirstCreated = timestampFirstCreated;
	}

	public void setTimestampLastUpdate(ZonedDateTime timestampLastUpdate) {
		this.timeStampLastUpdate = timestampLastUpdate;
	}

	public void setTimestampTimeZone(ZoneId timestampTimeZone) {
		this.timestampTimeZone = timestampTimeZone;
	}

	public abstract Long getId();

//	public abstract Long setId(ID id);
}
