function solve(stars = 5) {
    let count = Number(stars);
    for (let cols = 0; cols < count; cols++) {
        for (let rows = 0; rows < count; rows++) {
            console.log('* '.repeat(count));
        }
        console.log('\n');
    }
}
solve(2);