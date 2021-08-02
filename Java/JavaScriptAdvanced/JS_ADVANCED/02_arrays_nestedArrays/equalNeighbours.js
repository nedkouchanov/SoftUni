function solve(matrix) {
    let count = 0;
    for (let rows = 0; rows < matrix.length - 1; rows++) {
        for (let cols = 0; cols < matrix[rows].length; cols++) {
            if (matrix[rows][cols] == matrix[rows + 1][cols]) {
                count++;
            }
        }
    }
    for (let i = 0; i < matrix.length; i++) {
        for (let k = 0; k < matrix.length - 1; k++) {
            if (matrix[i][k] === matrix[i][k + 1]) {
                count++;
            }
        }
    }
    return count;
}
// console.log(solve([
//     ['2', '3', '4', '7', '0'],
//     ['4', '0', '5', '3', '4'],
//     ['2', '3', '5', '4', '2'],
//     ['9', '8', '7', '5', '4']
// ]));
console.log(solve([
    ['test', 'yes', 'yo', 'ho'],
    ['well', 'done', 'yo', '6'],
    ['not', 'done', 'yet', '5']
]));