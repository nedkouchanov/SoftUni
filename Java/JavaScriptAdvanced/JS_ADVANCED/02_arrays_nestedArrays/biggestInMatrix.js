function solve(matrix) {
    function matrixReducer(acc, c) {
        return acc.concat(c);
    }
    let result = matrix.reduce(matrixReducer);

    result.sort((a, b) => b - a);
    return result[0];
}
console.log(solve([
    [20, 50, 10],
    [8, 33, 145]
]));
// console.log([
//     [3, 5, 7, 12],
//     [-1, 4, 33, 2],
//     [8, 3, 0, 4]
// ]);