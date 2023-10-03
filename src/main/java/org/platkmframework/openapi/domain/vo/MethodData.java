package org.platkmframework.openapi.domain.vo;

import java.util.ArrayList;
import java.util.List;

public class MethodData {
	
	private String path;
	private String method;
	private String description;
	private List<ParameterData> parameters;
	
	private String key;
	

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<ParameterData> getParameters() {
		if(parameters == null) parameters = new ArrayList<>();
		return parameters;
	}
	public void setParameters(List<ParameterData> parameters) {
		this.parameters = parameters;
	}

 
	
	

}
