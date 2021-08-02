function solve(area, vol, dataAsJSON) {
    const figures = JSON.parse(dataAsJSON);
    const result = [];

    for (let figure of figures) {
        const output = {
            area: area.call(figure),
            volume: vol.call(figure)
        };
        result.push(output);
    }
    return result;
}

function area() {
    return Math.abs(this.x * this.y);
};

function vol() {
    return Math.abs(this.x * this.y * this.z);
};