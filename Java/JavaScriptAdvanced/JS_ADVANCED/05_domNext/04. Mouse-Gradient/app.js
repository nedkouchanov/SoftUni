function attachGradientEvents() {
    document.getElementById('gradient').addEventListener('mousemove', onMove);
    const output = document.getElementById('result');

    function onMove(event) {
        const percent = Math.floor(event.offsetX / event.target.clientWidth * 100);
        output.textContent = `${percent}%`;
    }
}