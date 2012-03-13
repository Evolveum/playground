define(function(require, exports, module) {
"use strict";

var oop = require("../lib/oop");
var xmlUtil = require("./xml_util");
var TextHighlightRules = require("./text_highlight_rules").TextHighlightRules;

var XmlHighlightRules = function() {

    // regexp must not have capturing parentheses
    // regexps are ordered -> the first match is used
    this.$rules = {
        start : [{
            token : "text",
            regex : "<\\!\\[CDATA\\[",
            next : "cdata"
        }, {
            token : "xml_pe",
            regex : "<\\?.*?\\?>"
        }, {
            token : "comment",
            merge : true,
            regex : "<\\!--",
            next : "comment"
        }, {
            token : "meta.tag", // opening tag
            regex : "<\\/?",
            next : "tag"
        }, {
            token : "text",
            regex : "\\s+"
        }, {
            token : "text",
            regex : "[^<]+"
        }],

        cdata : [{
            token : "text",
            regex : "\\]\\]>",
            next : "start"
        }, {
            token : "text",
            regex : "\\s+"
        }, {
            token : "text",
            regex : "(?:[^\\]]|\\](?!\\]>))+"
        }],

        comment : [{
            token : "comment",
            regex : ".*?-->",
            next : "start"
        }, {
            token : "comment",
            merge : true,
            regex : ".+"
        }]
    };

    xmlUtil.tag(this.$rules, "tag", "start");
};

oop.inherits(XmlHighlightRules, TextHighlightRules);

exports.XmlHighlightRules = XmlHighlightRules;
});
