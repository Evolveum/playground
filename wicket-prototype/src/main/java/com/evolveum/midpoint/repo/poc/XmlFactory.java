/*
 * Copyright (c) 2012 Evolveum
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at
 * http://www.opensource.org/licenses/cddl1 or
 * CDDLv1.0.txt file in the source code distribution.
 * See the License for the specific language governing
 * permission and limitations under the License.
 *
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 *
 * Portions Copyrighted 2012 [name of copyright owner]
 */

package com.evolveum.midpoint.repo.poc;

import com.evolveum.midpoint.repo.config.Config;
import com.evolveum.midpoint.repo.config.Factory;
import com.evolveum.midpoint.repo.config.Service;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;

/**
 * @author lazyman
 */
public class XmlFactory implements Factory {

    private static final Trace LOGGER = TraceManager.getTrace(XmlFactory.class);

    public XmlFactory() {
        LOGGER.info("constructor");
    }

    public void init(Config config) {
        LOGGER.info("init method");

    }

    public Service getService() {
        LOGGER.info("getService method");

        return new XmlService();
    }

    public void destroy() {
        LOGGER.info("destroy method");
    }
}
