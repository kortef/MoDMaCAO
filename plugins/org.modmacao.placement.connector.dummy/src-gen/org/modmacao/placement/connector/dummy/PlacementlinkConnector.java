/**
 * Copyright (c) 2016-2017 Inria
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * - Philippe Merle <philippe.merle@inria.fr>
 * - Faiez Zalila <faiez.zalila@inria.fr>
 *
 * Generated at Wed Aug 22 02:14:11 CEST 2018 from platform:/resource/org.modmacao.placement/model/placement.occie by org.eclipse.cmf.occi.core.gen.connector
 */
package org.modmacao.placement.connector.dummy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Connector implementation for the OCCI kind:
 * - scheme: http://schemas.modmacao.org/placement#
 * - term: placementlink
 * - title: 
 */
public class PlacementlinkConnector extends org.modmacao.placement.impl.PlacementlinkImpl
{
	/**
	 * Initialize the logger.
	 */
	private static Logger LOGGER = LoggerFactory.getLogger(PlacementlinkConnector.class);

	// Start of user code Placementlinkconnector_constructor
	/**
	 * Constructs a placementlink connector.
	 */
	PlacementlinkConnector()
	{
		LOGGER.debug("Constructor called on " + this);
		// TODO: Implement this constructor.
	}
	// End of user code
	//
	// OCCI CRUD callback operations.
	//
	
	// Start of user code PlacementlinkocciCreate
	/**
	 * Called when this Placementlink instance is completely created.
	 */
	@Override
	public void occiCreate()
	{
		LOGGER.debug("occiCreate() called on " + this);
		// TODO: Implement this callback or remove this method.
	}
	// End of user code

	// Start of user code Placementlink_occiRetrieve_method
	/**
	 * Called when this Placementlink instance must be retrieved.
	 */
	@Override
	public void occiRetrieve()
	{
		LOGGER.debug("occiRetrieve() called on " + this);
		// TODO: Implement this callback or remove this method.
	}
	// End of user code

	// Start of user code Placementlink_occiUpdate_method
	/**
	 * Called when this Placementlink instance is completely updated.
	 */
	@Override
	public void occiUpdate()
	{
		LOGGER.debug("occiUpdate() called on " + this);
		// TODO: Implement this callback or remove this method.
	}
	// End of user code

	// Start of user code PlacementlinkocciDelete_method
	/**
	 * Called when this Placementlink instance will be deleted.
	 */
	@Override
	public void occiDelete()
	{
		LOGGER.debug("occiDelete() called on " + this);
		// TODO: Implement this callback or remove this method.
	}
	// End of user code

	//
	// Placementlink actions.
	//

		


}	
