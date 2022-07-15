function SexSelect(sex) {
    if(sex==true){
        $("#man").attr("checked",true);
    }else if(sex==false){
        $("#woman").attr("checked",true);
    }
}

function Sex(sex) {
    if(sex==false){
        //男
        return "女";
    }else if(sex==true){
        //女
        return "男";
    }
}
