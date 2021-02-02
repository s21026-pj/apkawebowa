window.onload = function() {

    var st = 0;
    var menu = document.getElementsByClassName('menu')[0];
    var burger = document.getElementById('burger');
    burger.addEventListener('click', function (e) {

        st=!st;
        if(st==1){
            menu.style.display = "block";
            burger.setAttribute('src','foto/close_hamburger.png');
        }else {
            menu.style.display = "none";
            burger.setAttribute('src','foto/closed_hamburger.png');
        }
    })
    let pageVerticalPosition = localStorage.getItem('pageVerticalPosition') || 0;

    window.scrollTo(0, pageVerticalPosition);

    window.addEventListener("beforeunload", () => {
        localStorage.setItem('pageVerticalPosition', window.scrollY);    });
}
function goToNext(t, a) {
    if(a+1<t) {
        a++;
    }
    window.location.href = '/product/page/' + a.toString();
}

function goToPrevious(t, a) {
    if(a-1>=0) {
        a--;
    }
    window.location.href = '/product/page/' + a.toString();
}

function openModal() {
    document.getElementById("myModal").style.display = "block";
}

function closeModal() {
    document.getElementById("myModal").style.display = "none";
}

var slideIndex = 1;
showSlides(slideIndex);

function plusSlides(n) {
    showSlides(slideIndex += n);
}

function currentSlide(n) {
    showSlides(slideIndex = n);
}

function showSlides(n) {
    var i;
    var slides = document.getElementsByClassName("mySlides");
    var dots = document.getElementsByClassName("demo");
    var captionText = document.getElementById("caption");
    if (n > slides.length) {slideIndex = 1}
    if (n < 1) {slideIndex = slides.length}
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slides[slideIndex-1].style.display = "block";
    dots[slideIndex-1].className += " active";
    captionText.innerHTML = dots[slideIndex-1].alt;
}

function buy(a,id) {
    if(a>0){
        var boughtIcon = document.getElementById("cartIcon");
        boughtIcon.setAttribute("src","/foto/cart2.png")
        const Http = new XMLHttpRequest();
        const url='/product/sold/'+id;
        Http.open("GET", url);
        Http.send();
        return a-1;
    }
}

function makeGallery(n){
    for(var i=0; i<n; i++)
    {
        var galleryElement = document.createElement("div");
        galleryElement.className = "gallery";
        galleryElement.id="galleryElement" + i;
        document.getElementById("lastText").appendChild(galleryElement);

        var anchorElement = document.createElement("a");
        anchorElement.setAttribute("target","_self");
        anchorElement.setAttribute("th:href","@{'/show/' + ${productList.get(0).getId()}}");
        document.getElementById("galleryElement"+i).appendChild(anchorElement);
    }
}



