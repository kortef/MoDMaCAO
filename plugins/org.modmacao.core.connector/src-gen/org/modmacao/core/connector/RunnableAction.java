/*******************************************************************************
 * Copyright (c) 2019 University of Goettingen.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     - Johannes Erbel <johannes.erbel@cs.uni-goettingen.de>
 *******************************************************************************/
package org.modmacao.core.connector;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.cmf.occi.core.Link;
import org.eclipse.cmf.occi.infrastructure.Compute;
import org.modmacao.occi.platform.Component;

/**
 * Slave objects posting the requests to bring an application into an active
 * state.
 *
 * @author erbel
 *
 */
public class DeployerSlave implements Runnable {
	static Logger LOGGER = Logger.getLogger(DeployerSlave.class);
	private Component comp;
	private String action;
	private ApplicationConnector application;
	/**
	 * Constructor for a MartAppDeployerSlave.
	 * @param applicationConnector 
	 * @param action 
	 *
	 * @param conn
	 *            Connector to the OCCI API.
	 * @param app
	 *            Application to be deployed.
	 * @param martAppDeployerMaster 
	 */
	public DeployerSlave(ApplicationConnector applicationConnector, Component comp, String action) {
		this.comp = comp;
		this.action = action;
		this.application = applicationConnector;
	}

	@Override
	public void run() {
		LOGGER.info("Performing: " + action + " on " + comp);
		switch(this.action) {
		case "deploy":
			application.getBlockedVMs().addAll(getConnectedComputeNodes(comp));
			comp.deploy();
			application.getBlockedVMs().removeAll(getConnectedComputeNodes(comp));
			application.parallelComponentDeployment();
			break;
		case "configure":
			comp.configure();
			break;
		case "start":
			comp.start();
			break;
		case "stop":
			comp.stop();
			break;
		case "undeploy":
			comp.undeploy();
			break;
		default:
			break;
		}
	}
	
	private List<Compute> getConnectedComputeNodes(Component comp) {
		List<Compute> computes = new ArrayList<Compute>();
		for(Link pLink: comp.getLinks()) {
			if(pLink.getTarget() instanceof Compute) {
				computes.add((Compute) pLink.getTarget());
			}
			if(pLink.getTarget() instanceof Component) {
				computes.addAll(getConnectedComputeNodes((Component) pLink.getTarget()));
			}
		}
		return computes;
	}
}
