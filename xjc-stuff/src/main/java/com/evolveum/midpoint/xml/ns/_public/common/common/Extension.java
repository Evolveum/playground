package com.evolveum.midpoint.xml.ns._public.common.common;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "any"
})
@XmlRootElement(name = "extension")
public class Extension implements Serializable {

    private final static long serialVersionUID = 201105211233L;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }
}
