function solve() {
    function createElement(type, content, className) {
        const element = document.createElement(type);
        element.textContent = content;
        if (className) {
            element.className = className;
        }
        return element;
    }
    const [author, title, category] = document.querySelectorAll('input');
    const inputContent = document.querySelector('textarea');
    const section = document.querySelector('main').children[0];

    const olEl = document.querySelector('section[class="archive-section"]').children[1];



    const button = document.querySelector('button');
    button.addEventListener('click', (e) => {
        if (e.target.tagName === 'BUTTON') {
            e.preventDefault();

            const articleH = createElement('article');
            const h1 = createElement('h1', title.value);

            const pCategory = createElement('p', 'Category: ');
            const strongCategory = createElement('strong', category.value);
            const pAuthor = createElement('p', 'Creator: ');
            const strongCreator = createElement('strong', author.value);
            pAuthor.appendChild(strongCreator)
            const pContent = createElement('p', inputContent.value);

            pCategory.appendChild(strongCategory);
            articleH.appendChild(h1);
            articleH.appendChild(pCategory);
            articleH.appendChild(pAuthor);
            articleH.appendChild(pContent);
            section.appendChild(articleH);

            const name = title.value;


            const div = createElement('div', undefined, 'buttons');
            const deleteBtn = createElement('button', 'Delete', 'btn delete');
            const archiveButton = createElement('button', 'Archive', 'btn archive');
            div.appendChild(deleteBtn);
            div.appendChild(archiveButton);
            articleH.appendChild(div);

            archiveButton.addEventListener('click', (e) => {
                if (e.target.tagName === 'BUTTON') {
                    e.preventDefault();
                    const li = createElement('li', name);
                    olEl.appendChild(li)
                }
            })

            archiveButton.addEventListener('click', (e) => {
                articleH.parentNode.removeChild(articleH);
            })

        }

    })


}