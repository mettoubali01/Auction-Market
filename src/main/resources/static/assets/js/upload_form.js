let img_uploader_container = document.getElementsByClassName("photo__wrapper")[0];
let upload_img = document.getElementById("uploadImg");
let uploaded_img = document.getElementsByClassName("product__photos__placeholder")[0];
let maxPushDate = document.getElementById("maxDate");
let minDate = todayDate();

console.log(minDate);

img_uploader_container.addEventListener('click', (e) => {
    upload_img.click();
});

upload_img.onchange = (e) => {
    let input = e.target;

    if (input.files) {
        let file = input.files[0];
        let reader = new FileReader();

        reader.readAsDataURL(file);
        reader.onload = function (e) {

            uploaded_img.style.backgroundImage = `url(${reader.result})`;
            uploaded_img.classList.add('uploaded__img');
            img_uploader_container.classList.add('uploaded__photo__wrapper');
        }
    }
}

function todayDate() {
    let today = new Date();

    let day = today.getDate();
    let month = today.getMonth() + 1;
    let year = today.getFullYear();

    if (day < 10)
        day = '0' + day;

    if (month < 10)
        month = '0' + month;

    today = year + "-" + month + "-" + day;

    return today;
}

maxPushDate.setAttribute("min", minDate);

//https://es.quora.com/Qu%C3%A9-debo-saber-en-JavaScript-como-desarrollador-front-end
//https://developer.here.com/tutorials/how-to-find-geo-coordinates-using-the-geocoding-and-search-api/
