let app = new Vue({
    el: "#app",
    data: {
        ip: "http:/${ip}",
        port: 8080,
        peer: {},
        peers: {},
        blockchain: []
    },
    methods: {
        loadData: function () {
            let peerFetch = fetch(this.ip + ":" + this.port + "/peers", {
                method: "POST",
                headers: {
                    "Content-type":"application/x-www-form-urlencoded",
                    "Authorization":"Basic " + localStorage.getItem("base64")
                }
            })
                .then(res => res.json())
        .then(res => this.peers = res);



        },
        showBlockchain: function () {
            let blockFetch = fetch(this.ip + ":" + this.port + "/blocks", {
                method: "POST",
                headers: {
                    "Content-type":"application/x-www-form-urlencoded",
                    "Authorization":"Basic " + localStorage.getItem("base64")
                },
                body: JSON.stringify({
                    peerIp: this.peer.ip
                })
            })
                .then(res => res.json())
        .then(res => this.blockchain = res);
        },
        addBlock: function () {
            console.log("Add Block")
            let blockFetch = fetch(this.ip + ":" + this.port + "/addBlock", {
                method: "POST",
                headers: {
                    "Content-type":"application/x-www-form-urlencoded",
                    "Authorization":"Basic " + localStorage.getItem("base64")
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
    },
});