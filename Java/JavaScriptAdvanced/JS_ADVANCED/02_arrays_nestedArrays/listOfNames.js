function solve(array) {
    let result = array.sort((a, b) => a.localeCompare(b))
        .map((name, index) => {
            let result = `${index + 1}.${name}`;
            return result;
        })
    return result.join('\n');
}