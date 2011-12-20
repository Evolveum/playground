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

package com.evolveum.midpoint.web.admin.user;


import com.evolveum.midpoint.schema.exception.SchemaException;
import com.evolveum.midpoint.schema.processor.PropertyDefinition;
import com.evolveum.midpoint.schema.processor.ResourceObjectAttributeDefinition;
import com.evolveum.midpoint.schema.processor.ResourceObjectDefinition;
import com.evolveum.midpoint.schema.processor.Schema;
import com.evolveum.midpoint.schema.util.JAXBUtil;
import com.evolveum.midpoint.web.MidPointApplication;
import com.evolveum.midpoint.web.admin.PageAdmin;
import com.evolveum.midpoint.web.component.autoform.*;
import com.evolveum.midpoint.web.component.locale.LocalePanel;
import com.evolveum.midpoint.web.component.util.LoadableModel;
import com.evolveum.midpoint.xml.ns._public.common.common_1.ResourceType;
import org.apache.commons.lang.StringUtils;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.form.upload.UploadProgressBar;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.file.Files;
import org.apache.wicket.util.lang.Bytes;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.io.File;
import java.net.URL;
import java.util.*;

public class PageUser extends PageAdmin {

    public PageUser() {
        LocalePanel locale = new LocalePanel("locale");
        add(locale);

        final IModel<FormObject> model = new LoadableModel<FormObject>(false) {

            @Override
            protected FormObject load() {
                FormObject object = null;
                try {
                    URL url = PageUser.class.getClassLoader().getResource("com/test/resource.xml");
                    File file = new File(url.toURI());
                    ResourceType resource = ((JAXBElement<ResourceType>) JAXBUtil.unmarshal(file)).getValue();

                    object = createObject(resource);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                if (object == null) {
                    object = new FormObject(new ArrayList<FormAttribute>(), "Unknown");
                }

                return object;
            }
        };
        Form<FormObject> form = new Form<FormObject>("form", model);
        add(form);

        AutoFormPanel panel = new AutoFormPanel("autoForm", model);
        form.add(panel);

        add(new Label("serviceLabel", new LoadableModel<Object>() {

            @Override
            protected Object load() {
                MidPointApplication application = getMidpointApplication();
                return application.getService().getValue();
            }
        }));

        form.add(new AjaxLink<String>("submit", new Model<String>("Submit")) {

            @Override
            public void onClick(AjaxRequestTarget ajaxRequestTarget) {
                System.out.println(model.getObject());
            }
        });

        //file upload
        FileUploadForm progressUploadForm = new FileUploadForm("progressUpload");

        progressUploadForm.add(new UploadProgressBar("progress", progressUploadForm,
                progressUploadForm.fileUploadField));
        add(progressUploadForm);
    }

    private FormObject createObject(ResourceType resource) throws Exception {
        List<FormAttribute> list = new ArrayList<FormAttribute>();

        //todo
        QName accountType = new QName("http://midpoint.evolveum.com/xml/ns/public/" +
                "resource/instance/10000000-0000-0000-0000-000000000003", "AccountObjectClass");

        Schema schema = Schema.parse(resource.getSchema().getAny().get(0)); //ResourceTypeUtil.getResourceSchema(resource);
        // schema.updateSchemaAccess(resource.getXmlObject().getSchemaHandling());
        ResourceObjectDefinition definition = (ResourceObjectDefinition) schema
                .findContainerDefinitionByType(accountType);
        if (definition == null) {
            throw new SchemaException("Account definition for type '" + accountType + "' was not found.");
        }

//        Map<List<QName>, List<Object>> valueMap = createAttributeValueMap();//account.getAttributes());
        for (PropertyDefinition property : definition.getPropertyDefinitions()) {
            if (!(property instanceof ResourceObjectAttributeDefinition)) {
                continue;
            }
            if (property.isIgnored()) {
                continue;
            }
            FormAttributeDefinition attrDefinition = createFormAttributeDefinition((ResourceObjectAttributeDefinition) property);
            List<FormValue> values = getV(property.getName()); //getAttributeValues(valueMap, property.getName());
            list.add(new FormAttribute(attrDefinition, values));
        }

        //todo mock data
        FormAttributeDefinitionBuilder builder = new FormAttributeDefinitionBuilder();
        builder.setAvailableValues(Arrays.asList(new Object[]{"vilko", "macko", "usko"}));
        builder.setDescription("description");
        builder.setDisplayName("a display name");
        builder.setElementName(new QName("vilko", "repan"));
        builder.setType(AttributeType.STRING);
        list.add(new FormAttribute(builder.build()));

        builder = new FormAttributeDefinitionBuilder();
        builder.setDescription("some date stuff");
        builder.setDisplayName("a display some date");
        builder.setElementName(new QName("vilko", "date"));
        builder.setType(AttributeType.DATE);
        list.add(new FormAttribute(builder.build()));
        //todo end

        Collections.sort(list, new Comparator<FormAttribute>() {
            public int compare(FormAttribute attribute1, FormAttribute attribute2) {
                return String.CASE_INSENSITIVE_ORDER.compare(attribute1.getDefinition().getDisplayName(),
                        attribute2.getDefinition().getDisplayName());
            }
        });

        return new FormObject(list, getDisplayName(resource, definition));
    }

    private List<FormValue> getV(QName name) {
        List<FormValue> list = new ArrayList<FormValue>();
        if (name.equals(new QName("http://midpoint.evolveum.com/xml/ns/public/resource/instance/10000000-0000-0000-0000-000000000003", "audio"))) {
            list.add(new FormValue("hodnota1"));
        } else if (name.equals(new QName("http://midpoint.evolveum.com/xml/ns/public/resource/instance/10000000-0000-0000-0000-000000000003", "carLicense"))) {
            list.add(new FormValue("hodnota a"));
            list.add(new FormValue("hodnota b"));
        }

        return list;
    }

    private String getDisplayName(ResourceType resource, ResourceObjectDefinition definition) {
        StringBuilder displayName = new StringBuilder();
        displayName.append(resource.getName());
        displayName.append(": ");
        displayName.append(definition.getTypeName().getLocalPart());

        return displayName.toString();
    }

    private FormAttributeDefinition createFormAttributeDefinition(ResourceObjectAttributeDefinition def) {
        FormAttributeDefinitionBuilder builder = new FormAttributeDefinitionBuilder();
        if (def.getAllowedValues() != null) {
            List<Object> availableValues = new ArrayList<Object>();
            availableValues.addAll(Arrays.asList(def.getAllowedValues()));
            builder.setAvailableValues(availableValues);
        }
        builder.setDescription(def.getHelp());

        if (StringUtils.isEmpty(def.getDisplayName())) {
            builder.setDisplayName(def.getName().getLocalPart());
        } else {
            builder.setDisplayName(def.getDisplayName());
        }
        builder.setElementName(def.getName());
//		if (def.canRead()) {
//			builder.addFlag(Flag.READ);
//		}
//		if (def.canUpdate()) {
//			builder.addFlag(Flag.UPDATE);
//		}
//		if (def.canCreate()) {
//			builder.addFlag(Flag.CREATE);
//		}

        builder.setMaxOccurs(def.getMaxOccurs());
        builder.setMinOccurs(def.getMinOccurs());
        builder.setType(AttributeType.getType(def.getTypeName()));
        // builder.setFilledWithExpression(def.isFilledWithExpression());
        // //TODO: where can I get this?????

        return builder.build();
    }
}

class FileUploadForm extends Form<Void> {

    FileUploadField fileUploadField;

    /**
     * Construct.
     *
     * @param name Component name
     */
    public FileUploadForm(String name) {
        super(name);

        // set this form to multipart mode (allways needed for uploads!)
        setMultiPart(true);

        // Add one file input field
        add(fileUploadField = new FileUploadField("fileInput"));

        // Set maximum size to 100K for demo purposes
        setMaxSize(Bytes.kilobytes(100));
    }

    /**
     * @see org.apache.wicket.markup.html.form.Form#onSubmit()
     */
    @Override
    protected void onSubmit() {
        final List<FileUpload> uploads = fileUploadField.getFileUploads();
        if (uploads != null) {
            for (FileUpload upload : uploads) {
                // Create a new file
                File newFile = new File("/home/lazyman", upload.getClientFileName());

                // Check new file, delete if it already existed
                checkFileExists(newFile);
                try {
                    // Save to new file
                    newFile.createNewFile();
                    upload.writeTo(newFile);
                    System.out.println("File size: " + newFile.length());
                } catch (Exception e) {
                    throw new IllegalStateException("Unable to write file", e);
                }
            }
        }
    }

    private void checkFileExists(File newFile) {
        if (newFile.exists()) {
            // Try to delete the file
            if (!Files.remove(newFile)) {
                throw new IllegalStateException("Unable to overwrite " + newFile.getAbsolutePath());
            }
        }
    }
}
