/**
 * 取出Option对象
 */
var province = $("#province");
var city = $("#city");
var district = $("#district");

/**
 * 点击事件触发
 */
province.change(changeProvince());
city.change(changeCity);

/**
 * 湖北省
 * 湖南省
 */
var hbp;
var hnp;
/**
 * 湖北省
 *      武汉市
 *      荆州市
 * 湖南省
 *      长沙市
 *      岳阳市
 */
var whc;
var jzc;
var csc;
var yyc;
/**
 * 武汉市
 *      江汉区
 *      武昌区
 * 荆州市
 *      荆州区
 *      沙市区
 * 长沙市
 *      芙蓉区
 *      天心区
 * 岳阳市
 *      云溪区
 *      君山区
 */
var jhd;
var wcd;
var jzd;
var ssd;
var frd;
var txd;
var yxd;
var jsd;

/**
 * 更新Province索引
 */
function updateProvince() {
    hbp = $("#province option[value='1']");
    hnp = $("#province option[value='2']");
}

/**
 * 更新City索引
 */
function updateCity() {
    whc = $("#city option[value='3']");
    jzc = $("#city option[value='4']");
    csc = $("#city option[value='5']");
    yyc = $("#city option[value='6']");
}

/**
 * 更新District索引
 */
function updateDistrict() {
    jhd = $("#district option[value='7']");
    wcd = $("#district option[value='8']");
    jzd = $("#district option[value='9']");
    ssd = $("#district option[value='10']");
    frd = $("#district option[value='11']");
    txd = $("#district option[value='12']");
    yxd = $("#district option[value='13']");
    jsd = $("#district option[value='14']");
}

function changeProvince() {
    var pro = province.val();
    //选择湖北省
    if (pro == 1) {
        city.html(
            "<option value=' '>请选择...</option><option value='3'>武汉市</option><option value='4'>荆州市</option>"
        );
    }
    //选择湖南省
    else if (pro == 2) {
        city.html(
            "<option value=' '>请选择...</option><option value='5'>长沙市</option><option value='6'>岳阳市</option>"
        );
    }
}

function changeCity() {
    var cit = city.val();
    if (cit == 3) {
        district.html
        (
            "<option value=' '>请选择...</option><option value='7'>江汉区</option> <option value='8'>武昌区</option>"
        );
    } else if (cit == 4) {
        district.html(
            "<option value=' '>请选择...</option><option value='9'>荆州区</option><option value='10'>沙市区</option>"
        );
    } else if (cit == 5) {
        district.html(
            "<option value=' '>请选择...</option><option value='11'>芙蓉区</option><option value='12'>天心区</option>"
        );
    } else if (cit == 6) {
        district.html(
            "<option value=' '>请选择...</option><option value='13'>云溪区</option><option value='14'>君山区</option>"
        );
    }
}

/**
 * 解码地址
 */
function decodeAddress(stationAddress) {
    var addrs = new Array();//建一个空的数组
    addrs = stationAddress.split("-");//根据原始字符串的中文逗号拆分，给空的数组值
    updateProvince();
    if (addrs[0] == "湖北省") {
        hbp.attr("selected", true);
    } else if (addrs[0] == "湖南省") {
        hnp.attr("selected", true);
    }
    changeProvince();
    updateCity();
    if (addrs[1] == "武汉市") {
        whc.attr("selected", true);
    } else if (addrs[1] == "荆州市") {
        jzc.attr("selected", true);
    } else if (addrs[1] == "长沙市") {
        csc.attr("selected", true);
    } else if (addrs[1] == "岳阳市") {
        yyc.attr("selected", true);
    }
    changeCity();
    updateDistrict();
    if (addrs[2] == "江汉区") {
        jhd.attr("selected", true);
    } else if (addrs[2] == "武昌区") {
        wcd.attr("selected", true);
    } else if (addrs[2] == "荆州区") {
        jzd.attr("selected", true);
    } else if (addrs[2] == "沙市区") {
        ssd.attr("selected", true);
    } else if (addrs[2] == "芙蓉区") {
        frd.attr("selected", true);
    } else if (addrs[2] == "天心区") {
        txd.attr("selected", true);
    } else if (addrs[2] == "云溪区") {
        yxd.attr("selected", true);
    } else if (addrs[2] == "君山区") {
        jsd.attr("selected", true);
    }
}



