package com.specsaver.hackathon.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * The persistent class for the urs_users_mst database table.
 * @author Krishna Kuntala
 */
@Entity
@Table(name = "urs_users_mst")
public class UserMaster
{

	@Id
	@Column(name = "uuid")
	private String		userUUID;

	@Column(name = "lastloggedintime")
	private Timestamp	lastLoggedInTime;

	public UserMaster()
	{
	}

	public UserMaster(String userUUID, Timestamp lastLoggedInTime)
	{
		this();
		this.userUUID = userUUID;
		this.lastLoggedInTime = lastLoggedInTime;
	}

	public String getUserUUID()
	{
		return userUUID;
	}

	public void setUserUUID(String userUUID)
	{
		this.userUUID = userUUID;
	}

	public Timestamp getLastLoggedInTime()
	{
		return lastLoggedInTime;
	}

	public void setLastLoggedInTime(Timestamp lastLoggedInTime)
	{
		this.lastLoggedInTime = lastLoggedInTime;
	}

	@Override
	public String toString()
	{
		return "UserMaster [userUUID=" + userUUID + ", lastLoggedInTime=" + lastLoggedInTime + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userUUID == null) ? 0 : userUUID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserMaster other = (UserMaster) obj;
		if (userUUID == null)
		{
			if (other.userUUID != null)
				return false;
		}
		else if (!userUUID.equals(other.userUUID))
			return false;
		return true;
	}
}