function solve(array) {

    let rowSums = [];
    let colSums = [];
    for (let i = 0; i < array.length; i++) {
        let row = array[i];
        let sum = row.reduce((result, current) =>
            (result + current), 0);
        rowSums.push(sum);
    }
    for (let i = 0; i < array.length; i++) {
        let newRow = [];
        for (let j = 0; j < array.length; j++) {
            newRow.push(array[j][i]);
        }
        let sum = newRow.reduce((result, current) =>
            (result + current), 0);
        colSums.push(sum);
    }
    return rowSums.concat(colSums).every((el, i, array) => el === array[0]);
}
console.log(solve([
    [11, 32, 45],
    [21, 0, 1],
    [21, 1, 1]
]));