function listProc(data) {
    const [...myArr] = data;

    let result = [];
    const myObj = {
        add: (str) => {
            result.push(str);
        },
        remove: (str) => {
            let ind = result.indexOf(str);
            while (ind != -1) {
                result.splice(ind, 1);
                ind = result.indexOf(str);
            }
        },
        print: () => {
            console.log(result.join(','));
        }
    }
    for (const el of myArr) {
        let [command, string] = el.split(' ');
        myObj[command](string);
    }
}
listProc(['add hello', 'add again', 'remove hello', 'add again', 'print']);