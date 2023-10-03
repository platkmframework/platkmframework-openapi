package org.platkmframework.openapi.domain.dao;

import javax.persistence.PersistenceContext;

import org.platkmframework.annotation.Repository;
import org.platkmframework.jpa.entitymanager.PlatkmEntityManager;

@Repository
public class OpenApiDAO {

	@PersistenceContext(unitName = "$open-api-persistence-unit")
	private PlatkmEntityManager platkmEntityManager;
 
	public PlatkmEntityManager getPlatkmEntityManager() { 
		return platkmEntityManager; 
	}
	
}
