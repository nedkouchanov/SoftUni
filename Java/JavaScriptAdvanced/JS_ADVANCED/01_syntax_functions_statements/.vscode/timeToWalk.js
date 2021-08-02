function solve(steps, footPrint, speedKmH) {
    const speed = speedKmH * 1000 / 3600;
    const distance = steps * footPrint;

    const restsCount = Math.floor(distance / 500) * 60;
    const time = distance / speed + restsCount;

    const hours = Math.floor(time / 3600).toFixed(0).padStart(2, "0");
    const minutes = Math.floor((time - hours * 3600) / 60).toFixed(0).padStart(2, "0");
    const seconds = (time - hours * 60 * 60 - minutes * 60).toFixed(0).padStart(2, "0");

    return `${hours}:${minutes}:${seconds}`;
}
console.log(solve(4000, 0.6, 5));