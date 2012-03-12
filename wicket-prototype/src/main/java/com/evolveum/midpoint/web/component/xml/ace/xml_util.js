define(function(require, exports, module) {
"use strict";

var lang = require("../lib/lang");

var formTags = lang.arrayToMap(
    ("button|form|input|label|select|textarea").split("|")
);

var tableTags = lang.arrayToMap(
    ("table|tbody|td|tfoot|th|tr").split("|")
);

function string(state) {
    return [{
        token : "string",
        regex : '".*?"'
    }, {
        token : "string", // multi line string start
        merge : true,
        regex : '["].*',
        next : state + "_qqstring"
    }, {
        token : "string",
        regex : "'.*?'"
    }, {
        token : "string", // multi line string start
        merge : true,
        regex : "['].*",
        next : state + "_qstring"
    }];
}

function multiLineString(quote, state) {
    return [{
        token : "string",
        merge : true,
        regex : ".*?" + quote,
        next : state
    }, {
        token : "string",
        merge : true,
        regex : '.+'
    }];
}

exports.tag = function(states, name, nextState) {
    states[name] = [{
        token : "text",
        regex : "\\s+"
    }, {
        //token : "meta.tag",

    token : function(value) {
            if ( value==='a' ) {
                return "meta.tag.anchor";
            }
            else if ( value==='img' ) {
                return "meta.tag.image";
            }
            else if ( value==='script' ) {
                return "meta.tag.script";
            }
            else if ( value==='style' ) {
                return "meta.tag.style";
            }
            else if (formTags.hasOwnProperty(value.toLowerCase())) {
                return "meta.tag.form";
            }
            else if (tableTags.hasOwnProperty(value.toLowerCase())) {
                return "meta.tag.table";
            }
            else {
                return "meta.tag";
            }
        },
        merge : true,
        regex : "[-_a-zA-Z0-9:!]+",
        next : name + "_embed_attribute_list"
    }, {
        token: "empty",
        regex: "",
        next : name + "_embed_attribute_list"
    }];

    states[name + "_qstring"] = multiLineString("'", name + "_embed_attribute_list");
    states[name + "_qqstring"] = multiLineString("\"", name + "_embed_attribute_list");

    states[name + "_embed_attribute_list"] = [{
        token : "meta.tag",
        merge : true,
        regex : "\/?>",
        next : nextState
    }, {
        token : "keyword.operator",
        regex : "="
    }, {
        token : "entity.other.attribute-name",
        regex : "[-_a-zA-Z0-9:]+"
    }, {
        token : "constant.numeric", // float
        regex : "[+-]?\\d+(?:(?:\\.\\d*)?(?:[eE][+-]?\\d+)?)?\\b"
    }, {
        token : "text",
        regex : "\\s+"
    }].concat(string(name));
};

});
