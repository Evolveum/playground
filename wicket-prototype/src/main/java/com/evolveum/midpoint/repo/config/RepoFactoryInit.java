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
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author lazyman
 */
public class RepoFactoryInit implements ApplicationContextAware {

    private static final Trace LOGGER = TraceManager.getTrace(RepoFactoryInit.class);
    private ApplicationContext context;
    @Autowired(required = true)
    StartupInit startupInit;

    public RepoFactoryInit() {
        LOGGER.info("constructor");
    }

    public void init() {
        LOGGER.info("init method");

        try {
            Config config = startupInit.getConfig();
            Factory factory = getFactory(config);

            String profile = factory.getProfile();
            if (StringUtils.isNotEmpty(profile)) {
                LOGGER.info("Setting profile: " + profile);
                ConfigurableEnvironment environment = (ConfigurableEnvironment) context.getEnvironment();
                environment.setActiveProfiles(profile);
            }

            factory.init(config);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Service getService() {
        LOGGER.info("getService method");

        try {
            Factory factory = getFactory(startupInit.getConfig());
            return factory.getService();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

    private Factory getFactory(Config config) throws Exception {
        String className = config.getClassName();
        Class<Factory> clazz = (Class<Factory>) Class.forName(className);
        return context.getBean(clazz);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
