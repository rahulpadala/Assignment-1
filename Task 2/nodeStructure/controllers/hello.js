const fs = require('fs');

let rawdata = fs.readFileSync('./customer.json');
let employee = JSON.parse(rawdata);
console.log(employee);

exports.hello = (req,res) => {
    res.json({
     "hello":employee
    })
}