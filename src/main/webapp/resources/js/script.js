async function test() {
    let fetch1 = await fetch("http://192.168.137.74:8080/peers");
    document.querySelector("#peers").innerHTML = await fetch1.text();
}

test();
