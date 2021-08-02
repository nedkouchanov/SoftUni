function solution(number) {
    const sum = number;

    function addNumber(number) {
        return sum + number;
    }
    return addNumber;
}
let add5 = solution(5);
console.log(add5(2));
console.log(add5(3));