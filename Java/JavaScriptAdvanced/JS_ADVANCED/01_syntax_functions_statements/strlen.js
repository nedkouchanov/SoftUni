function strlen(a,b,c){
let total=0;
total += a.length;
total += b.length;
total += c.length;
let avarage = Math.floor(total/3);
console.log(total);
console.log(avarage);
}
strlen('chocolate','ice cream','cake');