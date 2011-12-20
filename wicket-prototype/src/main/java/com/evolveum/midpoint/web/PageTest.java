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

package com.evolveum.midpoint.web;

import com.evolveum.midpoint.web.admin.home.PageHome;
import com.evolveum.midpoint.web.component.autoform.AutoFormPanel;
import com.evolveum.midpoint.web.component.autoform.FormAttribute;
import com.evolveum.midpoint.web.component.autoform.FormObject;
import com.evolveum.midpoint.web.component.menu.top.TopMenu;
import com.evolveum.midpoint.web.component.menu.top.TopMenuItem;
import com.evolveum.midpoint.web.component.xml.ace.AceEditor;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.ajax.markup.html.form.AjaxCheckBox;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PageTest extends WebPage {

    private static final long serialVersionUID = -5079262830320085033L;
    private Label hodnota;
    private String text = "<asdf>\n</asdf>";

    public PageTest() {
        final Form form = new Form("form");
        add(form);

        ArrayList<Item> items = new ArrayList<Item>();
        items.add(new Item<String>("label1", "hodnota1", Type.STRING));
        items.add(new Item<Integer>("label2", 23, Type.NUMBER));
        items.add(new Item<Date>("label 2 kusy", new Date(), Type.DATE));

        AutoFormPanel autoFormPanel = new AutoFormPanel("autoform", new Model<FormObject>(new FormObject(new ArrayList<FormAttribute>(), "")));
        form.add(autoFormPanel);

//        form.add(new AceEditor<String>("aceEditor", new PropertyModel<String>(this, "text"), Language.XML));
        IModel<String> model = new PropertyModel<String>(this, "text");
        final AceEditor<String> editor = new AceEditor<String>("aceEditor", model);
        editor.add(new AttributeAppender("style", new Model("display:block;height:270px;"), " "));
        form.add(editor);
        hodnota = new Label("hodnota", model);
        form.add(hodnota);
        AjaxButton button = new AjaxButton("button", new Model<String>("vilko")) {

            @Override
            protected void onSubmit(AjaxRequestTarget ajaxRequestTarget, Form<?> f) {
                System.out.println("asdf");
                ajaxRequestTarget.add(form);
            }

            @Override
            protected void onError(AjaxRequestTarget ajaxRequestTarget, Form<?> form) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
        form.add(button);

        AjaxCheckBox readOnly = new AjaxCheckBox("readOnly", new PropertyModel<Boolean>(editor, AceEditor.F_READONLY)) {

            @Override
            protected void onUpdate(AjaxRequestTarget target) {
                System.out.println("bkl");
                target.add(form);
            }
        };
        form.add(readOnly);

        /**************************/
        List<TopMenuItem> list = new ArrayList<TopMenuItem>();
        list.add(new TopMenuItem("Login", "login page", PageLogin.class));
        list.add(new TopMenuItem("Test", "testovacia stranka", PageTest.class));
        list.add(new TopMenuItem("home", "home.description", PageHome.class));
        TopMenu topMenu = new TopMenu("topMenu", list);
        add(topMenu);


        /** page upload **/

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static class Item<T> implements Serializable {

        private static final long serialVersionUID = 6617392968499880093L;
        private String label;
        private T value;
        private Type type;

        public Item(String label, T value, Type type) {
            this.label = label;
            this.value = value;
            this.type = type;
        }

        public String getLabel() {
            return label;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Type getType() {
            return type;
        }
    }

    public static enum Type {
        DATE, STRING, NUMBER;
    }
}
