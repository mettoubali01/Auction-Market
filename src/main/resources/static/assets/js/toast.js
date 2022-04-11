const toast = document.getElementById("toast__container");
const btn = document.getElementsByClassName("submit__btn")[0];
const message = ["Done Successfully", "Something went Wrong"]

if (btn && notifType) {
    btn.addEventListener("click", () => {
            createToast();
        }
    );
} else if (notifType){
    createToast();
}

function createToast() {

    const notif = document.createElement("div");
    const notifIcon = document.createElement("span");
    let notifIconClass = setProperties(notifType);

    if (notifType === "success")
        notif.append(message[0])
    else
        notif.append(message[1])

    notifIcon.classList.add.apply(notifIcon.classList, notifIconClass.split(" "));

    notif.classList.add("toast");
    notif.classList.add(notifType);

    notif.append(notifIcon);
    toast.append(notif);

    //remove the notification
    setTimeout(() => {
        notif.remove();
    }, 2000);
}

function setProperties(notificationType) {
    let properties;

    if (notificationType)
        properties = "fas fa-check-circle";
    else
        properties = "fas fa-exclamation-circle";

    return properties
}
//670.72
//65.52