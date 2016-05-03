package com.eucom.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EuNoticeDAO {

    private transient final Logger logger = LoggerFactory.getLogger(getClass());

    private SqlSessionFactory sqlSessionFactory = MybatisManager
	    .getSqlSession();

    public int insertNoticeNews(HashMap<String, Object> hMap) throws Exception {
	int result = 0;
	SqlSession session = sqlSessionFactory.openSession();

	try {
	    result = session.insert(
		    "com.eucom.dao.EuNoticeDAO.insertNoticeNews", hMap);
	    session.commit();
	} catch (Exception e) {
	    logger.error(e.getMessage(), e);
	    throw e;
	} finally {
	    if (session != null) {
		try {
		    session.close();
		} catch (Exception e) {
		}
	    }
	}
	return result;
    }

    @SuppressWarnings("unchecked")
    
    public ArrayList<HashMap<String, Object>> selectNoticeNewsList(
	    HashMap<String, Object> hMap) throws Exception {
	SqlSession session = sqlSessionFactory.openSession();
	ArrayList<HashMap<String, Object>> result = null;

	try {
	    result = (ArrayList<HashMap<String, Object>>) session.selectList(
		    "com.eucom.dao.EuNoticeDAO.selectNoticeNewsList", hMap);
	} catch (Exception e) {
	    logger.error(e.getMessage(), e);
	    throw e;
	} finally {
	    if (session != null) {
		try {
		    session.close();
		} catch (Exception e) {}
	    }
	}
	return result;
    }

    @SuppressWarnings("unchecked")
    
    public HashMap<String, Object> selectNoticeNewsOne(HashMap<String, Object> hMap)
	    throws Exception {

	SqlSession session = sqlSessionFactory.openSession();
	HashMap<String, Object> result = null;
	try {
	    result = (HashMap<String, Object>) session.selectOne(
		    "com.eucom.dao.EuNoticeDAO.selectNoticeNewsOne", hMap);
	} catch (Exception e) {
	    logger.error(e.getMessage(), e);
	    throw e;
	} finally {
	    if (session != null) {
		try {
		    session.close();
		} catch (Exception e) {}
	    }
	}
	return result;
    }
    
    public int updateNoticeNews(HashMap<String,Object> hMap) throws  Exception{ 
	int cnt = 0 ; 

	SqlSession session = sqlSessionFactory.openSession();
	
	try{
		cnt = (Integer) session.update("com.eucom.dao.EuNoticeDAO.updateNoticeNews", hMap);
		session.commit();
	}catch(Exception e) {
		logger.error(e.getMessage(), e);	
		throw e;
	}finally {
		if(session != null) { 
		    try{ session.close(); 
		    }catch(Exception e){} }
	}
	return cnt ;
    }
    
    public int deleteNoticeNews(HashMap<String,Object> hMap) throws  Exception{ 
	int cnt = 0 ; 

	SqlSession session = sqlSessionFactory.openSession();
	
	try{
		cnt = (Integer) session.delete("com.eucom.dao.EuNoticeDAO.deleteNoticeNews", hMap);
		session.commit();
	}catch(Exception e) {
		logger.error(e.getMessage(), e);	throw e;
	}finally {
		if(session != null) { 
		    try{ session.close(); 
		    }catch(Exception e){} }
		}
	return cnt ;
    } 

}
