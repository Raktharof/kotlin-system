const express = require('express');

const app = express();

app.get("/", function (req, res) {
    res.send({"currentDateTime": new Date()});
});

app.listen(3000);
