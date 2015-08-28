package com.specsaver.hackathon.dao.impl;

import org.springframework.stereotype.Service;

import com.specsaver.hackathon.entities.UserMaster;
import com.specsaver.hackathon.web.dao.generic.GenericDAO;
import com.specsaver.hackathon.web.dao.generic.GenericDAOImpl;

/**
 * The class UserDAOImpl implements methods of {@link GenericDAO} interface.
 * @param <T> the generic type
 * @author Krishna Kuntala
 */
@Service
public class UserDAOImpl extends GenericDAOImpl<UserMaster> implements GenericDAO<UserMaster>
{

}