// Add your custom JS code here



// $(document).ready(function(){
//     document.getElementById("custom_header_mobile").innerHTML='<object type="text/html" data="header_mobile.html"></object>';
// })
// $(document).ready(function(){
//     document.getElementById("custom_header_desktop").innerHTML='<object type="text/html" data="header_desktop.html"></object>';
// })
// $(document).ready(function(){
//     document.getElementById("custom_footer").innerHTML='<object type="text/html" data="custom_footer.html"></object>';
// })

// header_mobile
$(document).ready(function(){
    $("#header_mobile").load("./tiles/header_mobile.html")   
});

// header_desktop
$(document).ready(function(){
    $("#header_desktop").load("./tiles/header_desktop.html")     
});

// Pushy Panel
$(document).ready(function(){
    $("#custom_pushy_panel").load("./tiles/custom_pushy_panel.html")
});


// footer_custom
$(document).ready(function(){
    $("#footer_custom").load("./tiles/footer_custom.html")
});
