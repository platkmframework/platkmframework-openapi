/*******************************************************************************
 * Copyright(c) 2023 the original author Eduardo Iglesias Taylor.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	 https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 * 	Eduardo Iglesias Taylor - initial API and implementation
 *******************************************************************************/
package org.platkmframework.openapi.domain.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * description:
 */
public class EntityData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8595215297102138620L;
	
	/**
	 * 
	 */
	private String table;
	
	private String searchBody;
	private String searchBodyInfo;
	private String tableBody;
	private String tableBodyInfo; 
	
	private List<String> fields;
	/**
	 * 
	 * @return
	 */
	public String getTable() {
		return table;
	}
	
	/**
	 * 
	 * @param table
	 */
	public void setTable(String table) {
		this.table = table;
	}

	public String getSearchBody() {
		return searchBody;
	}

	public void setSearchBody(String searchBody) {
		this.searchBody = searchBody;
	}

	public String getSearchBodyInfo() {
		return searchBodyInfo;
	}

	public void setSearchBodyInfo(String searchBodyInfo) {
		this.searchBodyInfo = searchBodyInfo;
	}

	public String getTableBody() {
		return tableBody;
	}

	public void setTableBody(String tableBody) {
		this.tableBody = tableBody;
	}

	public String getTableBodyInfo() {
		return tableBodyInfo;
	}

	public void setTableBodyInfo(String tableBodyInfo) {
		this.tableBodyInfo = tableBodyInfo;
	}

	public List<String> getFields() {
		if(fields == null) fields = new ArrayList<>();
		return fields;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}
}
