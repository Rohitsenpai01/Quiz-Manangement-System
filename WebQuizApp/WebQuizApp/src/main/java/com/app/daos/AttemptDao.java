package com.app.daos;

import java.util.List;

import com.app.pojos.Attempts;

public interface AttemptDao extends AutoCloseable{
	List<Attempts> findAll() throws Exception;
}
