// Add your custom JS code here

// .main-nav__list > li.has-children > a::after {
//     content: "";
//     display: inline-block;
//     margin-left: 9px;
//     width: 6px;
//     height: 4px;
//     background-image: url("data:image/svg+xml;charset=utf8,%3Csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 6 4'%3E%3Cpath transform='translate(-586.156 -1047.28)' fill='%23fff' d='M586.171,1048l0.708-.71,2.828,2.83-0.707.71Zm4.95-.71,0.707,0.71L589,1050.83l-0.707-.71Z'/%3E%3C/svg%3E");
//     background-size: 6px 4px;
//     background-repeat: no-repeat;
//     background-position: center center;
//     top: -2px;
//     position: relative;
// }


$(document).ready(function(){


    $("#custom_nav_logout").css({"color":"#F7F7F7"})

    var $wrapper     = $('.site-wrapper');
    var $toggle = $(".pushy-panel__toggle");

    $(document).on("click", ".pushy-panel__toggle, .pushy-panel__back-btn", function (e){
        e.preventDefault();
        $wrapper.toggleClass('site-wrapper--has-overlay-pushy');
    });

    // footer_custom
    $("#footer_custom").load("./tiles/footer_custom.html");



    // $('#whistle').css();
    // $('#whistle').attr("../../assets/images/ek_ground.png", imgurl);
});

