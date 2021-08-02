const { assert } = require('chai');

let pizzUni = {
    makeAnOrder: function(obj) {

        if (!obj.orderedPizza) {
            throw new Error('You must order at least 1 Pizza to finish the order.');
        } else {
            let result = `You just ordered ${obj.orderedPizza}`
            if (obj.orderedDrink) {
                result += ` and ${obj.orderedDrink}.`
            }
            return result;
        }
    },

    getRemainingWork: function(statusArr) {

        const remainingArr = statusArr.filter(s => s.status != 'ready');

        if (remainingArr.length > 0) {

            let pizzaNames = remainingArr.map(p => p.pizzaName).join(', ')
            let pizzasLeft = `The following pizzas are still preparing: ${pizzaNames}.`

            return pizzasLeft;
        } else {
            return 'All orders are complete!'
        }

    },

    orderType: function(totalSum, typeOfOrder) {
        if (typeOfOrder === 'Carry Out') {
            totalSum -= totalSum * 0.1;

            return totalSum;
        } else if (typeOfOrder === 'Delivery') {

            return totalSum;
        }
    }
}
describe("PizzUni", function() {

    it("makeAnOrder", function() {
        let firstOrder = { orderedPizza: undefined, orderedDrink: 'Queens' };
        let onlyDrink = { orderedDrink: 'Cola' };
        let secondOrder = { orderedPizza: 'QuattroFormagio' };
        let thirdOrder = { orderedPizza: 'QuattroFormagio', orderedDrink: 'Queens' };
        assert.throw(() => pizzUni.makeAnOrder(firstOrder), 'You must order at least 1 Pizza to finish the order.');
        assert.throw(() => pizzUni.makeAnOrder(onlyDrink), 'You must order at least 1 Pizza to finish the order.');
        assert.equal(pizzUni.makeAnOrder(secondOrder), 'You just ordered QuattroFormagio');
        assert.equal(pizzUni.makeAnOrder(thirdOrder), 'You just ordered QuattroFormagio and Queens.');
    });

    it('getRemainingWork', function() {
        let firstStatusArr = [{ pizzaName: 'first', status: 'preparing' },
            { pizzaName: 'second', status: 'ready' }, { pizzaName: 'third', status: 'preparing' }
        ];
        let secondStatusArr = [{ pizzaName: 'first', status: 'ready' },
            { pizzaName: 'second', status: 'ready' }
        ];
        let thirdStatusArr = [{ pizzaName: 'first', status: 'preparing' },
            { pizzaName: 'second', status: 'preparing' }, { pizzaName: 'third', status: 'preparing' }
        ];

        assert.equal(pizzUni.getRemainingWork(firstStatusArr), 'The following pizzas are still preparing: first, third.');
        assert.equal(pizzUni.getRemainingWork(secondStatusArr), 'All orders are complete!');
        assert.equal(pizzUni.getRemainingWork(thirdStatusArr), 'The following pizzas are still preparing: first, second, third.');
    });

    it('orderType', function() {
        assert.equal(pizzUni.orderType(100, 'Carry Out'), 90);
        assert.equal(pizzUni.orderType(100, 'Delivery'), 100);
    });
});