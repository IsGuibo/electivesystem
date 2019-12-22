var mySelect2 =  document.getElementById("mySelect2");
mySelect2.addEventListener("change",function () {
    var options=$("#mySelect2 option:selected");
    var option = options.val();
    var url = window.location.href;
    var urls=url.match(/(\S*)&/);
    if(urls!=null){
        url=urls[1];
    }
    window.location.href=url+"&option="+option;
});
