function solve(array) {
    array.sort((a, b) => a - b);
    let newArr = [];
    while (array.length) {
        newArr.push(array.shift());
        newArr.push(array.pop());
    }
    return newArr.filter(element => element != undefined);
    // За да не връща undefined при нечетен брой
}
console.log(solve([1, 65, 3, 52, 48, 63, 31, -3, 56]));