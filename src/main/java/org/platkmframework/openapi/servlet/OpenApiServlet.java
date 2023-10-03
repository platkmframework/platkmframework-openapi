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
package org.platkmframework.openapi.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.platkmframework.content.project.CorePropertyConstant;
import org.platkmframework.content.project.ProjectContent; 

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse; 
 
@WebServlet(urlPatterns = { "/platkmframework-openapi/*" })
public class OpenApiServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 462593772888300310L;
	
	private static final Logger logger = LogManager.getLogger(OpenApiServlet.class);
 
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		 
	}
	
	@Override
	protected final void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}
	
	@Override
	protected final void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req,resp);
	}
	
	
	@Override
	protected final void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		process(req,resp);
	}

	protected void process(HttpServletRequest request, HttpServletResponse resp) throws ServletException 
	{ 
		
		try { 
 
			InputStream  inputStream = this.getClass().getResourceAsStream("/openapi/index.html");
			String openApiPage = IOUtils.toString(inputStream, StandardCharsets.UTF_8.name());
			openApiPage = openApiPage.replace("${serverAPI}", "http://" +ProjectContent.instance().getProperty(CorePropertyConstant.ORG_PLATKMFRAMEWORK_SERVER_NAME) +
					                                ":" +
					                                ProjectContent.instance().getProperty(CorePropertyConstant.ORG_PLATKMFRAMEWORK_SERVER_PORT) +
					                                ProjectContent.instance().getProperty(CorePropertyConstant.ORG_PLATKMFRAMEWORK_CONTENT_PATH) + 
					                                ProjectContent.instance().getProperty(CorePropertyConstant.ORG_PLATKMFRAMEWORK_SERVLET_PLATH));
			
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("html");  
			resp.setStatus(200);
			PrintWriter out = resp.getWriter();
			out.println(openApiPage);
			out.flush();
			
		} catch (Exception e) {
			logger.error(e);
		} 
	}
}
