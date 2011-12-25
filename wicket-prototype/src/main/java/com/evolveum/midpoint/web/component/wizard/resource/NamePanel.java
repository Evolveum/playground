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

package com.evolveum.midpoint.web.component.wizard.resource;

import com.evolveum.midpoint.schema.util.JAXBUtil;
import com.evolveum.midpoint.web.component.wizard.WizardPanel;
import com.evolveum.midpoint.xml.ns._public.common.common_1.*;
import org.apache.commons.lang.StringUtils;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import javax.xml.bind.JAXBElement;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lazyman
 */
public class NamePanel extends WizardPanel<ResourceType> {

    private DropDownChoice<ConnectorType> version;
    private ConnectorType connectorType;
    private String name;
    private ConnectorType selectedConnector;

    public NamePanel(String id, IModel<ResourceType> wizardModel) {
        super(id, wizardModel);
        initLayout();
    }

    @Override
    public IModel<String> getTitle() {
        return createStringResource("NamePanel.title", this);
    }

    public ConnectorType getConnectorType() {
        return connectorType;
    }

    public void setConnectorType(ConnectorType connectorType) {
        this.connectorType = connectorType;
    }

    public ConnectorType getSelectedConnector() {
        return selectedConnector;
    }

    public void setSelectedConnector(ConnectorType selectedConnector) {
        this.selectedConnector = selectedConnector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void initLayout() {
        RequiredTextField<String> name = new RequiredTextField<String>("resourceName",
                new PropertyModel<String>(this, "name"));
        name.add(new AjaxFormComponentUpdatingBehavior("onFocus") {
            @Override
            protected void onUpdate(AjaxRequestTarget target) {
            }
        });
        add(name);

        final List<ConnectorType> connectors = getConnectors();
        final DropDownChoice<ConnectorType> type = createChoiceType(connectors);
        version = createChoiceVersion(connectors);
        version.add(new AjaxFormComponentUpdatingBehavior("onChange") {

            @Override
            protected void onUpdate(AjaxRequestTarget target) {
            }
        });

        type.add(new AjaxFormComponentUpdatingBehavior("onChange") {

            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                target.add(version);
            }
        });
        add(type);
        add(version);
    }

    private DropDownChoice<ConnectorType> createChoiceType(final List<ConnectorType> connectors) {
        return new DropDownChoice<ConnectorType>("connectorName",
                new PropertyModel<ConnectorType>(this, "connectorType"),
                new AbstractReadOnlyModel<List<? extends ConnectorType>>() {

                    @Override
                    public List<ConnectorType> getObject() {
                        List<ConnectorType> list = new ArrayList<ConnectorType>();
                        Set<String> types = new HashSet<String>();
                        for (ConnectorType connector : connectors) {
                            if (types.contains(connector.getConnectorType())) {
                                continue;
                            }
                            types.add(connector.getConnectorType());
                            list.add(connector);
                        }

                        return list;
                    }
                },
                new IChoiceRenderer<ConnectorType>() {

                    @Override
                    public Object getDisplayValue(ConnectorType connector) {
                        IModel<String> undefined = createStringResource("NamePanel.undefinedName", NamePanel.this);

                        return StringUtils.isEmpty(connector.getName()) ?
                                undefined.getObject() : connector.getName();
                    }

                    @Override
                    public String getIdValue(ConnectorType object, int index) {
                        return Integer.toString(index);
                    }
                }
        );
    }

    private DropDownChoice<ConnectorType> createChoiceVersion(final List<ConnectorType> connectors) {
        IModel<List<ConnectorType>> versions = new AbstractReadOnlyModel<List<ConnectorType>>() {

            @Override
            public List<ConnectorType> getObject() {
                List<ConnectorType> list = new ArrayList<ConnectorType>();
                ConnectorType connectorType = getConnectorType();
                if (connectorType == null) {
                    return list;
                }

                for (ConnectorType connector : connectors) {
                    if (connector.getConnectorType().equals(connectorType.getConnectorType())) {
                        list.add(connector);
                    }
                }

                return list;
            }
        };

        DropDownChoice<ConnectorType> choice = new DropDownChoice<ConnectorType>("connectorVersion",
                new PropertyModel<ConnectorType>(this, "selectedConnector"),
                versions, new IChoiceRenderer<ConnectorType>() {

            @Override
            public Object getDisplayValue(ConnectorType connector) {
                IModel<String> undefined = createStringResource("NamePanel.undefinedVersion", NamePanel.this);

                return StringUtils.isEmpty(connector.getConnectorVersion()) ?
                        undefined.getObject() : connector.getConnectorVersion();
            }

            @Override
            public String getIdValue(ConnectorType object, int index) {
                return Integer.toString(index);
            }
        });
        choice.setOutputMarkupId(true);

        return choice;
    }

    //todo implement - get from database
    private List<ConnectorType> getConnectors() {
        List<ConnectorType> connectors = new ArrayList<ConnectorType>();

        Objects objects = null;
        try {
            URL url = NamePanel.class.getClassLoader().getResource("com/test/connectors.xml");
            File file = new File(url.toURI());
            objects = (Objects) JAXBUtil.unmarshal(file);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (objects != null) {
            List<JAXBElement<? extends ObjectType>> elements = objects.getObject();
            for (JAXBElement<? extends ObjectType> element : elements) {
                connectors.add((ConnectorType) element.getValue());
            }
        }

        return connectors;
    }

    @Override
    public void performAfterNext(AjaxRequestTarget target) {
        System.out.println("neeeeeeeeeeeeeeeext stuff");

        IModel<ResourceType> model = getWizardModel();
        ResourceType resource = model.getObject();
        resource.setName(getName());

        ObjectReferenceType reference = new ObjectReferenceType();
        reference.setType(ConnectorType.ELEMENT_TYPE);
        reference.setOid(getSelectedConnector().getOid());
        resource.setConnectorRef(reference);
    }
}
