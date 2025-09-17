function loadPage(page){
    fetch(page)
        .then(res=>res.text())
        .then(data=>{
            document.getElementById("mainContent").innerHTML=data;
        })
        .catch(error=>{
            document.getElementById("mainContent").innerHTML="<h2>Error Loading page</h2>";
            console.error("Error :",error);
        })
}