let left = 0, right = 4;
let slides = document.getElementsByClassName("categories_list_item");

window.addEventListener('load', _ => {
    console.log("load ", "left ", left, " right ", right);
    show();
})

function show() {
    //shows just 4 categories slides
    for (let i = left; i <= right; i++) {
        console.log(i, " left ", left, " right ", right);
        slides[i].style.display = "block";
    }
    console.clear();
}

function hideElements() {
    for (let i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
}

function nextSlide() {
    if (left <= 2 && right <= 5) {
        slides[left].style.display = "none";
        left++;
        right++;
    } else {
        left = 0;
        right = 4;
        hideElements();
    }
    show();
    console.log("Left ", left, " Right ", right, " len ", slides.length);
}

function prevSlide() {
    if (left >= 2 && right >= 5) {
        slides[right].style.display = "none";
        left--;
        right--;
    } else {
         left = 3;
         right = 6;
         hideElements()
    }
    show();

}