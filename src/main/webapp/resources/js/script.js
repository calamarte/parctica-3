new Vue({
    el: "#app",
    data: {
        ip: "http:/${ip}",
        port: ${port},
        peer: {},
        peers: [],
        blockchain: [],
        data: "",
    },
    methods: {
        loadData: function () {
            if (!localStorage.getItem('base64')) {
                showModal();
                return;
            }

            fetch(this.ip + ":" + this.port + "/peers", {
                method: "POST",
                headers: {
                    "Content-type": "application/x-www-form-urlencoded",
                    "Authorization": "Basic " + localStorage.getItem("base64")
                }
            })
                .then(res => res.json())
                .then(res => this.peers = res.peers);


        },
        showBlockchain: function () {
            if (!localStorage.getItem('base64')) {
                showModal();
                return;
            }

            fetch(this.ip + ":" + this.port + "/blocks", {
                method: "POST",
                headers: {
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

            fetch(this.ip + ":" + this.port + "/addBlock", {
                method: "POST",
                headers: {
                    "Authorization": "Basic " + localStorage.getItem("base64")
                },
                body: JSON.stringify({
                    peerIp: this.peer.ip,
                    data: this.data,
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

