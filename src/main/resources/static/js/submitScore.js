var btn = document.getElementById('submitScore');
btn.addEventListener('click',submitScore , false);
var id = document.getElementById('cid').title;
function submitScore() {
    var list = Array();
    var sids = document.getElementsByName('sid');
    var grades = document.getElementsByName('grade');
    for(var i = 0; i < sids.length; i++){
        var data = {};
        data.sid = sids[i].innerHTML;
        data.grade = grades[i].innerHTML;
        data.cid = id;
        list.push(data);
        console.log(data);
    }
    $.ajax({
        type : 'POST',
        contentType : 'application/json;charset=utf-8',
        url : "/updateScore",
        processData : false,
        dataType : 'json',
        data : JSON.stringify(list),
        success:function (data) {
            if(data.size!==0){
                window.alert("成绩更新成功！")
            }else{
                window.alert("成绩更新失败！")
            }
        }
    })
}

