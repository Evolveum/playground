/*
 * Copyright (c) 2011 Evolveum
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
 * Portions Copyrighted 2011 [name of copyright owner]
 */

package com.evolveum.midpoint.web.pretty;

import org.apache.wicket.request.Request;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.mapper.parameter.IPageParametersEncoder;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.mapper.parameter.PageParameters.NamedPair;

import java.util.Iterator;

/**
 * @author lazyman
 */
public class MidPointPageParametersEncoder implements IPageParametersEncoder {

    @Override
    public Url encodePageParameters(PageParameters pageParameters) {
        Url url = new Url();

        for (NamedPair pair : pageParameters.getAllNamed()) {
            url.getSegments().add(pair.getKey());
            url.getSegments().add(pair.getValue());
        }

        return url;
    }

    @Override
    public PageParameters decodePageParameters(Request request) {
        PageParameters parameters = new PageParameters();

        int i = 0;
        for (Iterator<String> segment = request.getUrl().getSegments().iterator(); segment.hasNext(); ) {
            String key = segment.next();
            String value = segment.next();

            parameters.add(key, value);
        }

        return parameters.isEmpty() ? null : parameters;
    }
}
