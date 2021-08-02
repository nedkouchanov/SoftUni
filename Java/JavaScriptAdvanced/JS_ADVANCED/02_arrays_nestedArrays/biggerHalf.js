function solve(numbers) {
    return numbers
        .sort((a, b) => a - b)
        .slice(Math.floor(numbers.length / 2));
}
console.log(solve([3, 19, 14, 7, 2, 19, 6]));