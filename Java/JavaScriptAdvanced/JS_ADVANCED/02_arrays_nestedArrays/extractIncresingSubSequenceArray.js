function solve(array) {
    let result = []
    for (let i = 0; i < array.length; i++) {
        let element = array[i];
        if (element >= result[result.length - 1] ||
            result.length === 0) {
            result.push(element);
        }
    }
    return result;
}
console.log(solve([1,
    3,
    8,
    4,
    10,
    12,
    3,
    2,
    24
]));