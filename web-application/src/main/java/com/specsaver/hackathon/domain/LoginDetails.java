package com.specsaver.hackathon.domain;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class LoginDetails
{

	@NotNull(message = "The user UUID should not be null")
	@NotEmpty(message = "The user UUID should not be empty")
	@Size(min = 12, max = 12, message = "The user UUID should be exactly 12 characters long")
	private String		userUUID;

	@NotNull(message = "The user logged in time should not be null")
	private Timestamp	loggedInTime;

	public LoginDetails()
	{
	}

	public LoginDetails(String userUUID, Timestamp loggedInTime)
	{
		this();
		this.userUUID = userUUID;
		this.loggedInTime = loggedInTime;
	}

	public LoginDetails(String userUUID)
	{
		this(userUUID, null);
	}

	public String getUserUUID()
	{
		return userUUID;
	}

	public void setUserUUID(String userUUID)
	{
		this.userUUID = userUUID;
	}

	public Timestamp getLoggedInTime()
	{
		return loggedInTime;
	}

	public void setLoggedInTime(Timestamp loggedInTime)
	{
		this.loggedInTime = loggedInTime;
	}

	@Override
	public String toString()
	{
		return "LoginDetails [userUUID=" + userUUID + ", loggedInTime=" + loggedInTime + "]";
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
		LoginDetails other = (LoginDetails) obj;
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