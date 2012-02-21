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

import com.evolveum.midpoint.util.logging.Trace;
import com.evolveum.midpoint.util.logging.TraceManager;

/**
 * Class represents apache configuration
 *
 * @author lazyman
 */
public class Config {

    private static final Trace LOGGER = TraceManager.getTrace(Config.class);
    private String className;
    private String someValue;

    public Config() {
        LOGGER.info("constructor");
    }

    public String getSomeValue() {
        LOGGER.info("getSomeValue");
        return someValue;
    }

    public void setSomeValue(String someValue) {
        LOGGER.info("setSomeValue");
        this.someValue = someValue;
    }

    public String getClassName() {
        LOGGER.info("getClassName method");
        return className;
    }

    public void setClassName(String className) {
        LOGGER.info("setClassName method");
        this.className = className;
    }
}
