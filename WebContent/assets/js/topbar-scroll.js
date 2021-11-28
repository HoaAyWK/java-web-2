window.onscroll = function() {myFunction()};

var navbar = document.getElementById("navbar");

function myFunction() {
    if (window.pageYOffset >= 99) {
         navbar.classList.add("change-bg")
    } else {
        navbar.classList.remove("change-bg");
    }
}