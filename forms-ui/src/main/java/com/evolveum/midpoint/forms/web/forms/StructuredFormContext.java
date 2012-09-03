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

package com.evolveum.midpoint.forms.web.forms;

import com.evolveum.midpoint.forms.web.forms.interpreter.FormResolver;
import com.evolveum.midpoint.forms.web.forms.model.FormModel;
import com.evolveum.midpoint.forms.web.forms.model.ValueStatus;
import com.evolveum.midpoint.prism.PrismObject;
import com.evolveum.midpoint.prism.delta.ChangeType;
import com.evolveum.midpoint.prism.delta.ObjectDelta;
import com.evolveum.midpoint.util.exception.SchemaException;
import com.evolveum.midpoint.xml.ns._public.common.common_2.ObjectType;
import com.evolveum.midpoint.xml.ns._public.common.common_2.UserType;
import org.apache.commons.lang.Validate;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lazyman
 */
public class StructuredFormContext implements Serializable {

    private String mainForm;
    private PrismObject<UserType> user;
    private Map<String, FormContextItem> objects;
    private FormResolver resolver;

    private FormModel formModel;

    public StructuredFormContext(String mainForm, PrismObject<UserType> user, Map<String, FormContextItem> objects, FormResolver resolver) {
        Validate.notEmpty(mainForm, "Main form path must not be null.");
//        Validate.notNull(user, "PrismObject user must not be null.");
        Validate.notNull(resolver, "Form resolver must not be null.");

        this.mainForm = mainForm;
        this.objects = objects;
        if (this.objects == null) {
            this.objects = new HashMap<String, FormContextItem>();
        }
        this.resolver = resolver;
        this.user = user;
    }

    public String getMainFormPath() {
        return mainForm;
    }

    public Map<String, FormContextItem> getObjects() {
        return objects;
    }

    public FormResolver getResolver() {
        return resolver;
    }

    public PrismObject<UserType> getUser() {
        return user;
    }

    public FormModel getFormModel() {
        return formModel;
    }

    public void setFormModel(FormModel formModel) {
        this.formModel = formModel;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("StructuredFormContext{user: ");
        builder.append(user != null ? user.toDebugName() : null);
        builder.append(", objects: ");
        builder.append(objects != null ? objects.toString() : null);
        builder.append(", resolver: ");
        builder.append(resolver != null ? resolver.getClass().getName() : null);
        builder.append("}");

        return builder.toString();
    }

    public <T extends ObjectType> ObjectDelta<T> getObjectDelta(String objectKey) throws SchemaException {
        Validate.notEmpty(objectKey, "Object key must not be null.");
        FormContextItem contextItem = objects.get(objectKey);
        if (contextItem == null) {
            throw new SchemaException("Object '" + objectKey + "' doesn't exist.");
        }

        if (!(contextItem.getItem() instanceof PrismObject)) {
            throw new SchemaException("Object '" + objectKey + "' is not prism object.");
        }

        ObjectDelta delta;
        PrismObject object = (PrismObject) contextItem.getItem();
        switch (contextItem.getStatus()) {
            case ADDED:
                delta = new ObjectDelta(object.getCompileTimeClass(), ChangeType.ADD);
                //todo implement
                break;
            case DELETED:
                delta = new ObjectDelta(object.getCompileTimeClass(), ChangeType.DELETE);
                delta.setOid(object.getOid());
                //todo implement
                break;
            case EXISTING:
            default:
                delta = new ObjectDelta(object.getCompileTimeClass(), ChangeType.MODIFY);
                delta.setOid(object.getOid());
                //todo implement
        }

        return delta;
    }
}
