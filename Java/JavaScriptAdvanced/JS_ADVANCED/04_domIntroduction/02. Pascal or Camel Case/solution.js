function solve() {
    const input = document.getElementById('text').value;
    const currentCase = document.getElementById('naming-convention').value;
    const result = document.getElementById('result');
    const [...wordsArr] = input.split(' ');

    if (currentCase == 'Camel Case') {
        result.textContent = wordsArr.map((word, id) => {
            if (id != 0) {
                return word[0].toUpperCase() + word.slice(1).toLowerCase();
            } else {
                return word.toLowerCase();
            }
        }).join('');
    } else if (currentCase == 'Pascal Case') {
        result.textContent = wordsArr.map(word => {
            return word[0].toUpperCase() + word.slice(1).toLowerCase()
        }).join('');
    } else {
        result.textContent = 'Error!';
    }
}