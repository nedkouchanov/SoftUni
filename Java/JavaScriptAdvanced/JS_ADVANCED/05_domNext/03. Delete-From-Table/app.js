function deleteByEmail() {
    // read input field value
    const email = document.querySelector('input[name="email"]').value;
    // select all table cells from the last column
    const rows = Array.from(document.querySelectorAll('tbody>tr'));
    let deleted = false;
    // iterate over cells
    for (let row of rows) {
        // if text matches input value -> delete row
        if (row.children[1].textContent == email) {
            // -- remove row from parentNode
            row.parentNode.removeChild(row);
            deleted = true;
            // display remove message
            document.getElementById('result').textContent = 'Deleted.';
        }
    }
    if (!deleted) {
        document.getElementById('result').textContent = 'Not found.';
    }
}