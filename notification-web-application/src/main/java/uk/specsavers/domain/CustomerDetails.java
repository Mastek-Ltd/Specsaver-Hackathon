package uk.specsavers.domain;

import java.io.Serializable;
import java.math.BigDecimal;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="customerdetails")
public class CustomerDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8120111862153132071L;

	@Id
	@Column(name = "customerid")
	private BigDecimal customerid;
	
	@Column(name = "firstName")	
	private String firstName;
	
	@Column(name = "lastName")	
	private String lastName;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "age")
	private Integer age;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "lastHearingTestDate")
	private Date lastHearingTestDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "nexttHearingTestDate")
	private Date nextHearingTestDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "lastSightTestDate")
	private Date lastSightTestDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "nextSightTestDate")
	private Date nextSightTestDate;
	
	@Column(name = "contactNumber")
	private String contactNumber;
	
	@Column(name = "reminderStatus")
	private String reminderStatus;

	@Column(name = "additionalDetails")
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
