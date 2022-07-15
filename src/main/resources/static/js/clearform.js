/*
清空FORM表单内容 id：表单ID*/
function ClearForm(id) {
    var objId = document.getElementById(id);
    if (objId === undefined) {
        return;
    }
    for (var i = 0; i < objId.elements.length; i++) {
        if (objId.elements[i].type === "text") {
            objId.elements[i].value = "";
        }
        else if (objId.elements[i].type ==="password") {
            objId.elements[i].value = "";
        }
        else if (objId.elements[i].type === "radio") {
            objId.elements[i].checked = false;
        }
        else if (objId.elements[i].type === "checkbox") {
            objId.elements[i].checked = false;
        }
        else if (objId.elements[i].type === "select-one") {
            objId.elements[i].options[0].selected = true;
        }
        else if (objId.elements[i].type === "select-multiple") {
            for (var j = 0; j < objId.elements[i].options.length; j++) {
                objId.elements[i].options[j].selected = false;
            }
        }
        else if (objId.elements[i].type === "textarea") {
            objId.elements[i].value = "";
        }
//else if (objId.elements[i].type == "file") {
// //objId.elements[i].select();
// //document.selection.clear();
// // for IE, Opera, Safari, Chrome
// var file = objId.elements[i];
// if (file.outerHTML) {
// file.outerHTML = file.outerHTML;
// } else {
// file.value = ""; // FF(包括3.5)
// }
//}
    }
}