function solve(strigs) {
    let first = Number([...strigs].shift());
    let last = Number([...strigs].pop());
    return first + last;
}
console.log(solve(['20', '30', '40']));