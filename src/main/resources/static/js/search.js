function SearchBtnClick() {
    var searchText = document.getElementById('searchText').value;
    var url = window.location.href;
    var urls=url.match(/(\S*)&/);
    if(urls!=null){
        url=urls[1];
    }
    window.location.href=url+"&searchText="+searchText;
}