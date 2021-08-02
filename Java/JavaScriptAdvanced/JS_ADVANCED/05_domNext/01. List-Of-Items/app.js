function addItem() {
    // select input field and read input value
    // create new <li> element
    const liELement = document.createElement('li');
    // set etxt of new element to input value
    liELement.textContent = document.getElementById('newItemText').value;
    // select list from page
    // append new element to list
    document.getElementById('items').appendChild(liELement);
    document.getElementById('newItemText').value = '';
}