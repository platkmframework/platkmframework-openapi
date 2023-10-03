package org.platkmframework.openapi.domain.vo;

public class ParameterData {
	
	private boolean body;
	private boolean pathVariable;
	private String name;
	private String description;
	private boolean required;
	private String requestBody;
	private String requestBodyInfo;
	private String type;

	private String key;
	

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}


	public boolean isBody() {
		return body;
	}


	public void setBody(boolean body) {
		this.body = body;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isRequired() {
		return required;
	}


	public void setRequired(boolean required) {
		this.required = required;
	}


	public String getRequestBody() {
		return requestBody;
	}


	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public String getDescription() {
		return description;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public boolean isPathVariable() {
		return pathVariable;
	}


	public void setPathVariable(boolean pathVariable) {
		this.pathVariable = pathVariable;
	}

	public String getRequestBodyInfo() {
		return requestBodyInfo;
	}

	public void setRequestBodyInfo(String requestBodyInfo) {
		this.requestBodyInfo = requestBodyInfo;
	}

}
