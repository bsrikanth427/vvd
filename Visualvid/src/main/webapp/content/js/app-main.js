$(document).ready(function(){
    const players = Array.from(document.querySelectorAll('.player12345')).map(p => new Plyr(p));
    //var players = Array.from(document.querySelectorAll('.player')).map(p => new Plyr(p));
    // players.forEach((item) => {
    //     //console.log(item);
    //     item.toggleControls(false);
    //     item.on('play', event => {
    //         item.toggleControls(true);
    //    });
    // });
    $(".app-link-search").click(function(){
        $(this).closest(".nav-item-search").addClass("active-search");
        $(this).addClass('d-none');
        $(this).closest(".nav-item-search").find(".app-link-search-close").removeClass("d-none");
    });
    $(".app-link-search-close").click(function(){
        $(this).closest(".nav-item-search").removeClass("active-search");
        $(this).addClass('d-none');
        $(this).closest(".nav-item-search").find(".app-link-search").removeClass("d-none");
    });
    $('.nav-item-search input').focus(function () {
       $(".app-link-search-close").addClass("d-none");
       $(".app-link-search").removeClass("d-none");
    }).blur(function () {
        $(".app-link-search-close").removeClass("d-none");
        $(".app-link-search").addClass("d-none");
    });


    /// Mobile menu toggle
    $(".app-menu-user").click(function(){
        $("#homeMenu").removeClass("is-active");
        $("#mobilecommonMenu").removeClass("is-active");
        $(this).toggleClass("d-none");
        $("#profileMenu").toggleClass("d-none is-active");
        $("#mobileProfileMenu").toggleClass("is-active");
    });
    $("#profileMenu").click(function(){
        $(this).toggleClass("d-none is-active");
        $(".app-menu-user").toggleClass("d-none");
        $("#mobileProfileMenu").toggleClass("is-active");
    });

    $("#homeMenu").click(function(){
        $(this).toggleClass("is-active");
        $("#mobilecommonMenu").toggleClass("is-active");
        $(".app-menu-user").removeClass("d-none");
        $("#profileMenu").addClass("d-none").removeClass("is-active");
        $("#mobileProfileMenu").removeClass("is-active");
    });
});