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

function getAccordion(accordionId) {
	return document.getElementById(accordionId);
}
function getPanel(accordionControl, child) {
	return child.getElementsByTagName(accordionControl);
}

TINY.accordion = function() {

	function slider(accordionName) {
		this.accordionName = accordionName;
		this.accordions = [];
	}

	slider.prototype.init = function(accordionId, accordionControl, accordionMultipleSelect, accordionOpenedPanel, accordionSelectedAttr) {
		var accordionComponent = getAccordion(accordionId), i = s = 0;
		var accordionChilds = accordionComponent.childNodes;
		var length = accordionChilds.length;

		this.selectedAttr = accordionSelectedAttr || 0;
		this.multipleSelect = accordionMultipleSelect || 0;

		for (i; i < length; i++) {
			var child = accordionChilds[i];
			if (child.nodeType != 3) {
				this.accordions[s] = {};
				this.accordions[s].header = header = getPanel(accordionControl, child)[0];
				this.accordions[s].content = content = getPanel('div', child)[0];
				header.onclick = new Function(this.accordionName + '.expand(0,' + s + ')');

				if (accordionOpenedPanel == s) {
					header.className = selectedAttr;
					content.style.height = 'auto';
					content.opened = 1;
				} else {
					content.style.height = 0;
					content.opened = -1;
				}
				s++;
			}
		}
		this.length = s;
	};

	slider.prototype.expand = function(state, component) {
		for ( var i = 0; i < this.length; i++) {
			var header = this.accordions[i].header;
			var content = this.accordions[i].content;
			var currentHeight = content.style.height;
			currentHeight = currentHeight == 'auto' ? 1 : parseInt(currentHeight);
			clearInterval(content.timer);

			if ((currentHeight != 1 && content.opened == -1) && (state == 1 || i == component)) {
				content.style.height = '';
				content.totalHeight = content.offsetHeight;
				content.style.height = currentHeight + 'px';
				content.opened = 1;
				header.className = this.selectedAttr;
				timer(content, 1);
			} else if (currentHeight > 0 && (state == -1 || this.multipleSelect || i == component)) {
				content.opened = -1;
				header.className = '';
				timer(content, -1);
			}
		}
	};

	function timer(content) {
		content.timer = setInterval(function() {slide(content);}, 20);
	}
	function slide(content) {
		var totalHeight = content.offsetHeight;
		var opened = content.opened == 1 ? content.totalHeight - totalHeight : totalHeight;
		content.style.height = totalHeight + (Math.ceil(opened / 4) * content.opened) + 'px';
		content.style.opacity = totalHeight / content.totalHeight;
		content.style.filter = 'alpha(opacity=' + totalHeight * 100 / content.totalHeight + ')';
		if ((content.opened == 1 && totalHeight >= content.totalHeight) || (content.opened != 1 && totalHeight == 1)) {
			if (content.opened == 1) {
				content.style.height = 'auto';
			}
			clearInterval(content.timer);
		}
	};
	return {
		slider : slider
	};
}();

function createAccordion(id, expanded, multipleSelect, openedPanel) {
	accordion[id] = new TINY.accordion.slider("accordion['" + id + "']");
	accordion[id].init(id, "h3", multipleSelect, openedPanel, "acc-selected");

	if (expanded) {
		accordion[id].expand(1);
	}
}