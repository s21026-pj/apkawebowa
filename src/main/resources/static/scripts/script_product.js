window.onload = function() {

    var st = 0;
    var menu = document.getElementsByClassName('menu')[0];
    var burger = document.getElementById('burger');
    burger.addEventListener('click', function (e) {

        st=!st;
        if(st==1){
            menu.style.display = "block";
            burger.setAttribute('src','close_hamburger.png');
        }else {
            menu.style.display = "none";
            burger.setAttribute('src','closed_hamburger.png');
        }
    })

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

function table() {
    var ct = [{rok: 2010, przebieg: 5000, cena_wyjsciowa: 12000, cena_koncowa: 10000},
        {rok: 2011, przebieg: 50000, cena_wyjsciowa: 9000, cena_koncowa: 7500},
        {rok: 2012, przebieg: 500000, cena_wyjsciowa: 6000, cena_koncowa: 4500},
        {rok: 2013, przebieg: 50007, cena_wyjsciowa: 7000, cena_koncowa: 6600},
        {rok: 2015, przebieg: 1234, cena_wyjsciowa: 16000, cena_koncowa: 14500}];

    var tb=document.createElement('table');
    tb.style.width = '700px';
    var tr = tb.insertRow();
    var td;

    for (var j = 0; j<4; j++){
        td = tr.insertCell();
        td.style.border = '2px solid black';
        td.appendChild(document.createTextNode(Object.keys(ct[0])[j]));
    }

    for (var i=0; i <ct.length; i++){
        tr = tb.insertRow();
        for (var j = 0; j <4; j++){
            td= tr.insertCell();
            td.style.border = '2px solid black';
            td.appendChild(document.createTextNode(Object.values(ct[i])[j]));
        }
    }
    document.body.appendChild(tb);

}