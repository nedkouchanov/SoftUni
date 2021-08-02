function focus() {
    // select all input fields
    Array.from(document.querySelectorAll('input')).forEach(i => {
        i.addEventListener('focus', onFocus);
        i.addEventListener('blur', onBlur);
    });

    // onFocus -> select input parrent -> apply class "focused"
    function onFocus(ev) {
        ev.target.parentNode.className = 'focused';
    }
    // onBlur -> select input parent -> remove class "focused"
    function onBlur(ev) {
        ev.target.parentNode.className = '';
    }
}