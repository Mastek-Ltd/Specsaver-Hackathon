package com.specsaver.hackathon.web.dao.generic;

import uk.gov.hscic.framework.context.ContextInfo;

/**
 * The interface GenericDAO containing basic operations for an entity.
 * @param <T> the generic type
 * @author Krishna Kuntala
 */
public interface GenericDAO<T>
{

	/**
	 * Saves the object.
	 * @param object the entity
	 * @return T the JPA entity
	 */
	T save(T object);

	/**
	 * Saves the object.
	 * @param object the entity
	 * @param contextInfo the context information
	 * @return T the JPA entity
	 */
	T save(T object, ContextInfo contextInfo);

	/**
	 * Updates the object.
	 * @param object the entity
	 * @return T the JPA entity
	 */
	T update(T object);

	/**
	 * Updates the object.
	 * @param object the entity
	 * @param contextInfo the context information
	 * @return T the JPA entity
	 */
	T update(T object, ContextInfo contextInfo);

	/**
	 * Deletes the object.
	 * @param id the id
	 */
	void delete(Object id);

	/**
	 * Deletes the object.
	 * @param id the id
	 * @param contextInfo the context information
	 */
	void delete(Object id, ContextInfo contextInfo);

	/**
	 * Finds by primary key.
	 * @param id the id
	 * @return T the JPA entity
	 */
	T findByPrimaryKey(Object id);

	/**
	 * Finds by primary key.
	 * @param id the id
	 * @param contextInfo the context information
	 * @return T the JPA entity
	 */
	T findByPrimaryKey(Object id, ContextInfo contextInfo);
}