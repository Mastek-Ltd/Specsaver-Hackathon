package uk.specsavers.ui;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CustomerDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1901626651856356146L;


	/**
	 * 
	 */

	private BigDecimal customerid;
	
	
	private String firstName;
	
	private String lastName;
	
	private String location;
	
	private Integer age;
	
	private Date lastHearingTestDate;
	
	private Date nextHearingTestDate;
	
	private Date lastSightTestDate;
	
	private Date nextSightTestDate;
	
	private String contactNumber;
	
	private String reminderStatus;

	private String additionalDetails;

	public BigDecimal getCustomerid() {
		return customerid;
	}

	public void setCustomerid(BigDecimal customerid) {
		this.customerid = customerid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getLastHearingTestDate() {
		return lastHearingTestDate;
	}

	public void setLastHearingTestDate(Date lastHearingTestDate) {
		this.lastHearingTestDate = lastHearingTestDate;
	}

	public Date getNextHearingTestDate() {
		return nextHearingTestDate;
	}

	public void setNextHearingTestDate(Date nextHearingTestDate) {
		this.nextHearingTestDate = nextHearingTestDate;
	}

	public Date getLastSightTestDate() {
		return lastSightTestDate;
	}

	public void setLastSightTestDate(Date lastSightTestDate) {
		this.lastSightTestDate = lastSightTestDate;
	}

	public Date getNextSightTestDate() {
		return nextSightTestDate;
	}

	public void setNextSightTestDate(Date nextSightTestDate) {
		this.nextSightTestDate = nextSightTestDate;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getReminderStatus() {
		return reminderStatus;
	}

	public void setReminderStatus(String reminderStatus) {
		this.reminderStatus = reminderStatus;
	}

	public String getAdditionalDetails() {
		return additionalDetails;
	}

	public void setAdditionalDetails(String additionalDetails) {
		this.additionalDetails = additionalDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDetails other = (CustomerDetails) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
	
	
	
}
