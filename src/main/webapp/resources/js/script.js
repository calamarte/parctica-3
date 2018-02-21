new Vue({
    el: "#app",
    data: {
        ip: "http:/${ip}",
        port: ${port},
        peer: {},
        peers: {},
        blockchain: []
    },
    methods: {
        loadData: function () {
            if (!localStorage.getItem('base64')) {
                showModal();
                return;
            }

            fetch(this.ip + ":" + this.port + "/peers", {
                method: "GET",
                headers: {
                    "Content-type": "application/x-www-form-urlencoded",
                    "Authorization": "Basic " + localStorage.getItem("base64")
                }
            })
                .then(res => res.json())
                .then(res => this.peers = res);


        },
        showBlockchain: function () {
            if (!localStorage.getItem('base64')) {
                showModal();
                return;
            }

            fetch(this.ip + ":" + this.port + "/blocks", {
                method: "GET",
                headers: {
                    "Content-type": "application/x-www-form-urlencoded",
                    "Authorization": "Basic " + localStorage.getItem("base64")
                },
                body: JSON.stringify({
                    peerIp: this.peer.ip
                })
            })
                .then(res => res.json())
                .then(res => this.blockchain = res);
        },
        addBlock: function () {
            if (!localStorage.getItem('base64')) {
                showModal();
                return;
            }

            console.log("Add Block");
            fetch(this.ip + ":" + this.port + "/addBlock", {
                method: "GET",
                headers: {
                    "Content-type": "application/x-www-form-urlencoded",
                    "Authorization": "Basic " + localStorage.getItem("base64")
                },
                body: JSON.stringify({
                    peerIp: this.peer.ip
                })
            })
                .then(res => res.json())
                .then(res => this.showBlockchain());
        }
    },
    created: function () {
        this.loadData();
    }
});


function showModal() {
    $('#modal').modal('show');
}

document.querySelector('#save').addEventListener('click', () => {
    let user = document.querySelector('#user').value;
    let pass = document.querySelector('#pass').value;

    localStorage.setItem("base64", window.btoa(user + ":" + pass));

    location.reload(true);
});

