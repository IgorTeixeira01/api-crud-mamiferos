package br.com.magna.animal.api.model;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity<T, ID> {

	@Column(name = "USER_DATABASE_CREATE")
	private String userDatabaseCreate = "admin";
	
	@Column(name = "USER_DATABASE_UPDATE")
	private String userDatabaseUpdate = "admin";

	@Column(name = "TIMESTAMP_FIRST_CREATED")
	private ZonedDateTime timestampFirstCreated;

	@Column(name = "TIMESTAMP_LAST_UPDATE")
	private ZonedDateTime timestampLastUpdate;
	
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
		return timestampFirstCreated;
	}

	public void setTimestampFirstCreated(ZonedDateTime timestampFirstCreated) {
		this.timestampFirstCreated = timestampFirstCreated;
	}

	public void setTimestampLastUpdate(ZonedDateTime timestampLastUpdate) {
		this.timestampLastUpdate = timestampLastUpdate;
	}

	public void setTimestampTimeZone(ZoneId timestampTimeZone) {
		this.timestampTimeZone = timestampTimeZone;
	}

	public abstract Long getId();
}
