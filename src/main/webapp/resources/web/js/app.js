const button = document.getElementById("scroll-to-top");
button.addEventListener("click", returnHome);

window.onscroll = function () {
    visibleReturnHomeButton();
}

function visibleReturnHomeButton() {
    if (document.body.scrollTop > 25 || document.documentElement.scrollTop > 25) {
        button.style.visibility = "visible";
    }
    else {
        button.style.visibility = "hidden";
    }
}

function returnHome() {
    document.body.scrollTop = 0;
    document.documentElement.scrollTop = 0;
}