//$('#myLink').click(function(){ window.history.back(); return true; });

function goBack(){
    console.log("Going back...");
    window.history.back();
}
function displayStuff() {
    console.log(document.getElementById("searchSortForm").value=document.getElementById("sort").value);
}
function goToNewPage()
{
    var url = "/books?category=Default&order="+(document.getElementById("searchSortForm").value=document.getElementById("sort").value);
    if(url != 'none') {
        window.location = url;
    }
}












