function solve(numbers, flag) {
    let resultArr = [1];
    while (resultArr.length != numbers) {
        let nextElement = 0;
        for (let i = 1; i != flag + 1; i++) {
            if (resultArr[resultArr.length - i] != undefined && resultArr.length - i != NaN) {
                nextElement += resultArr[resultArr.length - i];
            }
        }
        resultArr.push(nextElement);
    }
    return resultArr;
}
console.log(solve(6, 3));
console.log(solve(8, 2));