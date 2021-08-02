function solve(array) {
    array.sort((a, b) => b - a);
    console.log(array[array.length - 1], array[array.length - 2]);
}
solve([30, 15, 50, 5]);
solve([3, 0, 10, 4, 7, 3]);