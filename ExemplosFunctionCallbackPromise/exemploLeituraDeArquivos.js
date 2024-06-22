const arquivo = require("fs");

arquivo.readFile("Arquivo1.txt",(erro1,valores1) => {
    arquivo.readFile("Arquivo2.txt",(erro2,valores2) => {
        console.log(String(erro1)+String(valores1));
        console.log(String(valores2));
    });
});

console.log("3° log");
console.log("4° log");
console.log("5° log");