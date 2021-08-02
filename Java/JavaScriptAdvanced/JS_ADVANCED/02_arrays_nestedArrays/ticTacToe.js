function solve(array) {
    let matrix = [];
    for (let i = 0; i < 3; i++) {
        matrix[i] = [];
        for (let j = 0; j < 3; j++) {
            matrix[i][j] = false;
        }
    }
    while (true) {
        for (let i = 0; i < array.length; i++) {
            let row = array[i].split(' ')[0];
            let col = array[i].split(' ')[1];
            if (i % 2 == 0) {
                matrix[row][col] = 'X';
            } else {
                matrix[row][col] = 'O';
            }
            if (matrix[0][0] == matrix[1][1] == matrix[2][2] != 'false' ||
                matrix[2][0] == matrix[1][1] == matrix[0][2] != 'false' ||
                matrix[0][0] == matrix[0][1] == matrix[0][2] != 'false' ||
                matrix[0][0] == matrix[1][0] == matrix[2][0] != 'false' ||
                matrix[2][0] == matrix[1][2] == matrix[2][2] != 'false' ||
                matrix[2][2] == matrix[1][2] == matrix[0][2] != 'false') {
                console.log('Win!'); //не работи/Спирам дотук!
            }
        }
    }
}
console.log(solve([
    "0 1",
    "0 0",
    "0 2",
    "2 0",
    "1 0",
    "1 1",
    "1 2",
    "2 2",
    "2 1",
    "0 0"
]));