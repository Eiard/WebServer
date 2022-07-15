function getMoreContents() {
    var seek = document.getElementById("seek").value;
    if (seek == "") {
        clearContent();
        return;
    } else {
        $.ajax({
            url: server_url + order_fuzzyQueryByStationInfo,
            async: true,
            type: "post",
            contentType: "application/x-www-form-urlencoded",
            timeout: 10000,
            dataType: 'json',
            data: {
                stationInfo: OnInput(event),
            },
            success: function (data) {
                if (data.status === 10) {
                    insertContent(data);
                } else {    // 如果请求资源异常，直接把后端定义的异常提示展示给用户
                    alert(data.msg);
                }
            },
            error: function () {
                //请求出错处理
                // 如果ajax请求本身失败了，则提示ajax请求异常
                alert('查询请求发送失败');
            }
        })
    }
}


function insertContent(content) {
    setLocation()
    clearContent();
    var len = content.data.length;
    var search_data = content.data;
    // console.log(search_data);
    for (var i = 0; i < len; i++) {
        let temp=' ';
        // temp = "<tr><td>" + search_data[i].stationAddress + "</td>" +
        //     "<td>" + search_data[i].stationName + "</td>" +
        //     "<td>" + search_data[i].stationName + "</td></tr>";
        temp=search_data[i].stationAddress;
        temp+=search_data[i].stationName;
        temp+=search_data[i].stationId;

        tr = document.createElement("tr");
        // tr.setAttribute("id","search_tr");
        // var obj=document.getElementById("#search_tr");
        // alert(obj.getAttribute("id"));
        // obj.addEventListener("click", check, false);
        // function check()
        // {
        //     alert("测试");
        // }


        var td = document.createElement("td");
        td.setAttribute("bgcolor", "#ffffff");
        td.setAttribute("border", "0");
        td.onmouseover = function () {
            this.className = 'mouseOver';
        };
        td.onmouseout = function () {
            this.className = 'mouseOut';
        };
        td.id = 'td' + i;
        var text = document.createTextNode(temp);
        td.appendChild(text);
        tr.appendChild(td);
        document.getElementById("search-delivery_body").append(tr);
    }
}




function clearContent() {
    var popNode = document.getElementById("pop");
    popNode.style.border = "none";
    var contentNode = document.getElementById("search-delivery_body");
    var len = contentNode.childNodes.length;
    for (var i = len - 1; i >= 0; i--) {
        contentNode.removeChild(contentNode.childNodes[i]);
    }
}

function setLocation() {
    var inputNode = document.getElementById("seek");
    var width = inputNode.offsetWidth;
    var left = inputNode["offsetLeft"];
    var top = inputNode.offsetHeight + inputNode["offsetTop"];
    var popNode = document.getElementById("pop");
    popNode.style.border = "gray 0.5px solid";
    popNode.style.width = width + "px";
    popNode.style.top = top + "px";
    popNode.style.left = left + "px";
    document.getElementById("search-delivery").style.width = width + "px";
}

function OnInput(event) {
    return event.target.value;
}

