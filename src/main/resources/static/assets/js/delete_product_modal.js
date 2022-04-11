const modal = document.getElementById("modal");
const cancelBtn = document.getElementById("cancel");
const removeBtn = document.getElementById("remove");
const showDeleteModal = document.getElementsByClassName("remove__product");

for (let element of showDeleteModal) {
    element.addEventListener("click", (e) => {
            modal.showModal();
    })
}

cancelBtn.addEventListener("click", () => {
    modal.close();
})