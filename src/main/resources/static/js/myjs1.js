var loginBtn = document.getElementById('loginBtn');
loginBtn.addEventListener('click', loginBtnClick);
function loginBtnClick() {

    var userId = $("#inputEmail3").val();
    var userPsw = document.getElementById('inputPassword3').value;
    var user={
        id:userId,
        psw:userPsw
    };
    $.ajax({
        type:'POST',
        url:"/login",
        data:JSON.stringify(user),
        beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
        },
        datatype:"json",
        success:function (data) {
            if(JSON.stringify(data).indexOf("1")!==-1){
                //学生
                window.location.href="/selectCou?id="+userId
            }else if(JSON.stringify(data).indexOf("2")!==-1){
                //老师
                window.location.href="/TeacherMag?id="+userId

            }else{
                window.alert("用户名或密码错误！")
            }

        },
        error:function (result) {
            window.alert("请求失败！")
        }


    })
}
