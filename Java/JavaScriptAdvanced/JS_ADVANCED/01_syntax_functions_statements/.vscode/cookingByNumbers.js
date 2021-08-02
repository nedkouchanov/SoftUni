function solve(num, comm1, comm2, comm3, comm4, comm5) {
    let number = Number(num);
    const arr = [comm1, comm2, comm3, comm4, comm5];
    for (let i = 0; i < arr.length; i++) {
        switch (arr[i]) {
            case 'chop':
                number /= 2;
                console.log(number);
                break;
            case 'dice':
                number = Math.sqrt(number);
                console.log(number);
                break;
            case 'spice':
                number++;
                console.log(number);
                break;
            case 'bake':
                number *= 3;
                console.log(number);
                break;
            case 'fillet':
                number -= number * 0.2;
                console.log(number);
                break;
        }
        function solve(num, comm1, comm2, comm3, comm4, comm5) {
            let number = +num;
            const arr = [comm1, comm2, comm3, comm4, comm5];
            for (let i = 0; i < arr.length; i++) {
                switch (arr[i]) {
                    case 'chop':
                        number /= 2;
                        break;
                    case 'dice':
                        number = Math.sqrt(number);
                    case 'spice':
                        number++;
                        break;
                    case 'bake':
                        number *= 3;
                        break;
                    case 'fillet':
                        number -= number * 0.2;
                        break;
                }
                console.log(number);
            }
        }
    }
}
solve('32', 'chop', 'chop', 'chop', 'chop', 'chop');