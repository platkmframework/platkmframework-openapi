package org.platkmframework.openapi.domain.dao;

import javax.persistence.PersistenceContext;

import org.platkmframework.annotation.Repository;
import org.platkmframework.jpa.base.PlatkmEntityManager;

@Repository
public class OpenApiDAO {

	@PersistenceContext(unitName = "${platkmframework_persistence_unit}")
	private PlatkmEntityManager platkmEntityManager;
 
	public PlatkmEntityManager getPlatkmEntityManager(){ 
		return platkmEntityManager; 
	}
	
}
