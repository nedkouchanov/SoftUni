function even(inputArr) {
    let result = '';
    for (let i = 0; i < inputArr.length; i += 2) {
        result += inputArr[i];
        result += ' ';
    }
    return result;
}
console.log(even(['20', '30', '40', '50', '60']));
console.log(even(['5', '10']));