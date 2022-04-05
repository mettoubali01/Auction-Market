let searchPlaceInput = document.getElementById('search__place');

function constructAutoSuggestRes(searchString) {
    return `https://autosuggest.search.hereapi.com/v1/autosuggest?apiKey=${apiKeyValue}&at=33.738045,73.084488&limit=5&resultType=city&q=${searchString}&lang=en-US`;
}

function showAutoSuggestList(data) {

    if (!data) {
        return;
    }

    suggestList.innerHTML = ``;
    data.items.map((item) => {
        let li = document.createElement('li');
        li.textContent = item.title;
        li.addEventListener('click', (e) => {
            suggestList.innerHTML = '';
            searchPlaceInput.value = e.target.innerHTML;
            addMarkerToMap(item.position.lat, item.position.lng);
        });

        suggestList.appendChild(li);
    });
}

const GeoCodeAutoSuggest = (e) => {
    let searchString = e.value;

    if (!searchString) {
        suggestList.innerHTML = `<li> We could not show any info for now</li>`;
        return;
    }

    let endpoint = constructAutoSuggestRes(searchString);
    console.log(endpoint)
    if (endpoint) {

        fetch(endpoint)
            .then((res) => res.json())
            .then((data) => showAutoSuggestList(data));
    }
};

let index = -1;

searchPlaceInput.addEventListener('keydown', (e) => {
    let liSelected;
    let ul = document.getElementById('list');
    let len = ul.getElementsByTagName('li').length - 1;

    if (e.key === "ArrowDown") {
        console.log("id ", this.id, " f ", this.className);
        index++;

        if (liSelected) {
            // liSelected.classList.remove('selected__item');
            next = ul.getElementsByTagName('li')[index]

            //ul.getElementsByTagName('li')[index].innerText = "Clicked";

            if (typeof next !== undefined && index <= len) {
                liSelected = next;
            } else {
                index = 0;
                liSelected = ul.getElementsByTagName('li')[0];
                liSelected.focus();
            }
            liSelected.classList.add('focus-visible')

        } else {
            index = 0;
            liSelected = ul.getElementsByTagName('li')[0];
            if (liSelected)
                liSelected.classList.add('focus-visible');
        }

        if (index === len)
            console.clear();

    }
}, true);