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
package org.platkmframework.openapi.domain.service;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.platkmframework.annotation.Api;
import org.platkmframework.annotation.AutoWired;
import org.platkmframework.annotation.ClassMethod;
import org.platkmframework.annotation.OpenApi;
import org.platkmframework.annotation.RequestBody;
import org.platkmframework.annotation.RequestParam;
import org.platkmframework.annotation.Service;
import org.platkmframework.common.domain.filter.criteria.FilterCriteria;
import org.platkmframework.common.domain.filter.criteria.SearchCriteria;
import org.platkmframework.common.domain.filter.criteria.WhereCriteria;
import org.platkmframework.common.domain.filter.ui.Filter;
import org.platkmframework.content.ObjectContainer;
import org.platkmframework.content.json.JsonUtil;
import org.platkmframework.openapi.controller.OpenApiController;
import org.platkmframework.openapi.domain.dao.OpenApiDAO;
import org.platkmframework.openapi.domain.vo.ControllerData;
import org.platkmframework.openapi.domain.vo.MethodData;
import org.platkmframework.openapi.domain.vo.ParameterData;
import org.platkmframework.util.ClassToJsonUtil;
import org.platkmframework.util.JsonException;
import org.platkmframework.util.Util;
import org.platkmframework.util.reflection.ReflectionUtil;

@Service
public class OpenApiServiceImpl{
 
	@AutoWired
	private OpenApiDAO openApiDAO;
	
	public List<ControllerData> getControllerAPIsInfo() throws JsonException { 
		
		List<?> controllers = ObjectContainer.instance().getControllersByAnnotation(OpenApi.class);
		List<ControllerData> controllerAPIs = new ArrayList<>();
		if(controllers != null) {
			Api api;
			ControllerData controllerData;
			List<Method> methods;
			ClassMethod classMethod;
			ParameterData parameterData;
			MethodData methodData;
			Parameter paramter;
			RequestBody requestBody;
			RequestParam requestParam;
			List<Map<String, Object>> results;
			for (Object object : controllers) {
				if(!object.getClass().getSimpleName().equalsIgnoreCase(OpenApiController.class.getSimpleName())){
					
					api = object.getClass().getAnnotation(Api.class);
					controllerData = new ControllerData();
					controllerData.setKey(Util.randomAlfaNumericString(100));
					controllerData.setDescription(api.description());
					controllerData.setPath(api.path());;
				
					methods = ReflectionUtil.getAllMethoddHeritage(object.getClass());
					if(methods != null) {
						for (Method method : methods) {
							if(method.isAnnotationPresent(ClassMethod.class)) {
								classMethod = method.getAnnotation(ClassMethod.class);
								methodData = new MethodData();
								methodData.setKey(Util.randomAlfaNumericString(100));
								methodData.setPath(classMethod.name());
								methodData.setMethod(classMethod.method().name());
								methodData.setDescription(classMethod.description());
								
								for(int i = 0; i  < method.getParameterCount(); ++ i) {
									paramter = method.getParameters()[i];
									parameterData = new ParameterData();
									parameterData.setKey(Util.randomAlfaNumericString(100));
									
									if(paramter.isAnnotationPresent(RequestBody.class)) {
										requestBody = paramter.getAnnotation(RequestBody.class);
										parameterData.setName("Cuerpo");
										parameterData.setBody(true);
										parameterData.setDescription(requestBody.description());
										
										if(paramter.getType().getName().equals(FilterCriteria.class.getName()) ||
												paramter.getType().getName().equals(SearchCriteria.class.getName())	||
												paramter.getType().getName().equals(WhereCriteria.class.getName())) {
											
											results = ClassToJsonUtil.process(Filter.class);
											parameterData.setRequestBody(JsonUtil.objectToJson(results.get(0)));
											parameterData.setRequestBodyInfo(JsonUtil.objectToJson(results.get(1)));
											
										}else {
											
											results = ClassToJsonUtil.process(paramter.getType());
											parameterData.setRequestBody(JsonUtil.objectToJson(results.get(0)));
											parameterData.setRequestBodyInfo(JsonUtil.objectToJson(results.get(1)));
											
										}
										parameterData.setRequired(requestBody.required());
										
									}else if(paramter.isAnnotationPresent(RequestParam.class)) {
										requestParam = paramter.getAnnotation(RequestParam.class);
										parameterData.setName(requestParam.name());
										parameterData.setBody(false);
										parameterData.setDescription(requestParam.description());
										parameterData.setRequired(requestParam.required());
									}	
									methodData.getParameters().add(parameterData);
								}
								
								controllerData.getApis().add(methodData);
							}
						}
					}
					controllerAPIs.add(controllerData);
				}
			}
		}
		return controllerAPIs;
	}



}
