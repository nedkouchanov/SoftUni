function solve(array, rotations) {
    for (let i = 0; i < rotations % array.length; i++) {
        let elemnt = array.pop();
        array.unshift(elemnt);
    }
    return array.join(' ');
}