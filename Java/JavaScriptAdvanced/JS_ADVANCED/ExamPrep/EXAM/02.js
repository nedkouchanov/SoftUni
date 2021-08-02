class Story {
    constructor(title, creator) {
        this.title = title;
        this.creator = creator;
        this._comments = [];
        this._likes = [];
    }
    get likes() {
        if (this._likes.length == 0) {
            return `${this.title} has 0 likes`
        } else if (this._likes.length == 1) {
            return `${this._likes[0]} likes this story!`;
        }
        return `${this._likes[0]} and ${this._likes.length-1} others like this story!`;
    }
    set likes(like) {
        this._likes.push(like);
    }

    like(username) {
        if (this._likes.includes(username)) {
            throw new Error("You can't like the same story twice!");
        }
        if (this.creator === username) {
            throw new Error("You can't like your own story!");
        }
        this._likes.push(username);
        return `${username} liked ${this.title}!`;
    }
    dislike(username) {
        if (!this._likes.includes(username)) {
            throw new Error("You can't dislike this story!");
        }
        this._likes.splice(username, 1);
        return `${username} disliked ${this.title}`;
    }
    comment(username, content, id) {
        if (!id || id - 1 >= this._comments.length) {
            this._comments.push({ id: (this._comments.length + 1), username, content, replies: [] });

            return `${username} commented on ${this.title}`;
        }
        let com = this._comments.find(comment => comment.id === id);
        let comIndex = this._comments.indexOf(com);
        let replies = this._comments[comIndex].replies.length;
        this._comments[comIndex].replies.push({ id: replies + 1, username, content })

        return `You replied successfully`;


    }
    toString(sortingType) {
        let result = '';

        if (sortingType === 'asc') {
            this._comments.sort((a, b) => a.id - b.id);
            this._comments.forEach(c => c.replies.sort((rep1, rep2) => Number(rep1.id) - Number(rep2.id)))

            this._comments.replies.sort((a, b) => a.id - b.id);
        } else if (sortingType === 'desc') {
            this._comments.sort((a, b) => b.id - a.id);
            this._comments.forEach(c => c.replies.sort((rep1, rep2) => Number(rep2.id) - Number(rep1.id)))


        } else if (sortingType === 'username') {
            this._comments.sort((a, b) => a.username.localeCompare(b.username));
            this._comments.forEach(c => c.replies.sort((rep1, rep2) => rep1.username.localeCompare(rep2.username)));
        }
        result += `\nTitle: ${this.title}` + '\n';
        result += `Creator: ${this.creator}` + '\n';
        result += `Likes: ${this._likes.length}` + '\n';
        result += `Comments:` + '\n';


        this._comments.forEach(el => {

            let ia = 1;
            result += `-- ${el.id}. ${el.username}: ${el.content}` + '\n'
            if (el.replies.length != 0) {

                el.replies.forEach(element => {

                    result += `--- ${el.id}.${ia++} ${element.username}: ${element.content}` + '\n';
                })
            }
        })
        return result.trim();
    }
}
let art = new Story("My Story", "Anny");
art.like("John");
console.log(art.likes);
art.dislike("John");
console.log(art.likes);
art.comment("Sammy", "Some Content");
console.log(art.comment("Ammy", "New Content"));
art.comment("Zane", "Reply", 1);
art.comment("Jessy", "Nice :)");
console.log(art.comment("SAmmy", "Reply@", 1));
console.log()
console.log(art.toString('username'));
console.log()
art.like("Zane");
console.log(art.toString('desc'));