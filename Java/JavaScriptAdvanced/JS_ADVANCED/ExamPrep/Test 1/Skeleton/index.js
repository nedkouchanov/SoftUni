function solve() {
    const formControls = document.querySelectorAll('.form-contol input');
    const lecture = formControls[0];
    const date = formControls[1];
    const moduleName = formControls[2];

    function createElement(type, text, attributes = []) {
        let element = document.createElement(type);
        if (text) {
            element.textContent = text;
        }
        attributes
            .map(attr => attr.split('='))
            .forEach(({ name, value }) => {
                element.setAttribute(name, value);
            })
    }

    function add() {
        let lectureName = lecture.value;
        let dateString = date.valuel
        const lectureTitle = ;
        const delButton = createElement('button', 'Del', ['class=red']);
        const lectureH4 = createElement('h4', lectureTitle);

    }
    document.main.addEventListener('click', (e) => {
        if (e.target.tagName !== 'BUTTON') {
            return;
        }
        if (e.target.textContent === 'Del') {

        } else if (e.target.textContent === 'Del') {
            e.preventDefault();
            add();
        }
    })
};