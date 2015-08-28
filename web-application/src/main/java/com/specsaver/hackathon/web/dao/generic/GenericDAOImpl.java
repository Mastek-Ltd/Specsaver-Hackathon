package com.specsaver.hackathon.web.dao.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import uk.gov.hscic.framework.context.ContextInfo;
import uk.gov.hscic.framework.logger.service.impl.CareIdDiagnosticLogger;
import uk.gov.hscic.framework.logger.service.impl.CareIdLogFactory;
import uk.gov.hscic.framework.logger.service.impl.CareIdPerformanceLogger.STATUS;

/**
 * The class GenericDAOImpl implements methods of {@link GenericDAO} interface.
 * @param <T> the generic type
 * @author Krishna Kuntala
 */
@Service
public abstract class GenericDAOImpl<T> implements GenericDAO<T>
{

	/** The diagnostic logger. */
	private static final CareIdDiagnosticLogger	DIAGNOSTIC_LOGGER	= CareIdLogFactory.getCareIdDiagnosticLogger(GenericDAOImpl.class);

	/** The entity manager. */
	private EntityManager								entityManager;

	/** The type. */
	private Class<T>										type;

	/**
	 * Instantiates a new care id dao impl.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked"})
	public GenericDAOImpl()
	{
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}

	/**
	 * Sets the entity manager.
	 * @param entityManager the new entity manager
	 */
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

	/*
	 * (non-Javadoc)
	 * @see
	 * uk.gov.hscic.careid.framework.generic.dao.CareIdDAO#save(java.lang.Object
	 * )
	 */
	@Override
	public T save(final T object)
	{
		DIAGNOSTIC_LOGGER.info("Inside <Data Access Layer> <CareIdDAOImpl>.<save>");
		getEntityManager().persist(object);
		DIAGNOSTIC_LOGGER.debug("Object persisted:" + object + " of type:" + object.getClass());
		DIAGNOSTIC_LOGGER.info("Exit <Data Access Layer> <CareIdDAOImpl>.<save>");
		return object;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * uk.gov.hscic.careid.framework.generic.dao.CareIdDAO#save(java.lang.Object
	 * , uk.gov.hscic.framework.context.ContextInfo)
	 */
	@Override
	public T save(final T object, ContextInfo contextInfo)
	{
		DIAGNOSTIC_LOGGER.info(STATUS.START.toString(), contextInfo, new Object[] { "[save]"});
		getEntityManager().persist(object);
		DIAGNOSTIC_LOGGER.debug("Object persisted:" + object + " of type:" + object.getClass(), contextInfo);
		DIAGNOSTIC_LOGGER.info(STATUS.END.toString(), contextInfo, new Object[] { "[save]"});
		return object;
	}

	/*
	 * (non-Javadoc)
	 * @see uk.gov.hscic.careid.framework.generic.dao.CareIdDAO#update(java.lang.
	 * Object )
	 */
	@Override
	public T update(final T object)
	{
		DIAGNOSTIC_LOGGER.info("Inside <Data Access Layer> <CareIdDAOImpl>.<update>");
		T updatedObject = getEntityManager().merge(object);
		DIAGNOSTIC_LOGGER.info("Exit <Data Access Layer> <CareIdDAOImpl>.<update>:" + object + " of type:" + object.getClass());
		return updatedObject;
	}

	/*
	 * (non-Javadoc)
	 * @see uk.gov.hscic.careid.framework.generic.dao.CareIdDAO#update(java.lang.
	 * Object , uk.gov.hscic.framework.context.ContextInfo)
	 */
	@Override
	public T update(final T object, ContextInfo contextInfo)
	{
		DIAGNOSTIC_LOGGER.info(STATUS.START.toString(), contextInfo, new Object[] { "[update]"});
		T updatedObject = getEntityManager().merge(object);
		DIAGNOSTIC_LOGGER.debug("Object updated:" + object + " of type:" + object.getClass(), contextInfo);
		DIAGNOSTIC_LOGGER.info(STATUS.END.toString(), contextInfo, new Object[] { "[update]"});
		return updatedObject;
	}

	/*
	 * (non-Javadoc)
	 * @see uk.gov.hscic.careid.framework.generic.dao.CareIdDAO#delete(java.lang.
	 * Object )
	 */
	@Override
	public void delete(final Object id)
	{
		DIAGNOSTIC_LOGGER.info("Inside <Data Access Layer> <CareIdDAOImpl>.<delete>:<" + id + ">");
		getEntityManager().remove(getEntityManager().getReference(type, id));
	}

	/*
	 * (non-Javadoc)
	 * @see uk.gov.hscic.careid.framework.generic.dao.CareIdDAO#delete(java.lang.
	 * Object )
	 */
	@Override
	public void delete(final Object id, ContextInfo contextInfo)
	{
		DIAGNOSTIC_LOGGER.info(STATUS.START.toString(), contextInfo, new Object[] { "[delete]"});
		getEntityManager().remove(getEntityManager().getReference(type, id));
		DIAGNOSTIC_LOGGER.debug("Object Deleted:<" + id + ">", contextInfo);
		DIAGNOSTIC_LOGGER.info(STATUS.END.toString(), contextInfo, new Object[] { "[delete]"});
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * uk.gov.hscic.careid.framework.generic.dao.CareIdDAO#findByPrimaryKey(java
	 * .lang.Object)
	 */
	@Override
	public T findByPrimaryKey(final Object id)
	{
		DIAGNOSTIC_LOGGER.debug("<Data Access Layer > Fetching Object....:<" + id + ">");
		T object = getEntityManager().find(type, id);
		return object;
	}

	/*
	 * (non-Javadoc)
	 * @see
	 * uk.gov.hscic.careid.framework.generic.dao.CareIdDAO#findByPrimaryKey(java
	 * .lang.Object)
	 */
	@Override
	public T findByPrimaryKey(final Object id, ContextInfo contextInfo)
	{
		DIAGNOSTIC_LOGGER.info(STATUS.START.toString(), contextInfo, new Object[] { "[findByPrimaryKey]"});
		T object = getEntityManager().find(type, id);
		DIAGNOSTIC_LOGGER.debug("Find entity by primary key:<" + id + ">", contextInfo);
		DIAGNOSTIC_LOGGER.info(STATUS.END.toString(), contextInfo, new Object[] { "[findByPrimaryKey]"});
		return object;
	}
}