package uk.specsavers.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import uk.specsavers.domain.CustomerDetails;

@Repository
public class CustomerDAO {
	
	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	/**
	 * Gets the entity manager.
	 * @return the entity manager
	 */
	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	public void save(final  CustomerDetails customerDetails)
	{
		try
		{
			getEntityManager().persist(customerDetails);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	
	@SuppressWarnings("unchecked")
	public List<CustomerDetails> fetchAllCustomers()
	{
		 List<CustomerDetails> customerDetails=null;
		try
		{
			customerDetails=getEntityManager().createQuery("from CustomerDetails").getResultList();
		}
		catch (Exception e)
		{
			throw e;
		}
		
		return customerDetails;
	}

	public void update(final  CustomerDetails customerDetails)
	{
		try
		{
			getEntityManager().merge(customerDetails);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	
	public CustomerDetails fetchCustomerById(String username)
	{
		 CustomerDetails customerDetails=null;
		try
		{
			Query query=getEntityManager().createQuery("from CustomerDetails where firstName=:firstName");
			query.setParameter("firstName", username);
			customerDetails=(CustomerDetails) query.getResultList().get(0);
		}
		catch (Exception e)
		{
			throw e;
		}
		
		return customerDetails;
	}
}
