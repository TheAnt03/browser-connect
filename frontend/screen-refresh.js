const host = window.location.hostname;
document.getElementById('image').src = "http://" + host + ":8080/screen/getimage?time=" + new Date().getTime();

setInterval(async function(){
    const host = window.location.hostname;
    const img = new Image();
    img.src = "http://" + host + ":8080/screen/getimage?time=" + new Date().getTime();
    img.id = "image";

    // Replace the existing image once the new one is fully loaded
    img.onload = function() {
        const oldImg = document.getElementById('image');
        
        if (oldImg) {
            oldImg.parentNode.replaceChild(img, oldImg);
        } else {
            img.id = "image";
            document.body.appendChild(img);
        }
    }
        
}, 1000/20);

document.addEventListener("DOMContentLoaded", function() {
    const windowImage = document.getElementById('image');

    document.addEventListener("mousedown", function(event) {
        if (event.target.id === "image") {
            fetch("http://" + host + ":8080/controls/mouse/click");
        }
    });
    
    document.addEventListener("keydown", function(event) {
        let key = event.key;

        if (key === " " || key === null || key === undefined) {
            key = "Space";
        }

        if (key === ".") {
            key = "Period";
        }

        fetch("http://" + host + ":8080/controls/press/" + key);
        console.log("Key pressed: " + key);
    });

    document.addEventListener("mousemove", function(event) {
        if (event.target.id === "image") {
            var rect = windowImage.getBoundingClientRect();
            var x = event.clientX - rect.left;
            var y = event.clientY - rect.top;
           
            fetch("http://" + host + ":8080/controls/mouse/" + x + "/" + y);
        }
    });
});


