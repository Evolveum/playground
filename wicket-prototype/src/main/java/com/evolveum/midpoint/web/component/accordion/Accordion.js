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

var accordion = {};
var TINY = {};

function T$(accordionId) {
    return document.getElementById(accordionId);
}
function T$$(accordionControl, child) {
    return child.getElementsByTagName(accordionControl);
}

TINY.accordion = function () {

    function slider(accordionName) {
        this.accordionName = accordionName;
        this.accordions = [];
    }

    slider.prototype.init = function (accordionId, accordionControl, accordionMultipleSelect, accordionOpenedPanel, accordionSelectedAttr) {
        var accordionComponent = T$(accordionId), i = s = 0, n = accordionComponent.childNodes, l = n.length;
        this.s = accordionSelectedAttr || 0;
        this.m = accordionMultipleSelect || 0;
        for (i; i < l; i++) {
            var v = n[i];
            if (v.nodeType != 3) {
                this.accordions[s] = {};
                this.accordions[s].h = h = T$$(accordionControl, v)[0];
                this.accordions[s].c = c = T$$('div', v)[0];
                h.onclick = new Function(this.accordionName + '.pr(0,' + s + ')');
                if (accordionOpenedPanel == s) {
                    h.className = this.s;
                    c.style.height = 'auto';
                    c.d = 1;
                } else {
                    c.style.height = 0;
                    c.d = -1;
                }
                s++;
            }
        }
        this.l = s;
    };

    slider.prototype.pr = function (state, component) {
        for (var i = 0; i < this.l; i++) {
            var h = this.accordions[i].h, c = this.accordions[i].c, k = c.style.height;
            k = k == 'auto' ? 1 : parseInt(k);
            clearInterval(c.t);
            if ((k != 1 && c.d == -1) && (state == 1 || i == component)) {
                c.style.height = '';
                c.m = c.offsetHeight;
                c.style.height = k + 'px';
                c.d = 1;
                h.className = this.s;
                su(c, 1);
            } else if (k > 0 && (state == -1 || this.m || i == component)) {
                c.d = -1;
                h.className = '';
                su(c, -1);
            }
        }
    };

    function su(content) {
        content.t = setInterval(function () {
            sl(content);
        }, 20);
    }

    function sl(content) {
        var h = content.offsetHeight, d = content.d == 1 ? content.m - h : h;
        content.style.height = h + (Math.ceil(d / 4) * content.d) + 'px';
        content.style.opacity = h / content.m;
        content.style.filter = 'alpha(opacity=' + h * 100 / content.m + ')';
        if ((content.d == 1 && h >= content.m) || (content.d != 1 && h == 1)) {
            if (content.d == 1) {
                content.style.height = 'auto';
            }
            clearInterval(content.t);
        }
    }

    ;
    return{slider:slider};
}();

function createAccordion(id, expanded, multipleSelect, openedPanel) {
    accordion[id] = new TINY.accordion.slider("accordion['" + id + "']");
    accordion[id].init(id, "h3", multipleSelect, openedPanel, "acc-selected");

    if (expanded) {
        accordion[id].expand(1);
    }
}