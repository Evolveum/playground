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

package com.evolveum.midpoint.repo.config;

import com.evolveum.midpoint.repo.poc.XmlFactory;
import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;

/**
 * @author lazyman
 */
public class StartupInit {

    private static final Trace LOGGER = TraceManager.getTrace(StartupInit.class);
    private Config config;

    public StartupInit() {
        LOGGER.info("constructor");
    }

    public Config getConfig() {
        LOGGER.info("getConfig method");

        return config;
    }

    public void init() {
        LOGGER.info("init method");

        config = new Config();
        config.setClassName(XmlFactory.class.getName());
//        config.setClassName(SqlFactory.class.getName());
        config.setSomeValue("some setting value");
    }
}
