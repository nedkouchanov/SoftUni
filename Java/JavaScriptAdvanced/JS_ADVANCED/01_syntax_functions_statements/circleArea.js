function solve(input){
    let typeInput=typeof(input);
    if(typeInput=='number'){
        let area = Math.PI*(input**2);
        console.log(area.toFixed(2));
    } else {
       console.log(`We can not calculate the circle area, because we receive a ${typeInput}.`);
    }
}
solve('da');