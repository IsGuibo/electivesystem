var btn = document.getElementById('btn_submit');
btn.addEventListener('click', test, false);
function test() {
    var str='';
    var id = document.getElementsByName('checkbox');
    var value =String();
    for(var i = 0; i < id.length; i++){
        if(id[i].checked)
            value += id[i].value+",";
    }

    $.ajax({
        type:'get',
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
        },
        url:'/selectCou/do?cids='+value.toString(),
        success:function (data) {
            window.alert(JSON.stringify(data)+"\n失败原因：您已经选择了这些课程")

        }
    })
}
