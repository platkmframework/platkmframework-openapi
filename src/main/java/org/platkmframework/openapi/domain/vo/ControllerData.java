package org.platkmframework.openapi.domain.vo;

import java.util.ArrayList;
import java.util.List;

public class ControllerData {
	
	private String description;
	private String path;
	private List<MethodData> apis;
	
	private String key;
	

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public List<MethodData> getApis() {
		if(apis == null) apis = new ArrayList<MethodData>();
		return apis;
	}

	public void setApis(List<MethodData> apis) {
		this.apis = apis;
	}
	
	

}
