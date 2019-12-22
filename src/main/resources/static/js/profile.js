var mySelect =  document.getElementById("mySelect");
    mySelect.addEventListener("change",function () {
        var options=$("#mySelect option:selected");
        var option = options.val();
        var url = window.location.href;
        var urls=url.match(/(\S*)&/);
        if(urls!=null){
            url=urls[1];
        }
        window.location.href=url+"&option="+option;
});
