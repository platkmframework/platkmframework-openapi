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
package org.platkmframework.openapi.controller;

import java.util.List;

import org.platkmframework.annotation.Api;
import org.platkmframework.annotation.AutoWired;
import org.platkmframework.annotation.ClassMethod;
import org.platkmframework.annotation.HttpRequestMethod;
import org.platkmframework.comon.service.exception.ServiceException;
import org.platkmframework.domain.base.dao.exception.DaoException; 
import org.platkmframework.openapi.domain.service.OpenApiServiceImpl;
import org.platkmframework.openapi.domain.vo.ControllerData;
import org.platkmframework.openapi.domain.vo.EntityData;
import org.platkmframework.util.JsonException;

@Api(path = "platkmframework/openapi", description = "OpenAPI")
public class OpenApiController{

	@AutoWired
	private OpenApiServiceImpl openApiService;
	
	@ClassMethod(name = "controllers", method=HttpRequestMethod.GET)
	public List<ControllerData> controller() throws ServiceException, DaoException {
		try {
			return openApiService.getControllerAPIsInfo();
		} catch (JsonException e) {
			e.printStackTrace();
			throw new ServiceException("No se pudo procesar la información");
		}
	}
	
	@ClassMethod(name = "list", method=HttpRequestMethod.GET)
	public List<EntityData> allTables() throws ServiceException, DaoException {
		return openApiService.allTables();
	}

}
