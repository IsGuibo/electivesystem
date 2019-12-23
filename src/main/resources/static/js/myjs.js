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
        url:'/selectCou/do?cids='+value.toString(),
        success:function (data) {
            window.alert(JSON.stringify(data))

        }
    })
}
