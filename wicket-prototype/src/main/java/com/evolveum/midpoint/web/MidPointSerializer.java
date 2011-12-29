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

import com.evolveum.midpoint.schema.util.JAXBUtil;
import org.apache.wicket.serialize.ISerializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Not used, not tested...
 *
 * @author lazyman
 */
public class MidPointSerializer implements ISerializer {

    public Object deserialize(byte[] bytes) {
        ByteArrayInputStream input = new ByteArrayInputStream(bytes);
        try {
            //we will try to check <?xml header
            if (isJaxbObject(bytes)) {
                try {
                    return JAXBUtil.unmarshal(input);
                } catch (Exception ex) {
                    ex.printStackTrace();

                    ObjectInputStream objectInput = new ObjectInputStream(input);
                    return objectInput.readObject();
                }
            } else {
                ObjectInputStream objectInput = new ObjectInputStream(input);
                return objectInput.readObject();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public byte[] serialize(Object o) {
        try {
            if (JAXBUtil.isJaxbClass(o.getClass())) {
                return JAXBUtil.marshalWrap(o).getBytes();
            } else {
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                ObjectOutputStream objectOutput = new ObjectOutputStream(output);
                objectOutput.writeObject(o);

                return output.toByteArray();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return new byte[0];
    }

    private boolean isJaxbObject(byte[] bytes) {
        if (bytes.length < 5) {
            return false;
        }
        byte[] header = new byte[10];
        for (int i = 0; i < bytes.length && i < 10; i++) {
            header[i] = bytes[i];
        }

        return "<?xml".equals(new String(header));
    }
}
