class List {
    constructor() {
        this.list = [];
        this.size = 0;
    }

    add(element) {
        if (typeof element === 'number' && element != NaN) {
            this.list.push(Number(element));
            this.list.sort((a, b) => a - b);
            this.size++;
        }
    }
    remove(index) {
        if (typeof index === 'number' && index != NaN) {
            if (index >= 0 && index < this.list.length) {
                this.list.splice(index, 1);
                this.list.sort((a, b) => a - b);
                this.size--;
            } else {
                throw new Error('Invalid Index!');
            }
        }
    }
    get(index) {
        if (typeof index === 'number' && index != NaN) {
            if (index >= 0 && index < this.list.length) {
                return this.list[index];
            } else {
                throw new Error('Invalid Index!');
            }
        }
    }
}
let list = new List();
list.add(5);
list.add(6);
list.add(7);
console.log(list.get(1));
list.remove(1);
console.log(list.get(1));